

import java.io.*;
import java.util.*;
class node{
	int data;
	node next;
	node(int x){
		data=x;
		next=null;
	}
}
class linkList1{
	static int count=0;
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Create a linked list");
		
		node head=null;
		node temp=head; //shows null pointer exception
		//creating list
		System.out.println("Enter Number of links: ");
		int n=sc.nextInt();
		System.out.println("Insert link data");
		while(count!=n){
				int n1=sc.nextInt();
				if(head==null){
					head=new node(n1);
					count++;
					temp=head;
				}
				else{
					node x=new node(n1);
					temp.next=x;
					temp=x;
					count++;
				}
		}
		temp=head;
		printList(head);
		System.out.println("Number of links:"+count);
		
		//insertion at K'th place
		System.out.println("Enter position element:");
		int pos=sc.nextInt();
		System.out.println("Enter element to be inserted");
		int numAdd=sc.nextInt();
		node tempHead=insertNode(head,pos,numAdd);
		head=tempHead;
		printList(head);
		System.out.println("Number of links:"+count);
		
		//searching an element in list
		System.out.println("Enter element to search: ");
		int numSerch=sc.nextInt();
		searchNode(head,numSerch);
		
		//deleting element in list
		System.out.println("Enter position element to delete:");
		int deltPos=sc.nextInt();
		node headTemp=deletetNode(head,deltPos);
		head=headTemp;
		printList(head);
		System.out.println("Number of links:"+count);
	}
	
	static node deletetNode(node head,int pos){
		int k=1;
		if(pos<0||pos>count){
			System.out.println("Number "+pos+" Node doesnt exist");
			return head;
			//System.exit(0);
		}
		if(head==null){
			System.out.println("List doesnt exist");
			return head;
		}
		else if(pos==1){
			head=head.next;
			count--;
			return head;
		}
		else{
			node temp=head;
			node prev=head;
			while(k!=pos){
				prev=temp;
				temp=temp.next;
				k++;
			}
			prev.next=temp.next;
			count--;
			return head;
		}
	}
	
	static void searchNode(node head,int num){
		int cnt=1;
		if(head==null){
			System.out.println("List doesnt exist");
		}
		else{
			node temp=head;
			do{
				if(temp.data==num){
					System.out.println("Found at "+cnt+" position");
					return;
				}
				temp=temp.next;
				cnt++;
			}while(temp!=null);
			System.out.println("Not found");
		}		
	}
	
	static node insertNode(node head,int pos,int n3){
		node temp=head;
		node temp1=head;
		if(pos<0||pos>(count+1))
		{
			System.out.println("Invalid position!!");
			return head;
			//System.exit(0);
		}
		if(head==null){
			head=new node(n3);
			count++;
			return head;
		}
		else if(pos==1){
			node first=new node(n3);
			first.next=head;
			head=first;
			count++;
			return head;
		}
		else{
			int i=1;
			while(i!=pos){
				temp1=temp;
				temp=temp.next;
				i++;
			}
			node k=new node(n3);
			temp1.next=k;
			k.next=temp;
			count++;
			return head;
		}
	}
	
	static void printList(node head){
		if(head==null){
			System.out.println("List doesnt exist");
		}
		else{
			node temp=head;
			System.out.println("Given list");
			while(temp!=null){
				System.out.print(+temp.data+"  ");
				temp=temp.next;
			}
		}
		System.out.println();
	}
}