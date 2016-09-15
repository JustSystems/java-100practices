
/**
 * 039：例外(1).
 * 次のプログラムをコンパイル・実行するとどうなるか？（実際に実行させずに解答すること）
 *
 * @author jswaf
 */
public class Knock039 {

    /**
     * main method.
     * @args arguments
     */
    public static void main(String[] arguments) {
        try {
            try {
                throw new Exception("1st");
            } finally {
                throw new Exception("2nd");
            }
        } catch (Exception happened) {
            System.out.println(happened.getMessage());
        }
    }
}
