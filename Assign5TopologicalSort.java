/**
 * Implementation of Topological Sort
 * @author Henil Doshi
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Assign5TopologicalSort
{
	Boolean error = false;
    Stack<Node> stack;

    public Assign5TopologicalSort()
    {
        stack=new Stack<>();
    }
    static class Node
    {
        String value;
        boolean visited;
        boolean visiting;
        List<Node> neighbourNodes;

        Node(String value)
        {
            this.value=value;
            this.neighbourNodes=new ArrayList<>();
        }
        public void appendNeighbourNode(Node neighbourNode)
        {
            this.neighbourNodes.add(neighbourNode);
        }
        public void setNeighbourNode(List<Node> neighbourNodes) 
        {
            this.neighbourNodes = neighbourNodes;
        }
        public List<Node> getNeighbourNode() 
        {
            return neighbourNodes;
        }
        
    }

    public void topologicalSorting(Node node)
    {
        List<Node> neighbourNodes=node.getNeighbourNode();
        node.visiting = true;
        for (int i = 0; i < neighbourNodes.size(); i++) 
        {
            Node neighbourNode=neighbourNodes.get(i);
            if(neighbourNode!=null && !neighbourNode.visited && !error)
            {
                if(neighbourNode.visiting)
                {
                    System.out.println("Error: Cycle found at node = " + neighbourNode.value);
                    error = true;
                    break;
                }
                topologicalSorting(neighbourNode);
                neighbourNode.visited=true;
            }
        }
        node.visiting = false;
        stack.push(node);
    }

    public static void main(String arg[])
    {
    	Assign5TopologicalSort tps = new Assign5TopologicalSort();
        Node nA =new Node("A");
        Node nB =new Node("B");
        Node nC =new Node("C");
        Node nD =new Node("D");
        Node nE =new Node("E");
        Node nF =new Node("F");
        Node nG =new Node("G");
        Node nH =new Node("H");
        Node nI =new Node("I");
        Node nJ =new Node("J");
        Node nK =new Node("K");

        nA.appendNeighbourNode(nB);
        nA.appendNeighbourNode(nF);
        nB.appendNeighbourNode(nF);
        nB.appendNeighbourNode(nC);
        nB.appendNeighbourNode(nD);
        nC.appendNeighbourNode(nE);
        nE.appendNeighbourNode(nD);
        nF.appendNeighbourNode(nG);
        nG.appendNeighbourNode(nI);
        nI.appendNeighbourNode(nK);
        nJ.appendNeighbourNode(nE);
        nJ.appendNeighbourNode(nH);
        nK.appendNeighbourNode(nJ);
        nH.appendNeighbourNode(nD);
        nI.appendNeighbourNode(nH);
        
        //We add this edge to make cycle in the graph, when you remove this, graph will be without cycle (its result is shown in screenshot)
        //nD.appendNeighbourNode(nC);

        Node all_nodes[] = {nA,nB,nC,nD,nE,nF,nG,nH,nI,nJ,nK};
        
        System.out.println("GRAPH WITHOUT CYCLE:--");
        for(Node vertex : all_nodes)
        {
            System.out.println("");
            System.out.print("Node : "+ vertex.value + "-> ");
            for(Node n: vertex.neighbourNodes)
            {
                System.out.print(""+ n.value + ",");
            }
        }
        System.out.println();
        System.out.println();
        System.out.print("Topological Sort for Graph without cycle: ");
        System.out.println();
        tps.topologicalSorting(nA);

        System.out.print("Topological Order: ");
        Stack<Node> noCycleStack=tps.stack;
        while (noCycleStack.empty()==false)
        {
            System.out.print(noCycleStack.pop().value.toString() + " ");
        }
        System.out.println();
    }

}

