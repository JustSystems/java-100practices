import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 055の解答です.
 *
 * @author jsfkdt
 */
public class Answer055 {
    /**
     * 055の解答です.
     * UTF-8のテキストファイルを読み込み、各行の文字数の合計を出力する.
     *
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        
        // テキストファイルを読み込み
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("Answer055.txt"))) {
            /* 文字数の合計. */
            AtomicInteger sum = new AtomicInteger(0);
            
            // 一行毎の文字数を取得し、{@code sum}に足していく.
            reader.lines().parallel().forEach(line -> sum.addAndGet(line.length()));
            
            // 文字数をカウントし、標準出力する.
            System.out.println(sum + "文字");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}