package absensiRFID.serial;

/**
 *
 * @author advan
 * @param <T>
 */
public interface SerialDataHandler<T> {
    void onDataReceived(String uid);
    
}
