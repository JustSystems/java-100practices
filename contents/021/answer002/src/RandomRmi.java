import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 021の解答です. 0～7の任意の整数を返すインターフェイス.
 *
 * @author jsfkdt
 */
public interface RandomRmi extends Remote {
    int returnRandom() throws RemoteException;
}