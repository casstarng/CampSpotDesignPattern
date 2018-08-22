package campspot;

import java.util.Observer;

/**
 * Created by Cassidy Tarng on 8/21/2018.
 */
public interface Subject {

    public void attach(campspot.Observer o);
    public void detatch(campspot.Observer o);
    public void notifyObserver();

}
