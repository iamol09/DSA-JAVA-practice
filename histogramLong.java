// not completed...running properly with value but not when we store index

import java.util.*;
class histogramLong{
	public static void main(String[] args){
		int hist[]={2,1,4,7,5,2,1,3,4,5,6,4,3,7,3};
		System.out.println(Arrays.toString(hist));
		Stack<Integer> st=new Stack<>();
		int leftMin[]=new int[hist.length];
		int rightMin[]=new int[hist.length];
		leftMin[0]=-1;
		st.push(leftMin[0]);
		for(int i=0;i<hist.length;i++){
			while(!st.empty()&&hist[i]<=hist[st.peek()]){
				st.pop();
			}
			if(!st.empty()){
				leftMin[i]=st.peek();
			}
			st.push(i);
		}
		System.out.println(Arrays.toString(leftMin));
		st.clear();
		rightMin[hist.length-1]=-1;
		st.push(rightMin[hist.length-1]);
		for(int i=hist.length-1;i>=0;i--){
			while(!st.empty()&&hist[i]>=hist[st.peek()]){
				st.pop();
			}
			if(!st.empty()){
				rightMin[i]=st.peek();
			}
			st.push(i);
		}
		System.out.println(Arrays.toString(rightMin));
		int ans=0;
		for(int i=0;i<hist.length;i++){
			ans=max(ans,(hist[i]*(rightMin[i]-leftMin[i]-1)));
		}
		System.out.println("Answer: "+ans);
	}
	static int max(int a,int b){
		if(a>b)
			return a;
		else
			return b;
	}
}