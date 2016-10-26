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
        Random randomInteger = new Random();
        int number = 3/0; // ArithmeticExceptionを発生させる.
        return new Integer(randomInteger.nextInt());
    }
}