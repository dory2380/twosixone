import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Node represents an intersection in the road graph. It stores its ID and its
 * location, as well as all the segments that it connects to. It knows how to
 * draw itself, and has an informative toString method.
 * 
 * @author tony
 */
public class Node implements Comparable<Node> {

	public final int nodeID;
	public final Location location;
	public final Collection<Segment> segments;

	//AStar
	Node prevNode;

	double costFromStart; //g

	double estimateCostToGoal; //h

	public double getEstimateCostToGoalHeuristic() {
		return estimateCostToGoal;
	}

	/**
	 * heuristic function finds: estimated cost to goal
	 *
	 * @param estimateCostToGoal
	 */
	public void setEstimateCostToGoalHeuristic(double estimateCostToGoal) {
		this.estimateCostToGoal = estimateCostToGoal;
	}

	public double f; //g+h
	public double g; //cost from start
	public double h; //estimated cost to goal node

	public Node(int nodeID, double lat, double lon) {
		this.nodeID = nodeID;
		this.location = Location.newFromLatLon(lat, lon);
		this.segments = new HashSet<Segment>();
		//this.estimateCostToGoal = calculateHeuristic();
	}

	public void addSegment(Segment seg) {
		segments.add(seg);
	}

	public void draw(Graphics g, Dimension area, Location origin, double scale) {
		Point p = location.asPoint(origin, scale);

		// for efficiency, don't render nodes that are off-screen.
		if (p.x < 0 || p.x > area.width || p.y < 0 || p.y > area.height)
			return;

		int size = (int) (Mapper.NODE_GRADIENT * Math.log(scale) + Mapper.NODE_INTERCEPT);
		g.fillRect(p.x - size / 2, p.y - size / 2, size, size);
	}

	public String toString() {
		Set<String> edges = new HashSet<String>();
		for (Segment s : segments) {
			if (!edges.contains(s.road.name))
				edges.add(s.road.name);
		}

		String str = "ID: " + nodeID + "  loc: " + location + "\nroads: ";
		for (String e : edges) {
			str += e + ", ";
		}
		return str.substring(0, str.length() - 2);
	}

	//A Star

	/**
	 * calculates cost of this node to another node
	 * @param n
	 * @return
	 */
	public double costToNode(Node n) {
		return 0; //TODO: costToNode
	}

	/**
	 * cost from start to this node
	 * @return
	 */
	public double getG() {
		return 0; //TODO: g:
	}

	/**
	 * heuristic function to calculate estimated 
	 * cost from cost to goal
	 * @return
	 */
	public double getH() {
		return 0; //TODO: costToNode
	}

	/**
	 * 
	 * @return
	 */
	public double getF() {
		return costFromStart+estimateCostToGoal;
	}


	public Set<Node> getNeighours() {
		HashSet<Node> neighbours= new HashSet<>();
		//TODO:
		return neighbours;
	}


	public double getCostFromStart() {
		return costFromStart;
	}

	public void setCostFromStart(double costFromStart) {
		this.costFromStart = costFromStart;
	}
	public Node getPrevNode() {
		return prevNode;
	}
	
	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}

	@Override
	public int compareTo(Node node) {
		if(this.getEstimateCostToGoalHeuristic() < node.getEstimateCostToGoalHeuristic())
			return -1;
		if(this.getEstimateCostToGoalHeuristic() > node.getEstimateCostToGoalHeuristic())
			return 1;
		else {
			return 0;
		}
	}
}
// code for COMP261 assignments