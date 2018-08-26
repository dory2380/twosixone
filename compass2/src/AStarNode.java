
/**
 * A* Node
 * @author doris
 *
 */
public class AStarNode extends Node implements Comparable {
	
	public AStarNode(int nodeID, double lat, double lon) {
		super(nodeID, lat, lon);
		// TODO Auto-generated constructor stub
	}

	AStarNode startNode;
	AStarNode goalNode;

	
	
	AStarNode pathParent;
	float costFromStart; //g
	float estimateCostToGoal; //h

	
	public float getCost() {
		return costFromStart+estimateCostToGoal;
	}
	
	
	
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void clearStartEndNodes() {
		startNode = null;
		goalNode = null;
		
	}
}
