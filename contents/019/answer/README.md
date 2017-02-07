[問題](../README.md)

***
# 019：解答例
JNIとは、Java Native Interfaceの略

native修飾子を付けたメソッド宣言を書いたjavaファイルを作成する
```java
public class Answer019 {
    private native int randomNum();
}
```

以下のコマンドでclassファイルを作成する
```
$ javac Answer019.java
```
Answer019.classが作成される

以下のコマンドでC言語のヘッダーファイルを作成する
```
$ javah -jni Answer019
```
Answer019.hが作成される

作成したヘッダーファイルの内容を元に、Answer019.cファイルを作成  
ここに、Javaから呼び出す処理（ランダムで整数を返す処理）を書く

cファイルをコンパイルして共有ライブラリを作成
```
$ gcc -shared -D__int64='long long' -I "C:\Program Files\Java\jdk1.8.0_121\include" -I "C:\Program Files\Java\jdk1.8.0_121\include\win32\" Answer019.c -o libAnswer019.dll
```

javaファイルにライブラリの読み込み処理を追記し、再コンパイル  
※libAnswer019.dllがDLL 検索パスに含まれること
```java
static {
    System.loadLibrary("libAnswer019");
}

public static void main(String arguments[]) {
    System.out.println(new Answer019().randomNum());
}
```

以下のコマンドで実行する
```
$ java Answer019
```


# 参考
https://docs.oracle.com/javase/jp/8/docs/technotes/guides/jni/spec/jniTOC.html
