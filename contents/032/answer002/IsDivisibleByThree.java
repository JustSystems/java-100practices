import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 3で割り切れる数を示すアノテーション.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface IsDivisibleByThree {
}
