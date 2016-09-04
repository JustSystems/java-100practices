[問題](../README.md)

***
# 016：解答例

## 他のクラスからインスタンス生成できないクラス

```java:UnInstantiableClass.java
public class UnInstantiableClass {
    private UnInstantiableClass(){}
}
```

## 生成を試みる

```java:Knock016.java
public class Knock016 {

    public static void main(String[] args) {
        new UnInstantiableClass();
    }

}
```

## コンパイルエラー発生

```:実行結果

D:\workspace>javac Knock016.java UnInstantiableClass.java
Knock016.java:4: エラー: UnInstantiableClass()はUnInstantiableClassでprivateアクセスされます
        new UnInstantiableClass();
        ^
エラー1個
```
