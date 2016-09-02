[目次](../toc.md)
[前の問題](../044/README.md)　[次の問題](../046/README.md)


***
## 045：コアAPI：java.lang.String(1)
* 次のプログラムをコンパイル・実行するとどうなるか？（実際に実行させずに解答すること）

```java
public class Knock045 extends String {
    //★コンストラクタはStringと同じものをすべて持つとする

    public static void main(String[] arguments) {
        System.out.println(new Knock045("Hello, World"));
    }
}
```

