import java.util.List;

/**
 * Created by Homayoun on 18/10/2016.
 */
public interface TripCalculation {

   double calculateTrip(Vehicle aVehicle,List<Location> stops, int numOfPassengetrs);
}
