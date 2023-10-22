import java.io.*;
import java.util.*;
class bitOperations{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n,i;
		System.out.println("Enter number and i for bit shifting");
		n=sc.nextInt();
		i=sc.nextInt();
		int n1=n&(1<<i);//checking i'th bit is set or unset, another way [(n>>i)&1]
		System.out.println("Shifted Number: "+n1);
		
		int n2=n^(1<<i);//toggling the i'th bit
		System.out.println("toggled Number: "+n2);	
	}
}