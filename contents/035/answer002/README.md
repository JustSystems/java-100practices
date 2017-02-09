# 解答
1～5秒（ランダム）ウェイトするだけのスレッドを実装したMyThreadクラスを作成する  
Answer035クラスのmainメソッドでは、ThreadGroupを2つ作成し、それぞれに属したMyThreadクラスのインスタンスを作成して、スレッドを起動する  
また、1秒毎に各スレッドグループに対して、`activeCount()`メソッドを呼び、アクティブなスレッドの数を取得して表示する

# 参考
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Thread.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/ThreadGroup.html  
