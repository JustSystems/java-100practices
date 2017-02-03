# 解答
created_name=nullが出力される

以下の行でcreateName()メソッドが呼ばれたときに、nameはどこも参照していないためnullとなる
```java
private String name = createName();
```
よって、createName()の返り値は"created_name=null"となり、nameに代入される
