import java.util.Random;

/**
 * 035で用いるスレッドの実行クラスです.
 *
 * @author jsfkdt
 */
public final class ThreadRun implements Runnable {
    
    /**
     * 1～5秒のランダムな時間だけスリープを行うスレッドを実行する.
     */    
    public void run() {
        /* Randomクラスのインスタンス化. */
        Random random = new Random();
        
        /* 1～5のランダムな値を取得. */
        int rand = random.nextInt(5) + 1;
        
        /* 対象スレッドのウエイト時間を指定. */
        long sleepTime = rand * 1000L;
        
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}