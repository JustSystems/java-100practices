# 解答
java.util.Date型のインスタンス変数`date`を持ち、`java.lang.Comparable`インタフェースを実装したクラスを作成する。
 このクラスで`compareTo`メソッドをオーバーライドして実装する。  
 `compareTo`メソッドでは、オブジェクトのインスタンス変数`date`を比較結果に従って、オブジェクトの比較とする。  
 また、`java.util.Collections`の`sort()`メソッドを使用して、作成したクラスのインスタンスのリストをソートする。  
 このとき、すべての要素はComparableインタフェースを実装しているクラスであり、要素の`compareTo()`に従ってソートされる。

# 参考
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Comparable.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/util/Collections.html#sort-java.util.List-  
https://docs.oracle.com/javase/jp/8/docs/api/java/util/Date.html#compareTo-java.util.Date-  
