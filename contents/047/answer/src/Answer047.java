import java.util.Date;

/**
 * 047の解答です。
 *
 * @author jsfkdt
 */
public class Answer047 {
    /* Date型変数. */
    private Date day;
    
    /**
     * Date型変数に格納する.
     *
     * @param day Date型変数
     */
    Answer047 (Date day) {
        this.day = day;
    }
    
    /**
     * 047の解答です.
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        // 現在の日付を格納し、Answer047オブジェクトを生成.
        final Answer047 answer047 = new Answer047(new Date());
        
        // 定められたフォーマットを返却するユーティリティを使用.
        final String dayAndTime = new FormatUtil().dayAndTime(answer047.day);
        
        // 日時を標準出力.
        System.out.println(dayAndTime);
    }
}
