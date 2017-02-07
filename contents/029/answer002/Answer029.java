import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class Answer029 {
    /**
     * java.lang.StringBufferクラスのインスタンスを生成しappend(String)メソッドを呼び出す.
     */
    public static void main(String arguments[]) {
        try {
            // java.lang.StringBufferクラスのClassオブジェクトを作成
            Class<?> stringBufferClass = Class.forName("java.lang.StringBuffer");
            // append(String)メソッドのMethodオブジェクトを取得
            Method appendMethod = stringBufferClass.getMethod("append", Class.forName("java.lang.String"));
            // StringBuffer型のインスタンスを作成。Object型で返ってくるためキャストする
            StringBuffer stringBuffer = (StringBuffer) stringBufferClass.newInstance();

            // stringBufferに対して、append("hoge")を呼ぶ
            appendMethod.invoke(stringBuffer, "hoge");
            System.out.println(stringBuffer.toString());
        }
        // 名前が一致するクラスが見つからない場合
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 一致する名前・引数のメソッドが見つからない場合
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        // このClassが抽象クラス、インタフェースなどでインスタンスの生成が失敗した場合
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        // クラスまたはその引数なしのコンストラクタにアクセスできない場合
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
