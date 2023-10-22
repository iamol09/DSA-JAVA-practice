import java.util.*;
class queueProb{
	public static void main(String[] args){
		Queue<Integer> qObj=new LinkedList<>();
		int n1=1;
		int n2=2;
		int n3=3;
		qObj.add(n1);
		qObj.add(n2);
		qObj.add(n3);
		int count=3;
		int k=16;
		while(count<=k){
			int a=qObj.peek();
			qObj.remove();
			qObj.add(a*10+n1);
			count+=1;
			if(count==k){
				System.out.println(k+"th number: "+(a*10+n1));
				break;
			}
			qObj.add(a*10+n2);
			count+=1;
			if(count==k){
				System.out.println(k+"th number: "+(a*10+n1));
				break;
			}
			qObj.add(a*10+n3);
			count+=1;
			if(count==k){
				System.out.println(k+"th number: "+(a*10+n1));
				break;
			}
		}
	}
}