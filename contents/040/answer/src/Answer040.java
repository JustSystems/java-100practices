/**
 * 040の解答です.
 *
 * @author jsfkdt
 */
public class Answer040 implements Runnable {
    
    /**
     * 040の解答です.
     * キャッチされない例外のスタックトレースを
     * 現在時刻とともに標準エラー出力する.
     * 
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        Thread thread = new Thread(new Answer040());
        
        // UncaughtExceptionHandlerを実装したハンドラをsetUncaughtExceptionメソッドで登録.
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        
        // メインスレッドの実行.
        thread.start();
    }
    
    /**
     * スレッドを実行.
     */
    public void run() {
        // スリープ.
        try {
             Thread.sleep(500L);
        } catch (InterruptedException e) {
             e.printStackTrace();
        }
        
        Thread subThread = new Thread(new SubThread());
        
        // UncaughtExceptionHandlerを実装したハンドラをサブスレッドに紐付ける.
        subThread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        
        // サブスレッドの実行.
        subThread.start();
    }
}