package Hw4;

import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Flight {
    private String destination;
    private int flightNumber;
    private LocalTime departureTime;
    private List<String> daysOfWeek;

    public Flight(String destination, int flightNumber, LocalTime departureTime, String[] daysOfWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.daysOfWeek = Arrays.asList(daysOfWeek);
    }

    public String getDestination() {return destination;}
    public LocalTime getDepartureTime() {return departureTime;}
    public List<String> getDaysOfWeek() {return daysOfWeek;}

    @Override
    public String toString() {
    	return "Flight " + flightNumber + " to " + destination + ", departure time: " + departureTime + ", days of week: " + daysOfWeek;
    	}

    public static List<Flight> getFlightsByDestination(List<Flight> flights, String destination) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDestination().equalsIgnoreCase(destination)) {
                result.add(flight);
            }
        }
        result.sort((f1, f2) -> f1.getDepartureTime().compareTo(f2.getDepartureTime()));
        return result;
    }
    
    public static List<Flight> getFlightsByDay(List<Flight> flights, String day) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDaysOfWeek().contains(day)) {
                result.add(flight);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Paris", 1146, LocalTime.of(16, 30), new String[]{"Monday", "Wednesday", "Sunday"}));
        flights.add(new Flight("Los Angeles", 964, LocalTime.of(15, 15), new String[]{"Wednesday", "Thursday", "Saturday"}));
        flights.add(new Flight("Beijing", 554, LocalTime.of(8, 0), new String[]{"Tuesday", "Friday"}));
        flights.add(new Flight("Paris", 1522, LocalTime.of(12, 10), new String[]{"Monday", "Saturday"}));
        flights.add(new Flight("Berlin", 269, LocalTime.of(20, 45), new String[]{"Thursday", "Friday","Sunday"}));

        String searchDestination = "Paris";
        List<Flight> parisFlights = Flight.getFlightsByDestination(flights, searchDestination);
        System.out.println("Flights to " + searchDestination + ":");
        for (Flight flight : parisFlights) {
            System.out.println(flight);
        }

        String searchDay = "Thursday";
        List<Flight> thursdayFlights = Flight.getFlightsByDay(flights, searchDay);
        System.out.println("\nFlights on " + searchDay + ":");
        for (Flight flight : thursdayFlights) {
            System.out.println(flight);
        }
    }
}
