public class Answer019 {
    // メソッド本体はC言語で実装
    private native int randomNum();

    // ライブラリを読み込み
    static {
        System.loadLibrary("libAnswer019");
    }

    public static void main(String arguments[]) {
        System.out.println(new Answer019().randomNum());
    }
}
