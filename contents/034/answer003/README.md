# 解答
java.lang.Systemクラスのフィールドoutの`println()`メソッドを呼ぶので、以下のようになる
```java
medals.forEach(System.out::println);
```

# 参考
http://www.oracle.com/technetwork/jp/articles/java/architect-lambdas-part1-2080972-ja.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/System.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/io/PrintStream.html#println-java.lang.String-  
