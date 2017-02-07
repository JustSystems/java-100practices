# 解答
以下の3つのファイルを用意する
* リモートインタフェースの定義ファイル : Answer021Ifc.java
* サーバ側の処理 : Answer021Server.java
* クライアント側の処理 : Answer021Client.java

３つのファイルを以下のコマンドでコンパイルする
```
$ javac Answer021Ifc.java
$ javac Answer021Server.java
$ javac Answer021Client.java
```

以下のコマンドでJava RMIレジストリを起動する
```
$ start rmiregistry
```

以下のコマンドでサーバを実行する
```
$ java Answer021Server
```

以下のコマンドでサーバを実行する
```
$ java Answer021Client
```

# 参考
https://docs.oracle.com/javase/jp/8/docs/technotes/guides/rmi/hello/hello-world.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/rmi/Naming.html
