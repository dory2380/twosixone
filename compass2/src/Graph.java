import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * This represents the data structure storing all the roads, nodes, and
 * segments, as well as some information on which nodes and segments should be
 * highlighted.
 * 
 * @author tony
 */
public class Graph {
	// map node IDs to Nodes.
	Map<Integer, Node> nodes = new HashMap<>();
	// map road IDs to Roads.
	Map<Integer, Road> roads;
	// just some collection of Segments.
	Collection<Segment> segments;

	Node highlightedNode;
	Node start;
	Node goal;
	
	//TODO: move into method to find shortest path? 
	AStarSearch search = new AStarSearch(start, goal);
	


	Collection<Road> highlightedRoads = new HashSet<>();
	Collection<Node> highlightedNodes = new HashSet<>();

	

	public Graph(File nodes, File roads, File segments, File polygons) {
		this.nodes = Parser.parseNodes(nodes, this);
		this.roads = Parser.parseRoads(roads, this);
		this.segments = Parser.parseSegments(segments, this);
	}

	public void draw(Graphics g, Dimension screen, Location origin, double scale) {
		// a compatibility wart on swing is that it has to give out Graphics
		// objects, but Graphics2D objects are nicer to work with. Luckily
		// they're a subclass, and swing always gives them out anyway, so we can
		// just do this.
		Graphics2D g2 = (Graphics2D) g;

		// draw all the segments.
		g2.setColor(Mapper.SEGMENT_COLOUR);
		for (Segment s : segments)
			s.draw(g2, origin, scale);

		// draw the segments of all highlighted roads.
		g2.setColor(Mapper.HIGHLIGHT_COLOUR);
		g2.setStroke(new BasicStroke(3));
		for (Road road : highlightedRoads) {
			for (Segment seg : road.components) {
				seg.draw(g2, origin, scale);
			}
		}

		// draw all the nodes.
		g2.setColor(Mapper.NODE_COLOUR);
		for (Node n : nodes.values())
			n.draw(g2, screen, origin, scale);

		// draw the highlighted node, if it exists.
		if (highlightedNode != null) {
			g2.setColor(Mapper.HIGHLIGHT_COLOUR);
			highlightedNode.draw(g2, screen, origin, scale);
		}
	}

	public void setHighlight(Node node) {
		this.highlightedNode = node;
		highlightedNodes.add(node); //TODO:
	}

	public void setHighlightRoads(Collection<Road> roads) {
		this.highlightedRoads = roads;
	}
	
//	public void setHighlightNodes(Collection<Node> nodes) {
//		this.highlightedNodes = nodes;
//	}
	
	
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

//	/**
//	 * f(node) = g(node) + h(node)
//	 */
//	public int f(int g, int h) {
//		return g+h;
//	}




}

// code for COMP261 assignments