import java.util.Date;

/**
 * 073で用いるランダムな数値取得コマンド.
 *
 * @author jsfkdt
 */
public class CurrentDateCommand extends AbstractCommand {
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected Date executeInner() {
        return new Date();
    }
}