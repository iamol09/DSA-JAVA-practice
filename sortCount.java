import java.util.*;
class sortCount{
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
		int freq[]=new int[6];
		for(int i=0;i<arr.length;i++){
			freq[arr[i]]++;
		}
		System.out.println("Frequency array: "+Arrays.toString(freq));
		System.out.println("Sorted array");
		for(int i=0;i<freq.length;i++){
			while(freq[i]>0){
				System.out.print(i+" ");
				freq[i]--;
			}
		}
		System.out.println();
	}
}