/**
 * 比較・処理クラスのインターフェイス.
 *
 * @author jsfkdt
 */
public interface ValidatorInterface {
    /**
     * 省略.
     */
    public void isValidAndProcess(HttpServletRequest req, HttpServletResponse res);
    
    
    // ユーザ操作定数の定義.
    public final String OPERATION01 = "all";
    public final String OPERATION02 = "update";
    public final String OPERATION03 = "delete";
    public final String OPERATION04 = "compare";
    public final String OPERATION05 = "template";
    public final String OPERATION06 = "nextTarget";
    public final String OPERATION07 = "versions";
    public final String OPERATION08 = "issue";
}