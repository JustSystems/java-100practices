public class ShowThread extends Thread {
    /**
     * グローバル変数の値を出力する.
     */
    public void run() {
        // Answer041.lockのロックを取得
        synchronized (Answer041.lock) {
            try {
                // 他スレッドでの加算処理が行われていない場合、wait()を呼び、加算処理が行われるのを待つ
                if (Answer041.getNum() == 0) {
                    System.out.println("wait start");
                    Answer041.lock.wait();
                    System.out.println("wait end");
                }
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Answer041.getNum());
        }
    }
}
