package Ticket;

import org.json.simple.JSONObject;

/**
 * Created by Cassidy Tarng on 8/7/2018.
 */
public class TicketFactory {

    private Ticket ticket;

    /**
     * Creates a ticket based on the reservation information and type of ticket being made
     * Acts as the factory method
     */
    public Ticket makeTicket(JSONObject reservations, int index){
        switch (index){
            case 1:
                ticket = new BasicTicket(reservations);
                return ticket;
            case 2:
                ticket = new ETicket(reservations);
                return ticket;
            default:
                ticket = new BasicTicket(reservations);
                return ticket;
        }
    }
}
