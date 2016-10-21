/**
 * Created by Homayoun on 18/10/2016.
 */
public class Location {

    private String locationName;
    private String locationFromName;
    private double locationFromDistanceKM;

    public Location(String locationName, String locationFromName, double locationKMFromDistanceKM) {
        this.locationName = locationName;
        this.locationFromName = locationFromName;
        this.locationFromDistanceKM = locationKMFromDistanceKM;
    }

    public double getLocationFromDistanceKM() {
        return locationFromDistanceKM;
    }

    public void setLocationFromDistanceKM(double locationFromDistanceKM) {
        this.locationFromDistanceKM = locationFromDistanceKM;
    }

    public String getLocationFromName() {
        return locationFromName;
    }

    public void setLocationFromName(String locationFromName) {
        this.locationFromName = locationFromName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
