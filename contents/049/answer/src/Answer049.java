import java.util.Date;

/**
 * 049の解答です。
 *
 * @author jsfkdt
 */
public class Answer049 {
    
    /**
     * 049の解答です.
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        
        // 現在日付から±1日のランダムな日時を取得.
        final Date randomDate = new DateUtil().randomDayAndTime();
        
        // 取得した日時を標準出力.
        System.out.println(randomDate);
    }
}
