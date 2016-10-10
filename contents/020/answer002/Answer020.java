import java.util.ArrayList;
import java.util.List;
/**
 * 020の解答です.
 *
 * @author jsfkdt
 */
public class Answer020 {
    
    /** 指定された配列 **/
    private static final String[] MEDALS = new String[] {"GOLD", "SILVER", "BRONZE"};
    
    /**
     * 020の解答です.
     * ジェネリクスを用いた場合と用いない場合、それぞれで要素を読み込み、
     * それぞれのリストについて、全要素を順番に出力する.
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        
        
        /** ジェネリクスを用いたリスト **/
        final List<String> genericList = new ArrayList<String>();
        
        /** ジェネリクスを用いないリスト **/
        final ArrayList nonGenericList = new ArrayList();
        
        // 指定のリスト要素をジェネリクスを用いたリストへ代入.
        for (final String medal : MEDALS) {
            genericList.add(medal);
        }
        
        // ジェネリクスを用いたリストの要素を順番に出力.
        for (int i = 0; i < genericList.size(); i++) {
            System.out.println(genericList.get(i));
        }
        
        // 指定のリスト要素をジェネリクスを用いないリストへ代入.
        for (String medal : MEDALS) {
            nonGenericList.add(medal);
        }
        
        // ジェネリクスを用いないリストの要素を順番に出力.
        for (int i = 0; i < nonGenericList.size(); i++) {
            System.out.println(nonGenericList.get(i));
        }
    }
    
}