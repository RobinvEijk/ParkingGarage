import java.awt.BorderLayout;

import javax.swing.*;

public class CarParkMain {
	private JFrame screen;
	private AbstractView simulatorView;
	private Simulator simulator;
	private AbstractController controller; 
	
	
	public CarParkMain () {
		simulator = new Simulator();
		simulatorView = new SimulatorView(3, 6, 30, simulator );
		controller = new Controller(simulator);				
		
		
		screen=new JFrame("Parking Garage Simulator");
		screen.setSize(900,600);
		screen.setResizable(false);
		screen.getContentPane().add(simulatorView, BorderLayout.CENTER);
		screen.getContentPane().add(controller, BorderLayout.WEST);
		screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		screen.setVisible(true);
		
	}
	
	 public static void main(String[] args)
     {
     	CarParkMain carPark = new CarParkMain();
     	
     }
}
