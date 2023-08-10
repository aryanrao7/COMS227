package mini2;
import java.util.Arrays;
/**
 * Utilities for working with arrays.
 * @author Aryan Rao
 */
public class ArrayAdventures {
// disable instantiation
private ArrayAdventures() { }
/**
 * Remove an element at index pos from the array. All elements to the right 
of
 * the given position are shifted down, and the last cell of the array is 
filled
 * with a zero. For example, if arr = [1, 10, 3, 5, 7], after invoking
 * remove(arr, 2), arr should be [1, 10, 5, 7, 0]. If pos is out of bounds, 
the
 * method does nothing.
 * 
 * @param arr the array from which to remove an element
 * @param pos the position at which the element should be removed
 */
public static void remove(int[] arr, int pos)
{
	if(pos>=arr.length)
	{
		
	}
	
	else
	{
		for(int i=pos;i<arr.length-1;i++)
		{
			arr[i]=arr[i+1];
			arr[i+1]=0;
		}
		
		arr[arr.length-1]=0;
	}
}
/**
 * Remove an element at index pos from the array. All elements to the left of
 * the given position are shifted up, and the first cell of the array is 
filled
 * with a zero. For example, if arr = [1, 10, 3, 5, 7], after invoking
 * removeAndShiftUp(arr, 2), arr should be [0, 1, 10, 5, 7]. If pos is out of
 * bounds, the method does nothing.
 * 
 * @param arr the array from which to remove an element
 * @param pos the position at which the element should be removed
 */
public static void removeAndShiftUp(int[] arr, int pos)
{
	if(pos>=arr.length)
	{
		
	}
	
	else
	{
		for(int i=pos;i>0;i--)
		{
			arr[i]=arr[i-1];
			arr[i-1]=0;
			
		}
		
		arr[0]=0;
	}
}
/**
 * Removes all odd numbers from the array. You must maintain the order of all
 * the remaining elements in the array and shift them down, and pad the array
 * with zeros. For example, if arr = [1, -10, 3, 7, 4], after invoking
 * removeOddElements(arr), arr should become [-10, 4, 0, 0, 0].
 * 
 * @param arr the array from which to remove the selected elements
 */
public static void removeOddElements(int[] arr) 
{
	for(int i=0;i<arr.length;i++)
	{
		for(int j=0;j<arr.length;j++)
		{
			if(arr[j] % 2!=0)
			{
				for(int k=j;k<arr.length-1;k++)
				{
					arr[k]=arr[k+1];
				}
				
				arr[arr.length-1]=0;
			}
			
		}
	}
}

/**
 * Finds the runs in the given array and returns a boolean array of the same
 * length indicating which elements are part of a run, where a run is defined
 * as a sequence of three or more adjacent repeated values. For example, if 
arr
 * = [6, 2, 5, 5, 5, 5, 4, 4, 5, 2, 2, 2, 1], then arr contains two runs, 5 5
5
 * 5 and 2 2 2, and the method would return a boolean array [false, false, 
true,
 * true, true, true, false, false, false, true, true, true, false].
 * 
 * @param arr the array in which to find the runs
 * @return a boolean array indicating the positions of the run(s)
 */
public static boolean[] findRuns(int[] arr)
{
  boolean[] coo = new boolean[arr.length];
  
  
  for(int i=0;i<arr.length-2;i++)
  {
	  if(arr[i]==arr[i+1] && arr[i+1] == arr[i+2])
	  {
		  coo[i] =true;
		  coo[i+1]= true;
		  coo[i+2]=true;
	  }
  }
  
  return coo;
}
/**
 * Removes all the runs in an array and then pads to the end of array with
 * zeros, where a run is defined as a sequence of three or more adjacent
 * repeated values. For example, if arr = [6, 2, 5, 5, 5, 5, 4, 4, 5, 2, 2, 
2,
 * 1], then arr contains two runs, 5 5 5 5 and 2 2 2, and after invoking
 * removeRuns(arr) the resulting array would be [6, 2, 4, 4, 5, 1, 0, 0, 0, 
0,
 * 0, 0, 0]
 * 
 * @param arr the array from which to remove the runs
 */
public static void removeRuns(int[] arr) 
{
	
	boolean[] a = findRuns(arr);
	int c=0;
	 int[] temp = new int[arr.length];
	 
	 Arrays.fill(temp,0);
	 
	 for(int i=0;i<arr.length;i++)
	 {
		 if(a[i]==false)
		 {
			 temp[c]=arr[i];
			 c++;
		 }
	 }
	 
	 for(int j=0;j<arr.length;j++)
	 {
		 arr[j]=temp[j];
	 }
	
	
	
}
/**
 * Returns a string representation of the given 2D array.
 * The format is demonstrated below. Each value is formated
 * with a minimum width of 7 characters, for example,
 * {@code String.format("%7d", value); }
 * <p> 
 * Example output:
 * <pre>
 * {      5,     56, 234235,   9867}
 * </pre>
 * 
 * @param arr the given array
 * @return a string representation of the given array
 */
public static String toString1D(int[] arr) 
{
	String d;
	
	if(arr.length == 0)
	{
	d = "{}";
	}
	
	else
	{
	  d= "{" + String.format("%7d",arr[0]);
	  for(int i=1;i<arr.length;i++)
	  {
		  d+= "," + String.format("%7d",arr[i]);
	  }
	  
	  d+="}";
	}
	
	
return d;
}
/**
 * Extra Credit (5 Points)
 * <p> 
 * Returns a string representation of the given 2D array.
 * The format is demonstrated below.
 * <p>
 * Example output:
 * <pre>
 * {{      5,     56, 234235,   9867},
 *  {    262,  39485,    -10,     78},
 *  {     56,      1,   9837,   8712},
 *  {     87,    -25,      0,   9820}} 
 * </pre>
 * 
 * @param arr the given array
 * @return a string representation of the given array
 */
public static String toString2D(int[][] arr)
{
  String f;
  
  if(arr.length==0)
	  f="{}";
  
  else
  {
	  f="{";
	  
	  for(int i=0;i<arr.length;i++)
	  {
		  if(i>0)
			  f+=" ";
		  f+="{";
		  for(int j=0;j<arr[i].length;j++)
		  {
			  f+= String.format("%7d", arr[i][j]);
			  if(j<arr[i].length-1)
			      f+=",";
			  
		  }
		  if(i==arr.length-1)
		  {
			  f+="}}";
		  }
		  else
		  { 
		  f+="},\n";
	      }
	  }
	  
  }
  
  return f;
}
/**
 * Extra Credit (5 Points)
 * <p> 
 * Exchanges the elements of one row with those in a different row in a given
2D
 * array. Each element remains in the same column. Assumes that all rows are 
the
 * same length and row indexes are in bounds.
 * 
 * @param arr  the array whose rows should be exchanged
 * @param row1 one of the rows to swap
 * @param row2 other row to swap
 */
public static void swapRows(int[][] arr, int row1, int row2) 
{
	int temp[] = arr[row1];
	arr[row1] = arr[row2];
	arr[row2] = temp;
}
     
/**
 * Extra Credit (5 Points)
 * <p> 
 * Returns true if the given array of indexes represent values
 * in an increasing order.
 * <p> 
 * The elements of the array <b>indexes</b> are indented to be
 * used as indexes into the array <b>values</b>.
 * <p>
 * For example, if values={44, 70, 28, 91, 10} and indexes={0, 1, 2}
 * then the selected values are {44, 70, 28}. These values
 * are not in increasing order so the method returns false.
 * <p>
 * On the other hand, if indexes={4, 2, 3} the selected values are
 * {10, 28, 91}. These values are in increasing order so the
 * method return true.
 * <p>
 * Assumes that all indexes are in bounds of the values array.
 * If indexes is empty the method returns true.
 * 
 * @param values an array of values
 * @param indexes an array of element that are to be 
 * @return a string representation of the given array
 */
public static boolean isIncreasing(int[] values, int[] indexes) 
{

	boolean bool = true;
	for(int i=0;i<indexes.length-1;i++)
	{
		if(values[indexes[i]]>values[indexes[i+1]])
		{
			bool=false;
		}
	}
	
	return bool;
}
}