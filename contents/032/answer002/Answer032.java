import java.lang.reflect.Field;

public class Answer032 {
    /**
     * コマンド入力時に第1引数で受け取った数値が3で割り切れるかを判定する.
     * @param String arguments[] 第1引数に数値を入力
     */
    public static void main(String arguments[]) {
        Number argNum = new Number();

        if (arguments.length >= 1) {
            try {
                argNum.num = Integer.parseInt(arguments[0]);

                if (isDivisibleNumberByThree(argNum)) {
                    System.out.println("3で割り切れる値が入力されました");
                } else {
                    System.out.println("3で割り切れない値が入力されました");
                }
            } catch (NumberFormatException e) {
                // 第1引数が数値以外の場合
                e.printStackTrace();
            } catch (Exception e) {
                // @IsDivisibleByThreeが付与されているフィールドがない場合
                e.printStackTrace();
            }
        }
    }

    /**
     * @IsDivisibleByThreeを付与したフィールドの値が3で割り切れる値であることを判定する.
     * @param Number number @IsDivisibleByThreeを付与したフィールドを持つクラスのオブジェクト
     * @throws Exception @IsDivisibleByThreeを付与したフィールドがない場合
     * @return 値が3で割り切れる場合はtrueを返す。3で割り切れない場合はfalseを返す。
     */
    private static boolean isDivisibleNumberByThree (Number number) throws Exception {
        Field field = number.getClass().getDeclaredField("num");
        // fieldに@IsDivisibleByThreeが付与されている場合
        if (field.getAnnotation(IsDivisibleByThree.class) == null){
            throw new Exception("@IsDivisibleByThreeが付与されているフィールドがありません");
        }

        int fieldNum = (int) field.get(number);
        return (fieldNum % 3 == 0);
    }
}
