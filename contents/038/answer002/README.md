# 解答
日本語用とデフォルト用の2つのメッセージ用プロパティファイルを作成し、以下のコマンドでエンコードしておく  
日本語用のファイルは、`基底名_ja.properties`とする  
デフォルト用のファイルは、`基底名.properties`とする
```
$ native2ascii -encoding UTF-8 message_ja.properties messageAscii_ja.properties
$ native2ascii -encoding UTF-8 message.properties messageAscii.properties
```

```java
ResourceBundle.getBundle(String baseName);
```
は、以下と同じである
```java
ResourceBundle.getBundle(baseName, Locale.getDefault(), this.getClass().getClassLoader())
```
よって、以下のように書くことで、デフォルトのロケールで対応したプロパティファイルを呼び出して使うことができる。
```java
ResourceBundle.getBundle("messageAscii");
```

# 参考
https://docs.oracle.com/javase/jp/8/docs/technotes/guides/intl/index.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/util/ResourceBundle.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/util/Locale.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/text/MessageFormat.html  
