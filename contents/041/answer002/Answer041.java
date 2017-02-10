public class Answer041 {
    // 各スレッドからアクセスされるグローバル変数
    private static int num = 0;
    // 各スレッドが同期に使用するロックオブジェクト
    public static final Object lock = new Object();

    public static void main(String[] arguments) {
        // グローバル変数に加算する処理を実行するスレッド
        Thread threadA = new SumThread();
        // グローバル変数の値を出力する処理を実行するスレッド
        Thread threadB = new ShowThread();

        threadB.start();
        threadA.start();
    }

    /**
     * 変数numに対して、引数の値を加算する.
     * @param int i 加える数
     */
    public static void addNum(int i) {
        num = num + i;
    }

    /**
     * 変数numの値を返す.
     */
    public static int getNum() {
        return num;
    }
}
