[問題](../README.md)

***
# 017：解答例

```java:Knock17.java
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Knock17 {

    private static final int COUNT = 1_000_000;

    private static volatile long variable = -1L;

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(2);
        final ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(() -> {
            for (int i = 0; i < COUNT; i++) {
                System.out.println(variable);
            }
            latch.countDown();
        });
        es.submit(() -> {
            for (int i = 0; i < COUNT; i++) {
                variable = (variable == 0) ? -1L : 0L;
            }
            latch.countDown();
        });
        latch.await();
        es.shutdown();
    }
}
```
