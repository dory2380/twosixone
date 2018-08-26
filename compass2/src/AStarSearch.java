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
	
	public AStarSearch(Node start, Node goal, Graph g) {
		//add existing the nodes in the graph with added distance from start
		for(Map.Entry<Integer, Node> entry : g.nodes.entrySet()) {
			Node weightedNode = entry.getValue();
			weightedNode.setCostFromStart(weightedNode.location.distance(startNode.location));
			weightedNodes.put(entry.getKey(), entry.getValue());
		}
		
		//Initialise there to be only start node in the fringe
		fringe.add(startNode);
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
	
	public void clearSearch() {
		startNode = null;
		endNode = null;
	}
	
	
	/**
	 * A* Search to find the shortest path from the start location
	 * to the goal location, printing out the sequence of reload segments 
	 * (including road names and segment lengths)
	 * @param start
	 * @param end
	 */
	public void findShortestPath(Node start, Node end) {
		Node current;
		while(!fringe.isEmpty()) {
//			for(Map.Entry<Integer, Node> entry : nodes.entrySet()) {
//	        if(nodeID == entry.getValue().nodeID) {
//	            node = entry.getValue();
//	            break;
//	        }
//	    }
			
		}
	}
	
	/**
	 * heuristic function finds: estimated cost to goal
	 */
	public int h() {
		return 0;//TODO: not 0
	}

	/**
	 * g(node): cost from the start
	 */
	public int g(Node currentNode) {
		return 0;//TODO: not 0
	}
}

