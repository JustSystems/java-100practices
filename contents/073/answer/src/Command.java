/**
 * 073で用いるCommandインタフェイス.
 *
 * @author jsfkdt
 */
public interface Command<T> {
    
    /**
     * コマンド実行状態のステータスを管理.
     */
    enum Status {
            NONE,
            EXECUTING,
            SUCCESS,
            ERROR;
    }
    
    /**
     * 処理を実行する.
     */
    public void execute();
    
    /**
     * 処理状況を取得する.
     * 
     * @return ステータス. 初期値はNONE.
     */
    public Status getStatus();
    
    /**
     * コマンドの実行結果を取得する.
     *
     * @return コマンド実行結果のオブジェクト. 未実行時やエラー時はnull.
     */
    public T getResult();
    
    /**
     * コマンド失敗時の例外を取得する.
     *
     * @return 例外. 未発生時はnull.
     */
    public Throwable getException();
}