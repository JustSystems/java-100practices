public class GlobalNum {
    // 値を保持する変数
    private static int num = 0;
    // 値に対する計算が行われたか否か。計算が行われていない状態(false)で初期化
    private static boolean isCalculated = false;

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

    /**
     * 値に対する計算が行われた状態にフラグに変更する.
     */
    public static void doneCalculation() {
        isCalculated = true;
    }
    /**
     * 値に対する計算が行われていない状態にフラグに変更する.
     * 合わせて変数numを計算前の初期値0に変更する
     */
    public static void clearCalculation() {
        isCalculated = false;
        num = 0;
    }

    /**
     * 値に対する計算が行われたか否かのフラグを返す.
     * @return 計算を実施した状態とする場合はtrue、そうでない場合はfalseとする。
     */
    public static boolean isCalculated() {
        return isCalculated;
    }
}
