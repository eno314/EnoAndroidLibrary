package jp.eno314.enolibrary.boot;

import android.content.Context;
import android.os.AsyncTask;

import jp.eno314.enolibrary.BuildConfig;

/**
 * 起動時の処理
 * <p>
 * Created by eno314 on 2015/10/18.
 */
class BootTask extends AsyncTask<Void, Void, Void> {

    private final BootPreference mBootPreference;

    private final Context mContext;

    private final Booter mBooter;

    private final int mBeforeVersionCode;

    BootTask(Context context, Booter booter) {
        mBootPreference = new BootPreference(context);
        mContext = context;
        mBooter = booter;
        mBeforeVersionCode = mBootPreference.getBeforeVersionCode();
    }

    @Override
    protected Void doInBackground(Void... params) {
        if (mBootPreference.isFirstBoot()) {
            mBooter.onFirstBootBackground();
        }

        mBooter.onBootBackground();

        if (isUpdate()) {
            mBooter.onUpdateBackground(mBeforeVersionCode);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        if (mBootPreference.isFirstBoot()) {
            mBooter.onFirstBoot(mContext);
            mBootPreference.setFirstBootFinished();
        }

        mBooter.onBoot(mContext);

        if (isUpdate()) {
            mBooter.onUpdate(mContext, mBeforeVersionCode);
            mBootPreference.setVersionCode(BuildConfig.VERSION_CODE);
        }
    }

    /**
     * バージョンアップ時かどうか
     *
     * @return true / false
     */
    private boolean isUpdate() {
        return mBeforeVersionCode < BuildConfig.VERSION_CODE;
    }
}
