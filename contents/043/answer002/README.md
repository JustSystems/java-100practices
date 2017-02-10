# 解答
java.lang.Objectを直接継承するため`extends Object`を指定する。  
また、java.lang.Cloneableインタフェースを実装するため`implements Cloneable`を指定する。

『従来、このインタフェースを実装するクラスは、publicメソッドでObject.clone (protected)をオーバーライドする必要があります。』とあるため、`clone()`をオーバーライドして作成する。  

# 参考
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Cloneable.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Object.html#clone--
