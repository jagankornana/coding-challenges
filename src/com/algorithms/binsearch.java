package searching;

import java.util.Scanner;

public class binsearch {
	
	public static int binarySearch(int[] arr, int num)
	{
		int start=0;
		int end = arr.length-1;
		while(start<end)
		{
		int mid = (start+end)/2;
		if(arr[mid]==num)
		{
			return mid;
			
		}
		else if(arr[mid]>num)
		{
			end = mid-1;
			continue;
		}
		else
		{
			start=mid+1;
			continue;
		}
		}
		return -1;
	}
	

	public static void main(String[] args) {
		Scanner s= new Scanner (System.in);
		int n = s.nextInt();
		int arr[] = new int [n];
		for (int i = 0 ; i<arr.length ; ++i)
		{
			arr[i]= s.nextInt();
		}
		int x = s.nextInt();
		
		//System.out.println("hi");
		int a = binarySearch(arr,x);
		System.out.println(a);
//		for(int i=0; i<arr.length; ++i)
//		{
//			System.out.print(arr[i]);
//		}

	}

}
