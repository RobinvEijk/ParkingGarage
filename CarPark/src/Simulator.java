import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Simulator extends AbstractController
implements ActionListener
{
	private LogicModel logicModel;
	private ActionEvent event; 
	private JButton eenButton;
    private JButton honderdButton;
	

    public Simulator(){
    	logicModel = new LogicModel(this);
    	setLayout(new GridLayout(0, 1));
    	
    	eenButton = new JButton("1 step");
        eenButton.addActionListener((ActionListener) this);
        add(eenButton);
         
        honderdButton = new JButton("100 steps");
        honderdButton.addActionListener((ActionListener) this);
        add(honderdButton);
        
        setVisible(true);
        
        
        
    }
    

    public void setActionEvent(ActionEvent e) {
    	event = e;
    }

    //returns the actionEvent
    public ActionEvent getActionEvent() {
    	return event;
    }

    public void actionPerformed(ActionEvent e)
    {
    	// sets the received actionEvent, and creates a new thread.
    	setActionEvent(e);
    	Thread performerThread = new Thread(){
		
	
		
		public void run(){
			ActionEvent e = getActionEvent();
			String command = e.getActionCommand();
		
			if (command == "100 steps"){
				logicModel.runSteps(100);
			}
			if (command == "1 step"){
				logicModel.runSteps(1);
			}
			
		}
    	};
    	performerThread.start();
    }
    
    	
    public static void main(String[] args)
    {
    	new Simulator();
    	
    }
}
   
    
    
    
   

