[問題](../README.md)

***
# 023：解答例

違う型の引数を取る同じ名前のメソッドを複数実装する。
例えば、受け取った引数を文字列に変換して標準出力するメソッド convertString を下記の通り定義する。

```java:int方の値をStringに変換するメソッド
private static String convertString(final int i) {
    return String.valueOf(i);
}
```

```java:float型の値をStringに変換するメソッド
private static String convertString(final float f) {
    return String.valueOf(f);
}
```

```java:呼び出し
convertString(1);
convertString(1f);
```

```:実行結果
i: int = 1
f: float = 1.0
```

[ソースコード(Knock023.java)](src/Knock023.java)
