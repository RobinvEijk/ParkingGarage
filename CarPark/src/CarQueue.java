import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

/**
 * Class for the queue's of cars
 * @author Johan Zandstra, Robin van Eijk, Dirk de Haan en Debbie Smith
 *
 */
public class CarQueue {
    private Queue<Car> queue = new LinkedList<>();
    private int queueSize = 0;

    /**
     * Ads a car to the queue and returns if the car has been added
     * @param car
     * @return boolean
     */
    public boolean addCar(Car car) {
        return queue.add(car);
    }

    /**
     * removes a car from the queue
     * @return car
     */
    public Car removeCar() {
        return queue.poll();
    }
    
    public int getQueueSize(){
    	if (queue.poll() == null){
    		System.out.println("there is no car in line");
    	}
    	for (Car car : queue){
    		queueSize++;
    	}
    	System.out.println(queueSize);
    	return queueSize;
    }

}