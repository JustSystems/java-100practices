import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 047で使用するユーティリティクラス.
 *
 * @author jsfkdt
 */
public final class FormatUtil {
    
    /**
     * 定められたフォーマットで日時を返却する
     *
     * @param  date  Date型変数
     * @return 定めたフォーマットでの日時.引数がnullの場合はnullを返却.
     */    
    public final String dayAndTime(final Date date) {
        if (date == null) {
            return null;
        }
        
        // フォーマットを定める.
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        
        //定めたフォーマットで返却.
        return df.format(date);
    }
}