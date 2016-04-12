import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class SimulatorView
 * This class creates the display for the view of the parking garage
 * 
 * @author Johan Zandstra, Dirk de Haan, Debbie Smith en Robin van Eijk
 */
public class SimulatorView extends AbstractView 
{ 
    private CarParkView carParkView;
    private int numberOfFloors;
    private int numberOfRows;
    private int numberOfPlaces;
    private Car[][][] cars;
    private QueueCounterView queueCounterView;
    private TypeOfCarView typeOfCarView;
    private TextOverview textOverview;
    private Sound sound;
    private WarningMessage warningMessage;
    private boolean test1 = true;
    private boolean test2 = true;
    
    
    
    
    
    /**
     * Creates an instance of SimulatorView
     * @param numberOfFloors
     * @param numberOfRows
     * @param numberOfPlaces
     * @param simulator
     */
    public SimulatorView(int numberOfFloors, int numberOfRows, int numberOfPlaces, Simulator simulator, QueueCounterView qCView,
    		TypeOfCarView tOCView, TextOverview tOView, CarLegendView cLView, Sound sound) {
    	this.numberOfFloors = numberOfFloors;
        this.numberOfRows = numberOfRows;
        this.numberOfPlaces = numberOfPlaces;
        cars = new Car[numberOfFloors][numberOfRows][numberOfPlaces];
        carParkView = new CarParkView();
        queueCounterView = qCView;
        typeOfCarView = tOCView;
        textOverview = tOView;
        this.sound = sound;
        this.warningMessage = warningMessage;
        
        
        //add a panel which contains the textviews 
        JPanel onderPaneel = new JPanel();
        onderPaneel.setBackground(Color.LIGHT_GRAY);
        onderPaneel.setLayout(new FlowLayout());
        onderPaneel.add(typeOfCarView);
        onderPaneel.add(queueCounterView);
        onderPaneel.add(textOverview);
       
        //Creates the contentpanel which contains al the views. 
        Container contentPane = getContentPane();
        contentPane.add(carParkView, BorderLayout.CENTER);
        contentPane.add(simulator, BorderLayout.WEST);
        contentPane.add(onderPaneel, BorderLayout.NORTH);
        contentPane.add(cLView, BorderLayout.SOUTH);
        
        pack();
        updateView();
        setVisible(true);
        
    }
   
   
    /**
     * Calls the updateview method inside carParkView
     */
    public void updateView() {
        carParkView.updateView();
        
        
    
    }
    
   	Thread t = new Thread();
   	public void run(){
   		errorMessage();
   	}
   	
   	
   	/**
   	 * plays a sound
   	 */
   	public void playMusic(){
     		sound.play("C:/Users/Robin/git/CarPark/src/mario1.wav");
   		}
   	
    /**
     * displays a errorMessage
     */
   	public void errorMessage(){
    	WarningMessage.infoBox("Er staan nu 50 adhoc autos geparkeerd", "Waarschuwing");
    }
    
    /**
     * calls the getAdHocAmount method in carParkView
     * @return amount
     */
    public int getAdHocAmount(){
    	int amount = carParkView.getAdHocAmount();
    	if (amount == 51 && test1 == true){
    		errorMessage();
    		test1 = false;
    	}
    	if (amount == 100 && test2 == true){
    		playMusic();
    		test2 = false;
    	}
    	return amount;
    }
    /**
     * calls the getPHAmount method in carParkView
     * @return amount 
     */
    public int getPHAmount(){
    	int amount = carParkView.getPHAmount();
    	return amount;
    }
    /**
     * calls the getResAmount method in carParkView
     * @return
     */
    public int getResAmount(){
    	int amount = carParkView.getResAmount();
    	return amount;
    }
    /**
     * calls the getResSpotAmount method in carParkView
     * @return
     */
    public int getResSpotAmount(){
    	int amount = carParkView.getResSpotAmount();
    	return amount;
    }
    
    public void setController(){
    	
    }
    
