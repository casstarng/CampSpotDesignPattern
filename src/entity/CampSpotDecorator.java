package entity;

import java.util.UUID;

/**
 * Created by Cassidy Tarng on 8/21/2018.
 */
abstract class CampSpotDecorator implements CampSpot{

    protected CampSpot campSpot;

    public CampSpotDecorator(CampSpot campSpot){
        this.campSpot = campSpot;
    }

    public double getPrice(){
        return campSpot.getPrice();
    }

    public UUID getCampSpotID() {
        return campSpot.getCampSpotID();
    }

    public int getRecommendedPeople() { return campSpot.getRecommendedPeople(); }

    public boolean isHandicap() { return campSpot.isHandicap(); }

    public int getTentSpace() {
        return campSpot.getTentSpace();
    }

    public int getParkingSpace() {
        return campSpot.getParkingSpace();
    }

    public void setHandicap(boolean handicap) {
        campSpot.setHandicap(handicap);
    }

    public void setParkingSpace(int parkingSpace) {
        campSpot.setParkingSpace(parkingSpace);
    }

    public void setPrice(double price) {
        campSpot.setPrice(price);
    }

    public void setRecommendedPeople(int recommendedPeople) {
        campSpot.setRecommendedPeople(recommendedPeople);
    }

    public void setTentSpace(int tentSpace) {
        campSpot.setTentSpace(tentSpace);
    }

    public String getLabel() { return campSpot.getLabel(); }

    public String[] getDatesReserved() {
        return campSpot.getDatesReserved();
    }
}
