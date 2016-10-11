import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
/**
 * 030の解答です.
 *
 * @author jsfkdt
 */
public class Answer030 {
    /**
     * 030の解答です.
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        
        // クラスをシリアライズしてファイルに保存.
        try (ObjectOutputStream outputObject = new ObjectOutputStream(new FileOutputStream("Sample.txt"))) {
            
            // シリアライズクラスのインスタンスを生成.
            ForSerializeClass serializeClass = new ForSerializeClass();
            
            // オブジェクトのインスタンス変数に値を設定する.
            serializeClass.setIntInstance(100);
            serializeClass.setStringInstance("Answer030");
            
            // シリアライズ対象のクラスの書き込み
            outputObject.writeObject(serializeClass);
            
        } catch (IOException e) {
            // 入出力エラー.
            e.printStackTrace();
        }
        
        // ファイルをデシリアライズし、インスタンス変数を標準出力.
        try (ObjectInputStream inputObject = new ObjectInputStream(new FileInputStream("Sample.txt"))) {
            
            // オブジェクトの読み込み.
            ForSerializeClass serializeClass = (ForSerializeClass) inputObject.readObject();
            
            // 読み込んだオブジェクトのインスタンス変数の妥当性をチェック.
            assert serializeClass.getIntInstance() == 100
                : "デシリアライズに失敗しました。int型変数の値：" + serializeClass.getIntInstance();
            
            assert serializeClass.getStringInstance().equals("Answer030")
                : "デシリアライズに失敗しました。String型変数の値：" + serializeClass.getStringInstance();
            
        } catch (IOException  e) {
            // 入出力エラー.
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // クラスが存在しない.
            e.printStackTrace();
        }
    }
}
