import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.io.IOException;

/**
 * 060の解答です.
 *
 * @author jsfkdt
 */
public class Answer060 {
    
    /**
     * 060の解答です.
     * 自マシンにバインドされているすべてのアドレスについて、
     * FQDNとIPアドレスとMACアドレスのセットを表示する.
     *
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        try {
            // マシン上の全てのインタフェースを取得.
            Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
            
            // インターフェイスが無ければ、スキップ.
            if (interfaces != null) {
                
                // 全インターフェイスを走査.
                while (interfaces.hasMoreElements()) {
                    
                    /* Macアドレス. */
                    String macAddress = "";
                    
                    // インタフェースを1件取得し、名前を表示.
                    NetworkInterface nextInterface = (NetworkInterface) interfaces.nextElement();
                    System.out.println("\n*ネットワークインターフェイス【" + nextInterface.getDisplayName() + "】");
                    
                    // このインタフェースにバインドされた全てのInetAddressesを取得.
                    Enumeration addresses = nextInterface.getInetAddresses();
                    
                    while (addresses.hasMoreElements()) {
                        // InetAddressを１件取得.
                        InetAddress address = (InetAddress)addresses.nextElement();
                        
                        /* FQDN. */
                        System.out.println("getCanonicalHostName = [" + address.getCanonicalHostName() + "]");
                        
                        /* IPアドレス. */
                        System.out.println("getHostAddress       = [" + address.getHostAddress() + "]");
                        
                        // Macアドレス取得.
                        byte[] byteMacAddresses = nextInterface.getHardwareAddress();
                        
                        // Macアドレスのバイト文字列から出力用文字列に変換.
                        if (byteMacAddresses != null) {
                            for (int i = 0; i < byteMacAddresses.length - 1; i++) {
                                macAddress += String.format("%02X:", byteMacAddresses[i]);
                            }
                            macAddress += String.format("%02X", byteMacAddresses[byteMacAddresses.length - 1]);
                        }
                        /* Macアドレス */
                        System.out.println("getMacAddress        = [" + macAddress + "]" + "\n");
                    }
                }
            } else {
                System.out.println("インターフェイスがありません。");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}