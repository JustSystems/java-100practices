[目次](../toc.md)
[前の問題](../038/README.md)　[次の問題](../040/README.md)


***
## 039：例外(1)
* 次のプログラムをコンパイル・実行するとどうなるか？（実際に実行させずに解答すること）

```java
public class Knock039 {
    public static void main(String[] arguments) {
        try {
            try {
                throw new Exception("1st");
            } finally {
                throw new Exception("2nd");
            }
        } catch (Exception happened) {
            System.out.println(happened.getMessage());
        }
    }
}
```

