import java.util.ArrayList;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QDecoderStream;

public class Trip {

  private ArrayList<Flight> flights;

  /** @returns the number of minutes from the departure of the first flight 
  *   to the arrival of the last flight, 
  *   if there are one or more flights in the trip;
  *   0, if there are no flights in the trip
  */
  public int getDuration() {
   
   if (flights.size() < 0){
     return 0;
   } 
   int duration = flights.get(0).getDepartureTime().minutesUntil(flights.get(flights.size() - 1).getArrivalTime());
      
   
    
    return duration; //dummy return;
  }

  /** Precondition: the departure time for each flight is later than
  *   the arrival time of its preceding flight
  *   @return 
  *   if therethe smallest number of minutes between the arrival of a flight
  *   and the departure of the flight(i+1) immediately after it,  are two or more flight in the trip;
  *   -1, if there are fewer than two flights in the trip
  */
  public int getShortestLayover() {
    if (flights.size() >= 2){

      int smallest = Integer.MAX_VALUE;
      
      for (int i = 0; i < flights.size() - 1; i++) {
         int shortestLV = flights.get(i).getArrivalTime().minutesUntil(flights.get(i+1).getDepartureTime());
         
        if (shortestLV < smallest){
          smallest = shortestLV;
        }
      }

      return smallest;
    }
    else {
      return -1;
    }
  
  }
}
