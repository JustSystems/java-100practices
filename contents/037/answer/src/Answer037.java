import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Cloneable;
import java.lang.InternalError;
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
        dateInstance.dateList.get(0).setDate(1);
        
        // ディープコピーデータの標準出力.
        if (deepCopyDateInstance == null) {
            System.out.println(deepCopyDateInstance);
        } else {
            System.out.println(deepCopyDateInstance.dateList.get(0).getDate());
        }
        
        // シャローコピーデータの標準出力.
        if (shallowDateList == null) {
            System.out.println(shallowDateList);
        } else {
            System.out.println(shallowDateList.get(0).getDate());
        }
        
    }
    
    /**
     * オブジェクトのディープコピーを行い、コピー後オブジェクトを返却する.
     *
     * @return Answer037オブジェクト.オブジェクトのdateListがnullの場合はオブジェクトを返却.
     */ 
    @Override
    public Answer037 clone() {
        try {
            // スーパークラスのcloneメソッドを呼ぶ.
            Answer037 result = (Answer037)super.clone();
            
            // 新規リストの作成.
            List<Date> copiedDateList = new ArrayList<Date>();
            
            if (result.dateList == null) {
                // nullの場合は、オブジェクトを返却.
                return result;
                
            }
            
            // Date型の要素を取得し、リストへ代入.
            for (Date dateInstance : result.dateList) {
                if (dateInstance == null) {
                    copiedDateList.add(null);
                } else {
                    copiedDateList.add(new Date(dateInstance.getTime()));
                }
            }
            
            // リストそのものを上書きする.
            result.dateList = copiedDateList;
            
            // 結果を返す.
            return result;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
    
    /**
     * オブジェクトのシャローコピーを行い、コピー後リストを返却する.
     *
     * @return Date型リスト. 引数がnullの時は、nullを返却.
     */
    public static List<Date> shallowCopy(List<Date> shallowList) {
        // nullの場合は、nullを返却.
        if (shallowList == null) {
            return null;
        }
        return new ArrayList<Date> (shallowList);
    }
}