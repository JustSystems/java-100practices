import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.Map;
import java.util.HashMap;
import java.util.Locale;
/**
 * 038の解答です.
 *
 * @author jsfkdt
 */
public class Answer038 {
    /**
     * 038の解答です.
     * ロケールを取得し、ロケールに合致するプロパティファイルを読み込みます.
     * 読み込んだファイルに指定されたキーと値を取得し、
     * その値の中から"x"を探し、コマンドライン引数で指定した値で置換します。
     * そして置換後の文章を標準出力します。
     *
     * @param arguments
     */
    public static void main(final String[] args) {
        
        // 配列に値が入っていない場合、強制終了.
        if (args.length < 1 ) {
            System.err.println("引数に置換後文字列を入力し、再実行してください。");
            System.exit(1);
        }
        /* 変換後文字列を取得 */
        String afterWord = args[0];
        
        /* ロケールの取得. */
        String country = getLocale();
        
        /* ロケールを元に、プロパティファイルのpathを取得. */
        final String propertiesFileName = findPropertiesFile(country) + "Map.properties";
        
        /* プロパティファイルを読み込んだマップを取得. */
        Map propertiesMap = propertiesToMap(propertiesFileName);
        
        /* keyに対応する値をString型で取得. */
        String beforeSentence = propertiesMap.get(findPropertiesFile(country)).toString();
        
        /* 変換前の文章を標準出力. */
        System.out.println(beforeSentence);
        
        /* 変換後の文章を取得. */
        String afterSentence = convertSentence(beforeSentence, afterWord);
        
        /* 変換後の文章を標準出力. */
        System.out.println(afterSentence);
    }
    
    /**
     * スケールを取得し、国名を返却する.
     *
     * @return 国名
     */
    public static String getLocale() {
        /* 現在のロケールを取得. */
        Locale location = Locale.getDefault();
        
        /* 国名を取得. */
        String country = location.getCountry();
        
        return country;
    }
    
    /**
     * プロパティファイル名の接頭語を返却する.
     *
     * @return ファイル名
     */
    public static String findPropertiesFile(String country) {
        if("JP".equals(country)) {
            // 日本語ファイル
            return "Japanese";
        } else {
            // 英語ファイル
            return "English";
        }
    }
    
    /**
     * プロパティファイルからマップを取得し、結果を返却する.
     *
     * @param propertiesFileName 対象のプロパティファイル
     * @return プロパティファイルのマップ
     */
    @SuppressWarnings("unchecked")
    public static Map propertiesToMap(String propertiesFileName) {
        
        Map propertiesMap = new HashMap();
        Properties property = new Properties();
        // プロパティファイルをロード.
        try {
            property.load(new FileInputStream(propertiesFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // プロパティファイル内容をマップに登録.
        for (Entry<Object, Object> e : property.entrySet()) {
            propertiesMap.put(e.getKey(), e.getValue());
        }
        
        return propertiesMap;
    }
    
    /**
     * 変換後の標準出力用文字列を返却する.
     *
     * @param beforeSentence 変換前の文字列
     * @param afterWord 変換後キーワード
     * @return 変換後の文字列
     */
    public static String convertSentence(String beforeSentence, String afterWord) {
        /* xに当たる箇所. */
        String regex = "x";
        
        // 指定の正規表現をパターンにコンパイルする.
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(beforeSentence);
        
        /* 変換後の文章. */
        String afterSentence = m.replaceFirst(afterWord);
        
        return afterSentence;
    }
}