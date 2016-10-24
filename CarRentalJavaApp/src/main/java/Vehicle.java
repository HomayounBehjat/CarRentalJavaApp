import java.util.ArrayList;
import java.util.List;

/**
 * Created by Homayoun on 18/10/2016.
 *
 * Vehicle.java.
 *
 * The superclass of all Vehicls.
 */
public abstract class Vehicle {

    public boolean hasAirConditioning() {
        return hasAirConditioning;
    }

    public void setHasAirConditioning(boolean hasAirConditioning) {
        this.hasAirConditioning = hasAirConditioning;
    }

    public Vehicle(int maxNumOfPassengersAllowed, int numberOfSeats, boolean isDiezel, boolean hasAirConditioning) {
        this.numberOfSeats = numberOfSeats;
        this.isDiezel = isDiezel;
        this.hasAirConditioning = hasAirConditioning;
        this.maxNumOfPassengersAllowed = maxNumOfPassengersAllowed;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getMaxNumOfPassengersAllowed() {
        return maxNumOfPassengersAllowed;
    }

    public void setTotalNumOfPassengersAllowed(int maxNumOfPassengersAllowed) {
        this.maxNumOfPassengersAllowed = maxNumOfPassengersAllowed;
    }

    public boolean isDiezel() {
        return isDiezel;
    }

    public void setDiezel(boolean diezel) {
        isDiezel = diezel;
    }

    public boolean isBus() {
        return this instanceof Bus;
    }

    /*
     *   May be more than the number of seats but up to this many passengers are allowed
     *   E.g. In a Bus 40 might be seated and 15 can stand but no more.
     *   In a car there are 5 seats but 6 can sit and no more.
     */
    private int maxNumOfPassengersAllowed;
    /*
    *  This is the number of passengers for which there would be no extra charges.
    *  Above this and up to the max allowed ther will be extra charges
    * */
    private int numberOfSeats;
    private boolean isDiezel;
    private boolean hasAirConditioning;
    private String registrationNumber;
    private Model model;
    private List<Customer> hiringCustomers = new ArrayList<>();
    private List<RentalInfo> rentalInfo = new ArrayList<>();
}
