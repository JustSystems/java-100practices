[問題](../README.md)

***
# 034：解答例
ラムダ式とメソッド参照を使うことで36字で書ける。

forEach を使う場合は stream() を呼ばずとも、 [Iterable インターフェイスに定義されている方の forEach メソッド](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Iterable.html#forEach-java.util.function.Consumer-)を使える。

```java:解答例
medals.forEach(System.out::println);
```


```java:Knock034.java
public class Knock034 {

    public static void main(String[] arguments) {
        final java.util.List<String> medals = new java.util.ArrayList<>();
        medals.add("gold");
        medals.add("silver");
        medals.add("bronze");
        medals.forEach(System.out::println);
    }

}
```
