/**
 * 023‚Ì‰ğ“š‚Å‚·.
 *
 * @author jsfkdt
 */
public class Answer023 {
    /**
     * 023‚Ì‰ğ“š‚Å‚·.
     * intŒ^‚âfloatŒ^‚ğˆø”‚É‚Â“¯–¼‚Ìƒƒ\ƒbƒh‚ğg—p‚µA
     * StringŒ^‚ÌŒ‹‰Ê‚ğæ“¾‚·‚é.
     * 
     * @param arguments g—p‚µ‚Ü‚¹‚ñ.
     */
    public static void main(final String[] args) {
        System.out.println(convertToString(100));
        System.out.println(convertToString(100f));
    
    }
    
    /**
     * intŒ^‚Å“n‚³‚ê‚½ˆø”‚ğStringŒ^‚É•ÏŠ·‚µ•Ô‹p‚·‚é.
     *
     * @param word intŒ^‚Ìˆø”
     * @return intŒ^‚©‚çStringŒ^‚Ö•ÏŠ·‚µ‚½Œ‹‰Ê.
     */
    private static String convertToString(final int word) {
        return String.valueOf("intŒ^‚©‚çStringŒ^‚Ö•ÏŠ·‚µ‚½Œ‹‰ÊF" + word);
    }
    
    /**
     * floatŒ^‚Å“n‚³‚ê‚½ˆø”‚ğStringŒ^‚É•ÏŠ·‚µ•Ô‹p‚·‚é.
     *
     * @param word floatŒ^‚Ìˆø”
     * @return floatŒ^‚©‚çStringŒ^‚Ö•ÏŠ·‚µ‚½Œ‹‰Ê.
     */
    private static String convertToString(final float word) {
        return String.valueOf("floatŒ^‚©‚çStringŒ^‚Ö•ÏŠ·‚µ‚½Œ‹‰ÊF" + word);
    }
}