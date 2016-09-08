/**
 * 023：オーバーロード.
 * 同一の名称で、int型1つを引数に取るメソッドとfloat型1つを引数に取るメソッドを作成し、
 * それぞれのメソッドでは渡された引数を文字列に変換して返すように実装せよ.
 *
 * @author Toast kid
 *
 */
public class Knock023 {

    /**
     * print passed int value.
     * @param i
     */
    private static void print(final int i) {
        System.out.println("i: int = " + String.valueOf(i));
    }

    /**
     * print passed float value.
     * @param f
     */
    private static void print(final float f) {
        System.out.println("f: float = " + String.valueOf(f));
    }

    /**
     * main method.
     * @param args
     */
    public static void main(final String[] args) {
        print(1);
        print(1f);
    }
}
