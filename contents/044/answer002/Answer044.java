import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Answer044 implements Comparable<Answer044> {
    // Date型のインスタンス変数
    private Date date;

    /**
     * 引数なしで作成された場合は、dateを現在日時とする
     */
    Answer044() {
        date = new Date();
    }

    /**
     * 受け取った引数をミリ秒後として標準時からミリ秒後のdateを作成する
     */
    Answer044(long time) {
        date = new Date(time);
    }

    public static void main(String[] arguments) {
        List<Answer044> list = new ArrayList<Answer044>();
        list.add(new Answer044(2000L));
        list.add(new Answer044(3000L));
        list.add(new Answer044(1000L));

        // ソート前の並び
        System.out.println("before sort");
        for (Answer044 item : list) {
            System.out.println(item.date);
        }

        // ソートを実行
        Collections.sort(list);

        // ソート後の並び
        System.out.println("after sort");
        for (Answer044 item : list) {
            System.out.println(item.date);
        }
    }

    /**
     * Answer044クラスのオブジェクトを比較する
     * @param  Answer044 target 比較対象のオブジェクト
     * @return このオブジェクトのdateが比較対象のdateと等しい場合は0。このオブジェクトのdateの方が前の場合は0より小さい値。このオブジェクトのdateの方が後の場合は0より大きい値。
     * @throws NullPointerException 比較対象のオブジェクトがnullの場合。または、このオブジェクトか比較対象のオブジェクトのdateがnullの場合。
     */
    @Override
    public int compareTo(Answer044 target) throws NullPointerException {
        if (target == null || this.date == null || target.date == null) {
            throw new NullPointerException();
        }

        return this.date.compareTo(target.date);
    }
}
