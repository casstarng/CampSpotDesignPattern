package Ticket;

import UTIL.GUIUtil;
import entity.Conf;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Cassidy Tarng on 8/7/2018.
 */
public class BasicTicket extends Ticket{

    public BasicTicket(JSONObject reservation){
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

    public void drawScreen(){

        frame.setLayout(new GridLayout(8, 2));
        frame.setTitle("Ticket");
        frame.setSize(400, 500);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.add(userName);
        frame.add(tentSpace);
        frame.add(handicap);
        frame.add(label);
        frame.add(parkingSpace);
        frame.add(recommendedPeople);
        frame.add(reserveTime);
        frame.add(startTime);
        frame.add(endTime);
        frame.add(pricePerDay);



        GUIUtil.toCenter(frame);

    }
}
