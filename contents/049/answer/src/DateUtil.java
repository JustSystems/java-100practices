import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 049で使用するユーティリティクラス.
 *
 * @author jsfkdt
 */
public final class DateUtil {
    
    /**
     * 現在時刻からプラスマイナス1日の範囲でランダムな日時を示す.
     *
     * @return 現在時刻からプラスマイナス1日のランダムなDate型日時
     */    
    public final Date randomDayAndTime() {
        // Date型の日時.
        Date randomDate = new Date();
        
        // 一日後の日時.
        final Calendar oneAfterDay = Calendar.getInstance();
        oneAfterDay.add(Calendar.DATE, 1);
        
        // 一日前の日時.
        final Calendar oneBeforeDay = Calendar.getInstance();
        oneBeforeDay.add(Calendar.DATE, -1);
        
        // ランダムな日時
        final Calendar randomDay = Calendar.getInstance();
        
        // ミリ秒の差を取得.
        final long timeDiff = oneAfterDay.getTimeInMillis() - oneBeforeDay.getTimeInMillis();
        
        // ミリ差の値をランダムで指定.
        // ThreadLocalRandomクラスを用いて、指定範囲内のLong型乱数を生成する.
        final long randomDiffTime = ThreadLocalRandom.current().nextLong(timeDiff + 1L);
        
        // 1日後のミリ秒からランダム生成したミリ秒を減算.
        final long randomTime = oneAfterDay.getTimeInMillis() - randomDiffTime;
        
        // 取得したミリ秒をカレンダーに設定.
        randomDay.setTimeInMillis(randomTime);
        
        // Calendar型をDate型へ変換.
        randomDate = randomDay.getTime();
        
        return randomDate;
    }
}