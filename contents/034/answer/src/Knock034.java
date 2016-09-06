
/**
 * 034：メソッド参照.
 * 以下のプログラムの★部分に36文字以内でコードを挿入し、`medals`の内容を1行につき1つずつ標準出力に出力するプログラムにせよ.
 * <pre>
 * public class Knock034 {
 *     public static void main(String[] arguments) {
 *         java.util.List<String> medals = new java.util.ArrayList<>();
 *         medals.add("gold");
 *         medals.add("silver");
 *         medals.add("bronze");
 *         ★
 *     }
 * }
 * </pre>
 *
 * @author toastkidjp
 *
 */
public class Knock034 {

    /**
     * main method.
     * @param args
     */
    public static void main(final String[] args) {
        final java.util.List<String> medals = new java.util.ArrayList<>();
        medals.add("gold");
        medals.add("silver");
        medals.add("bronze");
        medals.forEach(System.out::println);
    }

}
