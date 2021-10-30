
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
package ships;
import java.util.ArrayList;
import Sort.QuickSort;

import containers.*;
import interfaces.IShip;
import ports.Port;
/**
 * This is the class for the ships which implements IShip interface.
 * @author Taha Baturhan Akbulut
 *
 */
public class Ship implements IShip{
	/**
	 * ID of the ship
	 */
	private final int ID;
	/**
	 * Amount of the fuel of the ship
	 */
	private double fuel=0;
	/**
	 * The port where the Ship is currently in
	 */
	public Port currentPort; 
	/**
	 * Static variable which holds the total number of all the ships
	 */
	public static int shipCounter=0;
	/**
	 * Maximum weight of the ship
	 */
	int totalWeightCapacity; 
	/**
	 * Maximum number of containers which can be carried by the ship
	 */
	int maxNumberOfAllContainers; 
	/**
	 * Maximum number of heavy containers which can be carried by the ship
	 */
	int maxNumberOfHeavyContainers; 
	/**
	 * Maximum number of refrigerated containers which can be carried by the ship
	 */
	int	maxNumberOfRefrigeratedContainers; 
	/**
	 * Maximum number of liquid containers which can be carried by the ship
	 */
	int	maxNumberOfLiquidContainers; 
	/**
	 * The ship's consumption of the fuel per KM
	 */
	double fuelConsumptionPerKM;
	
	 
	
	/**
	 * ArrayList of all the containers that is being carried by the ship
	 */
	public ArrayList<Container> containers= new ArrayList<Container>();
	/**
	 * Current number of heavy containers
	 */
	int nofHeavy=0;
	/**
	 * Current number of refrigerated containers
	 */
	int nofRefri=0;
	/**
	 * Current number of liquid containers
	 */
	int nofLiquid=0;
	/**
	 * Current total weight of the ship
	 */
	int currentWeight=0;
	
	/**
	 * <p>Constructor of the Ship class
	 * @param ID ID of the ship
	 * @param p The port where the ship is currently in
	 * @param totalWeightCapacity Maximum weight of the ship
	 * @param maxNumberOfAllContainers Maximum number of containers which can be carried by the ship
	 * @param maxNumberOfHeavyContainers Maximum number of heavy containers which can be carried by the ship
	 * @param maxNumberOfRefrigeratedContainers Maximum number of refrigerated containers which can be carried by the ship
	 * @param maxNumberOfLiquidContainers Maximum number of liquid containers which can be carried by the ship
	 * @param fuelConsumptionPerKM The ship's consumption of the fuel per KM
	 */
	public Ship(int ID, Port p, int totalWeightCapacity, int
			maxNumberOfAllContainers, int maxNumberOfHeavyContainers, int
			maxNumberOfRefrigeratedContainers, int
			maxNumberOfLiquidContainers, double fuelConsumptionPerKM) {
		this.ID=ID;
		this.currentPort=p;
		this.currentPort.current.add(this);
		this.totalWeightCapacity=totalWeightCapacity;
		this.maxNumberOfAllContainers=maxNumberOfAllContainers;
		this.maxNumberOfHeavyContainers=maxNumberOfHeavyContainers;
		this.maxNumberOfRefrigeratedContainers=maxNumberOfRefrigeratedContainers;
		this.maxNumberOfLiquidContainers=maxNumberOfLiquidContainers;
		this.fuelConsumptionPerKM=fuelConsumptionPerKM;
		
		
	}
	
	/**
	 * <p>Method for returning the ArrayList containers in sorted state
	 * @return <b>sorted ArrayList</b> sorted ArrayList of the current containers in the ship
	 */
	public ArrayList<Container> getCurrentContainers(){
		return QuickSort.quickSort(containers, 0, containers.size()-1);
	}
	
