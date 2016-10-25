/**
 * メソッド集約クラスのインターフェイス.
 *
 * @author jsfkdt
 */
public interface ProcessInterface {
    /**
     * 省略.
     */
    public void allRequest(HttpServletResponse a);
    
    public void updateRequest(HttpServletRequest a, HttpServletResponse b);
    
    public void deleteRequest(HttpServletRequest a, HttpServletResponse b);
    
    public void compareRequest(HttpServletRequest a, HttpServletResponse b);
    
    public void templateRequest(HttpServletRequest a, HttpServletResponse b);
    
    public void nextTargetRequest(HttpServletRequest a, HttpServletResponse b);
    
    public void versionsRequest(HttpServletRequest a, HttpServletResponse b);
    
    public void issueRequest(HttpServletRequest a, HttpServletResponse b);
}