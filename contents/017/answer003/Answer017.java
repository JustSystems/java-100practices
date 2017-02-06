public class Answer017 extends Thread {
    private static volatile AtomicLong num = 0L;
    private static final int LOOP_COUNT = 1000000;

    public void run() {
        for (int i = 0; i < LOOP_COUNT; i++) {
            if (num.get() == 0L) {
                num.set(-1L);
            } else {
                num.set(0L);
            }
            System.out.print("A" + num + " ");
        }
    }

    public static void main(String arguments[]) {
        Answer017 thread1 = new Answer017();
        thread1.start();

        for (int i = 0; i < LOOP_COUNT; i++) {
            System.out.print("B" + num.get() + " ");
        }
    }
}
