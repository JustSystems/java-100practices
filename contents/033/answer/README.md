[問題](../README.md)

***
# 033：解答例

## 1. Listの作成

```java:0から9までの数値を1つずつ持つListを作成
final List<Integer> zeroToNine = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
```

## 2. ラムダ式での処理

```java:ラムダ式全体
zeroToNine
    .stream()                      // 処理用の Stream を生成
    .filter(i -> i % 2 == 1)       // 奇数のみを Stream に残す
    .forEach(System.out::println); // 残っている全要素に対し System.out.println(int) を実施
```

[ソースコード(Knock033.java)](src/Knock033.java)
