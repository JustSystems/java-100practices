# 解答
Threadクラスを継承したサブクラスとして、Threadクラスのrunメソッドをオーバーライドする  
オーバーライドしたrunメソッド内には、long型の変数numに-1, 0を繰り返し交互に代入する処理を書く  
一方でmainメソッドでは自クラスのインスタンスを生成し、startメソッドで新しいスレッドを起動してrunメソッドを実装する  
また、mainメソッドには、繰り返しnumを参照する処理を書く

long型の変数への代入はアトミックではなく、32bitの代入を2回行う。そのため、ここではAtomicLong型を使用することで、アトミックな代入を行えるlong値とする。  
また、複数のスレッドからアクセスされる変数は、スレッドごとにキャッシュを持っているため、volatile修飾子を宣言してキャッシュされた値を使用しないようにする。

# 参考
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Thread.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/util/concurrent/atomic/AtomicLong.html
