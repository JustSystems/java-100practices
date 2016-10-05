/**
 * 015の解答です。
 *
 * @author jsfkdt
 */
public class answer015 {

    private String name;
    
    answer015(){
        this("no name");
    }
    
    answer015(String iname){
        this.name = iname;
    }
    
    /**
     * 015の解答です。
     * @param arguments 使用しません。
     */
    public static void main(String[] args) {
        String def = new answer015().name;
        String input = new answer015("Answer015").name;
        System.out.println(def);
        System.out.println(input);
    }
}
