# 解答
3で割り切れる数を示す`@IsDivisibleByThree`アノテーションを作成する。  
`@Retention(RetentionPolicy.RUNTIME)`を指定して、実行時にも使用できるアノテーションとする。

`@IsDivisibleByThree`アノテーションを付与したフィールドを持つ`Number`クラスを作成する。

コマンド実行時に入力された第1引数の数値を`Number`クラスの`@IsDivisibleByThree`アノテーションを付与したフィールドに入れる。  
`@IsDivisibleByThree`アノテーションを付与したフィールドに入っている値が3で割り切れるかを判定する`isDivisibleNumberByThree(Number)`メソッドを呼ぶ。

# 参考
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/annotation/Retention.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/annotation/RetentionPolicy.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/reflect/Field.html
