import java.io.Serializable;
/**
 * 030用のインスタンス変数を持つクラスです.
 *
 * @author jsfkdt
 */
class ForSerializeClass implements Serializable {
    /* int型のインスタンス変数 */
    int intInstance = 1;
    /* String型のインスタンス変数 */
    String stringInstance = "Answer30";
    
    public void setIntInstance(int intInstance) {
        this.intInstance = intInstance;
    }
    
    public void setStringInstance(String stringInstance) {
        this.stringInstance = stringInstance;
    }
}