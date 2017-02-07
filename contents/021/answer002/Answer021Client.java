import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * クライアント側の処理.
 */
public class Answer021Client {

    /**
     * @param arguments 第一引数にリモートレジストリのホストを指定する。指定がなければローカルホストが使用される。
     */
    public static void main(String[] arguments) {
        String host = (arguments.length < 1) ? null : arguments[0];

        try {
            // 指定したnameのリモートオブジェクトを取得する
            Registry registry = LocateRegistry.getRegistry(host);
            Answer021Ifc answer021Ifc = (Answer021Ifc) registry.lookup("answer021");
            System.out.println(answer021Ifc.getRamdomNum());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
