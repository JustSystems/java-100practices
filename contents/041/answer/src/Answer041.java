/**
 * 041の解答です.
 *
 * @author jsfkdt
 */
public class Answer041 extends Thread {
    /**
     * 041の解答です.
     * @param arguments 使用しません.
     */    
    public static void main(final String[] args) {
        final MethodForThread calcAndOutput = new MethodForThread();
        new Thread() {
            /**
             * スレッドAを実行する.
             */
            public void run() {
                
                try {
                    System.out.println("スレッドAです。 2秒眠ります・・・");
                    sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                // 加算メソッドを実行.
                calcAndOutput.calc();
            }
        }.start();
        
        new Thread() {
            /**
             * スレッドBを実行する.
             */            
            public void run() {
                try {
                    sleep(500L);
                    System.out.println("1から10000までの合計を計算します！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                // 出力結果表示メソッドを実行.
                calcAndOutput.output();
            }
        }.start();
    }
}