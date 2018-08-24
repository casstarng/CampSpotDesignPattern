package campspot;

import entity.CampSpot;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Cassidy Tarng on 8/21/2018.
 */
public class InfoPanelObserver implements Observer {

    JLabel label = new JLabel();
    JLabel parkingSpace = new JLabel();
    JLabel recommendedPeople = new JLabel();
    JLabel tentSpace = new JLabel();
    JLabel price = new JLabel();
    JLabel handicap = new JLabel();

    private Subject infoPanelSubject;

    public InfoPanelObserver(Subject infoPanelSubject){
        this.infoPanelSubject = infoPanelSubject;

        this.infoPanelSubject.attach(this);
    }

    /**
     * Updates the Side Info Panel based on the currentSpot
     */
    public void update(CampSpot currentSpot){
        // Set Camp Spot Info
        label.setText("Label: " + currentSpot.getLabel());
        parkingSpace.setText("Parking Spaces: " + currentSpot.getParkingSpace());
        recommendedPeople.setText("Recommended People: " + currentSpot.getRecommendedPeople());
        tentSpace.setText("Tent Spaces: " + currentSpot.getTentSpace());
        price.setText("Price: " + currentSpot.getPrice());
        handicap.setText("Handicap: " + currentSpot.isHandicap());
    }

    /**
     * Draws the sideInfoPanel
     */
    public JPanel drawCampSpotInfo(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(6, 1));
        label.setText("Label: ---");
        jPanel.add(label);
        parkingSpace.setText("Parking Spaces: ---");
        jPanel.add(parkingSpace);
        recommendedPeople.setText("Recommended People: ---");
        jPanel.add(recommendedPeople);
        tentSpace.setText("Tent Spaces: ---");
        jPanel.add(tentSpace);
        price.setText("Price: ---");
        jPanel.add(price);
        handicap.setText("Handicap: ---");
        jPanel.add(handicap);
        return jPanel;
    }
}
