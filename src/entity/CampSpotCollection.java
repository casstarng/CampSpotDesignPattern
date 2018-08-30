package entity;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Cassidy Tarng on 8/16/2018.
 */
public class CampSpotCollection implements Aggregate{

    private ArrayList<CampSpot> campSpots;

    public CampSpotCollection(){
        campSpots = new ArrayList<>();
    }

    /**
     * Adds a CampSpot to the collection
     */
    public void addSpot(CampSpot campSpot){
        campSpots.add(campSpot);
    }

    /**
     * @return Size of the current collection
     */
    public int size(){
        return campSpots.size();
    }

    /**
     * @return CampSpot based on label
     */
    public CampSpot getCampSpot(String label){
        for (int i = 0; i < campSpots.size(); i++){
            if (campSpots.get(i).getLabel().equals(label)) return campSpots.get(i);
        }
        return null;
    }

    /**
     * @return CampSpot based on index
     */
    public int getCampSpotIndex(String label){
        for (int i = 0; i < campSpots.size(); i++){
            if (campSpots.get(i).getLabel().equals(label)) return i;
        }
        return 0;
    }

    /**
     * Creates an iterator and returns
     */
    public entity.Iterator createIterator(){
        return new CampSpotIterator(campSpots);
    }


}
