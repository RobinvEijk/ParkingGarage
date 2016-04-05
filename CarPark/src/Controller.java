import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Controller extends AbstractController implements ActionListener {
	private JButton oneStep;
	private JButton hundredSteps;
	private ActionEvent event;
    
	public Controller(Simulator simulator) {
		super(simulator);
		setSize(450, 50);
		oneStep=new JButton("One step");
		oneStep.addActionListener(this);
		hundredSteps=new JButton("Hundred Steps");
		hundredSteps.addActionListener(this);
		
		
		this.setLayout(new GridLayout(0, 1));
		add(oneStep);
		add(hundredSteps);
		
		setVisible(true);
	}
	
	//new run method
    //@param the amount of steps the simulator should perform
    public void runSteps(int getal) {
    	int i = getal;
    	while(i > 0){
    		simulator.tick();
    		i--; }
    	}
    //sets the ActionEvent
    //@param the recieved action event
    public void setActionEvent(ActionEvent e) {
    	event = e;
    }
    
    //returns the actionEvent
    public ActionEvent getActionEvent() {
    	return event;
    }
    
    
    //Performs the required action
    //@param the used ActionEvent
    //creates a new thread so the program keeps responding while executing the steps. 
    public void actionPerformed(ActionEvent e)
    {
    	// sets the received actionEvent, and creates a new thread.
    	setActionEvent(e);
    	Thread performerThread = new Thread(){
    		
    	
    		
    		public void run(){
    			ActionEvent e = getActionEvent();
    			String command = e.getActionCommand();
    		
    			if (command == "100 steps"){
    				runSteps(100);
    			}
    			if (command == "1 step"){
    				runSteps(1);
    			}
    			
    		}
    	};
    	performerThread.start();
    }
	
	
}