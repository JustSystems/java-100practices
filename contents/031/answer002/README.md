# 解答
コンパイル時に無検査変換の警告が発生するため、妥当である

Class<String>のobjectに対して、Classを返すメソッドの返り値を代入しようとしている
```java
Class<String> object = getStringClass();
```

# 参考
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/SuppressWarnings.html
