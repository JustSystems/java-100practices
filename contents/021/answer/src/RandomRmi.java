import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 021‚Ì‰ğ“š‚Å‚·.
 *
 * @author jsfkdt
 */
public interface RandomRmi extends Remote {
    
    /**
     * 021‚Ì‰ğ“š‚Å‚·.0`7‚Ì”CˆÓ‚Ì®”‚ğ•Ô‚µ‚Ü‚·.
     * @return 0`7‚Ì”CˆÓ‚Ì®”iƒ‰ƒ“ƒ_ƒ€j
     */
    int returnRandom() throws RemoteException;
}