import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

/**
 * 009の解答です。
 *
 * @author jsfkdt
 */
public class Answer009 {
    /**
     * 009の解答です。
     * @param arguments 使用しません。
     */
    public static void main (String[] args) {

        Properties properties = new Properties();
        
        //配列に値が入っていない場合、強制終了
        if (args.length < 1 ) {
            System.err.println("引数にファイルパスを指定し、再実行して下さい");
            System.exit(1);
        }
        String file = args[0];
        
        try (InputStream inputStream = new FileInputStream(file)) {
            System.out.println(file+"を読み込んだ結果... ");
            //読み込んだファイルをプロパティへロード
            properties.load(inputStream);

            //値の取得
            System.out.println(properties);
            System.out.println();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
