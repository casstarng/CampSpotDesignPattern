package UTIL;

import entity.Conf;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DAO {

    private static final DAO instance = new DAO();
    private static final JSONParser parser = new JSONParser();

    public DAO(){ }

    public static DAO getInstance(){
        return instance;
    }

    public void deleteReservations(JSONObject reservations){
        try {
            FileWriter reservationFile = new FileWriter("data/reservation.json", false);
            reservationFile.write(reservations.toJSONString());
            reservationFile.flush();
            reservationFile.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public JSONObject getReservations(){
        try {
            Object o = parser.parse(new FileReader("data/reservation.json"));
            JSONObject reservations = (JSONObject) o;
            return reservations;
        }catch (Exception e){

        }
        return null;
    }

    // CampSpotManager l-456
    public JSONArray getCampSpotManager(){
        try{
            return (JSONArray) parser.parse(new FileReader("data/CampSpotManager.json"));
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    public void addReservation(JSONObject newReservation, Date startDate, Date endDate){
        try{
            Object obj = parser.parse(new FileReader("data/reservation.json"));
            Object campSpotParser = parser.parse(new FileReader("data/CampSpotManager.json"));
            JSONObject reservations = (JSONObject) obj;
            JSONArray campsArr = (JSONArray) campSpotParser;
            JSONArray array;
            // If account exists
            if (reservations.containsKey(Conf.account)){
                array = (JSONArray) reservations.get(Conf.account);
            }
            else{
                array = new JSONArray();
            }

            array.add(newReservation);
            DateFormat acceptedDateFormat = new SimpleDateFormat("MM/dd/yyyy");

            for (int i = 0; i<campsArr.size(); i++) {
                JSONObject currCamp = (JSONObject) campsArr.get(i);
                JSONObject newCamp = (JSONObject)  newReservation.get("campSpot");
                if(currCamp.get("label").equals(newCamp.get("label"))) {
                    JSONArray datesForReservation = (JSONArray) currCamp.get("reservations");
                    ArrayList<Date> datesReserved = getDatesBetween(startDate, endDate);
                    for (Date currDate: datesReserved)
                        datesForReservation.add(acceptedDateFormat.format(currDate));
                }
            }

            reservations.put(Conf.account, array);
            FileWriter reservationFile = new FileWriter("data/reservation.json", false);
            FileWriter campManagerFile = new FileWriter("data/CampSpotManager.json", false);
            reservationFile.write(reservations.toJSONString());
            reservationFile.flush();
            reservationFile.close();
            campManagerFile.write(campsArr.toJSONString());
            campManagerFile.flush();
            campManagerFile.close();
        }
        catch(Exception e){
            System.out.println(e);
        }


    }

    private static ArrayList<Date> getDatesBetween(Date startDate, Date endDate) {
        ArrayList<Date> datesInRange = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);

        while (calendar.before(endCalendar)) {
            Date result = calendar.getTime();
            datesInRange.add(result);
            calendar.add(Calendar.DATE, 1);
        }
        datesInRange.add(endDate);
        return datesInRange;
    }
}
