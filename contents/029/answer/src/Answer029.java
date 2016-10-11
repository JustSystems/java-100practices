import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
/**
 * 029の解答です.
 *
 * @author jsfkdt
 */
public class Answer029 {
    /**
     * 029の解答です.
     * リフレクションを用いて、StringBufferクラスのインスタンスを生成し、
     * append(String)メソッドを呼び出す.
     * Answer029を標準出力で取得する.
     *
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        
        try {
            /* ジェネリクスを用いて、呼び出すクラスを初期化. */
            Class<?> stringBufferClass = null;
            
            /* 呼び出すメソッドの初期化. */
            Method appendMethod = null;
            
            // 使用するクラスを明示し、呼び出す.
            stringBufferClass = Class.forName("java.lang.StringBuffer");
            
            // appendメソッドを使用する.引数はString型であることを明示する.
            appendMethod = stringBufferClass.getMethod("append", String.class);
            
            // StringBufferクラスのインスタンスを生成.
            StringBuffer sb = (StringBuffer) stringBufferClass.newInstance();
            
            // 値の挿入.
            appendMethod.invoke(sb, "A");
            appendMethod.invoke(sb, "n");
            appendMethod.invoke(sb, "s");
            appendMethod.invoke(sb, "w");
            appendMethod.invoke(sb, "e");
            appendMethod.invoke(sb, "r");
            appendMethod.invoke(sb, "029");
            
            // 連結された値の標準出力を行う.
            System.out.println(sb.toString());
        } catch (NullPointerException e) {
            // nullエラー.
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            // クラスが存在しない.
            e.printStackTrace ();
        } catch (NoSuchMethodException e) {
            // メソッドが存在しない.
            e.printStackTrace();
        } catch (InstantiationException e) {
            // インスタンス作成不可.
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // 呼び出し:アクセス違反、保護されている.
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // 呼び出し:引数が異なる.
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // ターゲットとなるメソッド自身の例外処理.
            e.printStackTrace();
        }
    }
}