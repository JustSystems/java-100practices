public class Answer041 {
    // 各スレッドが同期に使用するロックオブジェクト
    public static final Object lock = new Object();

    public static void main(String[] arguments) {
        // グローバル変数に加算する処理を実行するスレッド
        Thread threadA = new SumThread();
        // グローバル変数の値を出力する処理を実行するスレッド
        Thread threadB = new ShowThread();

        // グローバル変数への加算処理を初期化
        GlobalNum.clearCalculation();

        threadB.start();
        threadA.start();
    }
}
