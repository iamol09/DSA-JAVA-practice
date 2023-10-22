//There is running stream of integers.Find median of elements after every new num joins.

import java.util.*;
class heapProblem{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		PriorityQueue<Integer> pqMax=new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> pqMin=new PriorityQueue<>();
		int n=12;
		int count=0;
		//size(pqMax)-size(pqMin)<=1-- keeping 1 element extra in pqMaxheap
		//TC= O(nlogn)
		
		for(int i=1;i<=9;i++){
			System.out.print("Enter element:");
			int x=sc.nextInt();
			if(pqMax.size()==0 || x>pqMax.peek()){
				pqMin.add(x);
				count++;
				if(pqMin.size()>pqMax.size()){
					int y=pqMin.poll();
					pqMax.add(y);
				}
			}
			else if(pqMin.size()==0 || x<pqMin.peek()){
				pqMax.add(x);
				count++;
				if(pqMax.size()-pqMin.size()>1){
					int y=pqMax.poll();
					pqMin.add(y);
				}
			}
			
			if(count%2==0){
				int ans=(pqMax.peek()+pqMin.peek())/2;
				System.out.println("Median of "+count+" elements is "+ans);
			}
			else{
				int ans=pqMax.peek();
				System.out.println("Median of "+count+" elements is "+ans);
			}
		}
	}
}

//Alternative code

/*class Solution
{
    static PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> pqMin = new PriorityQueue<>();
    static int count = 0;

    public static void insertHeap(int x)
    {
        if (pqMax.isEmpty() || x <= pqMax.peek()) {
            pqMax.add(x);
        } else {
            pqMin.add(x);
        }
        count++;
        balanceHeaps();
    }

    public static void balanceHeaps()
    {
        if (pqMax.size() - pqMin.size() > 1) {
            int y = pqMax.poll();
            pqMin.add(y);
        } else if (pqMin.size() > pqMax.size()) {
            int y = pqMin.poll();
            pqMax.add(y);
        }
    }

    public static double getMedian()
    {
        if (count % 2 == 0) {
            return (pqMax.peek() + pqMin.peek()) / 2.0;
        } else {
            return pqMax.peek();
        }
    }
}*/
