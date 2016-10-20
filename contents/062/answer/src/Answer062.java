import java.util.Map;
import java.util.Collections;

/**
 * 062の解答です.
 *
 * @author jsfkdt
 */
public class Answer062 {
    /* 任意のデータが格納可能なキーバリュー形式のMap.(1) */
    private Map<String, String> cacheMap = null;
    
    /**
     * LinkedHashMapクラスを生成し、Mapを作成する.
     */
    @SuppressWarnings("unchecked")
    Answer062() {
        /* 登録できるキーの数が最大100個のマップインスタンスを生成.(2) */
        /* スレッドセーフなMapのため、任意のタイミングでデータの挿入・取得可能.(3) */
        this.cacheMap = Collections.synchronizedMap(new LruHashMap(100));
    }
    /**
     * 062の解答です.
     * 
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        Answer062 answer =  new Answer062();
        
        // データを格納.
        answer.cacheMap.put("key111", "value111");
        answer.cacheMap.put("key222", "value222");
        answer.cacheMap.put("key333", "value333");
        
        // 既に存在するkeyの場合は上書きする.
        answer.cacheMap.put("key111", "value1111");
        displayAllElements(answer.cacheMap);
        
        /* データの取得可能.(3) */
        System.out.println(answer.cacheMap.get("key333") + "\n");
        
        /* データの挿入可能. (4) */
        answer.cacheMap.put("key444", "value444");
        answer.cacheMap.put("key555", "value555");
        answer.cacheMap.put("key666", "value666");
        
        /* 入れたデータは消えない. 常に残り続ける.(6),(7) */
        displayAllElements(answer.cacheMap);
        
        /* 同じデータを何度も取得可能.(7) */
        System.out.println(answer.cacheMap.get("key333"));
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
}

