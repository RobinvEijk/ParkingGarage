import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;
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
		adHoc = new JTextField("Number of adhoc cars inside garage:" + adHocNum );
		adHoc.setEditable(false);
		this.add(adHoc);
		passHolder = new JTextField("Number of passholder cars inside garage:" + passHolderNum );
		passHolder.setEditable(false);
		this.add(passHolder);
		this.setVisible(true);
		
	}
			
	/**
	 * Updates the values of the amounts of types of cars inside the garage
	 */
	public void updateView(){
		adHocNum = logicModel.getAdHocAmount();
		adHoc.setText("Number of adhoc cars inside garage:" + adHocNum );
		passHolderNum = logicModel.getPHAmount();
		passHolder.setText("Number of passholder cars inside garage:" + passHolderNum );
		
		
	}
}