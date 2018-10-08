import java.util.ArrayList;
import java.util.Scanner;

public class LamportLogical {
	
	
	ArrayList<Integer> processes=new ArrayList<Integer>();
	int n;
	Scanner sc=new Scanner(System.in);
	
	public void input()
	{
		System.out.println("Enter the number of processes ");
		n=sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			processes.add(0);
		}
	}
	
	
	public void printClocks()
	{
		for(int i=0;i<n;i++)
		{
			System.out.print("Process "+(i+1)+" :- "+processes.get(i));
			System.out.println();
		}
	}
	
	
	public void evaluate()
	{
		String choice;
		do
		{
		System.out.println("Enter the dependency. E.g.1 1 OR 1 2");
		int send=sc.nextInt();
		int rec=sc.nextInt();
		
		if(send==rec)
		{
			processes.set(send-1,processes.get(send-1)+1);
		}
		else if(processes.get(send-1)>processes.get(rec-1))
		{
			processes.set(rec-1, processes.get(send-1)+1);
			
		}
		
		printClocks();
		System.out.println("Enter y to add more events ");
		 choice=sc.next();
		}while(choice.equalsIgnoreCase("y"));
	}
	
	
	public static void main(String[]args)
	{
		
		
		LamportLogical ll=new LamportLogical();
		ll.input();
		ll.evaluate();
		
	}

}
