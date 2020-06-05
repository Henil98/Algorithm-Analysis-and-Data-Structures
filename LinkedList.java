/**
 * Implementation of selection sort by LinkedList swap by node rather than value
 * @author Henil Doshi
 */

import java.util.*;

public class LinkedList 
{
	Node head;
	
	static class Node 
	{
		int data;
		Node next;
		
		Node(int i)
		{
			data=i;
			next=null;
		}
	}
	
	public static LinkedList insert(LinkedList l, int i) 
	{
		Node n1=new Node(i);
		n1.next=null;
		
		if (l.head==null) 
		{
			l.head=n1;
		}

		else 
		{
			Node temp=l.head;
			while(temp.next!=null) 
			{
				temp=temp.next;
			}
			temp.next=n1;
		}
		return l;
	}
	
	public static void print(LinkedList l) 
	{
		Node n=l.head;
		System.out.println("Linkedlist is: ");
		while(n!=null)
		{
			System.out.print(n.data + " ");
			n=n.next;
		}
		System.out.println("");
	}
	
	public void selection_sort(LinkedList l)
	{
		Node temp1, temp2, itr1;
		itr1=l.head;
		for(Node node1=l.head; node1.next!=null; )
		{
			Node min=node1;
			temp1=l.head;
			temp2=l.head;
			
			for(Node node2=node1.next; node2!=null; )
			{
					if(min.data>node2.data)
					{
						min=node2;
					}
					if(node2.next!=null)
				    {
				    	 node2=node2.next;
				    }
				    else
				    {
				    	break;
				    }

			}
			
			while(temp1.next!=min)
			{
				temp1=temp1.next;
			}
			
			
		    if(node1==l.head)
		    {
		    	temp1.next=itr1;
		    	Node t1=min.next;
		    	min.next=itr1.next;
		    	itr1.next=t1;
		    	l.head=min;
		    	node1=min;
		    	
		    }
		    else
		    {
		    	while(temp2.next!=node1)
				{
					temp2=temp2.next;
				}
		    	
		    	temp1.next=temp2.next;
		    	Node t1=min.next;
		    	min.next=node1.next;
		    	node1.next=t1;
		    	temp2.next=min;
		    	node1=min;
		    	
		    	
		    }
		    
		    if(node1.next!=null)
		    {
		    	 node1=node1.next;
		    }
		    else
		    {
		    	break;
		    }	
		}
	}
	
	public static void main(String[] args) 
	{
		LinkedList list=new LinkedList();
		Scanner sin=new Scanner(System.in);
		System.out.println("Enter number of nodes you want in linked list: ");
		int num=sin.nextInt();
		for(int i=0;i<num;i++)
		{
			System.out.println("Enter number you want to insert at current node:");
			int n=sin.nextInt();
	        list = insert(list,n);
		}
		print(list);
		
		list.selection_sort(list);
		System.out.println("");
		System.out.println("After Sort:\n");
		print(list);
	}

}
