
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;
/**
 * This is the class for the heavy containers which extends the Container class
 * @author Taha Baturhan Akbulut
 *
 */
public class HeavyContainer extends Container{
	/**
	 * fuel consumption of the heavy container
	 */
	private final double fuelConsumption=3.0;
	/**
	 * <p>Constructor of the HeavyContainer class
	 * @param ID ID of the heavy container
	 * @param weight weight of the heavy container
	 */
	public HeavyContainer(int ID,int weight) {
		super(ID,weight);

	}
	/**
	 * <p>Method for calculating the consumption of the heavy container
	 * @return the consumption of the heavy container
	 */
	@Override
	public double consumption() {
		return fuelConsumption*weight;
	}

	
}





//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

