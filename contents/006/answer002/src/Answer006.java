import java.util.TimeZone;

/**
 * 006の解答です。
 *
 * @author jsfkdt
 */
public class Answer006 {
    /**
     * 006の解答です。
     * @param arguments 使用しません。
     */
    public static void main(String[] arguments) {
        // TimeZoneを取得し、標準出力を行う.
        // getDefault()：Java仮想マシンのデフォルトのTimeZoneを取得する.
        // getID()：現在の所在地のタイムゾーンのIDを取得する.
        System.out.println(TimeZone.getDefault().getID());
    }
}
