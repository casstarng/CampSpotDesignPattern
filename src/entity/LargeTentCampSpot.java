package entity;

/**
 * Created by Cassidy Tarng on 8/21/2018.
 */
public class LargeTentCampSpot extends CampSpotDecorator{

    public LargeTentCampSpot(CampSpot campSpot){
        super(campSpot);
    }

    /**
     * @return Price of CampSpot + 30 for a Large tent space
     */
    public double getPrice(){
        return campSpot.getPrice() + 30;
    }

}
