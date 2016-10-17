import java.util.Locale;
import java.util.ResourceBundle;
import java.text.MessageFormat;
import java.util.MissingResourceException;

/**
 * 038の解答です.
 *
 * @author jsfkdt
 */
public class Answer038 {
    
    /**
     * 038の解答です.
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        
        // 配列に値が入っていない場合、強制終了.
        if (args.length < 1 ) {
            System.err.println("引数に置換後文字列を入力し、再実行してください。");
            System.exit(1);
        }
        
        /* 変換後文字列を取得. */
        final String afterWord = args[0];
        
        /* リソースファイル. */
        final ResourceBundle resource;
        
        /* ファイル名を設定. */
        final String fileName = "output";
        
        
        try {
            // ロケールが日本の場合.
            if ("JP".equals(Locale.getDefault().getCountry())) {
                resource = ResourceBundle.getBundle(fileName, Locale.JAPAN);
            } else {
                //ロケールが日本以外の場合.
                resource = ResourceBundle.getBundle(fileName, Locale.US);
            }
            
            // 文字列を置換し、標準出力.
            System.out.println(MessageFormat.format(resource.getString("sentence"), afterWord));
        
        } catch (MissingResourceException e) {
            e.printStackTrace();
        }
    }
}