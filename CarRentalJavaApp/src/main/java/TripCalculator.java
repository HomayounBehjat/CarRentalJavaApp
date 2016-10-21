import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Homayoun on 18/10/2016.
 */
public class TripCalculator implements TripCalculation {

    private static final TripCalculator instance = new TripCalculator();

    //private constructor to avoid client applications to use constructor
    private TripCalculator(){}

    public static TripCalculator getInstance(){
        return instance;
    }

    @Override
    public double calculateTrip(Vehicle aVehicle, List<Location> locationStops, int numOfPassengetrs) {

        double total = 0.0;
        try {
            double tripRate = getTripRatePerKilometer(aVehicle, numOfPassengetrs);
            if (numOfPassengetrs > aVehicle.getMaxNumOfPassengersAllowed()) {
                throw new Exception("Requested number of passengers is more than allowed"); // Needs Application Exceptions here really
            }

            for (Location aLocation : locationStops) {
                total += aLocation.getLocationFromDistanceKM() * tripRate;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Some rounding errors occure and this takes care of it by rounding up
        return new BigDecimal(total).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * PLEASE NOTE: IT IS MY STRONG BELIEFE THAT THIS BEHAVIOUR SHOULD BE
     *              DEFINED AGAINST EACH TYPE OF VEHICLE IN THE OBJECT MODEL.
     *              THE OBJECT MODEL PRESENTED HERE IS NOT A POJO BUT A SERVER
     *              SIDE BUSINESS OBJECTS REFLECTING THE OBJECTS IN THE APPLICATION.
     *              THIS IS WHAT WAS REQUESTED. THIS IS SIMPLY A SMALLER PART OF A BIGGER
     *              APPLICATION.
     *              I WAS THEN TOLD THAT OTHER PEOPLE'S ATTEMPTS TO INCLUDE BUSINESS
     *              LOGIC IN THE VEHICLE CLASS WAS NOT APPRECIATED. I THEREFORE DID
     *              THE NEXT BEST THING AND INCLUDED THIS LOGIC HERE!
     *
     * @param aVehicle The Vehicle being used for the trip
     * @param numOfPassengers The number of passenger taking the trip
     * @return Total value for trip(s) after calculating.
     */
    private double getTripRatePerKilometer(Vehicle aVehicle, int numOfPassengers) {

        // First find out if it is Diezel Or Petrol
        double tripRate = aVehicle.isDiezel() ? DiezelVehicle.tripRatePerKilometer : PetrolVehicle.tripRatePerKilometer;

        // Also add a surcharge for Air Conditioning.
        tripRate += aVehicle.hasAirConditioning() ? 2.0 : 0;

        // It is assumed that 1Rs extra is charged per each extra passenger
        if (numOfPassengers > aVehicle.getNumberOfSeats()) {
            tripRate += numOfPassengers - aVehicle.getNumberOfSeats();
        }

        // Apply a discount of 2% of standard rate (which is 15) if the vehicle is a bus
        // Assumption made that the discount is based on the standard rate as specified
        // in requirement.
        tripRate -= aVehicle.isBus() ? 15.0 * 2.0 /100.0 : 0.0;

        return tripRate;
    }
}
