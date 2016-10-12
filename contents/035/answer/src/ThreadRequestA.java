import java.util.Random;

/**
 * 035で用いるスレッドAの実行クラスです.
 *
 * @author jsfkdt
 */
public class ThreadRequestA implements Runnable {
    /* アクティブスレッド数 */
    static int activeThreadCount = 0;
    
    /**
     * スレッドAを実行する.
     */
    public ThreadRequestA() {
    }
    
    /**
     * 1～5秒のランダムな時間だけスリープを行うスレッドを実行する.
     */
    @Override
    public void run() {
        // アクティブスレッド数をインクリメントする.
        activeThreadCount++;
        
        //Randomクラスのインスタンス化.
        Random random = new Random();
        
        // 1～5のランダムな値を取得.
        int rand = random.nextInt(5) + 1;
        
        // 対象スレッドのウエイト時間を指定.
        int sleepTime = rand * 1000;
        
        try{
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // アクティブスレッド数をデクリメントする.
        activeThreadCount--;
    }
}
