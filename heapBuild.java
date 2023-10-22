import java.util.*;
class heapBuild{
	static int heap[];
	public static void main(String[] args){
		int n=12;
		heap=new int[n];
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter given array: ");
		for(int i=0;i<n;i++){
			heap[i]=sc.nextInt();
		}
		for(int i=(n/2)-1;i>=0;i--){	//its actually O(n) tc to build a heap
			heapify(heap,i);
		}
		System.out.println(Arrays.toString(heap));
	}
	
	static void heapify(int heap[], int i) {
    int leftChild = 2 * i + 1;
    int rightChild = 2 * i + 2;
    
    while (leftChild < heap.length) {
        int j = i;  // Assume the parent (heap[i]) is the smallest
        
        if (leftChild < heap.length && heap[leftChild] < heap[j]) {
            j = leftChild;
        }
        
        if (rightChild < heap.length && heap[rightChild] < heap[j]) {
            j = rightChild;
        }
        // If the smallest element is the parent, the heap property is satisfied
        if (j == i) {
            return;
        }
        swap(i, j);
        i = j;
        
        // Update the indices of leftChild and rightChild
        leftChild = 2 * i + 1;
        rightChild = 2 * i + 2;
    }
}	
	static void swap(int i,int j){
		int t=heap[i];
		heap[i]=heap[j];
		heap[j]=t;
	}
}