import java.awt.EventQueue;
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
	private JTextField txtExpectedRevenue;
	private JTextField txtLengthIncQueue;
	private JTextField txtLengthOutQueue;
	
	
	
	
	
	// calculating the revenue
	public void calcRevenue()
	{
	
	int totalCars = 55;
	//int totalCars = 0;
	double ticketPrice = 7.50;
	double totalRevenue = totalCars * ticketPrice;
		
		txtRevenue.setText(" "+totalRevenue+"$");	
		txtExpectedRevenue.setText("Bedrag $$");
		txtLengthIncQueue.setText("Geen rij");
		txtLengthOutQueue.setText("Opstopping!");
		
	}
	
	// using the datum class to set the date of today in txtDate
	public void datum()
	{
		Calendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH)+ 1;
		int year = cal.get(Calendar.YEAR);
		
		txtDate.setText(" "+day+"-"+month+"-"+year);
	}
		
	/**
	 * Create the frame.
	 */
	public TextOverview() {
		
		this.setLayout(new GridLayout(0,5)); 
		setBounds(100, 100, 450, 339);
		
		
		
		JPanel datum = new JPanel();
		JLabel lblDate = new JLabel("Date");
		txtDate = new JTextField();
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		datum.add(lblDate);
		datum.add(txtDate);
		datum();
		this.add(datum);
		
		JLabel lblRevenue = new JLabel("Revenue");
		
		txtRevenue = new JTextField();
		txtRevenue.setEditable(false);
		txtRevenue.setColumns(10);
		
		JLabel lblExpectedRevenue = new JLabel("Expected Revenue");
		
		txtExpectedRevenue = new JTextField();
		txtExpectedRevenue.setEditable(false);
		txtExpectedRevenue.setColumns(10);
		
		JLabel lblLengthIncQueue = new JLabel("Length inc. queue");
		
		txtLengthIncQueue = new JTextField();
		txtLengthIncQueue.setEditable(false);
		txtLengthIncQueue.setColumns(10);
		
		JLabel lblLengthOutQueue = new JLabel("Length out. queue");
		
		txtLengthOutQueue = new JTextField();
		txtLengthOutQueue.setEditable(false);
		txtLengthOutQueue.setColumns(10);
		
		int totalRevenue = 20;
		txtRevenue.setText(" "+totalRevenue+"$");	
		txtExpectedRevenue.setText("Bedrag $$");
		txtLengthIncQueue.setText("Geen rij");
		txtLengthOutQueue.setText("Opstopping!");
		
		// using the datum class to set the date of today in txtDate
		datum();
		// using the calc function to calc the revenue
		calcRevenue();
		
	}
	public static void main(String[] argsu){
		JFrame test = new JFrame("test");
		test.add(new TextOverview());
		test.setSize(500, 500);
		test.setVisible(true);
		
	} 
	}