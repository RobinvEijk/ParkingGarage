import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
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
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		JLabel entranceTextL = new JLabel("Number of cars in entrance queue: ");
		entranceText = new JTextField("" + entranceNum, 10);
		entranceText.setEditable(false);
		panel1.add(entranceTextL);
		panel1.add(entranceText);
		add(panel1);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		JLabel exitTextL = new JLabel("Number of cars in exit queue: ");
		exitText = new JTextField("" + exitNum, 10);
		exitText.setEditable(false);
		panel2.add(exitTextL);
		panel2.add(exitText);
		add(panel2);
		setVisible(true);
	}
	
	/**
	 * Finds the new amount of cars in a queue and updates this to the display
	 */
	public void updateView(){
		entranceNum = logicModel.entranceList.size();
		entranceText.setText("" + entranceNum);
		exitNum = logicModel.exitList.size();
		exitText.setText("" + exitNum);
		repaint();
		}
		
		
		
		
	}
		
