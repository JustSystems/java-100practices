public class Answer017 extends Thread {
    private static long num = 0L;
    private static final int loopCount = 1000000;

    public void run() {
        for(int i = 0; i < loopCount; i++){
            num = (num == 0L) ? -1L : 0L;
            System.out.print("A" + num + " ");
        }
    }

    public static void main(String arguments[]) {
        Answer017 thread1 = new Answer017();
        thread1.start();

        for(int i = 0; i < loopCount; i++){
            System.out.print("B" + num + " ");
        }
    }
}
