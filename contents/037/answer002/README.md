# 解答
ディープコピーの作成は、`deepCopy()`メソッドを作成し、引数でコピー元のリストを受け取る。  
新たにリストのインスタンスを作成する。  
コピー元のリストの要素を取得し、その要素を同じ値で新たなインスタンスを作成し、先に作成したリストに追加する。

シャローコピーの作成は、`shallowCopy()`メソッドを作成し、引数でコピー元のリストを受け取る。  
ArrayListのコンストラクタ`public ArrayList(Collection<? extends E> c)`を使用して、引数で渡したコピー元のリストの要素が含まれる新たなリストのインスタンスを作成する。
このとき、新しいリストの要素は、コピー元のリストの要素を参照が同じである。

# 参考
https://docs.oracle.com/javase/jp/8/docs/api/java/util/ArrayList.html#ArrayList-java.util.Collection-  
https://docs.oracle.com/javase/jp/8/docs/api/java/util/Date.html#Date-long-
