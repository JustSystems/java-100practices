[問題](../README.md)

***
# 017：解答例

## 1. あるlong型の変数を用意

```java
private static volatile long variable = -1L;
```

## 2. スレッドを動かす ExecutorService を用意
今回は動かすスレッド数が2と決まっているので、newFixedThreadPool を使う。

```java
final ExecutorService es = Executors.newFixedThreadPool(2);
```

## 3. あるlong型の変数の参照を100万回するだけのスレッドAを用意＆submit

```java:スレッドA
es.submit(() -> {
    for (int i = 0; i < COUNT; i++) {
        assert variable == 0 || variable == -1
            : String.format("variable (%d) is not 0 or -1.", variable);
    }
    latch.countDown();
});
```

## 4. あるlong型の変数に、0ないし-1の代入を100万回繰り返すスレッドBを用意＆submit

```java:スレッドB
es.submit(() -> {
    for (int i = 0; i < COUNT; i++) {
        variable = (variable == 0) ? -1L : 0L;
    }
    latch.countDown();
});
```

[ソースコード(Knock017.java)](src/Knock017.java)
