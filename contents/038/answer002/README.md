# 解答
日本語用と英語用の2つのメッセージ用プロパティファイルを作成し、以下のコマンドでエンコードしておく  
日本語用のファイルは、`基底名_ja.properties`とする  
英語用のファイルは、`基底名_en.properties`とする
```
$ native2ascii -encoding UTF-8 message_ja.properties messageAscii_ja.properties
$ native2ascii -encoding UTF-8 message_en.properties messageAscii_en.properties
```

`Locale.getDefault()`で取得したロケールが日本のものか否かを判定し、`ResourceBundle.getBundle()`メソッドで指定のロケールのプロパティファイルを使用する

# 参考
https://docs.oracle.com/javase/jp/8/docs/technotes/guides/intl/index.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/util/ResourceBundle.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/util/Locale.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/text/MessageFormat.html  
