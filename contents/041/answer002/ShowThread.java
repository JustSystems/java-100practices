public class ShowThread extends Thread {
    /**
     * グローバル変数の値を出力する.
     */
    public void run() {
        // Answer041.lockのロックを取得
        synchronized (Answer041.lock) {
            try {
                // ロックオブジェクトのnotify()が他のスレッドから呼ばれるまで待つ
                System.out.println("wait start");
                Answer041.lock.wait();
                System.out.println("wait end");
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Answer041.num);
        }
    }
}
