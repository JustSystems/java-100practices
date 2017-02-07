# 解答
"Knock024A"が出力される

以下の行でKnock024A型の変数abには、Knock024B型のインスタンスが代入される
```java
Knock024A ab = new Knock024B();
```
しかし、staticメソッドは継承できないため、スーパークラスであるKnock024AクラスのgetString()が呼ばれる

# 参考
http://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html#jls-8.4.8
8.4.8.2. Hiding (by Class Methods)
