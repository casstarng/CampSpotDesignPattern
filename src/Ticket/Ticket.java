package Ticket;

import javax.swing.*;

/**
 * Created by Cassidy Tarng on 8/7/2018.
 *
 * Acts as the Abstract Product
 */
public abstract class Ticket {
    JFrame frame = new JFrame();
    JLabel userName = new JLabel();
    JLabel tentSpace = new JLabel();
    JLabel handicap = new JLabel();
    JLabel label = new JLabel();
    JLabel parkingSpace = new JLabel();
    JLabel recommendedPeople = new JLabel();
    JLabel reserveTime = new JLabel();
    JLabel startTime = new JLabel();
    JLabel endTime = new JLabel();
    JLabel pricePerDay = new JLabel();

    public void drawScreen(){}
}
