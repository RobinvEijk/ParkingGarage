import javax.swing.*;

public abstract class AbstractView extends JPanel {
	protected Simulator simulator;

	/**
	* constructor for the class Abstractview
	*/
	public AbstractView(Simulator sim) {
		this.simulator=sim;
		simulator.addView(this);
	}
	
	/**
	 * return the Model
	 * @return Simulator
	 */
	public Simulator getModel() {
		return simulator;
	}
	
	/**
	 * Repaits the view
	 */
	public void updateView() {
		repaint();
	}
}