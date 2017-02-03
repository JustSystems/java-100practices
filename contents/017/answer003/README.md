# 解答
Threadクラスを継承したサブクラスとして、Threadクラスのrunメソッドをオーバーライドする
オーバーライドしたrunメソッド内には、long型の変数numに-1, 0を繰り返し交互に代入する処理を書く
一方でmainメソッドでは自クラスのインスタンスを生成し、startメソッドで新しいスレッドを起動してrunメソッドを実装する
また、mainメソッドには、繰り返しnumを参照する処理を書く

# 参考
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Thread.html
