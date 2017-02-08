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
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            // シリアライズ可能なクラスのオブジェクト
            SerializableClass before = new SerializableClass();
            before.setId(123);
            before.setName("hogehoge");

            //　"t.tmp"ファイルに書き込むObjectOutputStreamを作成
            oos = new ObjectOutputStream(new FileOutputStream("t.tmp"));
            // ファイルへ書き込む
            oos.writeObject(before);

            // "t.tmp"ファイルから読み込むObjectInputStreamを作成
            ois = new ObjectInputStream(new FileInputStream("t.tmp"));
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
        } finally {
            if (oos != null && ois != null) {
                try {
                    oos.close();
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
