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
     * toString passed int value.
     * @param i
     * @return string
     */
    private static String intToString(final int i) {
        return String.valueOf(i);
    }

    /**
     * toString passed float value.
     * @param f
     * @return string
     */
    private static String floatToString(final float f) {
        return String.valueOf(f);
    }

    /**
     * main method.
     * @param args
     */
    public static void main(final String[] args) {
        System.out.println("i: int   = " + intToString(1));
        System.out.println("f: float = " + floatToString(1f));
    }
}
