[問題](../README.md)

***
# 070：解答例
## 問題点
1. `FileReader`はファイルの文字を一文字毎に読み込むため、
`FileReader`を用いてファイルを読み込むと、パフォーマンスが劣化してしまう。
`BufferedReader`を用いてファイルを読み込むことで改善される。
2. `try-catch`文ではなく、`try-with-resouces`構文を使用すべき。
`close()`メソッドの記載が不要となるため、`close()`し忘れといったことを防ぐことができる。

## 修正
```java
public class Knock070 {
    private static final Logger logger = Logger.getLogger("Knock070");

    public static void readFile() {
        //FileReader reader = null;
        
        // 修正箇所. #1, 2
        try(BufferedReader bufferReader = new BufferedReader(new FileReader(new File("c:¥¥tmp¥¥test.txt")))) {
            //File file = new File("b.txt");
            //reader = new FileReader(file);
            //int ch;
            //while ((ch = reader.read()) != -1) {
            //      System.out.print((char)ch);
            //}
            
            // ラムダ式で標準出力.
            bufferReader.lines().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "FileNotfound.", e);
        } catch (IOException e) {
            logger.log(Level.WARNING, "IOException.", e);
        } //finally {
        //    try {
        //        if(reader != null) {
        //            reader.close();
        //        }
        //    } catch(IOException e) {
        //        logger.log(Level.WARNING, "close error.", e);
        //    }
        //}
    }
}
```