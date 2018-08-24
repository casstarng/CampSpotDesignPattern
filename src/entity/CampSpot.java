package entity;

import java.util.UUID;

/**
 * Created by Cassidy Tarng on 8/21/2018.
 */
public interface CampSpot {

    UUID getCampSpotID();

    int getRecommendedPeople();

    boolean isHandicap();

    int getTentSpace();

    double getPrice();

    int getParkingSpace();

    void setHandicap(boolean handicap);

    void setParkingSpace(int parkingSpace);

    void setPrice(double price);

    void setRecommendedPeople(int recommendedPeople);

    void setTentSpace(int tentSpace);

    String getLabel();

    String[] getDatesReserved();
}
