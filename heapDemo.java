import java.util.*;
class heapDemo{
	static ArrayList<Integer> heap=new ArrayList<>();
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Given heap");
		for(int i=0;i<9;i++){
			int a=sc.nextInt();
			heap.add(a);
		}
		System.out.println(heap);
		
		System.out.println("Enter element to insert");
		int k=sc.nextInt();
		heapInsert(k);
		System.out.println(heap);
		
		extractHeapify();
		System.out.println(heap);
		
		
	}
	static void heapInsert(int k){ //O(log n)
		heap.add(k);
		int i=heap.size()-1;
		while(i!=0){
			int parent=(i-1)/2;
			if(heap.get(parent)>heap.get(i)){
				swap(i,parent);
				i=parent;
			}
			else{
				break;
			}
		}
	}
	
	static void extractHeapify(){
		int last=heap.get(heap.size()-1);
		heap.set(heap.size()-1,heap.get(0));
		heap.set(0,last);
		heap.remove(heap.size()-1);
		
		int i=0;
		while((2*i+1)<heap.size()){
			int x=min(heap.get(i),heap.get(2*i+1),heap.get(2*i+2));
			if(x==heap.get(i)){
				return;
			}
			else if(x==heap.get(2*i+1)){
				swap(i,(2*i+1));
				i=2*i+1;
			}
			else{
				swap(i,(2*i+2));
				i=2*i+2;
			}
		}
	}
	static void swap(int i,int j){
		int t=heap.get(i);
		heap.set(i,heap.get(j));
		heap.set(j,t);
	}
	
	static int min(int p,int q,int r){
		if(p<=q && p<=r){
			return p;
		}
		else if(q<=p && q<=r){
			return q;
		}
		else{
			return r;
		}
	}
}