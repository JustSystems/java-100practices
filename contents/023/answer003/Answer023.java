public class Answer023 {

    public static void main(String[] arguments) {
        System.out.println("int to String : " + convertString(123));
        System.out.println("float to String : " + convertString(1.23F));
    }

    /**
     * int型の値をString型に変換する.
     * @param intNUm int型の値
     */
    private static String convertString(int intNum) {
        return String.valueOf(intNum);
    }

    /**
     * float型の値をString型に変換する.
     * @param floatNUm float型の値
     */
    private static String convertString(float floatNum) {
        return String.valueOf(floatNum);
    }
}
