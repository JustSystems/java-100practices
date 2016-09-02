[目次](../toc.md)
[前の問題](../012/README.md)　[次の問題](../014/README.md)


***
## 013：初期化子(2)

* 次のプログラムをコンパイル・実行するとどうなるか？（実際に実行させずに解答すること）

```java
public class Knock013 {
    private static Object n;
    private static final Object HOGE = n.toString();
    public static void main(String[] arguments) {
        System.out.println("HOGE is " + HOGE);
    }
}
```

