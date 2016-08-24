[目次](../toc.md)
[前の問題](../076/README.md)　[次の問題](../078/README.md)


***
## 077：複合(17)
* 以下のコードの問題点を指摘し、修正案を提示せよ
    * スタックの再発明が問題点ではない（問題点はそれ以外）

```java
public class Knock077<T> {
    private T[] array;
    private int point = 0;
    private static final int INIT_SIZE = 4;

    @SuppressWarnings("unchecked")
    public Knock077() {
        this.array = (T[]) new Object[INIT_SIZE];
    }

    public void push(T target) {
        resize();
        this.array[this.point] = target;
        this.point += 1;
    }

    public T pop() {
        if(this.point == 0) {
            return null;
        }

        this.point -= 1;
        T result =  this.array[this.point];

        return result;
    }

    // pushするデータがサイズがはみ出る場合は、2倍程度に拡張する
    private void resize() {
        if(this.point >= this.array.length) {
            this.array = Arrays.copyOf(this.array, 2 * this.point + 1);
        }
    }
}
```

