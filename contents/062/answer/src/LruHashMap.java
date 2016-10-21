import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 062のLinkedHashMap用クラスです.
 *
 * @author jsfkdt
 */
public class LruHashMap<K, V> extends LinkedHashMap<K, V> {
    /* 最大容量. */
    private final int maxSize;
    
    /**
     * LRU方式用に設定する.
     * MaxSizeを設定する.
     */
    public LruHashMap(int maxSize) {
        /* trueにすることで、Mapで最も参照されていないものが削除される.(5) */
        // 格納する要素数100に対し、4/3倍の最大容量134を設定.
        super(134, 0.75f, true);
        this.maxSize = maxSize;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        /* Mapのサイズがmaxであれば、最も参照されていないものを削除.(5) */
        return size() > maxSize;
    }
}
