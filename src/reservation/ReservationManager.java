package reservation;

import Ticket.TicketFactory;
import UTIL.DAO;
import UTIL.GUIUtil;
import entity.Conf;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Cassidy Tarng on 5/4/2018.
 */
public class ReservationManager extends JFrame implements ActionListener{
    private JSONObject reservations;
    private JSONArray reservationArray;
    private JTable table;
    private DefaultTableModel tableModel;

    //private JButton editButton;
    private JButton deleteButton;
    private JButton viewTicketButton;
    private JRadioButton basicButton;
    private JRadioButton eButton;

    private TicketFactory ticketFactory;

    private String[] columns = {"pricePerDay", "reserveTime", "startTime", "endTime",
                                "label", "tentSpace", "parkingSpace", "handicap", "recommendedPeople"};
    private Object[][] data;
    private final DAO dao = DAO.getInstance();

    public ReservationManager(){
        reservations = dao.getReservations();

        reservationArray =  (JSONArray) reservations.get(Conf.account);
        if (reservationArray == null){
            data = new Object[0][9];
        }else{
            data = new Object[reservationArray.size()][9];
            for(int i = 0; i < reservationArray.size(); i++){
                JSONObject jsonObject = (JSONObject) reservationArray.get(i);
                JSONObject campObject = (JSONObject) jsonObject.get("campSpot");
                data[i][0] = jsonObject.get("pricePerDay");
                data[i][1] = jsonObject.get("reserveTime");
                data[i][2] = jsonObject.get("startTime");
                data[i][3] = jsonObject.get("endTime");
                data[i][4] = campObject.get("label");
                data[i][5] = campObject.get("tentSpace");
                data[i][6] = campObject.get("parkingSpace");
                data[i][7] = !(boolean) campObject.get("handicap") ? "No" : "Yes";
                data[i][8] = campObject.get("recommendedPeople");
            }
        }


        tableModel = new DefaultTableModel(data, columns);
        table = new JTable(tableModel);


        JScrollPane scrollPane = new JScrollPane(table);
        setLayout(new BorderLayout());


        add(scrollPane, BorderLayout.CENTER);

        //editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        viewTicketButton = new JButton("View Ticket");
        deleteButton.addActionListener(this);
        viewTicketButton.addActionListener(this);

        //Radio Button group
        basicButton = new JRadioButton("Printable Ticket");
        basicButton.setSelected(true);
        eButton = new JRadioButton("E-Ticket");
        ButtonGroup group = new ButtonGroup();
        group.add(basicButton);
        group.add(eButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        //buttonPanel.add(editButton, constraints);
        buttonPanel.add(deleteButton);
        buttonPanel.add(viewTicketButton);
        buttonPanel.add(basicButton);
        buttonPanel.add(eButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setTitle("Your Reservation");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 500);
        GUIUtil.toCenter(this);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteButton){
            delete();
        }
        if (e.getSource() == viewTicketButton){
            int row = table.getSelectedRow();
            if (row == -1){
                JOptionPane.showMessageDialog(this,"Please select one record!");
                return;
            }

            ticketFactory = new TicketFactory();

            int ticketVal = 1;
            if(basicButton.isSelected()) ticketVal = 1;
            else if(eButton.isSelected()) ticketVal = 2;
            ticketFactory.makeTicket((JSONObject) reservationArray.get(row), ticketVal);
        }
    }

    private void delete(){
        int row = table.getSelectedRow();
        if (row == -1){
            JOptionPane.showMessageDialog(this,"Please select one record!");
            return;
        }
        reservationArray.remove(row);

        reservations.put(Conf.account, reservationArray);

        dao.deleteReservations(reservations);

        tableModel.removeRow(row);
        tableModel.fireTableDataChanged();
    }
}
