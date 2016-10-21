[問題](../README.md)

***
# 066：解答例
## 問題点
1. `modelList`が`null`であれば、`NullPointerException`が発生する。
1. `modelList`にオブジェクトがあったとしても、その`Model`オブジェクトが`null`であれば、`NullPointerException`が発生する。
1. `modelList`も`Model`オブジェクトも`null`ではない場合に、`getType()`メソッドで取得したオブジェクトが`null`であれば、
`NullPointerException`が発生する。


## 修正後
```java
public class Knock066 {
    private Knock066() {};

    public static String convertToString(List<Model> modelList) {
        String result = "";
        // modelListがnullでないことを保証. #1
        if (modelList == null) {
            return result;
        }
        
        for (Model model : modelList) {
            // Modelオブジェクトがnullの場合はスキップ. #2
            if (model != null) {
                
                result += "id:" + model.getId() + "\n";
                result += "name:" + model.getName() + "\n";
                
                // getType()メソッドによって取得されるオブジェクトがnullの場合は、nullを表示. #3
                if (model.getType() != null) {
                    result += "type:" + model.getType().getId() + "\n";
                } else {
                    result += "type:" + null + "\n";
                }
                
                result += "memo:" + model.getMemo() + "\n";
                result += "---------\n";
            } else {
                // Modelオブジェクトがnullの場合に、nullを表示.
                result += "null\n";
                result += "---------\n";
            }
        }

        return result;
    }
}
```