import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 017：代入.
 * あるlong型の変数の参照を100万回するだけのスレッドAと、
 * その同じ変数を0か-1かどちらかを代入することを100万回繰り返すスレッドBを同時に動作させ、
 * スレッドAではこの変数の値を参照したときに必ず0または-1となるようにするプログラムを実装せよ.
 * 
 * @author toastkidjp
 */
public class Knock017 {

    /** ループ回数. */
    private static final int COUNT = 1_000_000;

    /** ある long 変数. */
    private static volatile long variable = -1L;

    /**
     * main method.
     * @param args
     */
    public static void main(final String[] args) throws InterruptedException {
        // 複数スレッドの終了を同期する仕組み.
        final CountDownLatch latch = new CountDownLatch(2);
        final ExecutorService es = Executors.newFixedThreadPool(2);

        // スレッドA
        es.submit(() -> {
            for (int i = 0; i < COUNT; i++) {
                assert variable == 0 || variable == -1
                    : String.format("variable (%d) is not 0 or -1.", variable);
            }
            latch.countDown();
        });

        // スレッドB
        es.submit(() -> {
            for (int i = 0; i < COUNT; i++) {
                variable = (variable == 0) ? -1L : 0L;
            }
            latch.countDown();
        });

        // A, B 両方の終了まで待機.
        latch.await();
        es.shutdown();
    }
}
