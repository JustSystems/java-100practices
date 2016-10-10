[問題](../README.md)

***
# 026：解答例
## アクセス修飾子
メソッドをオーバーライドした場合、
アクセス修飾子は元のメソッドと同じか、
それより緩い宣言でなければいけません。

・制限 弱←→強
`public protected 指定なし（デフォルト） private`
## 出力結果
コンパイルエラーが発生する。
## 正しく実行させるための例
`Knock026B`クラスに対して以下の修正を行う。
```Java
private int getValue() {return 2;} //修正前
public int getValue() {return 2;} //修正前
```