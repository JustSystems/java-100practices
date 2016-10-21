import java.util.Map;
import java.util.Collections;

/**
 * 062の解答です.
 *
 * @author jsfkdt
 */
public class Answer062 {
    
    /**
     * Answer062のインスタンスを生成する.
     */
    Answer062() {
        
    }
    
    /**
     * 062の解答です.
     * 
     * @param arguments 使用しません.
     */
    @SuppressWarnings("unchecked")
    public static void main(final String[] args) {
        /* 任意のデータが格納可能なキーバリュー形式のMap.(1) */
        /* 登録できるキーの数が最大100個のマップインスタンスを生成.(2) */
        final Map<String, String> cacheMap = Collections.synchronizedMap(new LruHashMap(100));
        
        // データを格納.
        cacheMap.put("key111", "value111");
        cacheMap.put("key222", "value222");
        cacheMap.put("key333", "value333");
        
        // 既に存在するkeyの場合は上書き.
        cacheMap.put("key111", "value1111");
        displayAllElements(cacheMap);
        
        /* データの取得可能.(3) */
        System.out.println(cacheMap.get("key333") + "\n");
        
        /* データの挿入可能. (4) */
        cacheMap.put("key444", "value444");
        
        /* 入れたデータは消えない. 常に残り続ける.(6),(7) */
        displayAllElements(cacheMap);
        
        /* 同じデータを何度も取得可能.(7) */
        System.out.println(cacheMap.get("key333"));
        
        /* マップに要素を101個格納し、正しく削除されているか確認.(5) */
        insertMaxAndCheckOperation(cacheMap);
    }
    
    /**
     * 全てのkey,Valueの組み合わせを標準出力する.
     * mapに格納されている値がない場合は、何も表示しない.
     * 
     * @param map cacheMap
     */
    public static void displayAllElements(Map<String, String> map) {
        
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println("");
    }
    
    /**
     * マップに要素を100個格納し、1番目の要素を参照する.
     * 次に101番目の要素を格納し、2番目の要素が削除されていることを確認する.
     * 
     * @param map cacheMap
     */
    public static void insertMaxAndCheckOperation(Map<String, String> map) {
        // マップをクリア.
        map.clear();
        
        // 要素を100個挿入.
        for (int i = 0; i < 100; i++) {
            map.put("key" + i, "value" + i);
        }
        
        // マップの先頭の値を参照.
        map.get("key0");
        
        // 101番目の要素を追加.
        map.put("key100", "value100");
        
        // マップの要素数が上限の100個であるか確認.
        assert map.size() == 100 : "マップの要素数が誤っています.";
        // 最も長く参照されていない要素が削除されていることを確認.
        assert map.get("key1") == null : "最も長く利用されていないものが削除されていません。";
    }
}

