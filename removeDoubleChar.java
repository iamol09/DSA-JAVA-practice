//double char trouble
import java.util.*;
class node{
	char ch;
	node next;
}
class removeDoubleChar{
	static node head=new node();
	public static void main(String[] args){
		head.next=null;
		String str="abccbd";
		for(int i=0;i<str.length();i++){
			char x=str.charAt(i);
			char y=top();
			if(x==y){
				pop();
			}
			else{
				push(x);
			}
		}
		String str1=new String("");
		while(head!=null){
			str1=str1+head.ch;
			head=head.next;
		}
		System.out.println("Given string: "+str);
		System.out.println("Final string: "+str1);//print str1 reverse for actual answer
	}
	static void push(char x){
		node input=new node();
		input.ch=x;
		if(head==null){
			head=input;
		}
		else{
			input.next=head;
			head=input;
		}
	}
	static void pop(){
		node temp=head;
		head=head.next;
		temp.next=null;
	}
	static char top(){
		char y=head.ch;
		return y;
	}
}