	/**
	 * <p>Method for controlling the suitability of the ship whether it can sail to the another port or not
	 * @param p The port where the ship is going to sail if the return value is true
	 * @return <b>boolean</b> true if fuel is sufficient to sail, else false
	 */
	@Override
	public boolean sailTo(Port p) {
		double totalConsumption=0;
		double distance=currentPort.getDistance(p);
		for(Container i: containers) {
			totalConsumption+=i.consumption();
		}
		totalConsumption+=fuelConsumptionPerKM;
		double totalFuelConsumption=distance*totalConsumption;
		if(fuel>=totalFuelConsumption) {
			fuel-=totalFuelConsumption;
			currentPort.outgoingShip(this);
			currentPort=p;
			p.incomingShip(this);
			return true;
		}
		else {
			return false;
			
		}
		
	}
	/**
	 * <p>Method for fueling the ship by a certain amount
	 * @param newFuel amount of fuel that is going to be added to the fuel of the ship
	 */
	@Override
	public void reFuel(double newFuel) {
		fuel+=newFuel;
		
	}
	/**
	 * <p>Method for controlling whether the ship can load the new container or not and if it is successful changing the current number of containers and the current weight of the ship
	 * @param cont new container that is going to be loaded if the return value is true
	 * @return <b>boolean</b> true if all the conditions(does port contain the parameter container, weight limit, max number of containers checks) are satisfied, else false
	 */
	@Override
	public boolean load(Container cont) {
		if(currentPort.containers.contains(cont)) {
			if(cont.getWeight()+currentWeight<=totalWeightCapacity) {
				if(containers.size()+1<=maxNumberOfAllContainers) {
					if(cont instanceof RefrigeratedContainer) {
						if(nofRefri+1<=maxNumberOfRefrigeratedContainers) {
							if(nofHeavy+1<=maxNumberOfHeavyContainers) {
								nofRefri+=1;
								nofHeavy+=1;
								currentWeight+=cont.getWeight();
								containers.add(cont);
								currentPort.containers.remove(cont);
								return true;
							}
						}
					}
					else if(cont instanceof LiquidContainer) {
						if(nofLiquid+1<=maxNumberOfLiquidContainers) {
							if(nofHeavy+1<=maxNumberOfHeavyContainers) {
								nofLiquid+=1;
								nofHeavy+=1;
								currentWeight+=cont.getWeight();
								containers.add(cont);
								currentPort.containers.remove(cont);
								return true;
							}
						}
					}
					else if(cont instanceof HeavyContainer) {
						if(nofHeavy+1<=maxNumberOfHeavyContainers) {
							nofHeavy+=1;
							currentWeight+=cont.getWeight();
							containers.add(cont);
							currentPort.containers.remove(cont);
							return true;
						}
					}
					else if(cont instanceof BasicContainer) {
						currentWeight+=cont.getWeight();
						containers.add(cont);
						currentPort.containers.remove(cont);
						return true;
						
					}
					
				}
			}
		}
		return false;
	}
	/**
	 * <p>Method for controlling whether the ship can unload the new container or not and if it is successful, for changing the current number of the containers and the current weight of the ship.
	 * @param cont new container that is going to be unloaded if the return value is true
	 * @return <b>boolean</b> true if the ship contains the parameter container, else false
	 */
	@Override
	public boolean unLoad(Container cont) {
		if(containers.contains(cont)) {
			currentWeight-=cont.getWeight();
			if(cont instanceof RefrigeratedContainer) {
				nofRefri-=1;
				nofHeavy-=1;
			}
			else if(cont instanceof LiquidContainer) {
				nofLiquid-=1;
				nofHeavy-=1;
				
			}
			else if(cont instanceof HeavyContainer) {
				nofHeavy-=1;
				
			}
			containers.remove(cont);
			currentPort.containers.add(cont);
			return true;
		}
		return false;
	}
	/**
	 * <p>Getter method of the current fuel
	 * @return <b>fuel</b> value of the current fuel
	 */
	public double getFuel() {
		return fuel;
	}
	/**
	 * <p>Getter method of the ID
	 * @return <b>ID</b> ID of the ship
	 */
	public int getID() {
		return ID;
	}
	
}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

