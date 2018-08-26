

public class AStarNode extends Node{
	
	protected double distance;

	public AStarNode(int nodeID, double lat, double lon) {
		super(nodeID, lat, lon);
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}

}
