[問題](../README.md)

***
# 021：解答例
## コンパイル・実行方法
1. コマンドプロンプト（A,B,C）を3つ立ち上げ、ソースが置かれているディレクトリへ`cd`します。
2. `A`でコンパイルを行います。 例：`javac *.java`
3. `B`で`rmiregistry`を実行します。
4. `C`でサーバ側の実行を行います。 例：`java RandomImpl`
5. `A`でクライアント側の実行を行います。 例：`java RandomClient`

[ソースコード(RandomImpl.java)](src/RandomImpl.java)