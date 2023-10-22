import java.util.*;
import java.io.*;

class evenOddPsum{
	static int arr[],evpsum[],odpsum[];
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Size of array: ");
		int size=sc.nextInt();
		arr=new int[size];
		evpsum=new int[size];
		odpsum=new int[size];
		
		System.out.println("Insert elements of array ");
		for(int i=0;i<arr.length;i++){
			arr[i]=sc.nextInt();
		}
		System.out.println("Array elements are:");
		for(int i=0;i<size;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		evpsum[0]=arr[0];
		odpsum[0]=0;
		odpsum[1]=arr[1];
		
		for(int i=1;i<arr.length;i++){
			if(i%2==0){
				evpsum[i]=arr[i]+evpsum[i-1];
			}
			else{
				evpsum[i]=evpsum[i-1];
			}
		}
		
		for(int i=1;i<size;i++){
			if(i%2==0){
				odpsum[i]=odpsum[i-1];
			}
			else{
				odpsum[i]=arr[i]+odpsum[i-1];
			}
		}
		System.out.println("Even sum array");
		for(int i=0;i<size;i++){
			System.out.print(evpsum[i]+" ");
		}
		System.out.println();
		System.out.println("Odd sum array");
		for(int i=0;i<size;i++){
			System.out.print(odpsum[i]+" ");
		}
	}
}