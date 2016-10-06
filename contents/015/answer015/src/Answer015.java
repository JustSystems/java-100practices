/**
 * 015の解答です。
 *
 * @author jsfkdt
 */
public class Answer015 {

    private String name;
    
    /**
     * {@code no name}を名前に持つインスタンスを生成する。
     */
    Answer015(){
        this("no name");
    }
    
    /**
     * コンストラクタで名前を設定する。
     *
     * @param iname 表示する名前
     */
    Answer015(String iname){
        this.name = iname;
    }
    
    /**
     * 015の解答です。
     * @param arguments 使用しません。
     */
    public static void main(String[] args) {
        String withoutName = new Answer015().name;
        String withName = new Answer015("Answer015").name;
        System.out.println(withoutName);
        System.out.println(withName);
    }
}
