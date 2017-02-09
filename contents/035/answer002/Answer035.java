public class Answer035 {
    /**
     *
     * @param String arguments[] [description]
     */
    public static void main(String arguments[]) {
        ThreadGroup groupA = new ThreadGroup("groupA");
        ThreadGroup groupB = new ThreadGroup("groupB");

        // groupA,Bそれぞれのスレッドグループに属するスレッドを100ずつ作成し起動する
        for (int i = 0; i < 100; i++) {
            new MyThread(groupA, "threadA").start();
            new MyThread(groupB, "threadB").start();
        }

        try {
            // 1秒毎に各スレッドグループに属しているアクティブなスレッドの数を出力
            // 各スレッドの停止時間が最大5秒だが、余裕を見て10秒間繰り返す
            for (int i = 0; i < 10; i++) {
                System.out.println("GroupA : " + groupA.activeCount());
                System.out.println("GroupB : " + groupB.activeCount());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
