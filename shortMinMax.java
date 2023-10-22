import java.io.*;
import java.util.*;

class shortMinMax{
	public static void main(String[] args){
		int arr[];
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array:");
		int size=sc.nextInt();
		arr=new int[size];
		System.out.println("Insert elements of array ");
		for(int i=0;i<arr.length;i++){
			arr[i]=sc.nextInt();
		}
		int maxnum,minnum;
		maxnum=minnum=arr[0];
		
		for(int i=0;i<size;i++){
			if(arr[i]>maxnum){
				maxnum=arr[i];
			}
			else if(arr[i]<minnum){
				minnum=arr[i];
			}
			else{
				continue;
			}
		}
		System.out.println("Maximum number: "+maxnum);
		System.out.println("Minimum number: "+minnum);
		
		int minRange=size+1;
		int closMin,closMax;
		closMax=closMin=-1;
		
		for(int i=size-1;i<=0;i--){
			//iteration of max for closest_min
			if(arr[i]==minnum){
				closMin=i;
				if(closMax!=-1){
					minRange=min(minRange,(closMin-i+1));
				}
			}
			else if(arr[i]==maxnum){
				//iteration of min for closest_max
					closMax=i;
					if(closMin!=-1){
						minRange=min(minRange,(closMax-i+1));
					}
				}
			else{
				if(minRange==2){
					break;
				}
			}
		}
		System.out.println("Shortest Range: "+minRange);
		
}
	static int min(int a,int b){
		if(a<b)
			return a;
		else
			return b;
	}
}