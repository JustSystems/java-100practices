# 解答
シリアライズ可能なクラスSerializableClassのオブジェクトを作成する  
"t.tmp"ファイルに書き込むためのFileOutputStreamを作成し、それを使ってObjectOutputStreamを作成する  
ObjectOutputStreamのwriteObject(Object)メソッドを使い、"t.tmp"ファイルにSerializableClassのオブジェクトを出力する

"t.tmp"ファイルから読み込むためのFileInputStreamを作成し、それを使ってObjectInputStreamを作成する  
ObjectInputStreamのreadObject(Object)メソッドを使い、"t.tmp"ファイルからSerializableClassのオブジェクトとして取得する

try-with-resources構文を使用することで、各ストリームを自動で閉じることができる

# 参考
https://docs.oracle.com/javase/jp/8/docs/api/java/io/Serializable.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/io/ObjectOutputStream.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/io/FileOutputStream.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/io/ObjectInputStream.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/io/FileInputStream.html
