# 解答
`hashCode()`メソッドをオーバーライドする必要がある  
`hashCode()`メソッドは、`equals()`がtrueを返すオブジェクトは、同じハッシュ値が返るようにする

# 参考
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Object.html#equals-java.lang.Object-  
通常、このメソッドをオーバーライドする場合は、hashCodeメソッドを常にオーバーライドして、「等価なオブジェクトは等価なハッシュ・コードを保持する必要がある」というhashCodeメソッドの汎用規約に従う必要があることに留意してください。  
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Object.html#hashCode--
