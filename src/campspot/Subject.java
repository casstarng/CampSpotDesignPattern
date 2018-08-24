package campspot;


/**
 * Created by Cassidy Tarng on 8/21/2018.
 */
public interface Subject {

    void attach(campspot.Observer o);
    void detatch(campspot.Observer o);
    void notifyObserver();

}
