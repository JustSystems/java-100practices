[問題](../README.md)

***
# 064：解答例
## 問題点
1. `doSomething()`メソッドでは、`Cache`オブジェクトに対し`key`に関する`value`を取得し、
この`value`が`null`であれば `key`, `value`をキャッシュに挿入する仕組みである。
この`check-then-act`操作において複数のスレッドが本操作を同時に行った場合、
`check-then-act`操作の競合が発生してしまう可能性がある。
例えば、スレッドAがキャッシュには存在しない`key a`の`value`を挿入しようとしており、
同時にスレッドBがキャッシュには存在しない`key a`の`value`を挿入しようとする状態に
なってしまう可能性があるということ。
2. インスタンス変数は`init()`メソッドで初期化するのではなく、あらかじめ初期化していおく必要がある。

## 修正後
```java
public class Knock064 {
    private final Cache<String, Object> cache = new Cache<>(); // 修正箇所. #2

    // 修正箇所. #2
    //public void init() {
    //    this.cache = new Cache<>();
    //}
    
public Object doSomething(String key) {
    synchronized(cache) { // 修正箇所. #1
        // 時間がかかる処理なので、結果をキャッシュしておき、同じリクエストなら、同じ答えを返すようにする
        Object result = this.cache.get(key);
        if (result != null) {
            return result;
        }

        // いろいろな処理（省略）
        // 結果、resultが帰ってきたとする
        result = new Object();
        this.cache.put(key, result);
        return result;
    }
}
```