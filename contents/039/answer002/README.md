[問題](../README.md)

***
# 039：解答例
まず最初に以下の文が呼ばれます。
```java
try {
    throw new Exception("1st");
}
```
その次に、以下の文が呼ばれます。
```java
finally {
    throw new Exception("2nd");
}
```
そこで上位`try-catch`文では`2nd`をキャッチするので、
`2nd`がメッセージとして出力されます。
