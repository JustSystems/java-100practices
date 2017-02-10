import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Date;

/**
 * UncaughtExceptionHandlerインタフェースを実装したクラス
 */
public class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {
    /**
     * 例外によってスレッドが終了した場合に、発生日時とスタックトレースを標準エラー出力する
     * @param Thread    t 例外が発生したスレッド
     * @param Throwable e 発生した例外
     */
    public void uncaughtException(Thread t, Throwable e) {
        System.err.print("[" + new Date() + "] ");
        e.printStackTrace();
    }
}
