[問題](../README.md)

***
# 034：解答例
ラムダ式とメソッド参照を使うことで36字で書ける。

forEach を使う場合は stream() を呼ばずとも、 [Iterable インターフェイスに定義されている方の forEach メソッド](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Iterable.html#forEach-java.util.function.Consumer-)を使える。

```java:解答例
medals.forEach(System.out::println);
```

[ソースコード(Knock034.java)](src/Knock034.java)
