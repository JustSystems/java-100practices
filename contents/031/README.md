[目次](../toc.md)
[前の問題](../030/README.md)　[次の問題](../032/README.md)


***
## 031：アノテーション(1)
* 以下のコードのアノテーションは妥当か妥当ではないか。理由も合わせて解答せよ。
    * getStringClass()メソッドは変更不可とする。

```java
@SuppressWarnings("unchecked")
public class Knock031 {
    public static void main(String[] arguments) {
        Class<String> object = getStringClass();
        System.out.println(object);
    }
    
    public static Class getStringClass() {
        return String.class;
    }
}
```

