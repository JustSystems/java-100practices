import java.util.Date;

/**
 * 073で用いるCommand実装クラス.
 *
 * @author jsfkdt
 */
public abstract class AbstractCommand<T> implements Command<T> {
    
    /* フラグの初期化. */
    private Status flag = Status.NONE;
    
    /* 例外の初期化. */
    private Exception error = null;
    
    /* 実行結果の初期化(未実行時の状態). */
    private T result = null;
    
    /**
     * 処理を行い、オブジェクトを返却する.
     *
     * @return 処理結果のオブジェクト.
     */
    protected abstract T executeInner();
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        // 実行状態フラグを設定.
        flag = Status.EXECUTING;
        
        try {
            // 共通メソッドの実行(本処理)
            result = executeInner();
            
        } catch (Exception error) {
            // エラーフラグを設定.
            flag = Status.ERROR;
            // 実行結果をnullに設定.
            result = null;
            // 例外を設定.
            this.error = error;
            return;
        }
        
        // 成功フラグを設定.
        flag = Status.SUCCESS;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Status getStatus() {
        return flag;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public T getResult() {
        return result;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Exception getException() {
        return error;
    }
}