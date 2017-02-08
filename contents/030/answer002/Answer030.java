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
        // "t.tmp"ファイルに書き込むObjectOutputStreamを作成
        // "t.tmp"ファイルから読み込むObjectInputStreamを作成
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("t.tmp"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("t.tmp"))) {
            // シリアライズ可能なクラスのオブジェクト
            SerializableClass before = new SerializableClass();
            before.setId(123);
            before.setName("hogehoge");

            // ファイルへ書き込む
            oos.writeObject(before);
            // SerializableClassのオブジェクトとして読み込む
            SerializableClass after = (SerializableClass) ois.readObject();

            if (before.getId() == after.getId()) {
                System.out.println("id matched : " + before.getId() + " = " + after.getId());
            }
            if (before.getName().equals(after.getName())) {
                System.out.println("name matched : " + before.getName() + " = " + after.getName());
            }
        } catch (FileNotFoundException e) {
            // ファイルが存在せず作成もできない場合
            e.printStackTrace();
        } catch (IOException e) {
            // 入出力エラーが発生した場合
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // 直列化されたオブジェクトのクラスが見つからなかった場合
            e.printStackTrace();
        }
    }
}
