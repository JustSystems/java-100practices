import java.lang.reflect.Field;
import java.lang.NoSuchFieldException;
import java.lang.IllegalAccessException;

public class Answer032 {
    /**
     * コマンド入力時に第1引数で受け取った数値が3で割り切れるかを判定する.
     * @param String arguments[] 第1引数に数値を入力
     */
    public static void main(String arguments[]) {
        MyNumber argNum = new MyNumber();

        if (arguments.length >= 1) {
            try {
                argNum.num = Integer.parseInt(arguments[0]);

                if (isDivisibleNumberByThree(argNum)) {
                    System.out.println("3で割り切れる値が入力されました");
                } else {
                    System.out.println("3で割り切れない値が入力されました");
                }
            } catch (NumberFormatException | MalformedClassException | NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @IsDivisibleByThreeを付与したフィールドの値が3で割り切れる値であることを判定する.
     * @param Number number @IsDivisibleByThreeを付与したフィールドを持つクラスのオブジェクト
     * @throws MalformedClassException @IsDivisibleByThreeを付与したフィールドがない場合
     * @throws NoSuchFieldException フィールドが見つからない場合
     * @throws IllegalAccessException フィールドにアクセスできない場合
     * @return 値が3で割り切れる場合はtrueを返す。3で割り切れない場合はfalseを返す。
     */
    private static boolean isDivisibleNumberByThree (MyNumber number)
        throws MalformedClassException, NoSuchFieldException, IllegalAccessException {
        Field field = number.getClass().getDeclaredField("num");
        // fieldに@IsDivisibleByThreeが付与されている場合
        if (field.getAnnotation(IsDivisibleByThree.class) == null) {
            throw new MalformedClassException("@IsDivisibleByThreeが付与されているフィールドがありません");
        }

        int fieldNum = (int) field.get(number);
        return (fieldNum % 3 == 0);
    }
}
