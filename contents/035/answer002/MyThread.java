import java.util.Random;

public class MyThread extends Thread {
    // スーパークラスThreadのコンストラクタを呼び出す
    MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    /**
     * 1から5秒でランダムにこのスレッドの実行を一時停止する
     */
    public void run() {
        try {
            Random rnd = new Random();
            sleep((rnd.nextInt(5) + 1) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
