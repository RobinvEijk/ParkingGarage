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
		screen.setSize(540, 285);
		screen.setResizable(false);
		screen.setLayout(null);
		screen.getContentPane().add(simulatorView);
		screen.getContentPane().add(controller);
	    simulatorView.setBounds(10, 10, 200, 200);
		controller.setBounds(0, 210, 450, 50);
		screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		screen.setVisible(true);
		
	}
	
	 public static void main(String[] args)
     {
     	CarParkMain CarPark = new CarParkMain();
     	
     }
}
