package entity;

/**
 * Created by Cassidy Tarng on 8/21/2018.
 */
public class LargeParkingCampSpot extends CampSpotDecorator {

    public LargeParkingCampSpot(CampSpot campSpot){
        super(campSpot);
    }

    public double getPrice(){
        return campSpot.getPrice() + 20;
    }


}
