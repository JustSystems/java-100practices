public class ShowThread extends Thread {
    /**
     * グローバル変数の値を出力する.
     */
    public void run() {
        // Answer041.lockのロックを取得
        synchronized (Answer041.lock) {
            try {
                // グローバル変数への加算処理が完了しているかを確認する
                // 完了していない場合はwait()を呼び、加算処理の完了後notify()が呼ばれるのを待つ
                if (!GlobalNum.isCalculated()) {
                    System.out.println("wait start");
                    Answer041.lock.wait();
                    System.out.println("wait end");
                }
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(GlobalNum.getNum());
        }
    }
}
