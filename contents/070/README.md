[目次](../toc.md)
[前の問題](../069/README.md)　[次の問題](../071/README.md)


***
## 070：複合(10)
* 以下は、テキストファイルを読み取り、その結果を出力するプログラムである。問題点を指摘し、修正せよ。

```java
public class Knock070 {
    private static final Logger logger = Logger.getLogger("Knock070");

    public static void readFile() {
        FileReader reader = null;
        try {
            File file = new File("c:¥¥tmp¥¥test.txt");
            reader = new FileReader(file);
            int ch;
            while ((ch = reader.read()) != -1) {
                  System.out.print((char)ch);
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "FileNotfound.", e);
        } catch (IOException e) {
            logger.log(Level.WARNING, "IOException.", e);
        } finally {
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch(IOException e) {
                logger.log(Level.WARNING, "close error.", e);
            }
        }
    }
}
```

