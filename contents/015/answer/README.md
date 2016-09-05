[問題](../README.md)

***
# 015：解答例

```java:Knock015.java
public class Knock015 {

    private String str;

    Knock015() {
        this("no name");
    }
    Knock015(final String str) {
        this.str = str;
    }

    public static void main(String[] args) {
        System.out.println(new Knock015("Just Taro").str);
        System.out.println(new Knock015().str);
    }

}
```


```:実行
$ javac Knock015.java
$ java Knock015
Just Taro
no name
```
