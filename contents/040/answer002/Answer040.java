public class Answer040 {
    /**
     * 例外をthrowするスレッドを起動する.
     */
    public static void main(String[] argumetns) {
        Thread thread = new MyThread();
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        thread.start();
    }
}
