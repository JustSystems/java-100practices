import java.rmi.Naming;

/**
 * 021の解答です. クライアント側が結果を取得する.
 *
 * @author jsfkdt
 */
public class RandomClient {
    /**
     * 021の解答です. 
     *
     * @param arguments 使用しません.
     */
    public static void main(String[] args) {
        RandomRmi random;
        
        try {
            random = (RandomRmi)Naming.lookup("rmi://localhost/RandomObject");
            
            System.out.println(random.returnRandom());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}