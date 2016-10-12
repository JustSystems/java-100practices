import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * 035の解答です.
 *
 * @author jsfkdt
 */
public class Answer035 {
    private final ExecutorService executor;
    
    /**
     * 実行するスレッド数を定める.
     */
    Answer035(int poolSize) {
        this.executor = Executors.newFixedThreadPool(poolSize);
    }
    
    /**
     * スレッドAを実行する.
     */
    public void startThreadsA() {
        for (int i = 0; i < 100; i++) {
            // スレッドAを実行させる.
            executor.execute(new ThreadRequestA());
        }
    }
    
    /**
     * スレッドBを実行する.
     */
    public void startThreadsB() {
        for (int i = 0; i < 100; i++) {
            executor.execute(new ThreadRequestB());
        }
    
    }
    /**
     * シャットダウンを行う.
     */
    public void shutdownPool() {
        executor.shutdown();
    }
    
    /**
     * 035の解答です.
     * @param arguments 使用しません.
     */
    public static void main(String[] args)  {
        
        Answer035 nh = new Answer035(200);
        
        // スレッドAの実行.
        nh.startThreadsA();
        
        // スレッドBの実行.
        nh.startThreadsB();
        
        // アクティブなスレッド数の表示.
        for(int i = 0; i < 6; i++) {
            System.out.println("スレッドA アクティブスレッド数：" + ThreadRequestA.activeThreadCount + "個");
            System.out.println("スレッドB アクティブスレッド数：" + ThreadRequestB.activeThreadCount + "個");
            int beforeActiveThread = ThreadRequestA.activeThreadCount;
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // スレッドの停止.
        nh.shutdownPool();
    }
}