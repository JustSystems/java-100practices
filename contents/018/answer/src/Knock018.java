/**
 * 018：列挙型.
 * ユニークな名前とIDを持ち、名前とIDどちらでもインスタンスが取得できるenumを実装せよ.
 *   * 例として、十二支を表現するenumを実装せよ.
 * 
 * @author toastkidjp
 */
public class Knock018 {

    /**
     * 十二支を表現する enum.
     *
     */
    private enum EarthlyBranches {
        NE("子", 1), USHI("丑", 2), TRA("寅", 3), U("卯", 4), TATSU("辰", 5), MI("巳", 6),
        HITSUJI("未", 7), UMA("午", 8), SARU("申", 9), TORI("酉", 10), INU("戌", 11), I("亥", 12);

        /** 十二支の日本名. */
        private final String text;

        /** ID */
        private final int id;

        /**
         * private constructor.
         * @param text 十二支の日本名
         * @param id   ID
         */
        private EarthlyBranches(final String text, final int id) {
            this.text = text;
            this.id   = id;
        }

        /**
         * ID で EarthlyBranches インスタンスを取得する.
         * @param id
         * @return ID に対応する EarthlyBranches インスタンス
         */
        public static EarthlyBranches findById(final int id) {
            for (final EarthlyBranches eb : EarthlyBranches.values()) {
                if (eb.id == id) {
                    return eb;
                }
            }
            return null;
        }

        /**
         * 名前 で EarthlyBranches インスタンスを取得する.
         * @param text 名前
         * @return 名前に対応する EarthlyBranches インスタンス
         */
        public static EarthlyBranches findByText(final String text) {

            if (text == null) {
                return null;
            }

            for (final EarthlyBranches eb : EarthlyBranches.values()) {
                if (eb.text.equals(text)) {
                    return eb;
                }
            }
            return null;
        }
    }

    /**
     * main method.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(EarthlyBranches.findById(1).text);
        System.out.println(EarthlyBranches.findByText("申").text);
    }

}
