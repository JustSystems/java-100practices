import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

/**
 * 058の解答です.
 *
 * @author jsfkdt
 */
public class Answer058 {
    
    /**
     * 058の解答です.
     * コマンド第一引数に指定されたテキストファイルを読み込み、
     * そのテキストファイルがBOM付きかどうかを判定する.
     *
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        
        // 配列に値が入っていない場合、強制終了.
        if (args.length < 1 ) {
            System.err.println("引数にテキストファイル名を指定し、再実行してください。");
            System.exit(1);
        }
        
        try {
            // ファイル内容をバイト表記で取得.
            final byte[] fileContentBytes = Files.readAllBytes(Paths.get(args[0]));
            
            // バイト数が3未満の場合.
            if (fileContentBytes.length < 3){
                System.out.println("BOM無しファイルです。");
                System.exit(0);
            }            
            
            // BOM判定.
            if (fileContentBytes[0] == (byte)0xEF && fileContentBytes[1] == (byte)0xBB
                    && fileContentBytes[2] == (byte)0xBF) {
                
                System.out.println("BOM付きファイルです。");
                System.exit(1);
            } else {
                System.out.println("BOM無しファイルです。");
                System.exit(0);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}