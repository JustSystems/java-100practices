/**
 * 040用のサブスレッド実行クラス.
 *
 * @author jsfkdt
 */
public class SubThread implements Runnable {
    
    /**
     * サブスレッドを実行.
     */
    public void run() {
        // ArithmeticExceptionを発生させる.
        int tmp = 2/0;
    }
}