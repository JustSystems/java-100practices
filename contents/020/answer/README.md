[問題](../README.md)

***
# 020：解答例

## 1. MEDALS の各要素を入れる List をジェネリクスあり・なしでそれぞれ定義する。

```java:ジェネリクスあり
final List<String> medals = new ArrayList<String>(MEDALS.length);
```

```java:ジェネリクスなし
final List medals = new ArrayList(MEDALS.length);
```

## 2. 拡張for文で全要素を 1. のリストに追加

```java
for (final String medal : MEDALS) {
    medals.add(medal);
}
```

## 3. 拡張for文で 1. のリストの全要素を出力

```java:ジェネリクスありの場合
for (final String medal : medals) {
    System.out.println(medal);
}
```

なお、Java8 以降であれば、ジェネリクスあり・なしどちらでも次の通りにも書ける。

```java:forEachメソッド利用
medals.forEach(System.out::println);
```

[ソースコード(Knock020.java)](src/Knock020.java)
