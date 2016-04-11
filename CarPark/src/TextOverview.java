import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TextOverview extends JPanel {
	private JTextField txtDate;
	private JTextField txtRevenue;
	private JTextField txtExpRevenue;
	private LogicModel logicModel;
	double ticketPrice = 7.50;
	
	
	
	/**
	 * Create the frame.
	 */
	public TextOverview(LogicModel logicModel) {
		this.logicModel = logicModel;
		this.setLayout(new GridLayout(0,1)); 
		//setBounds(100, 100, 450, 339);
		
		
		
		JPanel datum = new JPanel();
		datum.setLayout(new FlowLayout());
		JLabel lblDate = new JLabel("Date");
		txtDate = new JTextField();
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		datum.add(lblDate);
		datum.add(txtDate);
		this.add(datum);
		
		JPanel revenue = new JPanel();
		revenue.setLayout(new FlowLayout());
		JLabel lblRevenue = new JLabel("Total revenue");
		txtRevenue = new JTextField();
		txtRevenue.setEditable(false);
		txtRevenue.setColumns(10);
		revenue.add(lblRevenue);
		revenue.add(txtRevenue);
		this.add(revenue);
		
		JPanel expectedRevenue = new JPanel();
		expectedRevenue.setLayout(new FlowLayout());
		JLabel expRevL = new JLabel("Expected Revenue");
		txtExpRevenue = new JTextField();
		txtExpRevenue.setEditable(false);
		txtExpRevenue.setColumns(10);
		expectedRevenue.add(expRevL);
		expectedRevenue.add(txtExpRevenue);
		this.add(expectedRevenue);
		
				
		
		// using the datum class to set the date of today in txtDate
		datum();
		// using the calc function to calc the revenue
		calcRevenue();
		//calc the expected revenue
		calcExpRevenue(0);
	}
	
	/**
	 * updates the values inside the textFields
	 */
	public void updateView(){
		calcRevenue();
		datum();
		calcExpRevenue();
	}	
	
	/**
	 * calculates the revenue
	 */
	public void calcRevenue()
	{
	
	int totalCars = logicModel.getPayedCars();	
	double totalRevenue = totalCars * ticketPrice;
			
		txtRevenue.setText(" "+totalRevenue+"$");	
		
	}
	/**
	 * Calculates the expected Revenue of cars which still have to pay.
	 */
	public void calcExpRevenue(){
		
	int totalCarsLeft =  logicModel.getAdHocAmount();
	
	double totalExpRevenue = totalCarsLeft * ticketPrice;
	
		txtExpRevenue.setText(" "+totalExpRevenue+"$");	
	}
	/**
	 * initial expected revenue method which starts with zero cars
	 * @param i
	 */
	public void calcExpRevenue(int i){
		
		int totalCarsLeft =  i;
		
		double totalExpRevenue = totalCarsLeft * ticketPrice;
		
			txtExpRevenue.setText(" "+totalExpRevenue+"$");
		
		}
		
	
	/**
	 *  using the datum class to set the date of today in txtDate
	 */
	public void datum()
	{
		Calendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH)+ 1;
		int year = cal.get(Calendar.YEAR);
		
		txtDate.setText(" "+day+"-"+month+"-"+year);
	} 
}