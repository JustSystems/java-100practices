/**
 * 035の解答です.
 *
 * @author jsfkdt
 */
public final class Answer035 implements Runnable {
    /* スレッドグループA. */
    private static ThreadGroup groupA = new ThreadGroup("GroupA");
    
    /* スレッドグループB. */
    private static ThreadGroup groupB = new ThreadGroup("GroupB");
    
    /**
     * グループA,Bのスレッドを各100スレッド実行する.
     */
    @Override public void run() {
        for (int i = 0; i < 100; i++) {
            new Thread(groupA, new ThreadRun(), "thread" + i).start();
        }
        
        for (int i = 0; i < 100; i++) {
            new Thread(groupB, new ThreadRun(), "thread" + i).start();
        }
    }
    
    /**
     * 各スレッドグループにおけるアクティブスレッド数を出力する.
     *
     * @param point カウント回数
     */
    public static void printActiveCount(int point) {
        System.out.println("Active Threads in Thread Group " + groupA.getName() +
            " at point(" + point + "):" + " " + groupA.activeCount());
    
        System.out.println("Active Threads in Thread Group " + groupB.getName() +
            " at point(" + point + "):" + " " + groupB.activeCount());
    }
    
    /**
     * 035の解答です.
     * スレッドグループごとにスレッドを実行し、
     * 各スレッドにてアクティブであるスレッド数を標準出力する.
     *
     * @param arguments 使用しません.
     */    
    public static void main(String[] args) throws InterruptedException {
        /* 新しいスレッドを割り当てる. */
        Thread thread = new Thread(new Answer035());
        
        /* スレッドを実行する. */
        thread.start();
        
        // アクティブスレッド数を出力する.
        for (int i = 1 ;; i++) {
            printActiveCount(i);
            thread.sleep(1000L);
            
            // アクティブスレッドが0になったときにループを抜ける.
            if (groupA.activeCount() == 0 && groupB.activeCount() == 0) {
                break;
            }
        }
    }
}