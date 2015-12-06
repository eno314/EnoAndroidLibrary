package jp.eno314.enolibrary.boot;

import android.content.Context;

/**
 * 起動時の処理を作るための基底クラス
 * <p>
 * Created by eno314 on 2015/10/18.
 */
public class Booter {

    /**
     * 初回起動時に行う処理
     *
     * @param context コンテキスト
     */
    protected void onFirstBoot(Context context) {
    }

    /**
     * 初回起動時にバックグラウンドで行う処理
     */
    protected void onFirstBootBackground() {
    }

    /**
     * 起動時に行う処理
     *
     * @param context コンテキスト
     */
    protected void onBoot(Context context) {
    }

    /**
     * 起動時にバックグラウンドで行う処理
     */
    protected void onBootBackground() {
    }

    /**
     * バージョンアップ時の処理
     *
     * @param context           コンテキスト
     * @param beforeVersionCode アップデート前のバージョンコード
     */
    protected void onUpdate(Context context, int beforeVersionCode) {
    }

    /**
     * バージョンアップ時のバックグラウンド処理
     *
     * @param beforeVersionCode アップデート前のバージョンコード
     */
    protected void onUpdateBackground(int beforeVersionCode) {
    }
}
