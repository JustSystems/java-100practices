[目次](../toc.md)
[前の問題](../063/README.md)　[次の問題](../065/README.md)


***
## 064：複合(4)
* 以下は、毎回処理すると時間がかかるため、以前の結果をキャッシュして再利用するように実装されたプログラムの一部を抜粋したものである。問題点を指摘し、修正せよ。（Cacheクラスの実装は適切に与えられているものとする）

```java
public class Knock064 {
    private Cache<String, Object> cache;

    public void init() {
        this.cache = new Cache<>();
    }

    public Object doSomething(String key) {
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

