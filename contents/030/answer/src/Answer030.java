import java.io.*;
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
            ObjectOutputStream outputObject = new ObjectOutputStream(outputFile);
            
            // シリアライズ対象のクラスの書き込み
            outputObject.writeObject(new ForSerializeClass());
            
            // オブジェクト出力ストリームのクローズ.
            outputObject.close();
            
        } catch (IOException e) {
            // 入出力エラー.
            e.printStackTrace();
        }
        
        // ファイルをデシリアライズし、インスタンス変数を標準出力.
        try (FileInputStream inputFile = new FileInputStream("Sample.txt")) {
            // 入力オブジェクトの生成.
            ObjectInputStream inputObject = new ObjectInputStream(inputFile);
            
            // オブジェクトの読み込み.
            ForSerializeClass serializeClass = (ForSerializeClass)inputObject.readObject();
            
            // 読み込んだオブジェクトのインスタンス変数を標準出力.
            System.out.println(serializeClass.intInstance);
            System.out.println(serializeClass.stringInstance);
            
            // オブジェクト入力ストリームのクローズ.
            inputObject.close();
            
        } catch (IOException  e) {
            // 入出力エラー.
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // クラスが存在しない.
            e.printStackTrace();
        }
    }
}

/**
 * 030用のインスタンス変数を持つクラスです.
 *
 * @author jsfkdt
 */
class ForSerializeClass implements Serializable {
    /* int型のインスタンス変数 */
    int intInstance = 100;
    /* String型のインスタンス変数 */
    String stringInstance = "Answer030";
}