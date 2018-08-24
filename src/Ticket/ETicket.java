package Ticket;

import UTIL.GUIUtil;
import entity.Conf;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Cassidy Tarng on 8/14/2018.
 */
public class ETicket extends Ticket{

    private Icon QR=new ImageIcon("data/QR.png");
    private JLabel QRCode=new JLabel(QR);

    public ETicket(JSONObject reservation){
        JSONObject campSpot = (JSONObject) reservation.get("campSpot");
        userName.setText("Username: " + Conf.account);
        tentSpace.setText("Tent Spaces: " + campSpot.get("tentSpace"));
        handicap.setText("Handicap Accessible: " + campSpot.get("handicap"));
        label.setText("Label: " + campSpot.get("label"));
        parkingSpace.setText("Parking Spaces Available: " + campSpot.get("parkingSpace"));
        recommendedPeople.setText("Recommended People: " + campSpot.get("recommendedPeople"));
        reserveTime.setText("Reserved at: " + reservation.get("reserveTime"));
        startTime.setText("Start: " + reservation.get("startTime"));
        endTime.setText("End: " + reservation.get("endTime"));
        pricePerDay.setText("Price Per Day: " + reservation.get("pricePerDay"));
        drawScreen();
    }

    /**
     * Draws the ETicket
     */
    public void drawScreen(){

        frame.setLayout(new GridLayout(0, 2));
        frame.setTitle("E-Ticket");
        frame.setSize(600, 500);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(4, 0));

        infoPanel.add(userName);
        infoPanel.add(startTime);
        infoPanel.add(endTime);
        infoPanel.add(pricePerDay);

        frame.add(infoPanel);
        frame.add(QRCode);

        GUIUtil.toCenter(frame);

    }
}
