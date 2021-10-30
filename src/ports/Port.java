
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package ports;

import interfaces.IPort;
import java.util.ArrayList;
import ships.Ship;
import containers.Container;
import Sort.QuickSort;

/**
 * This is the class for the ports which implements IPort interface
 * @author Taha Baturhan Akbulut
 *
 */
public class Port implements IPort {
	/**
	 * ID of the port
	 */
	private final int ID;
	/**
	 * X coordinate of the location of the port
	 */
	private final double X;
	/**
	 * Y coordinate of the location of the port
	 */
	private final double Y;
	/**
	 * Static variable which holds the total number of all the ports
	 */
	public static int portCounter=0;
	/**
	 * ArrayList of the containers which are at the port
	 */
	public ArrayList<Container> containers= new ArrayList<Container>();
	/**
	 * Ship ArrayList which keeps track of every ship that has visited the port
	 */
	ArrayList<Ship> history=new ArrayList<Ship>();
	/**
	 * Ship ArrayList which contains the ships that is currently at the port 
	 */
	public ArrayList<Ship> current=new ArrayList<Ship>();
	/**
	 * <p>Constructor of the Port class
	 * @param ID ID of the port
	 * @param X coordinate of the location of the port
	 * @param Y coordinate of the location of the port
	 */
	public Port(int ID, double X, double Y) {
		this.ID=ID;
		this.X=X;
		this.Y=Y;
	}
	/**
	 * <p>Method for measuring the distance between <b>this</b>port and the other port
	 * @param other port where we measure the distance from
	 * @return <b>distance</b> between the two ports
	 */
	public double getDistance(Port other) {
		return Math.sqrt(Math.pow(this.X - other.X, 2) + Math.pow(this.Y-other.Y, 2)); //TODO
	}
	/**
	 * <p>Method for adding the ship to the port's current ship ArrayList
	 * @param s ship which is incoming to the port
	 */
	@Override
	public void incomingShip(Ship s) {
		current.add(s);
	}
	/**
	 * <p>Method for removing the ship from the port's current ship ArrayList and adding the ship to the ship history ArrayList
	 * @param s ship which is outgoing from the port
	 */
	@Override
	public void outgoingShip(Ship s) {
		current.remove(s);
		if(!history.contains(s)) {
			history.add(s);
		}
		
		
	}
	/**
	 * <p>Method for returning the sorted ArrayList of the current containers at the port
	 * @return <b>sorted ArrayList</b> sorted ArrayList of the current containers at the port
	 */
	public ArrayList<Container> getCurrentContainers(){
		return QuickSort.quickSort(containers, 0, containers.size()-1);
		
	}
	/**
	 * <p>Method for returning the sorted ArrayList of the current ships at the port
	 * @return <b>sorted ArrayList</b> sorted ArrayList of the current ships at the port
	 */
	public ArrayList<Ship> getShips(){
		return QuickSort.quickSorts(current, 0, current.size()-1);
	}
	/**
	 * <p>Getter method of the X coordinate of the port
	 * @return <b>X</b> X coordinate of the port
	 */
	public double getX() {
		return X;
	}
	/**
	 * <p>Getter method of the Y coordinate of the port
	 * @return <b>Y</b> Y coordinate of the port
	 */
	public double getY() {
		return Y;
	}
	/**
	 * <p>Getter method of the ID of the port
	 * @return <b>ID</b> ID of the port
	 */
	public int getID() {
		return ID;
	}
	
}
//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

