import java.lang.reflect.Field;

/**
 * 032の解答です.
 *
 * @author jsfkdt
 */
public class AnnoationUsingSamle {

    /**
     * 032の解答です.
     * アノテーションを用いて、
     * 引数に指定された値が3の倍数であるかどうかのチェックを行う.
     *
     * @param arguments
     */
    public static void main(final String[] args) throws Exception {

        // 配列に値が入っていない場合、強制終了
        if (args.length < 1) {
            System.err.println("引数に数値を指定し、再実行して下さい。");
            System.exit(1);
        }

        try {
            User user = getUser(Integer.parseInt(args[0]));
            checkUserInfo(user);
            System.out.println("3の倍数です。");
        } catch (NumberFormatException e) {
            System.err.println("引数に数値を指定し、再実行して下さい。");
            e.printStackTrace();
        }
    }

    /**
     * 引数が3の倍数かどうかを判定する.
     *
     * @param user User型オブジェクト
     */
    private static void checkUserInfo(User user) throws Exception {
        // フィールドの取得
        Field[] fields = user.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Constraint.class)) {

                int number = (int) field.get(user);

                // 3の倍数チェッククラスのインスタンスを生成.
                MultipleThreeValidator checkMultipleThree = new MultipleThreeValidator();

                // 3の倍数かどうかを判定.
                if(!checkMultipleThree.isValid(number)) {
                    System.err.println("3の倍数ではありません。");
                    throw new IllegalStateException();
                }
            }
        }
    }

    /**
     * User型のオブジェクトを返却する.
     *
     * @param number 指定の引数
     * @return User型のオブジェクト
     */
    private static User getUser(int number) {
        User user = new User();
        user.number = number;
        return user;
    }
}