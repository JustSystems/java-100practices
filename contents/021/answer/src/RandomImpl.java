import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Random;

/**
 * 021の解答です. サーバ側が結果を返却する.
 *
 * @author jsfkdt
 */
public class RandomImpl extends UnicastRemoteObject implements RandomRmi {
    
    public RandomImpl() throws RemoteException {
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int returnRandom() {
        Random rand = new Random();
        int num = rand.nextInt(8);
        return num;
    }
    
    /**
     * 021の解答です. 
     *
     * @param arguments 使用しません.
     */
    public static void main(String[] args) {
        // サーバの起動
        System.out.println("Server start");
        
        try {
            RandomRmi random = new RandomImpl();
            Naming.rebind("RandomObject", random);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
