package eksempler.src.main;


public interface FlightStatusObserver {
    void updateFlightStatus(String flightNumber, String status);
}