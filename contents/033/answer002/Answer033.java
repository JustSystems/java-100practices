import java.util.List;
import java.util.Arrays;
/**
 * 033‚Ì‰ð“š‚Å‚·.
 *
 * @author jsfkdt
 */
public class Answer033 {
    /**
     * 033‚Ì‰ð“š‚Å‚·.
     * @param arguments Žg—p‚µ‚Ü‚¹‚ñ.
     */
    public static void main(final String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        list.stream().filter(x->x % 2 == 1).forEach(System.out::println);
    }
    
}