    /**
     * returns the number of floors in the parking garage
     * @return numberOfFloors
     */
     public int getNumberOfFloors() {
            return numberOfFloors;
        }
     
    /**
     * returns the number of rows at a floor
     * @return numberOfRows
     */
     	public int getNumberOfRows() {
            return numberOfRows;
        }
     	
    /**
     * Gets the number of places in a row
     * @return numberOfPlaces
     */
     	public int getNumberOfPlaces() {
            return numberOfPlaces;
        }
     	
     /**
      * Checks if there is a car at the given location
      * @param location
      * @return	cars
      */
     	public Car getCarAt(Location location) {
            if (!locationIsValid(location)) {
                return null;
            }
            return cars[location.getFloor()][location.getRow()][location.getPlace()];
        }
     	
     /**
      * Sets specified car at specified location if location is valid and empty
      * @param location
      * @param car
      * @return boolean
      */
    
        public boolean setCarAt(Location location, Car car) {
            if (!locationIsValid(location)) {
                return false;
            }
            Car oldCar = getCarAt(location);
            if (oldCar == null) {
                cars[location.getFloor()][location.getRow()][location.getPlace()] = car;
                car.setLocation(location);
                return true;
            }
            return false;
        }
    /**
     * Removes car from specified location
     * @param location
     * @return car
     */
        public Car removeCarAt(Location location) {
            if (!locationIsValid(location)) {
                return null;
            }
            Car car = getCarAt(location);
            if (car == null) {
                return null;
            }
            cars[location.getFloor()][location.getRow()][location.getPlace()] = null;
            car.setLocation(null);
            return car;
        }
        
    /**
     * Finds the nearest free location
     * @return location
     */
        public Location getFirstFreeLocation() {
            for (int floor = 0; floor < getNumberOfFloors(); floor++) {
                for (int row = 0; row < getNumberOfRows(); row++) {
                    for (int place = 0; place < getNumberOfPlaces(); place++) {
                        Location location = new Location(floor, row, place);
                        if (getCarAt(location) == null) {
                            return location;
                        }
                    }
                }
            }
            return null;
        }
       
    /**
     * finds the nearest leaving car
     * @return car
     */
        public Car getFirstLeavingCar() {
            for (int floor = 0; floor < getNumberOfFloors(); floor++) {
                for (int row = 0; row < getNumberOfRows(); row++) {
                    for (int place = 0; place < getNumberOfPlaces(); place++) {
                        Location location = new Location(floor, row, place);
                        Car car = getCarAt(location);
                        if (car != null && car.getMinutesLeft() <= 0 && !car.getIsPaying()) {
                            return car;
                        }
                    }
                }
            }
            return null;
        }
        
    /**
     * For each car call its tick() method
     */
        public void tick() {
            for (int floor = 0; floor < getNumberOfFloors(); floor++) {
                for (int row = 0; row < getNumberOfRows(); row++) {
                    for (int place = 0; place < getNumberOfPlaces(); place++) {
                        Location location = new Location(floor, row, place);
                        Car car = getCarAt(location);
                        if (car != null) {
                            car.tick();
                        }
                    }
                }
            }
        }
        
    /**
     * Check if specified location exists
     * @param location
     * @return boolean
     */
        private boolean locationIsValid(Location location) {
            int floor = location.getFloor();
            int row = location.getRow();
            int place = location.getPlace();
            if (floor < 0 || floor >= numberOfFloors || row < 0 || row > numberOfRows || place < 0 || place > numberOfPlaces) {
                return false;
            }
            return true;
        }

    
    /**
     * Creates the view of the Carpark
     * @author Robin
     *
     */
    private class CarParkView extends JPanel {
        
        private Dimension size;
        private Image carParkImage;
        private int adHocCar= 0;
        private int PHCar = 0;
        private int reservedCar = 0;
        private int reservedSpot = 0;
    
