# 解答
ClassクラスのforName(String)メソッドで、java.lang.StringBufferクラスのClassのオブジェクトを作成する  
作成したClassオブジェクトに対してnewInstance()メソッドを呼び、StringBufferクラスのインスタンスを作成する

作成したClassオブジェクトに対してgetMethod(String, Class<?>...)を呼び、append(String)メソッドのMethodオブジェクトを取得する  
作成したMethodオブジェクトに対してinvoke(Object, Object...)メソッドを呼び、stringBufferに対して、append("hoge")する

# 参考
https://docs.oracle.com/javase/jp/8/docs/technotes/guides/reflection/index.html
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Class.html
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/reflect/Method.html
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/StringBuffer.html
