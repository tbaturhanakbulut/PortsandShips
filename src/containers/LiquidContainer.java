
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
package containers;
/**
 * This is the class for the liquid containers which extends the HeavyContainer class
 * @author Taha Baturhan Akbulut
 *
 */
public class LiquidContainer extends HeavyContainer {
	/**
	 * fuel consumption of the liquid container
	 */
	private final double fuelConsumption=4.0;
	/**
	 * <p>Constructor of the LiquidContainer class
	 * @param ID ID of the liquid container
	 * @param weight weight of the liquid container
	 */
	public LiquidContainer(int ID,int weight) {
		super(ID,weight);
		
	}
	/**
	 * <p>Method for calculating the consumption of the liquid container
	 * @return the consumption of the liquid container
	 */
	@Override
	public double consumption() {
		return fuelConsumption*weight;
	}
	
}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

