[問題](../README.md)

***
# 018：解答例

## 十二支を表現する enum の定義

### 変数の定義

```java
private final String text;
private final int id;
```

### コンストラクタの定義
enum もコンストラクタを持つことができる。enum のコンストラクタはクラス内部からしか呼べないため、
private はつける必要がなく、IDEによっては冗長な修飾子だと指摘される。

```java:コンストラクタ
private EarthlyBranches(final String text, final int id) {
    this.text = text;
    this.id   = id;
}
```


### enum インスタンスの定義
コンストラクタで定義した順に変数を指定する。

```java
NE("子", 1), USHI("丑", 2), TRA("寅", 3), U("卯", 4), TATSU("辰", 5), MI("巳", 6),
HITSUJI("未", 7), UMA("午", 8), SARU("申", 9), TORI("酉", 10), INU("戌", 11), I("亥", 12);
```

[ソースコード(Knock018.java)](src/Knock018.java)
