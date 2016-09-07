import java.util.ArrayList;
import java.util.List;

/**
 * 020：ジェネリクス.
 * 以下の配列`MEDALS`について、ジェネリクスを用いた場合のリストと用いない場合のリストにそれぞれ要素を入れ、
 * それぞれのリストについて、全要素を順番に出力するためのプログラムを実装せよ.
 *
 * <pre>
 * private static final String[] MEDALS = new String[]{
 *    "GOLD", "SILVER", "BRONZE"
 * };
 * </pre>
 *
 * @author toastkidjp
 *
 */
public class Knock020 {

    /** Medals. */
    private static final String[] MEDALS = new String[]{
       "GOLD", "SILVER", "BRONZE"
    };

    /**
     * main method.
     * @param args
     */
    public static void main(final String[] args) throws InterruptedException {
        withGeneric();
        withoutGeneric();
    }

    /**
     * ジェネリクスありのリストを使った場合.
     */
    private static void withGeneric() {
        final List<String> medals = new ArrayList<String>(MEDALS.length);

        for (final String medal : MEDALS) {
            medals.add(medal);
        }

        for (final String medal : medals) {
            System.out.println(medal);
        }
    }

    /**
     * ジェネリクスなしのリストを使った場合.
     */
    private static void withoutGeneric() {
        final List medals = new ArrayList(MEDALS.length);

        for (final Object medal : MEDALS) {
            medals.add(medal);
        }

        for (final Object medal : medals) {
            System.out.println(medal);
        }
    }
}
