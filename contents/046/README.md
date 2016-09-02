[目次](../toc.md)
[前の問題](../045/README.md)　[次の問題](../047/README.md)


***
## 046：コアAPI：java.lang.String(2)
* 次のプログラムをコンパイル・実行するとどうなるか？（実際に実行させずに解答すること）

```java
public class Knock046 {
    public static void main(String[] arguments) {
        String s1 = "hoge";
        String s2 = "ho" + "ge";
        String s3 = new String(s1);
        String s4 = new String(s1).intern();
        printDifference(s1, s2);
        printDifference(s1, s3);
        printDifference(s1, s4);
    }
    
    private static void printDifference(String a, String b) {
        System.out.println(
              (a == b)
            + ":"
            + a.equals(b)
            + ":"
            + ((a.hashCode() == b.hashCode()))
        );
    }
}
```

