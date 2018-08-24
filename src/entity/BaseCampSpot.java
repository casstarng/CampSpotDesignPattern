package entity; /**
 * Created by Cassidy Tarng on 5/4/2018.
 */
import campspot.CampAvailabilityState;
import campspot.CampOpen;

import java.util.UUID;
public class BaseCampSpot implements CampSpot{
    private UUID campSpotID;
    private String label;
    private int parkingSpace;
    private int recommendedPeople;
    private int tentSpace;
    private double price;
    private boolean handicap;
    private String[] datesReserved;
    private CampAvailabilityState campAvailabilityState;

    public BaseCampSpot(String label, int parkingSpace, int recommendedPeople,
                        int tentSpace, double price, boolean handicap, String[] datesReserved) {
        this.label = label;
        this.parkingSpace = parkingSpace;
        this.recommendedPeople = recommendedPeople;
        this.tentSpace = tentSpace;
        this.price = price;
        this.handicap = handicap;
        this.datesReserved = datesReserved;
        campSpotID = UUID.randomUUID();
        campAvailabilityState = new CampOpen();
    }

    public void setState(CampAvailabilityState campAvailabilityState){
        this.campAvailabilityState = campAvailabilityState;
    }

    public boolean isOpen(){
        return campAvailabilityState.isOpen();
    }

    public UUID getCampSpotID() {
        return campSpotID;
    }

    public int getRecommendedPeople() {
        return recommendedPeople;
    }

    public boolean isHandicap() {
        return handicap;
    }

    public int getTentSpace() {
        return tentSpace;
    }

    public double getPrice() {
        return price;
    }

    public int getParkingSpace() {
        return parkingSpace;
    }

    public void setHandicap(boolean handicap) {
        this.handicap = handicap;
    }

    public void setParkingSpace(int parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRecommendedPeople(int recommendedPeople) {
        this.recommendedPeople = recommendedPeople;
    }

    public void setTentSpace(int tentSpace) {
        this.tentSpace = tentSpace;
    }

    public String getLabel() {
        return label;
    }

    public String[] getDatesReserved() {
            return datesReserved;
    }
}
