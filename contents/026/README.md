[目次](../toc.md)
[前の問題](../025/README.md)　[次の問題](../027/README.md)


***
## 026：オーバーライド(3)
* 次のプログラムをコンパイル・実行するとどうなるか？（実際に実行させずに解答すること）

```java
public class Knock026A {
    public static void main(String[] arguments) {
        Knock026A ab = new Knock026B();
        System.out.println(ab.getValue());
    }
    
    public int getValue() {
        return 1;
    }
}
public class Knock026B extends Knock026A {
    private int getValue() {
        return 2;
    }
}
```

