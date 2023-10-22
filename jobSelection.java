import java.util.*;
class job{
	int reward;
	int deadline;
	job(int r,int d){
		this.reward=r;
		this.deadline=d;
	}
}
class jobSelection{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		job arr[]=new job[5];
		for (int i = 0; i < 5; i++) {
            System.out.println("Enter reward:");
            int r = sc.nextInt();
            System.out.println("Enter deadline:");
            int d = sc.nextInt();
			arr[i] = new job(r,d);
        }
		
		Arrays.sort(arr, new Comparator<job>(){
			public int compare(job j1,job j2){
				return Integer.compare(j1.deadline,j2.deadline);
			}
		});
		int day=0;
		int sum=0;
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=0;i<5;i++){
			if(arr[i].deadline>day){
				day++;
				pq.add(arr[i].reward);
				sum+=arr[i].reward;
			}
			else{
				if(arr[i].reward>pq.peek()){
					int x=pq.poll();
					sum-=x;
					pq.add(arr[i].reward);
					sum+=arr[i].reward;
				}
			}
		}
		System.out.println("Maximum reward:"+sum);
	}	
}