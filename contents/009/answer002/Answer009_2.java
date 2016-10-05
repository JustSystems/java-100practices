import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 009の解答です。
 *
 * @author jsfkdt
 */
public class Answer009_2 {
    /**
     * 009の解答です。
     * @param arguments 使用しません。
     */
    public static void main (String[] args) {

        Properties properties = new Properties();

        String file = args[0];
    	System.out.println("[ "+file+"を読み込んだ結果... ]");
        try {
            //ファイルを読み込み
            InputStream inputStream = new FileInputStream(file);
            //読み込んだファイルをプロパティへロード
            properties.load(inputStream);
            inputStream.close();

            //値の取得
            System.out.println(properties.getProperty("id"));
            System.out.println(properties.getProperty("password"));
            System.out.println(properties.getProperty("place"));
            System.out.println(properties.getProperty("name"));
        	System.out.println();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
