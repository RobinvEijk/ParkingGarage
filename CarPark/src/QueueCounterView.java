import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * Adds a view which counts and displays the amount of cars in the entrance and exit queue.
 * @author Robin van Eijk, Dirk de Haan, Johan Zandstra and Debbie Smith
 *
 */
public class QueueCounterView extends JPanel{
	private LogicModel logicModel;
	private JTextField entranceText;
	private JTextField exitText;
	private int entranceNum;
	private int exitNum;
	
	/**
	 * Constructs a queueCounterView and sets the initial values of cars in the queues 
	 * @param logicModel
	 */
	public QueueCounterView(LogicModel logicModel){
		this.logicModel = logicModel;
		entranceNum = 0;
		exitNum = 0;
		
		this.setLayout(new GridLayout(0, 1));
		entranceText = new JTextField("Number of cars in entrance queue: 0");
		entranceText.setEditable(false);
		add(entranceText);
		exitText = new JTextField("Number of cars in exit queue: 0");
		exitText.setEditable(false);
		add(exitText);
		repaint();
		setVisible(true);
	}
	
	/**
	 * Finds the new amount of cars in a queue and updates this to the display
	 */
	public void updateView(){
		entranceNum = logicModel.entranceList.size();
		entranceText.setText("Number of cars in entrance queue: " + entranceNum);
		exitNum = logicModel.exitList.size();
		exitText.setText("Number of cars in exit queue: " + exitNum);
		repaint();
		}
		
		
		
		
	}
		
