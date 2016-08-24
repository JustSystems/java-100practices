[目次](../toc.md)
[前の問題](../074/README.md)　[次の問題](../076/README.md)


***
## 075：複合(15)
* 以下は、Androidでデータベースを処理するプログラムの一部である。問題点を指摘し、修正せよ。
    * `LectureDataModel`はプログラム内で使われているデータモデルであり、適切に実装されているものとする。
    * データベースヘルパーのDB生成・アップデート処理はソースコードを一部省略している。

```java
public class Knock075 {
    private Knock075 () {
    };

    public static void update(final Context context,
            final List<LectureDataModel> lectureDatas) {
        SQLiteDatabase db = null;
        try {
            SQLiteOpenHelper helper = new DBHelper(context);
            db = helper.getWritableDatabase();
            db.beginTransaction();

            String sql = "UPDATE " + DBHelper.TABLE_NAME_1
                    + " SET consist_flg=? WHERE _id=?;";
            for (LectureDataModel lectureData : lectureDatas) {
                SQLiteStatement sqlitestatement = db.compileStatement(sql);
                sqlitestatement.bindString(1, lectureData.getConsistFlg());
                sqlitestatement.bindString(2, lectureData.getLectureId());
                sqlitestatement.executeInsert();
            }

            db.setTransactionSuccessful();

        } finally {
            if (db != null) {
                db.endTransaction();
            }

            db.close();
        }
    }

    public static void setDeleteFlag(final Context context, final int year,
            final int month, final String subject) {
        SQLiteDatabase db = null;
        try {
            SQLiteOpenHelper helper = new DBHelper(context);
            db = helper.getWritableDatabase();
            db.beginTransaction();

            String sql = "UPDATE " + DBHelper.TABLE_NAME_1
                    + " SET consist_flg='InConsistent'" 
                     + "WHERE year=? AND month=? AND subject=? ;";

            SQLiteStatement sqlitestatement = db.compileStatement(sql);
            sqlitestatement.bindLong(1, year);
            sqlitestatement.bindLong(2, month);
            sqlitestatement.bindString(3, subject);
            sqlitestatement.executeInsert();

            db.setTransactionSuccessful();

        } finally {
            if (db != null) {
                db.endTransaction();
            }

            db.close();
        }
    }

    /**
     * データベースヘルパー
     */
    private static class DBHelper extends SQLiteOpenHelper {

        /** データベースファイル名 */
        private static final String DB_FILE_NAME = "Database01";
        /** DBバージョン */
        private static final int DB_VERSION = 1;
        /** テーブル名 */
        private static final String TABLE_NAME_1 = "TABLE_NAME";

        /** コンストラクタ */
        public DBHelper(Context context) {
            super(context, DB_FILE_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i(this.getClass().getCanonicalName(), "init db");
            // データベース作成処理（省略）

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // データベースのバージョンアップ処理（省略）

        }
    }
}
```

