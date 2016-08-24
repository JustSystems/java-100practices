[目次](../toc.md)
[前の問題](../064/README.md)　[次の問題](../066/README.md)


***
## 065：複合(5)
* 以下はModelクラスの配列をデータベースに登録するAndroidプログラムである。問題点を指摘し、修正せよ。なお、Modelクラスは適切な実装が与えられているものとする。

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
        try {
            for (Model model : list) {
                ContentValues values = new ContentValues();
                values.put("id", model.getID());
                values.put("name", model.getName());
                values.put("title", model.getTitle());
                values.put("Yomigana", model.getYomigana());
                sdb.insert("map_table", "null", values);
            }
        } finally {
            sdb.close();
            helper.close();
        }
    }
}
```

