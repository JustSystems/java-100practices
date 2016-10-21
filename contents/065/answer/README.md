[問題](../README.md)

***
# 065：解答例

考えられる問題点1～4を以下に記載。
```java
public class Knock065 {
    SQLiteDatabase sdb = null;
    DBOpenHelper helper;

    public Knock065(Activity activity) {
        helper = new DBOpenHelper(activity.getApplicationContext(),
                "foo.db", null, Constants.DB_VERSION);
        sdb = helper.getWritableDatabase();
    }

    public void insertSpotData(List<Model> list) {
    // 問題点1. listがnullの場合、NullPointerExceptionが発生する.
        try {
            for (Model model : list) {
                ContentValues values = new ContentValues();
                values.put("id", model.getID());
                values.put("name", model.getName());
                values.put("title", model.getTitle());
                values.put("Yomigana", model.getYomigana());
                // 問題点2. insert文の箇所は複数のスレッドが実行する可能性があるので、スレッドセーフで実装しなければならない(?)。
                // 問題点3. insertメソッドは、エラーが発生した場合 -1が返却されるので、そのときの例外処理を実装しなければならない(?)。
                sdb.insert("map_table", "null", values);
            }
        } finally {
            // 問題点4. この位置で本当にclose()しても良いか不明。
            sdb.close();
            helper.close();
        }
    }
}
```