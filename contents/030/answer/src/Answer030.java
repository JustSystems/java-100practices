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
        try (FileOutputStream outputFile = new FileOutputStream("Sample.txt")) {
            
            // 出力オブジェクトの生成.
            try (ObjectOutputStream outputObject = new ObjectOutputStream(outputFile)) {
                
                // シリアライズ対象のクラスの書き込み
                outputObject.writeObject(new ForSerializeClass());
                
            } catch (IOException e) {
                // 入出力エラー.
                e.printStackTrace();
            }
            
        } catch (IOException e) {
            // 入出力エラー.
            e.printStackTrace();
        }
        
        // ファイルをデシリアライズし、インスタンス変数を標準出力.
        try (FileInputStream inputFile = new FileInputStream("Sample.txt")) {
            
            // 入力オブジェクトの生成.
            try (ObjectInputStream inputObject = new ObjectInputStream(inputFile)) {
                
                // オブジェクトの読み込み.
                ForSerializeClass serializeClass = (ForSerializeClass)inputObject.readObject();
                
                // オブジェクトのインスタンス変数に値を設定する.
                serializeClass.setIntInstance(100);
                serializeClass.setStringInstance("Answer030");
                
                // 読み込んだオブジェクトのインスタンス変数を標準出力.
                System.out.println(serializeClass.intInstance);
                System.out.println(serializeClass.stringInstance);
                
            } catch (IOException  e) {
                e.printStackTrace();
            }
            
        } catch (IOException  e) {
            // 入出力エラー.
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // クラスが存在しない.
            e.printStackTrace();
        }
    }
}
