/**
 * 022の解答です.
 *
 * @author jsfkdt
 */
public class Answer022 {
    /**
     * 022の解答です.
     * 定められた条件の引数を標準出力する.
     * 
     * @param arguments
     */
    public static void main(final String[] args) throws InterruptedException {
        /** 引数の個数 **/
        final int len;
        
        // 引数の数を取得.
        len = args.length;
        
        if (len == 3) {
            listNames(args[0], args[1]);
        } else if (len == 5) {
            listNames(args[1], args[2], args[4]);
        } else if (len == 7) {
            listNames(args[0], args[3], args[5], args[6]);
        } else {
            // USAGEを出力.
            System.out.println("Usage : 引数の数を3個または5個、7個にして再実行してください");
            // 終了コードを2として、強制終了.
            System.exit(2);
        }
    }
    
    /**
     * 入力された引数の一部を標準出力する.
     *
     * @param  names 引数の値
     */
    private static void listNames(String... names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
}