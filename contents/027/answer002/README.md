# 解答
"1"が出力される

以下の行でKnock027AクラスのgetValue()にはprivateがついているため、Knock026Bには継承されない
```java
private int getValue() {
    return 1;
}
```
よって、Knock027AクラスのprivateメソッドのgetValue()が呼び出される


# 参考
http://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html#jls-8.4.8
