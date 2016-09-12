[目次](../toc.md)
[前の問題](../024/README.md)　[次の問題](../026/README.md)


***
## 025：オーバーライド(2)
* 次のプログラムをコンパイル・実行するとどうなるか？（実際に実行させずに解答すること）

```java:Knock025A.java
public class Knock025A {
    public static void main(String[] arguments) {
        Knock025A ab = new Knock025B();
        System.out.println(ab.getValue());
    }
    
    private int getValue() {
        return 1;
    }
}
```

```java:Knock025B.java
public class Knock025B extends Knock025A {
    private int getValue() {
        return 2;
    }
}
```

