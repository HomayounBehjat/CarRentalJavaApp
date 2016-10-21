import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Homayoun on 18/10/2016.
 */
public class TripCalculatorTest {

    private static final double expectedTripCost1 = 18000;
    private static final double expectedTripCost2 = 16800;
    private static final double expectedTripCost3 = 19200;
    private static final double expectedTripCost4 = 20400;
    private static final double expectedTripCost5 = 44997.65;
    private static final double expectedTripCost6 = 51566.65;
    private static final double expectedTripCost7 = 74558.15;
    private static final double expectedTripCost8 = 48282.15;

    private TripCalculator tripCalculator;

    @Test
    public void testCalculateTripCarDiezelPassengerOverNoAC() throws Exception {
        List<Location> locationList = Arrays.asList(new Location("Mumbai","Pune",200),new Location("Pune","Bangalore",1000));
        Car car = new Car(6,5,true,false);
        assertThat(expectedTripCost1,is(tripCalculator.calculateTrip(car,locationList,6)));
    }

    @Test
    public void testCalculateTripCarDiezelMaxSeatNoAC() throws Exception {
        List<Location> locationList = Arrays.asList(new Location("Mumbai","Pune",200),new Location("Pune","Bangalore",1000));
        Car car = new Car(5,5,true,false);
        assertThat(expectedTripCost2,is(tripCalculator.calculateTrip(car,locationList,5)));
    }

    @Test
    public void testCalculateTripCarDiezelMaxSeatWithAC() throws Exception {
        List<Location> locationList = Arrays.asList(new Location("Mumbai","Pune",200),new Location("Pune","Bangalore",1000));
        Car car = new Car(6,5,true,true);
        assertThat(expectedTripCost3,is(tripCalculator.calculateTrip(car,locationList,5)));
    }

    @Test
    public void testCalculateTripCarPetrolMaxSeatNoAC() throws Exception {
        List<Location> locationList = Arrays.asList(new Location("Mumbai","Pune",200),new Location("Pune","Bangalore",1000));
        Car car = new Car(6,5,false,false);
        assertThat(expectedTripCost1,is(tripCalculator.calculateTrip(car,locationList,5)));
    }

    @Test
    public void testCalculateTripCarPetrolMaxSeatWithAC() throws Exception {
        List<Location> locationList = Arrays.asList(new Location("Mumbai","Pune",200),new Location("Pune","Bangalore",1000));
        Car car = new Car(6,5,false,true);
        assertThat(expectedTripCost4,is(tripCalculator.calculateTrip(car,locationList,5)));
    }

    @Test
    public void testCalculateTripBusDiezelNOAC() {
        List<Location> locationList = Arrays.asList(new Location("Mumbai","Delhi",2050),new Location("Mumbai","Chennai",1234.5));
        Bus bus = new Bus(55,40,true,false);
        assertThat(expectedTripCost5,is(tripCalculator.calculateTrip(bus,locationList,16)));
    }

    @Test
    public void testCalculateTripBusDiezelWithAC() {
        List<Location> locationList = Arrays.asList(new Location("Mumbai","Delhi",2050),new Location("Mumbai","Chennai",1234.5));
        Bus bus = new Bus(53,40,true,true);
        assertThat(expectedTripCost6,is(tripCalculator.calculateTrip(bus,locationList,22)));
    }

    @Test
    public void testCalculateTripBusStandardNOAC() {
        List<Location> locationList = Arrays.asList(new Location("Mumbai","Delhi",2050),new Location("Mumbai","Chennai",1234.5));
        Bus bus = new Bus(35,30,false,false);
        //Here
        assertThat(expectedTripCost8,is(tripCalculator.calculateTrip(bus,locationList,22)));
    }

    @Test
    public void testCalculateTripBusStandardWithAC() {
        List<Location> locationList = Arrays.asList(new Location("Mumbai","Delhi",2050),new Location("Mumbai","Chennai",1234.5));
        Bus bus = new Bus(40,30,false,true);
        assertThat(expectedTripCost7,is(tripCalculator.calculateTrip(bus,locationList,36)));
    }

    @After
    public void tearDown() throws Exception {
        tripCalculator = null;
    }

    @Before
    public void setUp() throws Exception {
        tripCalculator = TripCalculator.getInstance();
    }
}