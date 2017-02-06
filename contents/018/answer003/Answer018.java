public class Answer018 {

    /**
     * 十二支を表現するenum
     */
    private enum Eto {
        NE(1, "ne"),
        USHI(2, "ushi"),
        TORA(3, "tora"),
        U(4, "u"),
        TATSU(5, "tatsu"),
        MI(6, "mi"),
        UMA(7, "uma"),
        HITSUJI(8, "hitsuji"),
        SARU(9, "saru"),
        TORI(10, "tori"),
        INU(11, "inu"),
        I(12, "i");

        // 干支のID
        private int id;
        // 干支の名称
        private String label;

        /**
         * @param id 干支のID
         * @param label 干支の名称
         */
        Eto(int id, String label) {
            this.id = id;
            this.label = label;
        }

        /**
         * IDを取得する.
         * @return 干支のID
         */
        public int getId() {
            return this.id;
        }

        /**
         * ラベルを取得する.
         * @return 干支の名称
         */
        public String getLabel() {
            return this.label;
        }

        /**
         * 指定のIDをもつ干支を取得する.
         * @param id 干支のID
         * @return 指定のIDをもつ干支のインスタンス。存在しない場合はnullを返す
         */
        public static Eto findById(int id) {
            for (Eto eto : Eto.values()) {
                if (eto.getId() == id) {
                    return eto;
                }
            }
            return null;
        }

        /**
         * 指定の名称をもつ干支を取得する.
         * @param label 干支の名称
         * @return 指定の名称をもつ干支のインスタンス。存在しない場合、labelがnullの場合はnullを返す
         */
        public static Eto findByLabel(String label) {
            if (label == null) {
                return null;
            }
            for (Eto eto : Eto.values()) {
                if (eto.getLabel().equals(label)) {
                    return eto;
                }
            }
            return null;
        }
    }

    public static void main(String arguments[]) {
        System.out.println(Eto.findById(12).getLabel());
        System.out.println(Eto.findByLabel("uma").getId());
    }
}
