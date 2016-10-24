import java.util.List;

/**
 * Created by Homayoun on 18/10/2016.
 *
 * Please note that I envisage plenty more APIs on this class.
 * I have only concretely defined one method.
 */
public interface TripCalculation {

   double calculateTripCost(Vehicle aVehicle,List<Location> stops, int numOfPassengetrs);

   /**
    * @param aVehicle - The Vehicle being rented.
    * @param stops - The Locations a Vehicle will visit.
    * @param numOfPassengetrs - The number of passengers taking the journey.
    * @param discountRules - One or more rules describing the applicable discounts.
    *
    * @return the cost of the trip(s)
    */
   double calculateTripCostBasedOnDiscountRules(Vehicle aVehicle,List<Location> stops, int numOfPassengetrs, List<DiscountRule> discountRules);
}
