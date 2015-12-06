package jp.eno314.enolibrary.boot;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 起動に関するプリファレンス
 * <p/>
 * Created by eno314 on 2015/10/18.
 */
class BootPreference {

    private static final String NAME = "jp.eno314.kankoretool.library.boot.BootPreference";

    /**
     * 初回起動のフラグ
     */
    private static final String KEY_FIRST_BOOT = "first_boot";

    /**
     * バージョンコード
     */
    private static final String KEY_VERSION_CODE = "version_code";

    private SharedPreferences mPreferences;

    BootPreference(Context context) {
        mPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    /**
     * 初回起動判定
     *
     * @return true : 初回起動 / false : ２回目以降の起動
     */
    public boolean isFirstBoot() {
        return mPreferences.getBoolean(KEY_FIRST_BOOT, true);
    }

    /**
     * 初回起動が完了したことを保存する
     */
    public void setFirstBootFinished() {
        mPreferences.edit().putBoolean(KEY_FIRST_BOOT, false).apply();
    }

    /**
     * 前回起動のバージョンコードを返す
     *
     * @return 前回起動時のバージョンコード
     */
    public int getBeforeVersionCode() {
        return mPreferences.getInt(KEY_VERSION_CODE, 0);
    }

    /**
     * バージョンコードの保存
     *
     * @param versionCode バージョンコード
     */
    public void setVersionCode(int versionCode) {
        mPreferences.edit().putInt(KEY_VERSION_CODE, versionCode).apply();
    }
}
