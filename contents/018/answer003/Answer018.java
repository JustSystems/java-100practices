public class Answer018 {
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

        private int id;
        private String label;

        Eto(int id, String label){
            this.id = id;
            this.label = label;
        }

        public int getId() {
            return this.id;
        }

        public String getLabel() {
            return this.label;
        }

        public static Eto findById(int id) {
            for(Eto eto : Eto.values()){
                if(eto.getId() == id) return eto;
            }
            return null;
        }

        public static Eto findByLabel(String label) {
            if(label == null) return null;
            for(Eto eto : Eto.values()){
                if(eto.getLabel().equals(label)) return eto;
            }
            return null;
        }
    }

    public static void main(String arguments[]) {
        System.out.println(Eto.findById(12).getLabel());
        System.out.println(Eto.findByLabel("uma").getId());
    }
}
