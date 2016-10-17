[問題](../README.md)

***
# 053：解答例
time=3

## `Collections.unmodifiableList()`について
以下リンク参照
> 指定されたリストの変更不可能なビューを返します。このメソッドを使うと、モジュールはユーザーに内部リストへの「読取り専用」アクセス権を提供できます。

このメソッドは戻り値のリストが読み取り専用になりますが、 
**読み取り専用になるのは戻り値のリストのみ**で、引数に渡したリストの更新は可能です。
またリストの内容を変更するようなメソッドを呼ぶと例外になります。

## 備考
以下のような場合例外となる。
```java
datesList.add(new Date(3L));
```

## 参照
[Collections.unmodifiableList()](https://docs.oracle.com/javase/jp/8/docs/api/java/util/Collections.html#unmodifiableList-java.util.List-)