/**
 * Implementation of Binary Search Tree
 * @author Henil Doshi
 */

class Node
{
	int data;
	Node right;
	Node left;

	//This method is for creating new nodes.
	public Node createNewNode(int i)   
	{
		Node n = new Node();
		n.data = i;
		n.right = null;
		n.left = null;
		return n;
	}
	
	//This method is for insertion in Binary Search Tree (BST). It recursively inserts new nodes according to the property of BST.
	public Node insert(Node node, int i)    
	{                                      
		if(node==null)                      
		{
			return createNewNode(i);       
		}								   
		else if(i<node.data)
		{
			node.left=insert(node.left,i);  
		}
		else if(i>node.data)
		{
			node.right=insert(node.right,i);
		}
		return node;
	}
	
	//This method does inorder traversal (recursive) of tree and print the values.
	public void inorderPrint(Node node)  
	{
		if(node==null)
		{
			return;
		}
		inorderPrint(node.left);
		System.out.print(node.data+" ");
		inorderPrint(node.right);
	}
	
	/*This method is for deletion by predecessor, that is, the node which we want to delete,
	will be deleted by copying the value of its immediate predecessor in its place and
	deleting the immediate predecessor node and also keeping the property of BST.*/
	public Node deleteByPredecessor(Node node, int i) 
	{                                                 
		if(node==null)                                
		{
			return null;
		}
		if(i<node.data)
		{
			node.left=deleteByPredecessor(node.left, i);
		}
		else if(i>node.data)
		{
			node.right=deleteByPredecessor(node.right, i);
		}
		else
		{
			if(node.left==null || node.right==null)  
			{	                                    
				Node temp1=null;
				if(node.left==null)
				{
					temp1=node.right;
				}
				else if(node.right==null)
				{
					temp1=node.left;
				}
				
				if(temp1==null)
				{
					return null;
				}
				else
				{
					return temp1;
				}
			}
			else                                 
			{
				Node predecessor=getPredecessor(node);
				node.data=predecessor.data;
				node.left=deleteByPredecessor(node.left, predecessor.data);
				return node;
			}
		}
		return node;
	}
	
	/*This method is to get the immediate predecessor. Immediate Predecessor will be there on the left
	subtree in the right most side.*/
	public Node getPredecessor(Node node)  
	{                                      
		if(node==null)
		{
			return null;
		}
		
		Node temp=node.left;
		while(temp.right!=null)
		{
			temp=temp.right;
		}
		return temp;
	}
}
public class BSTNode 
{
	public static void main(String args[])
	{
		Node b=new Node();
		Node root=null;
		root=b.insert(root,100);
		root=b.insert(root,50);
		root=b.insert(root,200);
		root=b.insert(root,150);
		root=b.insert(root,300);
		root=b.insert(root,25);
		root=b.insert(root,75);
		root=b.insert(root,12);
		root=b.insert(root,37);
		root=b.insert(root,125);
		root=b.insert(root,175);
		root=b.insert(root,250);
		root=b.insert(root,320);
		root=b.insert(root,67);
		root=b.insert(root,87);
		root=b.insert(root,94);
		root=b.insert(root,89);
		root=b.insert(root,92);
		root=b.insert(root,88);
		System.out.println("The Inorder traversal of Binary Search Tree is:");	
		b.inorderPrint(root);
		b.deleteByPredecessor(root,100);
		System.out.println("\n");
		System.out.println("After Deletion of 100, the Inorder traversal of Binary Search Tree is:");
		b.inorderPrint(root);
	
	}
}
