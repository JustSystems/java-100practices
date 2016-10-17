import java.util.Date;
import java.util.Random;
import java.util.Calendar;

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
        Calendar oneAfterDay = Calendar.getInstance();
        oneAfterDay.add(Calendar.DATE, 1);
        
        // 一日前の日時.
        Calendar oneBeforeDay = Calendar.getInstance();
        oneBeforeDay.add(Calendar.DATE, -1);
        
        // ミリ秒の差を取得.
        final long timeDiff = oneAfterDay.getTimeInMillis() - oneBeforeDay.getTimeInMillis();
        
        // ミリ差の値をランダムで指定.
        final int random = new Random().nextInt((int)timeDiff + 1);
        
        // ランダムな年月日の生成.
        oneAfterDay.add(oneAfterDay.MILLISECOND, -random);
        
        // Calendar型をDate型へ変換.
        randomDate = oneAfterDay.getTime();
        
        return randomDate;
    }
}