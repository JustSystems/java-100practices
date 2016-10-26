import java.util.Date;
/**
 * 073の解答です.
 *
 * @author jsfkdt
 */
public class Answer073 {
    /**
     * 073の解答です.
     *
     * @param arguments 使用しません.
     */
    public static void main(final String[] args){
        // Dateコマンドを実行
        Command date = CommandFactory.getInstance().createCurrentCommand();
        System.out.println("Dateコマンドの実行");
        System.out.println("実行前ステータス：" + date.getStatus());
        date.execute();
        System.out.println("実行後ステータス：" + date.getStatus());
        System.out.println("実行結果：" + date.getResult());
        System.out.println("例外：" + date.getException());
        System.out.println();
        
        // Randomコマンドを実行
        Command num = CommandFactory.getInstance().createRandomIntegerCommand();
        System.out.println("Randomコマンドの実行");
        System.out.println("実行前ステータス：" + num.getStatus());
        num.execute();
        System.out.println("実行後ステータス：" + num.getStatus());
        System.out.println("実行結果：" + num.getResult());
        System.out.println("例外：" + num.getException());
        
    
    }
}