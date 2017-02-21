import java.util.stream.IntStream;
/**
 * 054の解答です.
 *
 * @author jsfkdt
 */
public class Answer054 {
    /**
     * 054の解答です.
     * java.util.streamのAPIを用いて、
     * 1から100までの整数に含まれる偶数だけを加算した結果を求める.
     *
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {

        /* IntStreamを用いて、1～100のうち偶数だけを抽出し、合計を標準出力. */
        System.out.println(IntStream.rangeClosed(1, 100).filter(x -> x % 2 == 0).sum());
    }
}