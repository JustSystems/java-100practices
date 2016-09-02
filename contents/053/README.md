[目次](../toc.md)
[前の問題](../052/README.md)　[次の問題](../054/README.md)


***
## 053：コアAPI：その他のCollections Framework
* 次のプログラムをコンパイル・実行するとどうなるか？（実際に実行させずに解答すること）

```java
import java.util.Date;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Knock053 {
    public static void main(String[] arguments) {
        Date[] datesArray = new Date[]{
            new Date(1L),
            new Date(2L)
        };
        List<Date> datesList = Collections.unmodifiableList(Arrays.asList(datesArray));
        datesList.get(0).setTime(3L);
        System.out.println("time=" + datesArray[0].getTime());
    }
}
```

