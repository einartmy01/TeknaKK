package part8;

import java.util.HashMap;
import java.util.Map;

public class FlightStatusObserverImpl implements FlightStatusObserver {
    private Map<String, String> flightStatuses;

    public FlightStatusObserverImpl() {
        flightStatuses = new HashMap<>();
    }

    /**
     * Update the flight status for the passenger.
     *
     * @param flightStatus The flight status object.
     */
    @Override
    public void updateFlightStatus(String flightNumber, String status) {
        flightStatuses.put(flightNumber, status);
        System.out.println("Flight " + flightNumber + " status updated to: " + status);
        sendNotification(flightNumber, status);
    }

    /**
     * Sends a notification to the passenger regarding the updated flight status.
     *
     * @param flightNumber The flight number.
     * @param status       The updated flight status.
     */
    private void sendNotification(String flightNumber, String status) {
        // THERE IS NO BUG IN THIS METHOD
        System.out.println("Notification: Flight " + flightNumber + " is now " + status);
    }

    /**
     * Get the flight status for a specific flight number.
     *
     * @param flightNumber The flight number.
     * @return The flight status.
     */
    public String getFlightStatus(String flightNumber) {
        return flightStatuses.get(flightNumber);
    }
}