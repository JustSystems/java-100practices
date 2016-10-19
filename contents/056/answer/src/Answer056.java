import java.lang.ProcessBuilder;
import java.io.IOException;

/**
 * 056の解答です.
 *
 * @author jsfkdt
 */
public class Answer056 {
    /**
     * 056の解答です.
     *
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        try {
            // コマンドを設定.
            ProcessBuilder command = new ProcessBuilder("cmd", "/c", "dir");
            
            // コマンドの実行.
            Process process = command.start();
            
            // スレッドインスタンスの生成.
            InputStreamThread output = new InputStreamThread(process.getInputStream());
            InputStreamThread outputError = new InputStreamThread(process.getErrorStream());
            
            // スレッドの開始.
            output.start();
            outputError.start();
            
            // プロセスの終了待ち
            process.waitFor();
            
            // スレッド終了待ち
            output.join();
            outputError.join();
            
            System.out.println("戻り値：" + process.exitValue());
            
            //標準出力の内容を出力
            for (String out : output.getStringList()) {
                System.out.println(out);
            }
            
            //標準エラーの内容を出力
            for (String outError : outputError.getStringList()) {
                System.err.println(outError);
            }
            
        } catch (IOException e) {
            // 入出力エラー.
            e.printStackTrace();
        } catch (InterruptedException e) {
            // 割り込みエラー.
            e.printStackTrace();
        }
    }
}