import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Creates a view of the type's of cars inside the parking garage
 * @author Robin van Eijk, Dirk de Haan
 *
 */
public class TypeOfCarView extends JPanel{
	private int adHocNum;
	private int passHolderNum;
	private LogicModel logicModel;
	private JTextField adHoc;
	private JTextField passHolder;
	
	
		   /**
		    * Constructor for the pie view
		    */
	public TypeOfCarView(LogicModel logicModel) {
		this.logicModel = logicModel;
		this.setLayout(new GridLayout(0,1));
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		JLabel adHocN = new JLabel("Number of adhoc cars inside garage: ");
		adHoc = new JTextField(" "+ adHocNum, 10);
		adHoc.setEditable(false);
		panel1.add(adHocN);
		panel1.add(adHoc);
		this.add(panel1);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		JLabel pHN = new JLabel("Number of passholder cars inside garage: ");
		passHolder = new JTextField("" + passHolderNum, 10 );
		passHolder.setEditable(false);
		panel2.add(pHN);
		panel2.add(passHolder);
		this.add(panel2);
		this.setVisible(true);
		
	}
			
	/**
	 * Updates the values of the amounts of types of cars inside the garage
	 */
	public void updateView(){
		adHocNum = logicModel.getAdHocAmount();
		adHoc.setText("" + adHocNum);
		passHolderNum = logicModel.getPHAmount();
		passHolder.setText("" + passHolderNum );
		
		
	}
}