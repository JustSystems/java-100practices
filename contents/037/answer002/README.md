# 解答
ディープコピーの作成は、ArrayListのコンストラクタ`public ArrayList(Collection<? extends E> c)`を使用して、引数で渡したオリジナルのリストの要素が含まれる新たなリスト(実体)を作成する。  
シャローコピーの作成は、オリジナルのリストの参照を返すことで作成する。

# 参考
https://docs.oracle.com/javase/jp/8/docs/api/java/util/ArrayList.html#ArrayList-java.util.Collection-
