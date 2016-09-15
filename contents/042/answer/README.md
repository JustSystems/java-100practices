[問題](../README.md)

***
# 042：解答例
hashCode()

実装しなければ、下記の [Object.hashCode の一般的な規則](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Object.html#hashCode--) 2 を満たすことができないため

> equals(Object)メソッドに従って2つのオブジェクトが等しい場合は、2つの各オブジェクトに対するhashCodeメソッドの呼出しによって同じ整数の結果が生成される必要があります。 

より具体的には、 equals が 実装されていても hashCode がオーバーライドされていない場合、HashSet や HashMap の挙動が保証されないため。

