public class Answer019 {
    /**
     * 0から7の整数値をランダムで返す
     */
    private native int randomNum();

    // ライブラリを読み込み
    static {
        System.loadLibrary("libAnswer019");
    }

    public static void main(String arguments[]) {
        System.out.println(new Answer019().randomNum());
    }
}
