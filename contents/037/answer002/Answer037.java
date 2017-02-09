import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.lang.CloneNotSupportedException;

public class Answer037 implements Cloneable {
    public static void main(String[] arguments) {
        List<Date> dateList = new ArrayList<Date>();
        dateList.add(new Date());
        dateList.add(new Date());

        // ディープコピー
        List<Date> deepCopy = deepCopy(dateList);
        // シャローコピー
        List<Date> shallowCopy = shallowCopy(dateList);

        // オリジナルを書き換える前のコピーリストの要素
        System.out.println("deepCopy    : " + deepCopy.get(0));
        System.out.println("shallowCopy : " + shallowCopy.get(0));

        // 3秒間待ち、オリジナルのリストの1つ目の要素を現在時刻に書き換える
        try {
            Thread.sleep(3000);
            dateList.set(0, new Date());
            System.out.println("set new Date to original");
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        // オリジナルを書き換えた後のコピーリストの要素
        System.out.println("deepCopy    : " + deepCopy.get(0));
        System.out.println("shallowCopy : " + shallowCopy.get(0));
    }

    /**
     * ディープコピーを作成する.
     * @param  List<Date> list オリジナルのリスト
     * @return オリジナルリストの要素を含む新たなリストの実体
     */
    public static List<Date> deepCopy(List<Date> list) {
        return new ArrayList<Date>(list);
    }

    /**
     * シャローコピーを作成する.
     * @param  List<Date> list オリジナルのリスト
     * @return オリジナルリストの参照
     */
    public static List<Date> shallowCopy(List<Date> list) {
        return list;
    }
}
