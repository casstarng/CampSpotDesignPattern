package campspot;

/**
 * Created by Cassidy Tarng on 8/23/2018.
 */
public class CampOpen implements CampAvailabilityState {
    @Override
    public boolean isOpen() {
        return false;
    }
}
