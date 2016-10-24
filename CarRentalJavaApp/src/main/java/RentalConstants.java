/**
 * Created by Homayoun on 24/10/2016.
 *
 * RentalConstants.java.
 *
 * Containes constants for the application.
 */
public interface RentalConstants {

    /* Ideally all the rate constants should come from the
     * database.
     * They are defined here for simplicity of the exercise.
     */
    double PETROL_TRIP_RATE_PER_KILOMETER = 15.0;
    double DIEZEL_TRIP_RATE_PER_KILOMETER = PETROL_TRIP_RATE_PER_KILOMETER - 1;
    double AC_TRIP_RATE_SURCHARGE_PER_KILOMETER = 2.0;
}
