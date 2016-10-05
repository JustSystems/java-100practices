/**
 * 016の解答です。
 *
 * @author jsfkdt
 */
public class answer016 {
    public static void main(String[] args) {
        new answer016_2();
    }
}

public class Answer016 {

    private String name;
    
    //privateコンストラクタを実装
    private answer016_2(){
        System.out.println("end");
    }
}

（コメント）
privateコンストラクタを実装することで、他クラスからインスタンスを作成できないようにしました。
answer016をコンパイルすると以下のようなエラーが発生します。

C:\Users\fukudata\Documents\tmp>javac *.java
answer016.java:12: エラー: answer016_2()はanswer016_2でprivateアクセスされます
        new answer016_2();
        ^
エラー1個

