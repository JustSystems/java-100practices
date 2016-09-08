[問題](../README.md)

***
# 023：解答例

違う型の引数を取る同じ名前のメソッドを複数実装する。例えば、受け取った引数を文字列に変換して標準出力するメソッド print を下記の通り定義する。

```java:int方の値をprintするメソッド
private static void print(final int i) {
    System.out.println("i: int = " + String.valueOf(i));
}
```

```java:float型の値をprintするメソッド
private static void print(final float f) {
    System.out.println("f: float = " + String.valueOf(f));
}
```

今回はどちらのメソッドが呼ばれたのかをわかりやすくするために、出力の頭に型を表示している。

```java:呼び出し
print(1);
print(1f);
```

```:実行結果
i: int = 1
f: float = 1.0
```

[ソースコード(Knock023.java)](src/Knock023.java)
