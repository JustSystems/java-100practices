public class Answer022 {

    /**
     * 複数個の引数を受け取る.
     * 引数が3,5,7個の場合は引数を1行ごとに標準出力する
     * それ以外の個数の場合はUsageを出力してコード2で終了する
     * @param arguments 長さ0以上のString型の配列
     */
    public static void main(String... arguments) {
        switch (arguments.length) {
            case 3:
                showArgument(arguments[0], arguments[1]);
                break;
            case 5:
                showArgument(arguments[1], arguments[2], arguments[4]);
                break;
            case 7:
                showArgument(arguments[0], arguments[3], arguments[5], arguments[6]);
                break;
            default:
                System.out.println("Usage: Please enter either 3, 5, or 7 arguments.");
                System.exit(2);
                break;
        }
    }

    /**
     * 引数を標準出力する.
     * @param items String型の配列
     */
    private static void showArgument(String... items) {
        for (String item : items) {
            System.out.println(item);
        }

    }
}
