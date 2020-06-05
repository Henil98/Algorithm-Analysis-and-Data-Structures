/**
 * Implementation of Heap Sort
 * @author Henil Doshi
 *
 */

public class HeapSort 
{
	/*Now, we know that Heap is a complete Binary tree, and on initial given array heap sort cannot be applied so, this method is to move all 
	 the null nodes in between array to the last positions and store elements and in new array so that heap sort can be implemented. Here, 
	 array's 0th index stores the number of elements in the array, and actual elements are stored from index 1,2,3 and so on and null nodes
	 are in last .*/
	public int[] completeTreeArray(int a[])
	{
		int a1[] = new int[a.length+1];
		int countminus=0;
		int nodes=0;
		int j=1;
		for(int i=0; i<a.length; i++)
		{
			if(a[i]!=-1)
			{
				a1[j]=a[i];
				j++;
				nodes++;
			}
			else 
			{
				countminus++;
			}
		}
		for(int i=0; i<countminus; i++)
		{
			a1[j]=-1;
			j++;
		}
		a1[0]=nodes;
		return a1;
	}
	
	/*Method for heap sort (Ascending order)*/
	public void sortArray(int a[])
	{
		for(int i=a[0]/2; i>=1; i--)
		{
			maxHeapify(a,i,a[0]);
		}
		
		System.out.println("AFTER Heap is built (Max Heap) :");
		printArray(a);
		
		for(int i=a[0]; i>=1; i--)
		{
			int temp=a[1];
			a[1]=a[i];
			a[i]=temp;
			maxHeapify(a,1,i-1);
		}
		
	}
	
	/*Method to print Array*/
	public void printArray(int a[])
	{
		for(int i=0; i<a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println("\n");
	}
	
	/*Method to build heap and heapify*/
	public void maxHeapify(int a[], int i, int n)
	{
		int largestnum=i;
		int lch=2*i;
		int rch=2*i+1;
		
		if(lch<=n && a[lch]>a[largestnum])
		{
			largestnum=lch;
		}
		if(rch<=n && a[rch]>a[largestnum])
		{
			largestnum=rch;
		}
		if(largestnum!=i)
		{
			int temp=a[i];
			a[i]=a[largestnum];
			a[largestnum]=temp;
			maxHeapify(a,largestnum,n);
		}

	}
	
	/*Here -1 in the array represents null node.*/
	public static void main(String args[])
	{
		HeapSort hs = new HeapSort();
		int a[] = {5,3,15,14,16,-1,11,26,21,23,25,41,-1,31,35,48,37,50,-1,8,-1,-1,65,61,62,-1};
		System.out.println("Initial Array:");
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println("\n");
		System.out.println("-----After shifting null nodes to the last positions, the new array is------");
		System.out.println();
		int compTreeArray[] = hs.completeTreeArray(a); 
		System.out.println("Array BEFORE applying Heap sort (0th index in array stores total number of nodes containing positive numbers and from 1st index actual numbers are stored and so on) :");
		for(int i=0;i<compTreeArray.length;i++)
		{
			System.out.print(compTreeArray[i]+" ");
		}
		System.out.println("\n");
		hs.sortArray(compTreeArray);
		System.out.println("Array AFTER applying Heap sort (Sorted array) : ");
		hs.printArray(compTreeArray);
		
	}

}
