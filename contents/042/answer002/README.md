[問題](../README.md)

***
# 042：解答例
hashCode()

## 理由
・[`java.lang.Object hash`コード一般規則](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Object.html)の2つ目の要件を満たすため。
・`equals()`の結果2つのオブジェクトが等価であるならば、その2つのオブジェクトは同じ`hashCode()`の値を持たな
ければならないことになっており、`equals()`が 実装されていても`hashCode()`がオーバーライドされていない場合、
`HashSet`や`HashMap`のコレクションが正しく機能しなくなるため。
