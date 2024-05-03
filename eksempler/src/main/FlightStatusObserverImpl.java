package eksempler.src.main;

import java.util.HashMap;
import java.util.Map;

public class FlightStatusObserverImpl implements FlightStatusObserver {
    private Map<String, String> flightStatuses; //Oversikt over <Flight, Status>

    public FlightStatusObserverImpl() {
        flightStatuses = new HashMap<>();
    }

    @Override
    public void updateFlightStatus(String flightNumber, String status) {
        flightStatuses.put(flightNumber, status);
        System.out.println("Flight " + flightNumber + " status updated to: " + status);
        sendNotification(flightNumber, status);
    }
 
    private void sendNotification(String flightNumber, String status) {
        System.out.println("Notification: Flight " + flightNumber + " is now " + status);
    }

    public String getFlightStatus(String flightNumber) {
        return flightStatuses.get(flightNumber);
    }
}