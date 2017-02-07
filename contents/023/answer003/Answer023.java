public class Answer023 {

    public static void main(String[] arguments) {
        System.out.println("int to String : " + convertToString(123));
        System.out.println("float to String : " + convertToString(1.23F));
    }

    /**
     * int型の値をString型に変換する.
     * @param intNUm int型の値
     */
    private static String convertToString(int intNum) {
        return String.valueOf(intNum);
    }

    /**
     * float型の値をString型に変換する.
     * @param floatNUm float型の値
     */
    private static String convertToString(float floatNum) {
        return String.valueOf(floatNum);
    }
}
