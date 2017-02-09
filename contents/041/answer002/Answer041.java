public class Answer041 {
    // 各スレッドからアクセスされるグローバル変数
    public static int num = 0;
    // 各スレッドが同期に使用するロックオブジェクト
    public static Object lock = new Object();

    public static void main(String[] arguments) {
        // グローバル変数に加算する処理を実行するスレッド
        Thread threadA = new SumThread();
        // グローバル変数の値を出力する処理を実行するスレッド
        Thread threadB = new ShowThread();

        // 先にロックを取得するため、wait()を実装するスレッドを先に起動
        threadB.start();
        threadA.start();
    }
}
