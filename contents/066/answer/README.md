[問題](../README.md)

***
# 066：解答例
## 問題点
1. `modelList`が`null`であれば、`NullPointerException`が発生する。
1. `modelList`にオブジェクトがあったとしても、その`Model`オブジェクトが`null`であれば、`NullPointerException`が発生する。
1. `modelList`も`Model`オブジェクトも`null`ではない場合に、`getType()`メソッドで取得したオブジェクトが`null`であれば、
`NullPointerException`が発生する。
1. `+`による文字列の連結は`String`型のインスタンスを生成して、文字列の連結を行っているため、パフォーマンスに問題がある。
文字列は`+=`を用いて連結させるのではなく、`StringBuilder`を用いる必要がある。  
（メソッド内で`result`変数の宣言がされているため、スレッドセーフな`StringBuffer`のメソッドを使用する必要がない）

## 修正後
```java
public class Knock066 {
    private Knock066() {};

    public static String convertToString(List<Model> modelList) {
        //String result = "";
        StringBuilder result = new StringBuilder(); // 修正箇所. #4

        // modelListがnullでないことを保証. #1
        if (modelList == null) {
            return result.toString();
        }
               
        for (Model model : modelList) {
            // Modelオブジェクトがnullの場合はスキップ. #2
            if (model != null) {
                
                //result += "id:" + model.getId() + "\n";
                result.append("id:");
                result.append(model.getId());
                result.append("\n");
                
                //result += "name:" + model.getName() + "\n";
                result.append("name:");
                result.append(model.getName());
                result.append("\n");
                
                //result += "type:" + model.getType().getId() + "\n";
                result.append("type:");
                
                // getType()メソッドによって取得されるオブジェクトがnullの場合は、nullを表示. #3
                if (model.getType() != null) {
                    result.append(model.getType().getId());
                } else {
                    result.append("null");
                }
                result.append("\n");
                
                //result += "memo:" + model.getMemo() + "\n";
                result.append("memo:");
                result.append(model.getMemo());
                result.append("\n");
                                
                //result += "---------\n";
                result.append("---------");
                result.append("\n");
            } else {
                // Modelオブジェクトがnullの場合に、nullを表示.
                result.append("null");
                result.append("\n");
                result.append("---------");
                result.append("\n");
            }
        }
        
        return result.toString();
    }
}
```
