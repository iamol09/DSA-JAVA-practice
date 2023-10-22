// do not run
import java.util.*;
class inversionCount{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter array size");
		int size=sc.nextInt();
		int[] arr=new int[size];
		System.out.println("Enter array elements");
		for(int i=0;i<arr.length;i++){
			arr[i]=sc.nextInt();
		}
	System.out.println(Arrays.toString(arr));
	//Merge_sort
	int l=0;
	int r=size-1;
	int count=mergeSort(arr,l,r);
	System.out.println("Sorted array");
	System.out.println(Arrays.toString(arr));
	System.out.println("Count: "+count);
	}
	static int mergeSort(int arr[],int l,int r){
		if(l==r)
			return 0;
		int mid=(l+r)/2;
		int x=mergeSort(arr,l,mid);
		int y=mergeSort(arr,mid+1,r);
		int z=mergeArr(arr,l,mid+1,r);
		return x+y+z;
	}
	static void mergeArr(int arr[],int p,int q,int r){
		int count=0;
		int temp[]=new int[r-p+1]; 
		int i=p;
		int j=q;
		int k=0;
		while(i<q&&j<=r){
			if(arr[i]<arr[j]){
				temp[k]=arr[i];
				k++;
				i++;
			}
			else{
				temp[k]=arr[j];
				k++;
				j++;
				count+=q-i;
			}
		}
		while(i<q){
			temp[k]=arr[i];
			i++;
			k++;
		}
		while(j<=r){
			temp[k]=arr[j];
			k++;
			j++;
		}
		for(int l=0;l<r-p+1;l++){
			arr[p+l]=temp[l];
		}
		return count;
	}
}