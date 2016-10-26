/**
 * 各クラスのメソッド集約したインターフェイス.
 *
 * @author jsfkdt
 */
public interface RequestProcessor {
    /**
     * 省略.
     */
    public void process(HttpServletRequest req, HttpServletResponse res)
    throws Exception;
    
}