package Ticket;

import org.json.simple.JSONObject;

/**
 * Created by Cassidy Tarng on 8/7/2018.
 */
public class TicketFactory {

    public Ticket makeTicket(JSONObject reservations, int index){
        switch (index){
            case 1:
                return new Ticket1(reservations);
            default:
                return new Ticket1(reservations);
        }
    }
}
