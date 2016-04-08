import java.util.Random;

/**
 * Class for the logic which implements the movements of the cars inside the carPark
 * @author Debbie Smith, Robin van Eijk, Johan Zandstra en Dirk de Haan
 *
 */
public class LogicModel extends AbstractModel
{
	private CarQueue entranceCarQueue;
    private CarQueue paymentCarQueue;
    private CarQueue exitCarQueue;
    private SimulatorView simulatorView;
    private Simulator simulator;
    
	private int day = 0;
	private int hour = 0;
    private int minute = 0;
    
    private int tickPause = 200;
    
    int weekDayArrivals= 50; // average number of arriving cars per hour
    int weekendArrivals = 90; // average number of arriving cars per hour
    
    int enterSpeed = 3; // number of cars that can enter per minute
    int paymentSpeed = 10; // number of cars that can pay per minute
    int exitSpeed = 9; // number of cars that can leave per minute
    
    

	/**
	 * Constructs a new instance of the LogicModel
	 * Creates a new entranceCarQueue, paymentCarQueue and exitCarQueue
	 * @param simulator
	 */
	public LogicModel(Simulator simulator){
		entranceCarQueue = new CarQueue();
	    paymentCarQueue = new CarQueue();
	    exitCarQueue = new CarQueue();
	    simulatorView = new SimulatorView(3, 6, 30, simulator);
	}
	
	/**
	 * Runs the simulation for the given amount of steps
	 * @param getal
	 */
    public void runSteps(int getal) {
    	int i = getal;
    	while(i > 0){
    		tick();
    		i--; }
    	}
    
    
  
	/**
	 * Forwards the simulation by one step/minute
	 */
	public void tick() {
        // Advance the time by one minute.
        minute++;
        while (minute > 59) {
            minute -= 60;
            hour++;
        }
        while (hour > 23) {
            hour -= 24;
            day++;
        }
        while (day > 6) {
            day -= 7;
        }

        Random random = new Random();
        Random rand = new Random();

        int  whichCar = rand.nextInt(100) + 1;

        // Get the average number of cars that arrive per hour.
        int averageNumberOfCarsPerHour = day < 5
                ? weekDayArrivals
                : weekendArrivals;

        // Calculate the number of cars that arrive this minute.
        double standardDeviation = averageNumberOfCarsPerHour * 0.1;
        double numberOfCarsPerHour = averageNumberOfCarsPerHour + random.nextGaussian() * standardDeviation;
        int numberOfCarsPerMinute = (int)Math.round(numberOfCarsPerHour / 60);

        // Add the cars to the back of the queue.
        for (int i = 0; i < numberOfCarsPerMinute; i++) {
        	if (whichCar <= 85){
        		Car car = new AdHocCar();
        		entranceCarQueue.addCar(car);
        	}
        	else if (whichCar >= 85){
        		Car car = new PassHolderCar();
        		entranceCarQueue.addCar(car);
        	}
        
        }

        // Remove car from the front of the queue and assign to a parking space.
        for (int i = 0; i < enterSpeed; i++) {
            Car car = entranceCarQueue.removeCar();
            if (car == null) {
                break;
            }
            // Find a space for this car.
            Location freeLocation = simulatorView.getFirstFreeLocation();
            if (freeLocation != null) {
                simulatorView.setCarAt(freeLocation, car);
                int stayMinutes = (int) (15 + random.nextFloat() * 10 * 60);
                car.setMinutesLeft(stayMinutes);
            }
        }

        // Perform car park tick.
        simulatorView.tick();

        // Add leaving cars to the exit queue.
        while (true) {
            Car car = simulatorView.getFirstLeavingCar();
            if (car == null) {
                break;

            //payment for normal cars    
            }
            if (car.getClass().equals(AdHocCar.class)){
            car.setIsPaying(true);
            paymentCarQueue.addCar(car);
            }
            
            //New payment method for pass holders, they dont pay. they just drive out. 
            else if (car.getClass().equals(PassHolderCar.class)){
            car.setIsPaying(false);
            simulatorView.removeCarAt(car.getLocation());
            exitCarQueue.addCar(car);
            }
            
            
        }

        // Let cars pay.
        for (int i = 0; i < paymentSpeed; i++) {
            Car car = paymentCarQueue.removeCar();
            if (car == null) {
                break;
            }
            // TODO Handle payment.
            simulatorView.removeCarAt(car.getLocation());
            exitCarQueue.addCar(car);
        }

        // Let cars leave.
        for (int i = 0; i < exitSpeed; i++) {
            Car car = exitCarQueue.removeCar();
            if (car == null) {
                break;
            }
            // Bye!
        }

        // Update the car park view.
        simulatorView.updateView();

        // Pause.
        try {
            Thread.sleep(tickPause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	

}