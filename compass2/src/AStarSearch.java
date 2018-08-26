
public class AStarSearch {
	
	//Nodes for finding shortest path
	AStarNode startNode,goalNode;

	public AStarSearch(Node start, Node goal) {
		// TODO Auto-generated constructor stub
	}

	public AStarNode getStartNode() {
		return startNode;
	}

	public void setStartNode(Node startNode) {
		this.startNode = (AStarNode) startNode;
	}

	public AStarNode getGoalNode() {
		return goalNode;
	}

	public void setGoalNode(Node closest) {
		this.goalNode = (AStarNode) closest;
	}
	
	public void clearSearch() {
		startNode = null;
		goalNode = null;
	}
}

