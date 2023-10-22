import java.util.*;
class sortMerge{
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
	mergeSort(arr,l,r);
	System.out.println("Sorted array");
	System.out.println(Arrays.toString(arr));
	}
	static void mergeSort(int arr[],int l,int r){
		if(l==r)
			return;
		int mid=(l+r)/2;
		mergeSort(arr,l,mid);
		mergeSort(arr,mid+1,r);
		mergeArr(arr,l,mid+1,r);
	}
	static void mergeArr(int arr[],int p,int q,int r){
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
	}
}