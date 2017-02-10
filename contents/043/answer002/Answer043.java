import java.util.Date;

public class Answer043 extends Object implements Cloneable {
    // インスタンスの生成時刻
    Date date = new Date();

    public static void main(String[] arguments) {
        Answer043 original = new Answer043();
        Answer043 copy = original.clone();

        System.out.println("reference equal : " + (original.date == copy.date));
    }

    /**
     * シャローコピーを作成する.
     * Objectのclone()をオーバーライド。
     */
    @Override
    public Answer043 clone() {
        Answer043 copy = null;
        try {
            copy = (Answer043) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return copy;
    }
}
