package eksempler.src.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FlightStatus class to represent the status of a flight.
 */
public class FlightStatus {
    public static final String ON_TIME = "ON_TIME";
    public static final String DELAYED = "DELAYED";
    public static final String CANCELLED = "CANCELLED";
    public static final String DEPARTED = "DEPARTED";
    public static final String ARRIVED = "ARRIVED";

    public static final List<String> VALID_STATUSES = Arrays.asList(ON_TIME, DELAYED, CANCELLED, DEPARTED, ARRIVED);

    private final String flightNumber;
    private String status;

    //VIKTIG:
    private List<FlightStatusObserver> observers = new ArrayList<>();

    public FlightStatus(String flightNumber, String status) {
        if (VALID_STATUSES.contains(status)) {
            this.flightNumber = flightNumber;
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid flight status");
        }
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        notifyObservers(status);
        if (VALID_STATUSES.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid flight status");
        }
    }

    //VIKTIG
    public void addObserver(FlightStatusObserver observer) {
        observers.add(observer);
    }
    //VIKTIG
    public void removeObserver(FlightStatusObserver observer) {
        observers.remove(observer);
    }

    //VIKTIG
    private void notifyObservers(String status) {
        for (FlightStatusObserver observer : observers) {
            observer.updateFlightStatus(flightNumber, status);
        }
    }

    public static void main(String[] args) {
        String flightNumber = "SK101";
        FlightStatus flightStatus = new FlightStatus(flightNumber, "ON_TIME");

        FlightStatusObserverImpl observer = new FlightStatusObserverImpl();
        flightStatus.addObserver(observer);

        // Updating the flight status
        flightStatus.setStatus("DELAYED");
        System.out.println(observer.getFlightStatus(flightNumber));

        try {
            flightStatus.setStatus("IN FLIGHT");
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument exception for invalid flight status");
        }

        System.out.println(observer.getFlightStatus(flightNumber));

        flightStatus.removeObserver(observer);
        flightStatus.setStatus(DEPARTED);
        System.out.println(observer.getFlightStatus(flightNumber));

    }
}
