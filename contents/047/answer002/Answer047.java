import java.util.Date;

public class Answer047 {
    public static void main(String[] arguments) {
        // 現在時刻をフォーマットして表示
        String dateStr = FormatUtil.dateToFormatString(new Date());
        System.out.println(dateStr);
    }
}
