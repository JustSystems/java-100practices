/**
 * 041用のメソッドを扱うクラスです.
 *
 * @author jsfkdt
 */
public class MethodForThread {
    
    /**
     * 1から10000までの加算結果を変数へ格納する.
     */
    public synchronized void calc() {
        
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // 加算処理.
        for(int num = 0; num < 10001; num++) {
            GlobalVariable.sum += num;
        }
        
        // waitしているスレッドに知らせる.
        notify();
    }
    
    /**
     * 加算結果を標準出力する.
     */
    public synchronized void output() {
        
        try {
            System.out.println("スレッドAで計算が完了するまで待ちます・・・");
            
            // 加算処理が完了したことを確認し、再度実行を開始.
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // 加算結果を表示する.
        System.out.println("計算結果：" + GlobalVariable.sum);
    }
}