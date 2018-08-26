import java.util.HashSet;
import java.util.PriorityQueue;

public class AStarSearch{
	
	//Nodes for finding shortest path
	Node startNode,endNode;
	
	PriorityQueue<Node> fringe = new PriorityQueue<>();
	HashSet<Node> visited = new HashSet<Node>();
	
	Graph search;
	
	
	public AStarSearch(Node start, Node goal, Graph g) {
		// TODO Auto-generated constructor stub
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
	 * to the goal location, printing out the sequence of reoad segments 
	 * (including road names and segment lengths)
	 * @param start
	 * @param end
	 */
	public void findShortestPath(Node start, Node end) {

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

