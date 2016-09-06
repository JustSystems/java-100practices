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

```java
        for (final String medal : medals) {
            System.out.println(medal);
        }
```

## コード全体

```java:Knock20.java
import java.util.ArrayList;
import java.util.List;

public class Knock20 {

    private static final String[] MEDALS = new String[]{
            "GOLD", "SILVER", "BRONZE"
        };

    public static void main(String[] args) throws InterruptedException {
        withGeneric();
        withoutGeneric();
    }

    private static void withGeneric() {
        final List<String> medals = new ArrayList<String>(MEDALS.length);
        for (final String medal : MEDALS) {
            medals.add(medal);
        }
        //medals.forEach(System.out::println); // Java8
        for (final String medal : medals) {
            System.out.println(medal);
        }
    }

    private static void withoutGeneric() {
        final List medals = new ArrayList(MEDALS.length);
        for (final Object medal : MEDALS) {
            medals.add(medal);
        }
        //medals.forEach(System.out::println); // Java8
        for (final Object medal : medals) {
            System.out.println(medal);
        }
    }
}
```
