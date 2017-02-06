# 解答
"Knock024B"が出力される

以下の行でKnock024A型の変数abには、Knock024B型のインスタンスが代入される
```java
Knock024A ab = new Knock024B();
```
以下の行でのgetString()は、上記で代入されたインスタンスのKnock024Bでオーバーライドされたものが実行される
```java
System.out.println(ab.getString());
```
