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
		startNode = start;
		endNode = end;

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
	public void findShortestPath() {
		//initialise search
		fringe.offer(startNode);

		Node previous = null;
		Node current;

		while(!fringe.isEmpty()) {
			current = fringe.poll();

			if(!visited.contains(current)) {
				visited.add(current);
				current.setPrevNode(previous);					

				//if current node is target node, break
				System.out.println("current node: " + current);
				if(current.equals(endNode)) {
					break;
				}


				for(Segment seg:current.segments) {
					//go through each edge to find neighbour
					Node neighbour = seg.end;
					//if unvisited
					if(!visited.contains(neighbour)) { 
						g = g* + seg.length; 
						f = g + neighbour.getEstimateCostToGoalHeuristic();

						fringe.offer(neighbour);
					}

				}
			}
			System.out.println("travelled route");
			HashSet<Segment> segmentsVisited = new HashSet<Segment>();
				System.out.println("through: ");
			}
		}

	/**
	 * g(node): cost from the start
	 */
	public void setCostFromStart(double cost) {
		g = cost;
	}
}

