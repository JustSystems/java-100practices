import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtil {
    /**
     * "yyyy-MM-dd HH:mm:ss.SSS"の形で日時をフォーマットした文字列を作成する.
     * @param  Date date フォーマットする日時
     * @return 引数で受け取った日時をフォーマットした文字列。引数がnullの場合はnullを返す。
     */
    public static String dateToFormatString(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(date);
    }
}
