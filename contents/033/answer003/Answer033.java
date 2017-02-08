import java.util.Arrays;
import java.util.List;

public class Answer033 {
    /**
     * 数値のリストから、奇数のみを出力する.
     */
    public static void main(String arguments[]) {
        List<Integer> numberList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        // 奇数の要素のみに絞り、それぞれを出力する
        numberList.stream()
            .filter(number -> isOddNumber(number))
            .forEach(number -> System.out.println(number));
    }

    /**
     * 奇数を判定する.
     * @return 奇数の場合にtrueを返し、偶数の場合にfalseを返す
     */
    private static boolean isOddNumber(int num) {
        return (num % 2 != 0);
    }
}
