package jp.eno314.enolibrary.util;

import android.database.Cursor;

import java.io.Closeable;
import java.io.IOException;

/**
 * IO処理のユーティリティ処理をまとめたクラス
 * <p/>
 * Created by eno314 on 2015/10/13.
 */
public class IoUtils {

    public static void close(Closeable closeable) {
        if (closeable == null) {
            return;
        }

        try {
            closeable.close();
        } catch (IOException e) {
            // do nothing..
        }
    }

    public static void close(Cursor cursor) {
        if (cursor == null) {
            return;
        }

        cursor.close();
    }
}
