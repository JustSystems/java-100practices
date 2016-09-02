[目次](../toc.md)
[前の問題](../027/README.md)　[次の問題](../029/README.md)


***
## 028：オーバーライド(5)
* 次のプログラムをコンパイル・実行するとどうなるか？（実際に実行させずに解答すること）
    * 027との違いに注目

```java
public class Knock028A {
    public static void main(String[] arguments) {
        Knock028A ab = new Knock028B();
        System.out.println(ab.getValue());
    }
    
    public int getValue() {
        return 1;
    }
}
public class Knock028B extends Knock028A {
    public int getValue() {
        return 2;
    }
}
```

