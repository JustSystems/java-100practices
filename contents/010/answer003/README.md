# 解答
* JARファイル作成時に、eオプションで、エントリ・ポイントを指定する
```
$ jar cvfe Answer.jar Answer010 Answer010.class
```
パッケージがある場合は、以下のようになる
```
$ jar cvfe Answer.jar package.Answer010 package\Answer010.class
```
マニフェストファイルが作成され、MANIFEST.MFに
```
Main-Class: Answer010
```
が記載されていればOK
* JARファイルの実行は、以下のコマンドで実行
```
$ java -jar Answer.jar
```
