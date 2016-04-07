/**
 * Class for the cars inside the parkingarage
 * Contains the location of the car and for how long the will be staying
 * @author Robin van Eijk, Johan Zandstra, Dirk de Haan en Debbie Smith
 *
 */
public abstract class Car {

    private Location location;
    private int minutesLeft;
    private boolean isPaying;

    /**
     * Constructor for objects of class Car
     */
    public Car() {

    }
    
    /**
     * returns the location of the car
     * @return location
     */
    public Location getLocation() {
        return location;
    }
    
    /**
     * sets the location of the car to the specified location
     * @param location
     */
    public void setLocation(Location location) {
        this.location = location;
    }
    
    /**
     * Returns the amount of minutes the car has left to stay
     * @return minutesLeft
     */
    public int getMinutesLeft() {
        return minutesLeft;
    }

    /**
     * Sets the amount of minutes which te car wil stay
     * @param minutesLeft
     */
    public void setMinutesLeft(int minutesLeft) {
        this.minutesLeft = minutesLeft;
    }
    
    /**
     * Returns if a car is paying
     * @return isPaying
     */
    public boolean getIsPaying() {
        return isPaying;
    }

    /**
     * Sets if the car is paying
     * @param isPaying
     */
    public void setIsPaying(boolean isPaying) {
        this.isPaying = isPaying;
    }

    /**
     * subtracts one minute from the time the car is staying
     */
    public void tick() {
        minutesLeft--;
    }

}