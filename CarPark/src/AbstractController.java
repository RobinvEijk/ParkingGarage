import javax.swing.*;


public abstract class AbstractController extends JPanel {
	protected Simulator simulator;
	
	public AbstractController(Simulator sim) {
		this.simulator=sim;
	}
}