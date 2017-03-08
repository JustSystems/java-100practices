[問題](../README.md)

***
# 065：解答例

## 問題点
1. インスタンス変数が他クラスから書き換えられないようにするために、`private`修飾子を付与する必要がある。
2. `insertSpotDate()`メソッドにおいて、引数の`list`が`null`の場合は後続で`NullPointerException`が発生するので、
ガード節を用意する必要がある。
3. `SQLiteDatabase`クラスの`insert()`メソッドは複数スレッドが実行する可能性があるので、スレッドセーフでなければならない。
また、`insert()`メソッドは、エラーが発生した場合 `-1`を返却するので、その際の例外処理を実装する必要がある。
4. 修正前の実装だと、全てのインサートが完了していない状態で`close()`メソッドを実行してしまう可能性があるため、
`SQLiteDatabase`と`DBOpenHelper`のインスタンス生成を`insertSpotData()`メソッド内で行う必要がある。

## 修正
```java
public class Knock065 {
    private SQLiteDatabase sdb = null; // 修正箇所. #1
    private DBOpenHelper helper; // 修正箇所. #1
    private Activity activity; // 修正箇所. #4
    private static final Logger logger = Logger.getLogger("Knock065"); // 修正箇所. #3
    
    // 修正箇所. #4
    public Knock065(Activity activity) {
        this.activity = activity;
    }
    
    public void insertSpotData(List<Model> list) {
        // 修正箇所. #2
        if (list == null || list.isEmpty()) {
            return;
        }
        
        // 修正箇所. #4
        helper = new DBOpenHelper(activity.getApplicationContext(),
                "foo.db", null, Constants.DB_VERSION);
        sdb = helper.getWritableDatabase();
        
        try {
            for (Model model : list) {
                ContentValues values = new ContentValues();
                
                // 修正箇所. #3
                synchronized (values) {
                    values.put("id", model.getID());
                    values.put("name", model.getName());
                    values.put("title", model.getTitle());
                    values.put("Yomigana", model.getYomigana());
                    
                    // 修正箇所. #3
                    try {
                        if (sdb.insert("map_table", "null", values) == -1) {
                            throw new Exception();
                        }
                    } catch(Exception e) {
                        logger.log(Level.WARNING, "InsertError", e);
                    }
                    
                }
            }
        } finally {
            sdb.close();
            helper.close();
        }
    }
}
```
