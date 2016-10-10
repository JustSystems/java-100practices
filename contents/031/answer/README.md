[問題](../README.md)

***
# 031：解答例
妥当ではない。

## 理由
`getStringClass()`メソッドにおいてジェネリクスが使用されていないため、
アノテーションの記載は必要であるが、問題文の箇所に記載してしまうと、
他の予期しない箇所の警告まで抑制してしまう可能性があるため。

## 正しく使用するには以下のように修正
```java
//@SuppressWarnings("unchecked") // 修正前
public class Knock031 {
    public static void main(String[] arguments) {
        @SuppressWarnings("unchecked") // 修正後
        Class<String> object = getStringClass();
        System.out.println(object);
    }

    public static Class getStringClass() {
        return String.class;
    }
}
```
