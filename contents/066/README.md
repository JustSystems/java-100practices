[目次](../toc.md)
[前の問題](../065/README.md)　[次の問題](../067/README.md)


***
## 066：複合(6)
* 以下はModelクラスのリストを文字列化して返すプログラムである。問題点を指摘し、修正せよ。なお、Modelクラスは適切な実装が与えられているものとする。

```java
public class Knock066 {
    private Knock066() {};

    public static String convertToString(List<Model> modelList) {
        String result = "";

        for (Model model : modelList) {
            result += "id:" + model.getId() + "\n";
            result += "name:" + model.getName() + "\n";
            result += "type:" + model.getType().getId() + "\n";
            result += "memo:" + model.getMemo() + "\n";
            result += "---------\n";
        }

        return result;
    }
}
```

