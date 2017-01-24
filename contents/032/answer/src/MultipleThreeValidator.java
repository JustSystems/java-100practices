/**
 * 032‚Å—p‚¢‚é3‚Ì”{””»’è‘•’u.
 *
 * @author jsfkdt
 */
public class MultipleThreeValidator implements Validator {

    /**
     * {@inheritDoc}
     */
    public boolean isValid(int number) {
         return number % 3 == 0;
    }
}