import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class AStarSearch{
	
	//Nodes for finding shortest path
	Node startNode,endNode;
	
	PriorityQueue<Node> fringe = new PriorityQueue<>();
	HashSet<Node> visited = new HashSet<Node>();
	
	Map<Integer, Node> weightedNodes = new HashMap<>();
	Graph aStarGraph;
	
	double f; //g(node) + h(node)
	double g; //cost from start
	
	//shouldn't need start and end here...lol
	public AStarSearch(Node start, Node end, Graph graph) {
		this.aStarGraph = graph;
		//add existing the nodes in the graph with added distance from start
		for(Map.Entry<Integer, Node> entry : aStarGraph.nodes.entrySet()) {
			Node weightedNode = entry.getValue();
			weightedNode.setEstimateCostToGoalHeuristic(weightedNode.location.distance(endNode.location));
			weightedNodes.put(entry.getKey(), entry.getValue());
		}
	}

	public Node getStartNode() {
		return startNode;
	}

	public void setStartNode(Node startNode) {
		this.startNode = startNode;
	}

	public Node getGoalNode() {
		return endNode;
	}

	public void setGoalNode(Node closest) {
		this.endNode = closest;
	}
	
//	public void clearSearch() {
//		startNode = null;
//		endNode = null;
//	}
	
	
	/**
	 * A* Search to find the shortest path from the start location
	 * to the goal location, printing out the sequence of reload segments 
	 * (including road names and segment lengths)
	 * @param start
	 * @param end
	 */
	public void findShortestPath(Node start, Node end) {
		startNode = start;
		endNode = end;
		//initialise search
		fringe.offer(startNode);
		System.out.println("added" + startNode.toString());
		
		Node previous = null;
		Node current = fringe.poll();

		
		while(!fringe.isEmpty()) {
			
			//if current node is unvisited
			if(!visited.contains(current)) {
				//set node as visited and set prev
				visited.add(current);
				current.setPrevNode(previous);
				
			}
			
			//if current node is target node, break
			if(current.equals(endNode)) {
				break;
			}
			
			//go through edges of current node
			//put nodes coming out from current into the fringe
			for(Segment seg:aStarGraph.segments) {
				//go through each edge to find neighbour
				if(seg.start.equals(current)) {
					Node neighbour = seg.end;
					//if unvisited
					if(!visited.contains(neighbour)) { 
						g = g* + seg.length; 
						f = g + neighbour.getEstimateCostToGoalHeuristic();
						visited.add(neighbour);
					}
					
					//add a new	element	<neigh,node*,g,f> into the	fringe;
					seg.end.setPrevNode(current);					
					fringe.offer(seg.end);
				}
			}
		}
	}
	


	/**
	 * g(node): cost from the start
	 */
	public void setCostFromStart(double cost) {
		g = cost;
	}
}

