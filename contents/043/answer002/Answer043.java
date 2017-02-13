import java.util.Date;

public class Answer043 extends Object implements Cloneable {
    // インスタンスの生成時刻
    private Date date = new Date();

    public static void main(String[] arguments) {
        Answer043 original = new Answer043();
        // 3秒停止後にコピー
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Answer043 copy = original.clone();

        System.out.println("original " + (original.date));
        System.out.println("copy     " + (copy.date));
    }

    /**
     * ディープコピーを作成する.
     * Objectのclone()をオーバーライド。
     */
    @Override
    public Answer043 clone() {
        Answer043 copy = null;
        try {
            copy = (Answer043) super.clone();
            // インスタンスの作成日時を現在時刻にする
            copy.setDate(new Date());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return copy;
    }

    /**
     * インスタンスの作成日時を設定する.
     * @param Date date インスタンスの作成日時
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
