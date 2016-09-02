[目次](../toc.md)
[前の問題](../026/README.md)　[次の問題](../028/README.md)


***
## 027：オーバーライド(4)
* 次のプログラムをコンパイル・実行するとどうなるか？（実際に実行させずに解答すること）

```java
public class Knock027A {
    public static void main(String[] arguments) {
        Knock027A ab = new Knock027B();
        System.out.println(ab.getValue());
    }
    
    private int getValue() {
        return 1;
    }
}
public class Knock027B extends Knock027A {
    public int getValue() {
        return 2;
    }
}
```

