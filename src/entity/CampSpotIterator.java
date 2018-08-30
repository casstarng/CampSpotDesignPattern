package entity;

import java.util.ArrayList;

public class CampSpotIterator implements Iterator {

    private ArrayList<CampSpot> campSpots;
    private int size;
    private int index = 0;

    public CampSpotIterator(ArrayList<CampSpot> campSpots){
        this.campSpots = campSpots;
        this.size = campSpots.size();
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public CampSpot next() {
        CampSpot spot = campSpots.get(index);
        index++;
        return spot;
    }
}
