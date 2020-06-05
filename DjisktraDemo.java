/**
 * Implementation of Dijkstra's Algorithm
 * @author Henil Doshi
 */

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;


class DijkstraEdge 
{
	public DijkstraVertex startVertex;
    public DijkstraVertex endVertex;
    public int weight;

    public DijkstraEdge(int weight, DijkstraVertex startVertex, DijkstraVertex endVertex) 
    {
        this.weight = weight;
        this.startVertex = startVertex;
        this.endVertex = endVertex;
    }

    public void printEdge() 
    {
        System.out.println(this.startVertex+" --> "+this.endVertex+ ", Weight= "+this.weight);
        
    }

}


class DijkstraVertex implements Comparable<DijkstraVertex>
{
	public String name;
    List<DijkstraEdge> adjacencyList;
    public boolean visited;
    public DijkstraVertex predecessor;
    public int dist = Integer.MAX_VALUE;

    public DijkstraVertex(String name)
    {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
    }

    public List<DijkstraEdge> getAdjacencyList()
    {
        return adjacencyList;
    }
    
    public void addAdjacent(DijkstraEdge edge) 
    {
        this.adjacencyList.add(edge);
    }
    
    @Override
    public int compareTo(DijkstraVertex otherVertex)
    {
        return Integer.compare(this.dist, otherVertex.dist);
    }
    
    @Override
    public String toString() 
    {
        return this.name;
    }
}

class DijkstraShortestPath 
{
	public void getShortestPaths(DijkstraVertex sourceVertex)
    {
    	sourceVertex.dist=0;
        PriorityQueue<DijkstraVertex> pq = new PriorityQueue<>();
        pq.add(sourceVertex);
        sourceVertex.visited=true;

        while(!pq.isEmpty())
        {
            DijkstraVertex vx = pq.poll();

            for(DijkstraEdge edge : vx.getAdjacencyList())
            {	
            	DijkstraVertex v = edge.endVertex;
                if(!v.visited)
                {
                    int new_dist = vx.dist + edge.weight;

                    if( new_dist < v.dist )
                    {
                        pq.remove(v);
                        v.dist=new_dist;
                        v.predecessor=vx;
                        pq.add(v);
                    }
                }
            }
            vx.visited=true;
        }
    }

    public List<DijkstraVertex> getShortestPath_vx(DijkstraVertex endVertex)
    {
        List<DijkstraVertex> path = new ArrayList<>();
        for(DijkstraVertex v=endVertex;v!=null;v=v.predecessor)
        {
            path.add(v);
        }
        Collections.reverse(path);
        return path;
    }

}


public class DjisktraDemo 
{
	public static void main(String[] args) 
	{
		DijkstraVertex vertexA = new DijkstraVertex("A");
		DijkstraVertex vertexB = new DijkstraVertex("B");
		DijkstraVertex vertexC = new DijkstraVertex("C");
		DijkstraVertex vertexD = new DijkstraVertex("D");
		DijkstraVertex vertexE = new DijkstraVertex("E");
		DijkstraVertex vertexF = new DijkstraVertex("F");
		DijkstraVertex vertexG = new DijkstraVertex("G");
		DijkstraVertex vertexH = new DijkstraVertex("H");
		DijkstraVertex vertexI = new DijkstraVertex("I");
		DijkstraVertex vertexJ = new DijkstraVertex("J");
		DijkstraVertex[] vertices = {vertexA,vertexB,vertexC,vertexD,vertexE,vertexF,vertexG,vertexH,vertexI,vertexJ};

        vertexA.addAdjacent(new DijkstraEdge(12,vertexA,vertexB));
        vertexA.addAdjacent(new DijkstraEdge(10,vertexA,vertexF));
        vertexA.addAdjacent(new DijkstraEdge(11,vertexA,vertexG));
        vertexB.addAdjacent(new DijkstraEdge(20,vertexB,vertexI));
        vertexB.addAdjacent(new DijkstraEdge(35,vertexB,vertexC));
        vertexF.addAdjacent(new DijkstraEdge(10,vertexF,vertexG));
        vertexF.addAdjacent(new DijkstraEdge(19,vertexF,vertexE));
        vertexF.addAdjacent(new DijkstraEdge(15,vertexF,vertexC));
        vertexG.addAdjacent(new DijkstraEdge(30,vertexG,vertexH));
        vertexG.addAdjacent(new DijkstraEdge(21,vertexG,vertexJ));
        vertexG.addAdjacent(new DijkstraEdge(13,vertexG,vertexE));
        vertexC.addAdjacent(new DijkstraEdge(6,vertexC,vertexE));
        vertexC.addAdjacent(new DijkstraEdge(50,vertexC,vertexH));
        vertexC.addAdjacent(new DijkstraEdge(17,vertexC,vertexI));
        vertexC.addAdjacent(new DijkstraEdge(5,vertexC,vertexJ));
        vertexD.addAdjacent(new DijkstraEdge(8,vertexD,vertexC));
        vertexD.addAdjacent(new DijkstraEdge(22,vertexD,vertexJ));
        vertexD.addAdjacent(new DijkstraEdge(36,vertexD,vertexH));
        vertexD.addAdjacent(new DijkstraEdge(14,vertexD,vertexI));
        vertexE.addAdjacent(new DijkstraEdge(7,vertexE,vertexH));
        vertexE.addAdjacent(new DijkstraEdge(18,vertexE,vertexD));

        DijkstraShortestPath shortestPath = new DijkstraShortestPath();
        shortestPath.getShortestPaths(vertexA);

        for(DijkstraVertex v : vertices)
        {
            System.out.println("\nVertex= "+v.name);
            for(DijkstraEdge e1: v.getAdjacencyList())
            {
                e1.printEdge();
            }
        }
       
        System.out.println("\nDijkstra Output Tree:");
        System.out.println("______________________");

        for(DijkstraVertex v : vertices)
        {
            if(v.predecessor != null)
            System.out.println(v.predecessor.name+ " -> "+v.name);
        }
        System.out.println("\n");
        System.out.println("Shortest Path from A to J= "+shortestPath.getShortestPath_vx(vertexJ));
        System.out.println("\n");
        System.out.println("Minimum dist from A to J= "+vertexJ.dist);
      
    }


}
