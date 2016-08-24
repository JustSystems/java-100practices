[目次](../toc.md)
[前の問題](../062/README.md)　[次の問題](../064/README.md)


***
## 063：複合(3)
* 以下のコードの問題点を指摘し、修正案を提示せよ。

```java
public class Knock063 {
    public int check1(String target) {
        if (target ==  "value1") {
            return 0;
        } else if (target == "value2") {
            return 1;
        }
        return 2;
    }

    public int check2(String target) {
        if (target.equals("value1")) {
            return 0;
        } else if (target.equals("value2")) {
            return 1;
        }
        return 2;
    }
}
```

