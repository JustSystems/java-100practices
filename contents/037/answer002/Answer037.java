import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.lang.CloneNotSupportedException;

public class Answer037 {
    public static void main(String[] arguments) {
        List<Date> dateList = new ArrayList<Date>();
        dateList.add(new Date());
        dateList.add(new Date());

        // ディープコピー
        List<Date> deepCopy = deepCopy(dateList);
        // シャローコピー
        List<Date> shallowCopy = shallowCopy(dateList);

        // オリジナルの要素と参照が同じか確認
        System.out.println("deepCopy    reference equal : " + (dateList.get(0) == deepCopy.get(0)));
        System.out.println("shallowCopy reference equal : " + (dateList.get(0) == shallowCopy.get(0)));
        // オリジナルの要素と値が同じか確認
        System.out.println("deepCopy    value equal : " + (dateList.get(0).equals(deepCopy.get(0))));
        System.out.println("shallowCopy value equal : " + (dateList.get(0).equals(shallowCopy.get(0))));
    }

    /**
     * ディープコピーを作成する.
     * @param  List<Date> oriList オリジナルのリスト
     * @return オリジナルリストの要素と同じ値の新たなDateインスタンスをもつ、新たなArrayListのインスタンス。引数がnullの場合は、nullを返す。
     */
    public static List<Date> deepCopy(List<Date> oriList) {
        if (oriList == null) {
            return null;
        }

        // 新たなリストのインスタンス
        List<Date> copyList = new ArrayList<Date>();
        // オリジナルリストの要素と同じ値で新たな要素のインスタンスを作成しaddする
        // 要素がnullの場合は、nullをaddする
        for (Date oriDate : oriList) {
            if (oriDate == null) {
                copyList.add(null);
            } else {
                copyList.add(new Date(oriDate.getTime()));
            }
        }
        return copyList;
    }

    /**
     * シャローコピーを作成する.
     * @param  List<Date> oriList オリジナルのリスト
     * @return オリジナルリストの要素の参照を持つ新たなArrayListのインスタンス。引数がnullの場合は、nullを返す。
     */
    public static List<Date> shallowCopy(List<Date> oriList) {
        if (oriList == null) {
            return null;
        }

        return new ArrayList<Date>(oriList);
    }
}
