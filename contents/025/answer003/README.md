# 解答
"1"が出力される

以下の行でKnock025AクラスのgetValue()メソッドには、privateがついているため、Knock025Bクラスには継承されない
```java
private int getValue() {
    return 1;
}
```
よって、以下の行ではKnock025AクラスのgetValue()が実行される
```java
System.out.println(ab.getValue());
```

# 参考
http://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html#jls-8.4.8  
8.4.8.1. Overriding (by Instance Methods)
