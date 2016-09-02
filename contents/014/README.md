[目次](../toc.md)
[前の問題](../013/README.md)　[次の問題](../015/README.md)


***
## 014：初期化子(3)

* 次のプログラムをコンパイル・実行するとどうなるか？（実際に実行させずに解答すること）

```java
public class Knock014 {
    private String name = createName();
    private String createName() {
        return "created_name=" + name;
    }
    public static void main(String[] arguments) {
        System.out.println(new Knock014().name);
    }
}
```

