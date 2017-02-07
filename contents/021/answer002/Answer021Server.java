import java.util.Random;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * サーバ側の処理.
 */
public class Answer021Server implements Answer021Ifc {
    public Answer021Server() {}

    public static void main(String arguments[]) {
        try {
            // リモートオブジェクトを作成し、Java RMIランタイムへエクスポート
            Answer021Server obj = new Answer021Server();
            // portに0を指定すると、portは自動割り当てされる
            Answer021Ifc stub = (Answer021Ifc) UnicastRemoteObject.exportObject(obj, 0);
            // リモートオブジェクトレジストリに指定した名前でバインドする
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("answer021", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 0から7の整数値をランダムで返す
     */
    public int getRamdomNum() throws RemoteException {
        Random rand = new Random();
        return rand.nextInt(8);
    }
}
