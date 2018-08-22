package entity;

import java.util.UUID;

/**
 * Created by Cassidy Tarng on 8/21/2018.
 */
public interface CampSpot {

    public UUID getCampSpotID();

    public int getRecommendedPeople();

    public boolean isHandicap();

    public int getTentSpace();

    public double getPrice();

    public int getParkingSpace();

    public void setHandicap(boolean handicap);

    public void setParkingSpace(int parkingSpace);

    public void setPrice(double price);

    public void setRecommendedPeople(int recommendedPeople);

    public void setTentSpace(int tentSpace);

    public String getLabel();

    public String[] getDatesReserved();
}
