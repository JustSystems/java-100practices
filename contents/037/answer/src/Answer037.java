import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Cloneable;
/**
 * 037の解答です。
 *
 * @author jsfkdt
 */
public class Answer037 implements Cloneable {    
    /* Date型リスト */
    private List<Date> dateList = new ArrayList<Date>();
    
    /**
     * 037の解答です.
     * @param arguments 使用しません.
     */
    @Deprecated
    public static void main(final String[] args) throws ParseException {
        SimpleDateFormat yearMonthDay = new SimpleDateFormat("yyyy/mm/dd");
        
        /* Date型 過去日付 */
        String pastDay = "2015/01/17";
        Date pastDate = yearMonthDay.parse(pastDay);
        
        /* Date型 未来日付 */
        String furtureDay = "2017/06/06";
        Date futureDate = yearMonthDay.parse(furtureDay);
        
        /* Date型 今日日付 */
        Date today = new Date();
        
        // インスタンスを生成（コピー元）.
        Answer037 dateInstance = new Answer037();
        
        // リストへDATE型オブジェクトを格納.
        dateInstance.dateList.add(pastDate);
        dateInstance.dateList.add(today);
        dateInstance.dateList.add(futureDate);
        
        // ディープコピーを行う.
        Answer037 deepCopyDateInstance = dateInstance.clone();
        
        // シャローコピーを行う.
        List<Date> shallowDateList = shallowCopy(dateInstance.dateList);
        
        // 元データの書き換え
        shallowDateList.get(0).setDate(1);
        
        // 元データの標準出力.
        System.out.println(dateInstance.dateList.get(0).getDate());
        // ディープコピーデータの標準出力.
        System.out.println(deepCopyDateInstance.dateList.get(0).getDate());
        // シャローコピーデータの標準出力.
        System.out.println(shallowDateList.get(0).getDate());
        
    }
    
    /**
     * オブジェクトのディープコピーを行い、コピー後オブジェクトを返却する.
     *
     * @return Answer037オブジェクト
     */ 
    @Override
    public Answer037 clone() {
        try {
            // スーパークラスのcloneメソッドを呼ぶ.
            Answer037 result = (Answer037)super.clone();
            
            // 新規リストの作成.
            List<Date> copiedDateList = new ArrayList<Date>();
            
            // Date型の要素を取得.
            Date pastDate = new Date(result.dateList.get(0).getTime());
            Date today = new Date(result.dateList.get(1).getTime());
            Date futureDate = new Date(result.dateList.get(2).getTime());
            
            // リストへDate型を代入.
            copiedDateList.add(pastDate);
            copiedDateList.add(today);
            copiedDateList.add(futureDate);
            
            // リストそのものを上書きする.
            result.dateList = copiedDateList;
            
            // 結果を返す.
            return result;
        } catch(CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    
    /**
     * オブジェクトのシャローコピーを行い、コピー後リストを返却する.
     *
     * @return Date型リスト
     */
    public static List<Date> shallowCopy(List<Date> shallowList) {
        List<Date> shallowDateList = new ArrayList<Date> (shallowList);
        return shallowDateList;
    }
}