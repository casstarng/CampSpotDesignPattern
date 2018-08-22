package entity;

/**
 * Created by Cassidy Tarng on 8/21/2018.
 */
public class LargeTentCampSpot extends CampSpotDecorator{

    public LargeTentCampSpot(CampSpot campSpot){
        super(campSpot);
    }

    public double getPrice(){
        return campSpot.getPrice() + 30;
    }

}
