import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CarLegendView extends JPanel {

	public CarLegendView(){
		this.setLayout(new FlowLayout());
		this.setBackground(Color.LIGHT_GRAY);
		
		JPanel adHoc = new JPanel();
		adHoc.setLayout(new FlowLayout());
		adHoc.setBackground(Color.LIGHT_GRAY);
		JTextField adHocC = new JTextField("", 3);
		adHocC.setEditable(false);
		adHocC.setBackground(Color.RED);
		adHocC.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		adHoc.add(adHocC);
		JLabel adHocT = new JLabel("Ad hoc car");
		adHoc.add(adHocT);
		
		JPanel passH = new JPanel();
		passH.setLayout(new FlowLayout());
		passH.setBackground(Color.LIGHT_GRAY);
		JTextField passHC = new JTextField("", 3);
		passHC.setEditable(false);
		passHC.setBackground(Color.GREEN);
		passHC.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		passH.add(passHC);
		JLabel passHT = new JLabel("Passholder car");
		passH.add(passHT);
		
		this.add(adHoc);
		this.add(passH);
		this.setVisible(true);
	}
	
	
}
