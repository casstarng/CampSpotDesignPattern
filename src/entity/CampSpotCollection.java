package entity;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Cassidy Tarng on 8/16/2018.
 */
public class CampSpotCollection implements CampSpotIterator{

    private ArrayList<CampSpot> campSpots;

    public CampSpotCollection(){
        campSpots = new ArrayList<>();
    }

    public void addSpot(CampSpot campSpot){
        campSpots.add(campSpot);
    }

    public int size(){
        return campSpots.size();
    }

    public CampSpot getCampSpot(String label){
        for (int i = 0; i < campSpots.size(); i++){
            if (campSpots.get(i).getLabel().equals(label)) return campSpots.get(i);
        }
        return null;
    }

    public int getCampSpotIndex(String label){
        for (int i = 0; i < campSpots.size(); i++){
            if (campSpots.get(i).getLabel().equals(label)) return i;
        }
        return 0;
    }

    public Iterator createIterator(){
        return campSpots.iterator();
    }


}
