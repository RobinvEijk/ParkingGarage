import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
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
	private int reservationNum;
	private int resSpotNum;
	private LogicModel logicModel;
	private JTextField adHoc;
	private JTextField passHolder;
	private JTextField reservation;
	private JTextField reservationSpot;
	
	
		   /**
		    * Constructor for the pie view
		    */
	public TypeOfCarView(LogicModel logicModel) {
		this.logicModel = logicModel;
		this.setLayout(new GridLayout(0,1));
		
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.setBackground(Color.LIGHT_GRAY);
		JLabel adHocN = new JLabel("Number of adhoc cars inside garage: ");
		adHoc = new JTextField(" "+ adHocNum, 10);
		adHoc.setEditable(false);
		adHoc.setBackground(Color.LIGHT_GRAY);
		adHoc.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		panel1.add(adHocN);
		panel1.add(adHoc);
		this.add(panel1);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.setBackground(Color.LIGHT_GRAY);
		JLabel pHN = new JLabel("Number of passholder cars inside garage: ");
		passHolder = new JTextField("" + passHolderNum, 10 );
		passHolder.setEditable(false);
		passHolder.setBackground(Color.LIGHT_GRAY);
		passHolder.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		panel2.add(pHN);
		panel2.add(passHolder);
		this.add(panel2);
		
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.setBackground(Color.LIGHT_GRAY);
		JLabel resCN = new JLabel("Number of reservation cars inside garage: ");
		reservation = new JTextField(" "+ reservationNum, 10);
		reservation.setEditable(false);
		reservation.setBackground(Color.LIGHT_GRAY);
		reservation.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		panel3.add(resCN);
		panel3.add(reservation);
		this.add(panel3);
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		panel4.setBackground(Color.LIGHT_GRAY);
		JLabel resSN = new JLabel("Number of reserved spots inside garage: ");
		reservationSpot = new JTextField(" "+ resSpotNum, 10);
		reservationSpot.setEditable(false);
		reservationSpot.setBackground(Color.LIGHT_GRAY);
		reservationSpot.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		panel4.add(resSN);
		panel4.add(reservationSpot);
		this.add(panel4);
		
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
		reservationNum = logicModel.getResAmount();
		reservation.setText("" + reservationNum);
		resSpotNum = logicModel.getResSpotAmount();
		reservationSpot.setText(""+ resSpotNum);
		
		
	}
}