@SuppressWarnings("unchecked")
public class Answer031 {
    public static void main(String[] arguments) {
        Class<String> object = getStringClass();
        System.out.println(object);
    }

    public static Class getStringClass() {
        return String.class;
    }
}
