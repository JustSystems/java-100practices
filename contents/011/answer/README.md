[問題](../README.md)

***
# 011：解答例

以下の順番で実行されます。
    4. `final`であり型がプリミティブないしは文字列となるクラス変数への宣言時の、定数と解釈する値の代入
    2. `static`イニシャライザでのクラス変数への値の代入
    1. インスタンス変数への宣言時の値の代入
    3. コンストラクタでのインスタンス変数への値の代入

[Java Language Specification 12.4.2. Detailed Initialization Procedure](https://docs.oracle.com/javase/specs/jls/se8/html/jls-12.html#jls-12.4.2) によれば、
> The procedure for initializing C is then as follows:
>
> (中略)
>
> '6. Otherwise, record the fact that initialization of the Class object for C is in progress by the current thread, and release LC.
> Then, initialize the static fields of C which are constant variables (§4.12.4, §8.3.2, §9.3.1).
>
> (中略)
>
> '9. Next, execute either the class variable initializers and static initializers of the class, or the field initializers of the interface, in textual order, as though they were a single block.

とあります。上記「6.」が設問の選択肢4、上記「9.」が設問の選択肢2に該当します。

    ※GitHub Markdownの制約上、上記箇条書きでは本来不要な ' を番号の前に追加しています。以下同様です。

また、上記に続く [12.5. Creation of New Class Instance](https://docs.oracle.com/javase/specs/jls/se8/html/jls-12.html#jls-12.5) では、
> '4. Execute the instance initializers and instance variable initializers for this class, assigning the values of instance variable initializers to the corresponding instance variables, in the left-to-right order in which they appear textually in the source code for the class. If execution of any of these initializers results in an exception, then no further initializers are processed and this procedure completes abruptly with that same exception. Otherwise, continue with step 5.
>
> '5. Execute the rest of the body of this constructor. If that execution completes abruptly, then this procedure completes abruptly for the same reason. Otherwise, this procedure completes normally.

とあります。上記「4.」が設問の選択肢1、上記「5.」が選択肢3に該当します。

上記以外にも、クラスの初期化時、インスタンスの初期化時はいろいろな処理を行っています。ぜひ[Java言語仕様](https://docs.oracle.com/javase/specs/)を一読してください。
