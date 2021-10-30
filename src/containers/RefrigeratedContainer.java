
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;
/**
 * This is the class for the refrigerated containers which extends the HeavyContainer class
 * @author Taha Baturhan Akbulut
 *
 */
public class RefrigeratedContainer extends HeavyContainer{
	/**
	 * fuel consumption of the refrigerated container
	 */
	private final double fuelConsumption=5.0;
	/**
	 * <p>Constructor of the RefrigeratedContainer class
	 * @param ID ID of the container
	 * @param weight weight of the container
	 */
	public RefrigeratedContainer(int ID,int weight) {
		super(ID,weight);
		
	}
	/**
	 * <p>Method for calculating the consumption of the refrigerated container
	 * @return the consumption of the refrigerated container
	 */
	@Override
	public double consumption() {
		return fuelConsumption*weight;
	}
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

