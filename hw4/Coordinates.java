// good to go
/**
 * Coordinates class with multiple functions
 *
 * @author xzhou309
 * @version 1.0
 */
public class Coordinates {

    private final double latitude;
    private final double longitude;

    /**
    *
    * takes in two doubles that should be assigned to
    * latitude and longitude respectively.
    * @param latitude represents coordinates
    * @param longitude represents coordiantes
    */
    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }


    /**
     * This returns a boolean representing whether another object is logically
     * equivalent to this instance of Coordinates.
     * @param other the object to compare to
     * @return boolean whether two instances are equal or not
     */
    public boolean equals(Object other) {
        return (this.latitude == ((Coordinates) other).latitude)
                && (this.longitude == ((Coordinates) other).longitude);
    }

    /**
     * This returns the String representation of this Coordinate object’s stored
     * information in the following format:
     * "latitude: (latitude), longitude: (longitude)"
     * @return String representation of Coordinates
     */
    public String toString() {
        //"latitude: 12.34, longitude: 56.78"
        return "latitude: " + String.format("%.2f", getLatitude())
                + ", longitude: " + String.format("%.2f", getLongitude());
    }

    /**
     * getter method for the latitude field
     * @return the current value of latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * getter method for the totalSales field
     * @return the current value of longitude
     */
    public double getLongitude() {
        return longitude;
    }

    // public static void main(String[] args) {
    //     Coordinates a = new Coordinates(3.3, 3.4);
    //     Coordinates b = new Coordinates(3.3, 3.4);
    //     System.out.print(b.equals(a));
    // }


}