import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * 056の解答です.InputStreamを読み込むスレッドクラス.
 *
 * @author jsfkdt
 */
public class InputStreamThread extends Thread {
    /* BufferedReaderのプライベート変数. */
    private BufferedReader bufferReader;
    
    /* 標準出力・エラー内容の格納用リスト.  */
    private List<String> outputList = new ArrayList<String>();
    
    /**
     * BufferedReaderに格納する.
     *
     * @param day InputStream
     */
    public InputStreamThread(final InputStream stream) {
        this.bufferReader = new BufferedReader(new InputStreamReader(stream));
    }
    
    /**
     * 出力・エラー内容をList変数に格納する.
     */
    @Override
    public void run() {
        try {
            // 出力内容を出力用配列に読み込み.
            bufferReader.lines().forEach(line -> outputList.add(line));
            
            bufferReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 出力文字列を取得する.
     *
     * @return 出力文字列のリスト.
     */
    public List<String> getStringList() {
        return outputList;
    }
}