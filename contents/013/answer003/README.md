# 解答
以下の行でnはnullの状態なので、toString()でNullPointerExceptionが発生する
```java
private static final Object HOGE = n.toString();
```

# 参考
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Object.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/NullPointerException.html
