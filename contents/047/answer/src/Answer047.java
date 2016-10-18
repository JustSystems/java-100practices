import java.util.Date;

/**
 * 047の解答です。
 *
 * @author jsfkdt
 */
public class Answer047 {
    
    /**
     * 047の解答です.
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        
        // 定められたフォーマットを返却するユーティリティを使用.
        final String dayAndTime = new FormatUtil().dayAndTime(new Date());
        
        // 日時を標準出力.
        System.out.println(dayAndTime);
    }
}
