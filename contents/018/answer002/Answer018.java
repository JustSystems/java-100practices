/**
 * 018を解答.
 * 
 * @author jsfkdt
 */
public class Answer018 {
    
    private enum ZodiacSigns {
        NE("子", 1), USHI("丑", 2), TORA("寅", 3), U("卯", 4), TATSU("辰", 5), MI("巳", 6),
        HITSUJI("未", 7), UMA("午", 8), SARU("申", 9), TORI("酉", 10), INU("戌", 11), I("亥", 12);
        
        /** 十二支の名前. */
        private final String name;
        
        /** 固有のID. */
        private final int id;
        
        /**
         * 十二支の名前とIDを設定する.
         *
         * @param name 十二支の名前
         * @param id   固有のID
         */
        private ZodiacSigns(final String name, final int id) {
            this.name = name;
            this.id = id;
        }
        
        // 十二支の名前を取得する.
        public String getName() {
            return name;
        }
        
        // 固有のIDを取得する.
        public int getId() {
            return id;
        }
        
        /**
         * 固有のIDに紐付く十二支のインスタンスを取得する.
         *
         * @param  id  固有のID
         * @return 該当のIDに紐付く十二支のインスタンス. 該当しない場合はnull.
         */
        public static ZodiacSigns getInstanceFromId(final int id) {
            for (final ZodiacSigns instance : ZodiacSigns.values()) {
                if (instance.id == id) {
                    return instance;
                }
            }
            return null;
        }
        
        /**
         * 十二支の名前に紐付くインスタンスを取得する.
         *
         * @param  name  十二支の名前
         * @return 該当の名前に紐付く十二支のインスタンス. 該当しない場合はnull.
         */
        public static ZodiacSigns getInstanceFromName(final String name) {
            for (final ZodiacSigns instance : ZodiacSigns.values()) {
                if (instance.name == name) {
                    return instance;
                }
            }
            return null;
        }
    }

    /**
     * 018の解答です.
     * @param arguments 使用しません.
     */
    public static void main(String[] args) {
        System.out.println(ZodiacSigns.getInstanceFromId(1));
        System.out.println(ZodiacSigns.getInstanceFromName("寅"));
    }
}
