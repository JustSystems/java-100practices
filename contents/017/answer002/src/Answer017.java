import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 017の解答です。
 *
 * @author jsfkdt
 */
public class Answer017 {

    /** ループ回数. */
    private static final int COUNT = 1_000_000;

    /** ある long 変数. */
    private static volatile long variable = -1L;
    
    /**
     * 017の解答です.
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) throws InterruptedException {
        // 複数スレッドの終了を同期する仕組み
        final CountDownLatch latch = new CountDownLatch(2); // スレッドが2つとも終了するまで待つためのクラス.
        final ExecutorService es = Executors.newFixedThreadPool(2); // 2つのスレッドを並列処理させるためのクラス.
        final AtomicLong atom = new AtomicLong(); // long型変数をアトミックな値に設定するためのクラス.

        // スレッドA.
        es.submit(() -> {
            for (int i = 0; i < COUNT; i++) {
                
                /** 評価用の変数 **/
                long atomicVariable;
    
                // 参照値をアトミックな値に設定.
                atom.set(variable);
                
                // 参照値を評価用変数に代入.
                atomicVariable = atom.get();
                
                // 変数が0でも-1でもない場合にその内容を出力.
                if (atomicVariable != 0 && atomicVariable != -1) {
                    System.out.printf("variable (%d) is not 0 or -1.\n", atomicVariable);
                }
            }
            
            // スレッドAが終了したことをカウントへ反映.
            latch.countDown();
        });

        // スレッドB.
        es.submit(() -> {
            for (int i = 0; i < COUNT; i++) {
                // 変数が0の場合-1Lを代入し、それ以外の場合は0Lを代入する.
                if (variable == 0) {
                    variable = -1L;
                } else {
                    variable = 0L;
                }
            }
            // スレッドBが終了したことをカウントへ反映.
            latch.countDown();
        });
        
        // A, B 両方の終了まで待機.
        latch.await();
        es.shutdown();
    }
}
