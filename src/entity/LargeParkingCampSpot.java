package entity;

/**
 * Created by Cassidy Tarng on 8/21/2018.
 */
public class LargeParkingCampSpot extends CampSpotDecorator {

    public LargeParkingCampSpot(CampSpot campSpot){
        super(campSpot);
    }

    /**
     * @return Price of CampSpot + 30 for a Large parking space
     */
    public double getPrice(){
        return campSpot.getPrice() + 20;
    }


}
