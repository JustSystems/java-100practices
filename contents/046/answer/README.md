[問題](../README.md)

***
# 046：解答例
|   比較対象   |  ==比較    |  .equals()  | hashCode比較 |
|:------------:|:----------:|:-----------:|:------------:|
|    s1, s2    | true       |     true    |     true     |
|    s1, s3    | false      |     true    |     true     |
|    s1, s4    | true       |     true    |     true     |

## 理由
* ==比較は、参照比較。
`s1 == s2 true` `String`を`new`せずに直接値を入れたら、擬似プリミティブとして扱われるため。
`s1 == s3 false` 同一のオブジェクトで無いから。
`s1 == s4 true` `s4`は`s1`を参照しているから。

* `.equals`比較は、文字列比較なので、全て`true`。

* `hashCode()`メソッドが返すハッシュ値は以下のような性質を持つため、全て`true`。
`equals()`メソッドによって同じとみなされる複数のオブジェクトは、同じハッシュ値を返さなければならない。

## 参照
* s3に格納される値について
[リンク：Stringクラスのコンストラクタ](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/String.html#String-java.lang.String-)

* s4に格納される値について
呼び出されたときに、`equals(Object)`メソッドによってこの`String`オブジェクトに等しいと判定される文字列がプールにすでにあった場合は、プール内の該当する文字列が返されます。
つまり、同じ文字列が既にプールにある場合は、該当する文字列を参照する。
[リンク：String intern()メソッド](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/String.html#intern--)