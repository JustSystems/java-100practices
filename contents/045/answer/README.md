[問題](../README.md)

***
# 045：解答例
コンパイルエラーが発生する。

## 理由
`String`クラスは`final`修飾子が付与されており、
サブクラスで継承することができないため。

## 参照
[クラスString](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/String.html)
