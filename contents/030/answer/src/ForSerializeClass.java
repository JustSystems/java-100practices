import java.io.Serializable;
/**
 * 030用のインスタンス変数を持つクラスです.
 *
 * @author jsfkdt
 */
public class ForSerializeClass implements Serializable {
    /* int型のインスタンス変数 */
    private int intInstance = 1;
    /* String型のインスタンス変数 */
    private String stringInstance = "Answer30";
    
    /**
     * int型インスタンス変数の値を設定する.
     *
     * @param intInstance int型の引数
     */
    public void setIntInstance(int intInstance) {
        this.intInstance = intInstance;
    }
    
    /**
     * int型インスタンス変数の値を取得する.
     *
     * @return int型インスタンス変数の値
     */
    public int getIntInstance() {
        return this.intInstance;
    }
    
    /**
     * String型インスタンス変数の値を設定する.
     *
     * @param stringInstance String型の引数
     */
    public void setStringInstance(String stringInstance) {
        this.stringInstance = stringInstance;
    }
    
    /**
     * String型インスタンス変数の値を取得する.
     *
     * @return String型インスタンス変数の値
     */
    public String getStringInstance() {
        return this.stringInstance;
    }
}