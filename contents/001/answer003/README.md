# 解答
* 以下のサイトにアクセスし、最新のJDKをダウンロード、インストールする
http://www.oracle.com/technetwork/java/javase/downloads/index.html
* ユーザーの環境変数に「JAVA_HOME」を作成し、値に以下を設定する
C:\Program Files\Java\jdk1.8.0_121 (インストールしたバージョンによる)
* ユーザーの環境変数に「Path」の値に以下を追加する
%JAVA_HOME%\bin
* Answer001.javaファイルを作成し、javacコマンドでコンパイルする
```
$ javac Answer001.java
```
* 同じディレクトリにAnswer001.classが作成されていることを確認し、javaコマンドで実行する
```
$ java Answer001
```
