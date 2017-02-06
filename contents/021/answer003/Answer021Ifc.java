import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remoteインタフェース.
 * サーバとクライアントで共有されるインタフェース
 */
public interface Answer021Ifc extends Remote {
    // クライアントから呼び出されるランダム値を返すメソッドを定義
    int getRamdomNum() throws RemoteException;
}
