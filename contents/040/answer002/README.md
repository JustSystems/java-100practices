# 解答
非チェック例外を投げるスレッドを作成する。  
そのスレッドに対して、`setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler)`メソッドを使い、UncaughtExceptionHandlerインタフェースを実装したハンドラクラスを設定する。  
スレッド起動後に非チェック例外がthrowされてスレッドが終了し、ハンドラが呼ばれ、その中で現在時刻とスタックトレースを標準エラー出力する。

# 参考
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Thread.UncaughtExceptionHandler.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Thread.html  
