import java.util.Date;
import java.util.Calendar;
import java.util.Random;

public class DateUtil {
    /**
     * 現在時刻を基準に前後一日の範囲でランダムな日時を返す.
     */
    public static Date getRandomDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        // 時フィールドに対して-23から23の間のランダムな値を加算する
        cal.add(Calendar.HOUR, getRandomInt(23));
        // 分フィールドに対して-59から59の間のランダムな値を加算する
        cal.add(Calendar.MINUTE, getRandomInt(59));
        // 秒フィールドに対して-59から59の間のランダムな値を加算する
        cal.add(Calendar.SECOND, getRandomInt(59));
        // ミリ秒フィールドに対して-999から999の間のランダムな値を加算する
        cal.add(Calendar.MILLISECOND, getRandomInt(999));

        return cal.getTime();
    }

    /**
     * 0を基準に前後を指定された値の範囲でランダムな値を返す.
     * ex.) 引数で10を指定されたら、-10から10の範囲でランダムの数値を返す
     * @param  int range ランダムで返す値の絶対値の最大値
     */
    private static int getRandomInt(int range) {
        Random rand = new Random();
        return (rand.nextInt(range * 2 + 1) - range);
    }
}
