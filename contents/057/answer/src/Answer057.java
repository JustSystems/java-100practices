import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemException;
import java.nio.file.Paths;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.io.IOException;

/**
 * 057の解答です.
 *
 * @author jsfkdt
 */
public class Answer057 {
    /**
     * 057の解答です.
     *
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        
        // 配列に値が入っていない場合、強制終了.
        if (args.length < 1 ) {
            System.err.println("引数にテキストファイル名を指定し、再実行してください。");
            System.exit(1);
        }
        
        // テキストファイルを読み込み.
        try (Stream<String> txtFile = Files.lines(Paths.get(args[0]))) {
            
            // 一行毎に標準出力.
            txtFile.map(line -> line).forEach(System.out::println);
            
            // {@code filesystem}の取得.
            final FileSystem fileSystem = FileSystems.getDefault();
            
            // コピー元ファイルパスを取得.
            final Path beforeFile = Paths.get(args[0]);
            
            // コピー先のパスを取得.
            final Path afterFile = fileSystem.getPath(args[0] + ".read");
            
            // ファイルをコピー.
            Files.copy(beforeFile, afterFile, REPLACE_EXISTING);
            
            // 元ファイルの削除.
            Files.deleteIfExists(beforeFile);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}