# 解答
コンパイル時にエラーが発生する

以下の行でKnock026AクラスのgetValue()にはpublicがついている
```java
public int getValue() {
    return 1;
}
```
しかし、Knock026Bではオーバーライドする場合にpublicを指定していないため、コンパイル時にエラーとなる
```java
private int getValue() {
    return 2;
}
```

# 参考
http://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html#jls-8.4.8  
The access modifier (§6.6) of an overriding or hiding method must provide at least as much access as the overridden or hidden method, as follows:  
If the overridden or hidden method is public, then the overriding or hiding method must be public; otherwise, a compile-time error occurs.
