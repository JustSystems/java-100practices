[目次](../toc.md)
[前の問題](../023/README.md)　[次の問題](../025/README.md)


***
## 024：オーバーライド(1)
* 次のプログラムをコンパイル・実行するとどうなるか？（実際に実行させずに回答すること）

```java
public class Knock024A {
    public static void main(String[] arguments) {
        Knock024A ab = new Knock024B();
        System.out.println(ab.getString());
    }
    
    protected static String getString() {
        return "Knock024A";
    }
}
public class Knock024B extends Knock024A {
    protected static String getString() {
        return "Knock024B";
    }
}
```

