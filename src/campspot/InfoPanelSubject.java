package campspot;

import entity.CampSpot;

import java.util.*;

/**
 * Created by Cassidy Tarng on 8/21/2018.
 */
public class InfoPanelSubject implements Subject {

    private ArrayList<campspot.Observer> observers = new ArrayList<>();
    private CampSpot currentSpot;

    /**
     * Updates the currentSpot and notifies all observers
     */
    public void setCurrentSpot(CampSpot currentSpot){
        this.currentSpot = currentSpot;

        notifyObserver();
    }


    @Override
    public void attach(campspot.Observer o) {
        observers.add(o);
    }

    @Override
    public void detatch(campspot.Observer o) {
        int observerIndex = observers.indexOf(o);
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        for(campspot.Observer o : observers){
            o.update(currentSpot);
        }
    }
}
