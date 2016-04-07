import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Class for the controller of the Simulator. 
 * Contains the buttons for the simulator with its ActionListener and ActionEvent
 * @author Dirk de Haan, Robin van Eijk, Johan Zandstra en Debbie Smith
 *
 */
public class Simulator extends AbstractController
implements ActionListener
{
	private LogicModel logicModel;
	private ActionEvent event; 
	private JButton eenButton;
    private JButton honderdButton;
	
    /**
     * Constructs an instance of the Simulator Controller
     * and add the buttons "1 step" an "100 steps" 
     */
    public Simulator(){
    	logicModel = new LogicModel(this);
    	setLayout(new GridLayout(0, 1));
    	
    	eenButton = new JButton("One step");
        eenButton.addActionListener((ActionListener) this);
        add(eenButton);
         
        honderdButton = new JButton("Hundred steps");
        honderdButton.addActionListener((ActionListener) this);
        add(honderdButton);
        
        setVisible(true);
    }
    

    /**
     * Sets the from the ActionListener recieved ActionEvent to the field event
     * @param e
     */
    public void setActionEvent(ActionEvent e) {
    	event = e;
    }

    /**
     * returns the set event
     * @return event
     */
    public ActionEvent getActionEvent() {
    	return event;
    }

    /**
     * Executes the the input action
     */
    public void actionPerformed(ActionEvent e)
    {
    	// sets the received actionEvent, and creates a new thread.
    	setActionEvent(e);
    	Thread performerThread = new Thread(){
		
	
		
		public void run(){
			ActionEvent e = getActionEvent();
			String command = e.getActionCommand();
		
			if (command == "Hundred steps"){
				logicModel.runSteps(100);
			}
			if (command == "One step"){
				logicModel.runSteps(1);
			}
			
		}
    	};
    	performerThread.start();
}
    
    
    
    
    
    
    
    /**
     * Starts the simulation/ Main
     */
    public static void main(String[] args)
    {
    	new Simulator();
    	
    }
}
   
    
    
    
   

