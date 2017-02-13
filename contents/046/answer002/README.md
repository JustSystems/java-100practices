# 解答
true : true : true  
false : true : true  
true : true : true  

### `printDifference(s1, s3)`について
`(a == b)` -> 文字列リテラルは、同じ値のインスタンスを参照する（intern()と同じ動きをする）ためtrue  
`a.equals(b)` -> 値は"hoge"で一致するためtrue  
`((a.hashCode() == b.hashCode()))` -> `equals()`がtrueなのでtrue  

### `printDifference(s1, s3)`について
`(a == b)` -> 参照が異なるためfalse  
`a.equals(b)` -> 値は"hoge"で一致するためtrue  
`((a.hashCode() == b.hashCode()))` -> `equals()`がtrueなのでtrue  

### `printDifference(s1, s4)`について
`(a == b)` -> trueになる。  
```java
String s4 = new String(s1).intern();
```
が呼ばれたとき、s1と同じ値のオブジェクトがプールに存在するため、その参照が返される。  
`a.equals(b)` -> 値は"hoge"で一致するためtrue  
`((a.hashCode() == b.hashCode()))` -> `equals()`がtrueなのでtrue  

# 参考
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/String.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Object.html#equals-java.lang.Object-  
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Object.html#hashCode--  
http://docs.oracle.com/javase/specs/jls/se8/html/jls-3.html#jls-3.10.5  
A string literal is a reference to an instance of class String
