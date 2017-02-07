import java.util.ArrayList;
import java.util.List;

public class Answer020 {
    // リストに入れるメダル
    private static final String[] MEDALS = new String[]{
        "GOLD", "SILVER", "BRONZE"
    };

    public static void main(String arguments[]) {
        createNonGenericsList();
        createGenericsList();
    }

    /**
     * ジェネリクスを用いていないリストの作成と表示
     */
    private static void createNonGenericsList() {
        List nonGenericsList = new ArrayList();
        for (String medal : MEDALS) {
            nonGenericsList.add((String) medal);
        }
        for (int i = 0; i < nonGenericsList.size(); i++) {
            System.out.println((String) nonGenericsList.get(i));
        }
    }

    /**
     * ジェネリクスを用いたリストの作成と表示
     */
    private static void createGenericsList() {
        List<String> genericsList = new ArrayList<String>();
        for (String medal : MEDALS) {
            genericsList.add(medal);
        }
        for (String item : genericsList) {
            System.out.println(item);
        }
    }
}
