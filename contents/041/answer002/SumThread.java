public class SumThread extends Thread {
    // 加算処理のループ回数
    private static final int LOOP_NUM = 10000;

    /**
     * グローバル変数に加算する.
     */
    public void run() {
        // Answer041.lockのロックを取得
        synchronized (Answer041.lock) {
            System.out.println("sum loop start");
            for (int i = 1; i < LOOP_NUM + 1; i++) {
                GlobalNum.addNum(i);
            }
            System.out.println("sum loop end");
            // 値への加算処理が完了したことを設定する
            GlobalNum.doneCalculation();
            // ロックオブジェクトに対してwait()している他のスレッド1つを再開する
            Answer041.lock.notify();
        }
    }
}
