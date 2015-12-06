package jp.eno314.enolibrary.boot;

import android.app.Application;

/**
 * 起動処理を使うためのアプリケーション基底クラス
 * <p>
 * Created by eno314 on 2015/12/06.
 */
public abstract class BootBaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        final BootTask task = new BootTask(getApplicationContext(), createBooter());
        task.execute();
    }

    protected abstract Booter createBooter();
}
