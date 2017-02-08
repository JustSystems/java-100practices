# 解答
妥当ではない

以下の箇所でコンパイル時に無検査変換の警告が発生するため、その抑制のために有効であるが、`@SuppressWarnings`をclass全体ではなく、該当箇所にスコープを絞って付与するのが妥当である。
```java
Class<String> object = getStringClass();
```
`Class<String>`のobjectに対して、Classを返すメソッドの返り値を代入しようとしている

# 参考
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/SuppressWarnings.html
