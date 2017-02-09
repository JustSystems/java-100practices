import java.util.Locale;
import java.util.ResourceBundle;
import java.text.MessageFormat;

public class Answer038 {
    /**
     * 引数に対するメッセージを出力する.
     * ロケールが日本の場合は日本語で、それ以外のロケールの場合は英語で出力する。
     * @param String[] arguments 第1引数に文字列を入力
     */
    public static void main(String[] arguments) {
        // 第1引数がなければUsageを表示して終了
        if (arguments.length < 1) {
            System.out.println("Usage: Please input one argument.");
            exit(2);
        }

        ResourceBundle rb = null;

        if (Locale.JAPAN.equals(Locale.getDefault())) {
            rb = ResourceBundle.getBundle("messageAscii", Locale.JAPAN);
        } else {
            // ロケールが日本以外の場合は、英語でメッセージを表示
            rb = ResourceBundle.getBundle("messageAscii", Locale.ENGLISH);
        }

        System.out.println(MessageFormat.format(rb.getString("error"), arguments[0]));
    }
}
