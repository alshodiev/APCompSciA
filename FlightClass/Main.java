Fimport java.lang.reflect.*;
import java.util.ArrayList;

public class Main {
  
  public static void main(String[] args) {
    
    testGetDuration();
    System.out.println("Finished testing getDuration() successfully!");
     
    
    testShortestLayover();
    System.out.println("Finished testing shortestLayover() successfully!");
    System.out.println("All tests passed!");
    
  }
  
  public static void testGetDuration() {
    
    Field flightsField = null;
    try {
      flightsField = Trip.class.getDeclaredField("flights");
    }
    catch(Exception e) {
      System.out.println("Did you change the flights instance variable in the Trip class?!");
      System.exit(0);
    }
    flightsField.setAccessible(true);
    
    for(int numFlights = 0; numFlights < 10; numFlights++) {
      
      ArrayList<Flight> flights = new ArrayList<Flight>();
      Trip trip = new Trip();
      
      try {
        flightsField.set(trip, flights);
      }
      catch(Exception e) {
        System.out.println("Unable to initialize flights instance variable in the Trip class");
        System.exit(0);
      }
      
      int firstDepart = 0;
      int lastArrive = 0;
      
      int lastTime = 0;
      
      for(int i = 0; i < numFlights; i++) {
        
        int depart = (int)(Math.random()*60) + lastTime + 1;
        int arrive = (int)(Math.random()*60) + depart + 1;
        
        flights.add(new CustomFlight(depart, arrive));
        
        if(i == 0) firstDepart = depart;
        if(i == numFlights-1) lastArrive = arrive;
        
        lastTime = arrive;
      }
      
      int duration = lastArrive - firstDepart;
      int result = -1;
      
      try {
        result = trip.getDuration();
      }
      catch(Exception e) {
        System.out.println("Error calling getDuration() method of Trip class");
        System.exit(0);
      }
      
      if(duration != result) {
        System.out.println("Value returned by getDuration() is incorrect");
        System.exit(0);
      }
      
    }
    
  }
  
  public static void testShortestLayover() {
    
    Field flightsField = null;
    try {
      flightsField = Trip.class.getDeclaredField("flights");
    }
    catch(Exception e) {
      System.out.println("Did you change the flights instance variable in the Trip class?!");
      System.exit(0);
    }
    flightsField.setAccessible(true);
    
    for(int numFlights = 0; numFlights < 10; numFlights++) {
      
      ArrayList<Flight> flights = new ArrayList<Flight>();
      Trip trip = new Trip();
      
      try {
        flightsField.set(trip, flights);
      }
      catch(Exception e) {
        System.out.println("Unable to initialize flights instance variable in the Trip class");
        System.exit(0);
      }
      
      int shortest = -1;
      
      int lastArrive = -1;
      
      for(int i = 0; i < numFlights; i++) {
        
        int depart = (int)(Math.random()*60) + lastArrive + 1;
        int arrive = (int)(Math.random()*60) + depart + 1;
        
        flights.add(new CustomFlight(depart, arrive));
        
        if(i == 1) {
          shortest = depart - lastArrive;
        }
        else if(i > 1 && depart - lastArrive < shortest) {
          shortest = depart - lastArrive;
        }

        
        lastArrive = arrive;
      }
      
      int result = -1;
      
      try {
        result = trip.getShortestLayover();
      }
      catch(Exception e) {
        System.out.println("Error calling getShortestLayover() method of Trip class");
        System.exit(0);
      }
      
      if(shortest != result) {
        System.out.println("Value returned by getShortestLayover() is incorrect");
        System.exit(0);
      }
      
    }
    
  }
  
}

class CustomTime extends Time {
  
  private int minutes;
  
  public CustomTime(int m) {
    minutes = m;
  }
  
  public int minutesUntil(Time other) {
        return ((CustomTime)other).minutes - minutes;
  }
}

class CustomFlight extends Flight
{
    private Time depart;
    private Time arrive;
    
    public CustomFlight(int d, int a) {
      depart = new CustomTime(d);
      arrive = new CustomTime(a);
    }
  
    public Time getDepartureTime() {
        return depart;
    }
    
    public Time getArrivalTime() {
        return arrive;
    }
}
