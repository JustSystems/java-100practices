import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remoteインタフェース.
 * サーバとクライアントで共有されるインタフェース
 */
public interface Answer021Ifc extends Remote {
    /**
     * 0から7の整数値をランダムで返す
     */
    int getRamdomNum() throws RemoteException;
}
