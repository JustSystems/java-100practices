import java.util.Random;

/**
 * 073で用いる現在日時取得コマンド.
 *
 * @author jsfkdt
 */
public class RandomIntegerCommand extends AbstractCommand {
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer executeInner() {
        return new Integer(new Random().nextInt());
    }
}