        /**
         * Constructor for objects of class CarPark
         */
        public CarParkView() {
            size = new Dimension(0, 0);
        }
    
        /**
         * Overridden. Tell the GUI manager how big we would like to be.
         */
        
        /**
         * returns the amount of adHocCars inside the Garage
         * @return adHocCar
         */
        public int getAdHocAmount(){
        	return adHocCar;
        }
        /**
         * returns the amount of PassholderCars inside the garage
         * @return PHCar
         */
        public int getPHAmount(){
        	return PHCar;
        }
        /**
         * returns the amount of reservationCars inside the garage
         * @return reservedCar
         */
        public int getResAmount(){
        	return reservedCar;
        }
        /**
         * returns the amount of reserved spots inside the garage
         * @return reservedSpot
         */
        public int getResSpotAmount(){
        	return reservedSpot;
        }
        
        public Dimension getPreferredSize() {
            return new Dimension(1000, 500);
        }
    
        /**
         * Overriden. The car park view component needs to be redisplayed. Copy the
         * internal image to screen.
         */
        public void paintComponent(Graphics g) {
            if (carParkImage == null) {
                return;
            }
    
            Dimension currentSize = getSize();
            if (size.equals(currentSize)) {
                g.drawImage(carParkImage, 0, 0, null);
            }
            else {
                // Rescale the previous image.
                g.drawImage(carParkImage, 0, 0, currentSize.width, currentSize.height, null);
            }
        }
    
        /**
         * Updates the view of the parking garage to the current state of the garage
         */
        public void updateView() {
        	adHocCar = 0;
        	PHCar = 0;
        	reservedCar = 0;
        	reservedSpot = 0;
            // Create a new car park image if the size has changed.
            if (!size.equals(getSize())) {
                size = getSize();
                carParkImage = createImage(size.width, size.height);
            }
            Graphics graphics = carParkImage.getGraphics();
            for(int floor = 0; floor < getNumberOfFloors(); floor++) {
                for(int row = 0; row < getNumberOfRows(); row++) {
                    for(int place = 0; place < getNumberOfPlaces(); place++) {
                        Location location = new Location(floor, row, place);
                        Car car = getCarAt(location);
                        //gives the parking spot a white color if there is no car parked.
                        if (car == null){
                        	Color color = Color.white;
                        	drawPlace(graphics, location, color);
                        }
                        //gives the parking spot a red color if there is a AdHocCar parked.
                        else if (car != null && car.getClass().equals(AdHocCar.class)){
                        	Color color2 = Color.red;
                        	drawPlace(graphics, location, color2);
                        	adHocCar++;
                        }
                        //gives the parking spot a green color if a PassholderCar is parked.
                        else if (car != null && car.getClass().equals(PassHolderCar.class)){
                        	Color color2 = Color.green;
                        	drawPlace(graphics, location, color2);
                        	PHCar++;
                        }
                        //gives the parking spot a blue color if a ReservationCar is. 
                        //or a yellow color if it has been reserved but the car has not yet arrived
                        else if (car != null && car.getClass().equals(ReservationCar.class)){
                        	if (car.getArrivalTime() == 0){
                        		Color color3 = Color.blue;
                        		drawPlace(graphics, location, color3);
                        		reservedCar++;
                        		}
                        	else if (car.getArrivalTime() != 0){
                        		Color color3 = Color.yellow;
                        		drawPlace(graphics, location, color3);
                        		reservedSpot++;
                        	}
                        
                        }
                    }
                }
            }
            repaint();
        }
    
        /**
         * Paint a place on this car park view in a given color.
         */
        private void drawPlace(Graphics graphics, Location location, Color color) {
            graphics.setColor(color);
            graphics.fillRect(
                    location.getFloor() * 260 + (1 + (int)Math.floor(location.getRow() * 0.5)) * 75 + (location.getRow() % 2) * 20,
                    60 + location.getPlace() * 10,
                    20 - 1,
                    10 - 1); // TODO use dynamic size or constants
        }
    }

  
}
