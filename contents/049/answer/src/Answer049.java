import java.util.Date;

/**
 * 049の解答です。
 *
 * @author jsfkdt
 */
public class Answer049 {
    /* Date型変数. */
    private Date day;
    
    /**
     * Date型変数に格納する.
     *
     * @param day Date型変数
     */
    Answer049 (Date day) {
        this.day = day;
    }
    
    /**
     * 049の解答です.
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        // 現在の日付を格納し、Answer049オブジェクトを生成.
        final Answer049 answer049 = new Answer049(new Date());
        
        // 現在日付から±1日のランダムな日時を取得.
        final Date randomDate = new DateUtil().randomDayAndTime();
        
        // 取得した日時を標準出力.
        System.out.println(randomDate);
    }
}
