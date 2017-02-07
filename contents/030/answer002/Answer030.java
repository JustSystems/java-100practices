import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ClassNotFoundException;

public class Answer030 {
    /**
     * オブジェクトをシリアライズしてファイルに保存し、そのファイルを読み込んでデシリアライズする。
     * また、その前後でオブジェクトの変数値が一致していることを確認する。
     */
    public static void main(String arguments[]) {
        try {
            // シリアライズ可能なクラスのオブジェクト
            SerializableClass before = new SerializableClass();

            // "t.tmp"ファイルに書き込むためのFileOutputStreamを作成
            FileOutputStream fos = new FileOutputStream("t.tmp");
            //　"t.tmp"ファイルに書き込むObjectOutputStreamを作成
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // ファイルへ書き込む
            oos.writeObject(before);
            oos.close();

            // "t.tmp"ファイルを開くFileInputStreamを作成
            FileInputStream fis = new FileInputStream("t.tmp");
            // "t.tmp"ファイルから読み込むObjectInputStreamを作成
            ObjectInputStream ois = new ObjectInputStream(fis);
            // SerializableClassのオブジェクトとして読み込む
            SerializableClass after = (SerializableClass) ois.readObject();
            ois.close();

            if (before.getId() == after.getId()) {
                System.out.println("id matched");
            }
            if (before.getName().equals(after.getName())) {
                System.out.println("name matched");
            }
        }
        // ファイルが存在せず作成もできない場合
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 入出力エラーが発生した場合
        catch (IOException e) {
            e.printStackTrace();
        }
        // 直列化されたオブジェクトのクラスが見つからなかった場合
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
