
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import containers.*;
import ports.Port;
import ships.Ship;
/**
 * This is the main class that we use it to run our program.
 * @author Taha Baturhan Akbulut
 *
 */
public class Main {
	/**
	 * * Main method to control over all the program. In this method we are reading the input file, we are controlling the actions by the inputs and printing out the results into the output file.
	 * @param args args array which is used to call the input and output file
	 * @throws FileNotFoundException Exception is not thrown. Try,catch is used without exception.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		//
		// Main receives two arguments: path to input file and path to output file.
		// You can assume that they will always be provided, so no need to check them.
		// Scanner and PrintStream are already defined for you.
		// Use them to read input and write output.
		// 
		// Good Luck!
		//
		
		
		//making static fields equal to zero to prevent some problems
		Container.containerCounter=0;
		Ship.shipCounter=0;
		Port.portCounter=0;
		//initializing the input and the output objects to read the file and output it.
		Scanner in = new Scanner(new File(args[0]));
		PrintStream out = new PrintStream(args[1]);
		//N= number of lines after the first line
		int N=in.nextInt();
		in.nextLine();
		//ArrayLists for port,ship,container to store the related objects in them.
		ArrayList<Port> ports=new ArrayList<Port>();
		ArrayList<Ship> ships=new ArrayList<Ship>();
		ArrayList<Container> containers=new ArrayList<Container>();
		//READING THE FILE
		for(int i=0;i<N;i++) {
			String line[]=in.nextLine().split(" ");
			//Checking the first number of each line with if condition
			if(Integer.parseInt(line[0])==1) {
				//initializing container objects by checking which container type they belong to
				int portID=Integer.parseInt(line[1]);
				int weight=Integer.parseInt(line[2]);
				try {
					String type=line[3];
					if(type.equals("R")) {
						RefrigeratedContainer container= new RefrigeratedContainer(Container.containerCounter,weight);
						ports.get(portID).containers.add(container);
						containers.add(container);
					}
					else if(type.equals("L")) {
						LiquidContainer container= new LiquidContainer(Container.containerCounter,weight);
						ports.get(portID).containers.add(container);
						containers.add(container);
					}
				}
				catch(Exception e) {
					if(weight<=3000) {
						BasicContainer container= new BasicContainer(Container.containerCounter,weight);
						ports.get(portID).containers.add(container);
						containers.add(container);
					}
					else {
						HeavyContainer container= new HeavyContainer(Container.containerCounter,weight);
						ports.get(portID).containers.add(container);
						containers.add(container);
					}
					
				}
				Container.containerCounter+=1;
							
			}
			else if(Integer.parseInt(line[0])==2){
				//initializing ship object
				int shipPortID=Integer.parseInt(line[1]);
				int maxWeight=Integer.parseInt(line[2]);
				int maxNofContainers=Integer.parseInt(line[3]);
				int maxNofHeavyContainers=Integer.parseInt(line[4]);
				int maxNofRefrigeratedContainers=Integer.parseInt(line[5]);
				int maxNofLiquidContainers=Integer.parseInt(line[6]);
				double fuelConsumption = Double.parseDouble(line[7]);
				Ship ship= new Ship(Ship.shipCounter,ports.get(shipPortID),maxWeight,maxNofContainers,maxNofHeavyContainers,maxNofRefrigeratedContainers,maxNofLiquidContainers,fuelConsumption);
				ships.add(ship);
				//incrementing
				Ship.shipCounter+=1;
				
			}
			else if(Integer.parseInt(line[0])==3) {
				//initializing port object
				double X=Double.parseDouble(line[1]);
				double Y= Double.parseDouble(line[2]);
				Port p= new Port(Port.portCounter,X,Y);
				ports.add(p);
				//incrementing
				Port.portCounter+=1;
			}
			
			else if(Integer.parseInt(line[0])==4){
				//loading the container into the ship
				int shipID=Integer.parseInt(line[1]);
				Ship ship=ships.get(shipID);
				int containerID=Integer.parseInt(line[2]);
				ship.load(containers.get(containerID));
				
			}
			
			else if(Integer.parseInt(line[0])==5){
				//unloading the container from the ship
				int shipID=Integer.parseInt(line[1]);
				Ship ship=ships.get(shipID);
				int containerID=Integer.parseInt(line[2]);
				ship.unLoad(containers.get(containerID));
			}
			else if(Integer.parseInt(line[0])==6){
				//sailing the ship into the different port
				int destID=Integer.parseInt(line[2]);
				Port dest=ports.get(destID);
				int shipID=Integer.parseInt(line[1]);
				Ship ship=ships.get(shipID);
				ship.sailTo(dest);
					
				
			}
			else if(Integer.parseInt(line[0])==7){
				//refueling the tank of the ship
				int shipID=Integer.parseInt(line[1]);
				double fuel=Double.parseDouble(line[2]);
				ships.get(shipID).reFuel(fuel);
				
			}
		}
		
		for(Port i:ports) {
			out.println("Port "+i.getID()+": "+"("+String.format("%.2f", i.getX())+", "+String.format("%.2f", i.getY()) +")");
			boolean check1=true;
			for(Container j:i.getCurrentContainers()) {
				if(j.getClass() ==BasicContainer.class) {
					if(check1) {
						out.print("  BasicContainer:");
						check1=false;
					}
					out.print(" "+j.getID());
				}
			}
			if(!check1) {
				out.println();
			}
			check1=true;
			for(Container j:i.getCurrentContainers()) {
				if(j.getClass()== HeavyContainer.class) {
					if(check1) {
						out.print("  HeavyContainer:");
						check1=false;
					}
					out.print(" "+j.getID());
				}
				
			}
			if(!check1) {
				out.println();
			}
			check1=true;
			for(Container j:i.getCurrentContainers()) {
				if(j.getClass()== RefrigeratedContainer.class) {
					if(check1) {
						out.print("  RefrigeratedContainer:");
						check1=false;
					}
					out.print(" "+j.getID());
				}
			}
			if(!check1) {
				out.println();
			}
			
			check1=true;
			for(Container j:i.getCurrentContainers()) {
				if(j.getClass()== LiquidContainer.class) {
					if(check1) {
						out.print("  LiquidContainer:");
						check1=false;
					}
					out.print(" "+j.getID());
				}
			}
			if(!check1) {
				out.println();
			}
			for(Ship j:i.getShips()) {
				out.println("  Ship "+j.getID()+": "+String.format("%.2f",j.getFuel()));
				boolean check=true;
				for(Container k:j.getCurrentContainers()) {
					if(k.getClass()==BasicContainer.class) {
						if(check) {
							out.print("    BasicContainer:");
							check=false;
						}
						out.print(" "+ k.getID());
					}
				}
				if(!check) {
					out.println();
				}
				
				check=true;
				for(Container k:j.getCurrentContainers()) {
					if(k.getClass()== HeavyContainer.class) {
						if(check) {
							out.print("    HeavyContainer:");
							check=false;
						}
						out.print(" "+k.getID());
					}
					
				}
				if(!check) {
					out.println();
				}
				check=true;
				for(Container k:j.getCurrentContainers()) {
					if(k.getClass()== RefrigeratedContainer.class) {
						if(check) {
							out.print("    RefrigeratedContainer:");
							check=false;
						}
						out.print(" "+k.getID());
					}
				}
				if(!check) {
					out.println();
				}
				check=true;
				for(Container k:j.getCurrentContainers()) {
					if(k.getClass()==LiquidContainer.class) {
						if(check) {
							out.print("    LiquidContainer:");
							check=false;
						}
						out.print(" "+k.getID());
					}
				}
				if(!check) {
					out.println();
				}
				
			}
		}
		
		in.close();
		out.close();
	}
}






//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

