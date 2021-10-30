
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE


package containers;
/**
 * This is the abstract parent class of the other container classes
 * @author Taha Baturhan Akbulut
 *
 */
public abstract class Container {
	/**
	 * Static variable which holds the total number of all the containers
	 */
	public static int containerCounter=0;
	/**
	 * ID of the container
	 */
	final int ID;
	/**
	 * weight of the container
	 */
	int weight;
	/**
	 * <p>Constructor of the Container class
	 * @param ID ID of the container
	 * @param weight weight of the container
	 */
	public Container(int ID,int weight) {
		this.ID=ID;
		this.weight=weight;
	}
	/**
	 * <p>abstract method which is going to be implemented in child classes to return the fuel consumption
	 * @return  fuel consumption of the container
	 */
	public abstract double consumption();
	/**
	 * <p> Method for comparing the two containers whether they are the same or not
	 * @param other parameter which is going to be compared with <b>this</b> container
	 * @return <b>boolean</b> true if they are the same objects, else false
	 */
	public boolean equals(Container other) {
		if (this.getClass() == other.getClass() && this.ID == other.ID && this.weight == other.weight) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * <p>Getter method of the ID
	 * @return ID of the container
	 */
	public int getID() {
		return ID;
	}
	/**
	 * <p>Getter method of the weight
	 * @return weight of the container
	 */
	public int getWeight() {
		return weight;
	}
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

