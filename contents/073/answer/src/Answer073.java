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
        output("Date", CommandFactory.getInstance().createCurrentCommand());
        // Randomコマンドを実行
        output("Random", CommandFactory.getInstance().createRandomIntegerCommand());
    }
    
    public static void output(String commandName, Command command) {
        System.out.println(commandName + "コマンドの実行");
        System.out.println("実行前ステータス：" + command.getStatus());
        command.execute();
        System.out.println("実行後ステータス：" + command.getStatus());
        System.out.println("実行結果：" + command.getResult());
        System.out.println("例外：" + command.getException());
        System.out.println();
    }
}