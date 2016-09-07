import java.util.Arrays;
import java.util.List;

/**
 * 033：ラムダ式.
 * 0～9の整数が1つずつ入った10個を要素に持つリストに対して、奇数だけを標準出力するプログラムをラムダ式を用いて実装せよ。
 *
 * @author toastkidjp
 *
 */
public class Knock033 {

    /**
     * main method.
     * @param args
     */
    public static void main(final String[] args) {
        final List<Integer> zeroToNine = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        zeroToNine.stream().filter(i -> i % 2 == 1).forEach(System.out::println);
    }
}
