//Check the given seqence of paranthesis is valid or not
import java.util.*;
class node{
	char ch;
	node next;
}
class paranthesis{
	public static void main(String[] args){
		node head=null;
		String str="({})";
		System.out.println("Given string "+str);
		for(int i=0;i<str.length();i++){
			char x=str.charAt(i);
			node lastBrackt=new node();
			lastBrackt.ch=str.charAt(i);
			lastBrackt.next=head;
			node temp=head;
			if(x=='{'||str.charAt(i)=='('||str.charAt(i)=='['){
				head=lastBrackt;
			}
			else if ((x == '}' && head != null && head.ch == '{') ||
                     (x == ']' && head != null && head.ch == '[') ||
                     (x == ')' && head != null && head.ch == '(')){
						 head=head.next;
			}
			else{
				System.out.println("Invalid paranthesis!");
				return;
			}
		}
		if(head==null)
			System.out.println("Valid paranthesis!!");
		else//not needed
			System.out.println("Invalid paranthesis!!");
	}
}