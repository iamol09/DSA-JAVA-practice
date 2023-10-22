import java.io.*;
import java.util.*;
class treeNode{
	int data;
	treeNode left;
	treeNode right;
	treeNode(int x){
		data=x;
		left=null;
		right=null;
	}
}
class treeDemo{
	static int maxNum,minNum,count;
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		treeNode root=null;
		System.out.println("Enter root node");
		int r=sc.nextInt();
		root=new treeNode(r);
		treeNode temp=root;
		
		insertTreeLeaf(root);
		
		maxNum=minNum=root.data;
		count=0;
		
		System.out.println("Inorder traversal ");
		inorderPrint(root);
		System.out.println();
		
		System.out.println("Level Order traversal ");
		levelOrderPrint(root);
		
		System.out.println("Maximum of tree: "+maxNum);
		System.out.println("Minimun of tree: "+minNum);
		System.out.println("Total elements of tree: "+count);
		
		int ht=treeHeight(root);
		System.out.println("Height of tree: "+ht);
		
	}
	
	static void insertTreeLeaf(treeNode root){
		Scanner sc=new Scanner(System.in);
		treeNode leftRoot=root;
		treeNode rightRoot=root;
		//left side tree insertion
		System.out.println("Is left node present to "+root.data);
		System.out.println("Yes-->1");
		System.out.println("No-->0");
		int ln=sc.nextInt();
		
		switch(ln){
			case 1:
			System.out.println("Enter left child of "+leftRoot.data+" node:");
			int num=sc.nextInt();
			treeNode newNode=new treeNode(num);
			leftRoot.left=newNode;
			leftRoot=leftRoot.left;
			insertTreeLeaf(leftRoot);
			break;
			default:break;
		}
		
		//right side tree insertion
		System.out.println("Is right node present to "+root.data);
		System.out.println("Yes-->1");
		System.out.println("No-->0");
		int rn=sc.nextInt();
		
		switch(rn){
			case 1:
			System.out.println("Enter right child of "+rightRoot.data+" node:");
			int num=sc.nextInt();
			treeNode newNode=new treeNode(num);
			rightRoot.right=newNode;
			rightRoot=rightRoot.right;
			insertTreeLeaf(rightRoot);
			break;
			default:break;
		}
		
	}
	
	static int treeHeight(treeNode root){
		if(root==null){
			return -1; //height of empty tree is -1 and of only node tree is 0
		}
		int lh=treeHeight(root.left);
		int rh=treeHeight(root.right);
		return max(lh,rh)+1;
	}
	
	static void inorderPrint(treeNode root){
		if(root==null){
			return;
		}
		inorderPrint(root.left);
		System.out.print(root.data+"->");
		count++;
		if(root.data>maxNum){
			maxNum=root.data;
		}
		if(root.data<minNum){
			minNum=root.data;
		}
		inorderPrint(root.right);
	}
	
	static void levelOrderPrint(treeNode root){
		Queue<treeNode> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			treeNode x=q.peek();
			q.poll();
			System.out.print(x.data+" ");
			if(x.left!=null){
				q.add(x.left);
			}
			if(x.right!=null){
				q.add(x.right);
			}
		}
		System.out.println();
	}
	
	static int max(int a,int b){
		if(a>b)
			return a;
		else
			return b;
	}
}