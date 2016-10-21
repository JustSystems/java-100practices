[問題](../README.md)

***
# 063：解答例
## `check1`メソッド
### 問題点
文字列比較の際に`==`を使うのは良くない。
`==`によって文字列を比較すると、参照比較となってしまうため、
例えば本クラスのインスタンスを生成し、`new String("value1")`を引数に
本メソッドの呼び出しが行われた場合、2が返却される。
`"value1"` を引数に呼び出しが行われた場合は、0が返却される。
### 修正案
文字列の比較は`equals()`メソッドを使用する.

## `check2`メソッド
### 問題点
もし`target`変数が`null`であれば、`NullPointerException`が発生してしまう。

### 修正案
* `if`文での条件分岐の前で`null`チェックを行う。
```java
public int check2(String target) {
    /* ガード節を挿入. */
    if (target == null) {
        return 2;
    }
    
    if (target.equals("value1")) {
        return 0;
    } else if (target.equals("value2")) {
        return 1;
    }
    return 2;
}
```

* `(定数).equals(変数)`の形に置き換えることで、変数に`null`が入っても例外は発生しない。
* 1つ目の`if`文で戻り値を返しているので、2つ目の`if`文では`else if`とはせずに`if`文で実装する.
```java
public int check2(String target) {
    if ("value1".equals(target)) {
        return 0;
    }
    if ("value2".equals(target)) {
        return 1;
    }
    return 2;
}
```