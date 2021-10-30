
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;
/**
 * This is the class for the basic containers which extends Container class
 * @author Taha Baturhan Akbulut
 *
 */
public class BasicContainer extends Container {
	/**
	 * fuel consumption of the basic container
	 */
	private final double fuelConsumption=2.5;
	/**
	 * <p>Constructor of the BasicContainer class
	 * @param ID ID of the basic container
	 * @param weight weight of the basic container
	 */
	public BasicContainer(int ID, int weight) {
		super(ID,weight);
	}
	/**
	 * <p>Method for calculating the consumption of the basic container
	 * @return the consumption of the basic container
	 */
	@Override
	public double consumption() {
		return fuelConsumption*weight;
	}
	
}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

