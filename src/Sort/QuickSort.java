package Sort;
import java.util.ArrayList;
import containers.Container;
import ships.Ship;
/**
 * QuickSort implementation for sorting the objects by their IDs.
 * @author Taha Baturhan Akbulut
 *
 */
public class QuickSort {
	/**
	 * Method for swapping two objects in the ArrayList
	 * @param arr ArrayList of containers which is going to be sorted.
	 * @param i one of the indexes which is going to be used to swap two objects in the ArrayList
	 * @param j one of the indexes which is going to be used to swap two objects in the ArrayList
	 */
	public static void swap(ArrayList<Container> arr, int i, int j)
	{
	    Container temp = arr.get(i);
	    arr.set(i, arr.get(j));
	    arr.set(j, temp);
	}
	/**
	 * This method takes last element as pivot, places
	   the pivot element at its correct position in sorted
	   array, and places all smaller (smaller than pivot)
	   to left of pivot and all greater elements to right
	   of pivot.
	 * @param arr ArrayList of containers which is going to be sorted.
	 * @param low Starting index
	 * @param high Ending index
	 * @return <b>(i+1)</b> the pivot value
	 */
	public static int partition(ArrayList<Container> arr, int low, int high)
	{

	    int pivot = arr.get(high).getID();
	    int i = (low - 1);
	 
	    for(int j = low; j <= high - 1; j++)
	    {

	        if (arr.get(j).getID() < pivot)
	        {

	            i++;
	            swap(arr, i, j);
	        }
	    }
	    swap(arr, i + 1, high);
	    return (i + 1);
	}
	/**
	 * The main method that implements QuickSort Algorithm
	 * @param arr ArrayList of the containers which is going to be sorted
	 * @param low Starting index
	 * @param high Ending index
	 * @return <b>arr</b> the sorted version of the ArrayList
	 */
	public static ArrayList<Container> quickSort(ArrayList<Container> arr, int low, int high)
	{
	    if (low < high)
	    {

	        int pi = partition(arr, low, high);

	        quickSort(arr, low, pi - 1);
	        quickSort(arr, pi + 1, high);
	    }
	    return arr;
	}
	/**
	 * Method for swapping two objects in the ArrayList
	 * @param arr ArrayList of ships which is going to be sorted.
	 * @param i one of the indexes which is going to be used to swap two objects in the ArrayList
	 * @param j one of the indexes which is going to be used to swap two objects in the ArrayList
	 */
	public static void swaps(ArrayList<Ship> arr, int i, int j)
	{
	    Ship temp = arr.get(i);
	    arr.set(i, arr.get(j));
	    arr.set(j, temp);
	}
	/**
	 * This method takes last element as pivot, places
	   the pivot element at its correct position in sorted
	   array, and places all smaller (smaller than pivot)
	   to left of pivot and all greater elements to right
	   of pivot.
	 * @param arr ArrayList of ships which is going to be sorted.
	 * @param low Starting index
	 * @param high Ending index
	 * @return <b>(i+1)</b> the pivot value
	 */
	public static int partitions(ArrayList<Ship> arr, int low, int high)
	{

	    int pivot = arr.get(high).getID();
	    int i = (low - 1);
	 
	    for(int j = low; j <= high - 1; j++)
	    {

	        if (arr.get(j).getID() < pivot)
	        {

	            i++;
	            swaps(arr, i, j);
	        }
	    }
	    swaps(arr, i + 1, high);
	    return (i + 1);
	}
	/**
	 * The main method that implements QuickSort Algorithm
	 * @param arr ArrayList of the ships which is going to be sorted
	 * @param low Starting index
	 * @param high Ending index
	 * @return <b>arr</b> the sorted version of the ArrayList
	 */
	public static ArrayList<Ship> quickSorts(ArrayList<Ship> arr, int low, int high)
	{
	    if (low < high)
	    {

	        int pi = partitions(arr, low, high);

	        quickSorts(arr, low, pi - 1);
	        quickSorts(arr, pi + 1, high);
	    }
	    return arr;
	}

	 
}

