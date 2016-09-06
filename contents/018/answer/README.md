[問題](../README.md)

***
# 018：解答例

```java:EarthlyBranches.java
public class Knock {
    private enum EarthlyBranches {
        NE("子", 1), USHI("丑", 2), TRA("寅", 3), U("卯", 4), TATSU("辰", 5), MI("巳", 6),
        HITSUJI("未", 7), UMA("午", 8), SARU("申", 9), TORI("酉", 10), INU("戌", 11), I("亥", 12);

        private final String text;
        private final int id;

        private EarthlyBranches(final String text, final int id) {
            this.text = text;
            this.id   = id;
        }

        public static EarthlyBranches findById(final int id) {
            for (final EarthlyBranches eb : EarthlyBranches.values()) {
                if (eb.id == id) {
                    return eb;
                }
            }
            return null;
        }

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

    public static void main(String[] args) {
        System.out.println(EarthlyBranches.findById(1).text);
        System.out.println(EarthlyBranches.findByText("申").text);
    }

}
```
