import java.util.Date;

/**
 * 073で用いるCommandFactory.
 *
 * @author jsfkdt
 */
public class CommandFactory {
    private static CommandFactory instance = new CommandFactory();
    
    /**
     * インスタンス化されないための修飾子を付与したコンストラクタ.
     */
    private CommandFactory() {
    }
    
    /**
     * 本クラスのインスタンスを取得する.
     */
    public static CommandFactory getInstance() {
        return instance;
    }
    
    // 日付取得インスタンス 
    
    
    /**
     * 現在日時を表すメソッドを持つクラスのインスタンスを取得.
     *
     * @return 現在日時を表すメソッドを持つクラスのインスタンス.
     */
    @SuppressWarnings("unchecked")
    public Command<Date> createCurrentCommand() {
        Command<Date> date = new CurrentDateCommand();
        return date;
    }
    
    /**
     * ランダムな数値を返すメソッドを持つクラスのインスタンスを取得.
     *
     * @return ランダムな数値を返すメソッドを持つクラスのインスタンス.
     */
    @SuppressWarnings("unchecked")
    public Command<Integer> createRandomIntegerCommand() {
        Command<Integer> rand = new RandomIntegerCommand();
        return rand;
    }
    

}