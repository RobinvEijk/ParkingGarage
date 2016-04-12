/**
 * Class Which contains a car which has made a reservation
 * @author Robin van Eijk, Dirk de Haan, Debbie Smith en Johan Zandstra
 *
 */
public class ReservationCar extends Car{
	private int arrivalTime;
	/**
	 * Constructs an instance of ReservationCar, and sets the time that is left until the car arrives
	 */
	public ReservationCar(int time){
		arrivalTime = time;
		
	}
	/**
	 * returns the amount of time until the car arrives
	 * @return arrivalTime
	 */
	public int getArrivalTime(){
		return arrivalTime;
	}
	
	/**
	 * subtracts 1 minute per tick of the amount of time until arrival
	 */
	public void removeArrivalTime(){
		if (arrivalTime != 0){
			arrivalTime--;
			}
	}
}