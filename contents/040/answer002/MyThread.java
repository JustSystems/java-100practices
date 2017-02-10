public class MyThread extends Thread {
    /**
     * 非チェック例外を投げる.
     */
    public void run() {
        throw new RuntimeException();
    }
}
