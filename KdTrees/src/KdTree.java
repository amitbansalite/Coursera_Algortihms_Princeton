
//ODD_LEVEL = true = vertical line;
//EVEN_LEVEL = false = horizontal line;

// axis-aligned rectangle corresponding to the node: 
	// "rectangle containing all the points that could ever end up being on the subtree starting from this node, 
	//  at any point during its lifetime".

public class KdTree {

	private Node root;	
	
	
	private class Node{
		private Point2D p;
		private RectHV rect;
		private Node lb;
		private Node rt;

		Node(Point2D p, RectHV rect){
			this.p = p;
			this.rect = rect;
		}
	}

	public KdTree() {
		// construct an empty set of points
	}

	public boolean isEmpty() {
		return root == null;
	}

	// number of points in the set
	public int size() {
		return size(root);
	}

	private int size(Node x){
		if (x == null) return 0;

		return 1 + size(x.lb) + size(x.rt);
	}

	// add the point p to the set (if it is not already in the set)
	public void insert(Point2D p) {
		RectHV initialRect = new RectHV(0,0,1,1);
		root = insert(root, p, true, initialRect);
	}

	private Node insert(Node node, Point2D p, boolean level, RectHV rectXYValues){	   
		if (node == null) {			
			return new Node(p, rectXYValues);			
		}		

		int cmp = 0;		
		if( level ) 
			cmp = Point2D.X_ORDER.compare(p, node.p);					
		else
			cmp = Point2D.Y_ORDER.compare(p, node.p);
		
		RectHV nextNodeRect;
		// current node constructs the next node's rectangle co-ordinates
		if (cmp < 0){
			if(level)
				nextNodeRect = new RectHV(node.rect.xmin(), node.rect.ymin(), node.p.x(), node.rect.ymax());
			else
				nextNodeRect = new RectHV(node.rect.xmin(), node.rect.ymin(), node.rect.xmax(), node.p.y());
			
			node.lb = insert(node.lb, p, !level, nextNodeRect);
		}
		else{
			if(level)
				nextNodeRect = new RectHV(node.p.x(), node.rect.ymin(), node.rect.xmax(), node.rect.ymax());				
			else
				nextNodeRect = new RectHV(node.rect.xmin(), node.p.y(), node.rect.xmax(), node.rect.ymax());
			
			node.rt = insert(node.rt, p, !level, nextNodeRect);
		}

		return node;
	}

	// does the set contain the point p?
	public boolean contains(Point2D p) {
		return contains(root, p, true);
	}

	private boolean contains(Node node, Point2D p, boolean level){
		if (node == null) return false;
		int cmp = 0;

		if( level ) 
			cmp = Point2D.X_ORDER.compare(p, node.p);
		else
			cmp = Point2D.Y_ORDER.compare(p, node.p);

		if		(cmp < 0) 	return contains(node.lb, p, !level);
		else if (cmp > 0)	return contains(node.rt, p, !level);
		else if (node.p.compareTo(p) == 0)
			return true;
		else
			return false;
	}

	// draw all of the points to standard draw
	public void draw() {
		StdDraw.line(0, 0, 1, 0);
        StdDraw.line(0, 0, 0, 1);
        StdDraw.line(1, 0, 1, 1);
        StdDraw.line(0, 1, 1, 1);
		draw(root, true);	
	}
	
	private void draw(Node node, boolean level){		
		
		StdDraw.setPenColor(StdDraw.BLACK);
		node.p.draw();
		if ( level ){
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.line(node.p.x(), node.rect.ymin(), node.p.x(), node.rect.ymax());
			StdDraw.show(0);
		}
		else{
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.line(node.rect.xmin(), node.p.y(), node.rect.xmax(), node.p.y());
			StdDraw.show(0);
		}
		
		if (node.lb != null)
			draw(node.lb, !level);

		if (node.rt != null)
			draw(node.rt, !level);				
	}

	// all points in the set that are inside the rectangle
	public Iterable<Point2D> range(RectHV rect) {		
		Queue<Point2D> q = new Queue<Point2D>();		
		return range(rect, root, q);		
	}
	
	private Queue<Point2D> range(RectHV rect, Node node, Queue<Point2D> q){
	
		if (node == null) return q;
		
		if ( rect.intersects(node.rect)){
			
			if (rect.contains(node.p) )
				q.enqueue(node.p);
		
			range(rect, node.lb, q);
			range(rect, node.rt, q);
		}		
		return q;
	}
	

	// a nearest neighbor in the set to p; null if set is empty
	public Point2D nearest(Point2D p) {		
		return nearest(p, root, root.p, true);			
	}
	
	private Point2D nearest(Point2D p, Node node, Point2D nearestPoint, boolean level) {
		
		if ( node == null) return nearestPoint;
		
		double distToNearestPoint = p.distanceTo(nearestPoint);		
		double distToNodeRect = node.rect.distanceTo(p);
		
		if (distToNearestPoint > distToNodeRect){
			
			if (p.distanceTo(node.p) < distToNearestPoint){
				nearestPoint = node.p;
				StdOut.print(node.p.toString() + "\n");
			}
			
			int cmp = 0;
			if( level ) 
				cmp = Point2D.X_ORDER.compare(p, node.p);
			else
				cmp = Point2D.Y_ORDER.compare(p, node.p);

			if		(cmp < 0) 
				nearestPoint = nearest(p, node.lb, nearestPoint, !level);
			else if (cmp > 0)
				nearestPoint = nearest(p, node.rt, nearestPoint, !level);
			
			return nearestPoint;
		}
		else		
			return nearestPoint;		
	}
}
