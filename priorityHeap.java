import java.util.*;
class priorityHeap{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		pq.add(7);
		pq.add(3);
		pq.add(5);
		int n=12;
		System.out.println("Enter heap elements:");
		for(int i=1;i<=(n-3);i++){
			int x=sc.nextInt();
			if(x>pq.peek()){
				pq.poll();
				pq.add(x);
			}
		}
		System.out.println("Third largest:"+pq.peek());
	}
}