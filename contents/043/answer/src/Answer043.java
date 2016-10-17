import java.util.Date;
import java.text.SimpleDateFormat;
import java.lang.Cloneable;
import java.lang.InternalError;
/**
 * 043の解答です。
 *
 * @author jsfkdt
 */
public class Answer043 implements Cloneable {    
    /* Date型インスタンス */
    Date targetDay = new Date(1421453545000L);
    
    /**
     * 043の解答です.
     * @param arguments 使用しません.
     */
    @Deprecated
    public static void main(final String[] args) {
        
        // インスタンスの生成.
        Answer043 answer043 = new Answer043();
        
        // ディープコピーを行う.
        Answer043 deepCopyDateInstance = answer043.clone();
        
        // 元データの書き換え
        answer043.targetDay.setTime(1476423938529L);
        
        // ディープコピーデータの標準出力.
        if (deepCopyDateInstance == null) {
            System.out.println(deepCopyDateInstance);
        } else {
            // 書き換え前データのインスタンス生成時刻を出力.
            System.out.println("インスタンス生成時刻「"
                    + convertToTime(deepCopyDateInstance.targetDay) + "」");
        }
        
        // 書き換え後データの時刻を出力.
        System.out.println("書き換え後の時刻「"
                + convertToTime(answer043.targetDay) + "」");
    }
    
    /**
     * オブジェクトのディープコピーを行い、コピー後オブジェクトを返却する.
     *
     * @return Answer043オブジェクト.
     */
    @Override
    public Answer043 clone() {
        try {
            // スーパークラスのcloneメソッドを呼ぶ.
            Answer043 result = (Answer043)super.clone();
            
            // Date型インスタンスを生成.
            Date copiedDate = new Date();
            
            // 生成したインスタンスで元データを上書き.
            result.targetDay = copiedDate;
            
            // 結果を返す.
            return result;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
    
    /**
     * Date型変数が保有する日時を時刻表示に変換する.
     *
     * @param target Date型変数
     * @return 時刻. Date型変数がnullの場合はnullを返却.
     */    
    public static String convertToTime(Date target) {
        // 時刻フォーマット.
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        if (target == null) {
            return null;
        } else {
            return df.format(target);
        }
    }
}