// The convex hull of a set of N points is the smallest perimeter fence enlcosing the points

// application 1) Robot motion planning : find the shortest path in the plane from s to t
				// that avoids a polygon obstacle
				// FACT : Shortest path is either straight line from s to t or it is one of two polygon
				// chains of convex hull.

// 2) Farthest pair problem : given N points in the plane, find a pair of points with the largest Euclidian 
					// distance between them
					// Fact : farthest pair of points are extreme points on convex hull


// Graham scan demo : 
	// choose point p with smallest y coordinate
	// sort points by polar angle with p
	// Consider points in order, discard unless it creates a CounterClockWise turn

// running time : NlogN for sorting and linear for rest (as each point is pushed on the stack and popped only once)

public class ConvexHull {

	/*Stack<Point2D> hull = new Stack<Point>();
	
	Arrays.Sort(p, Point2D.Y_ORDER);
	Arrays.sort(p, p[0].BY_POLAR_ORDER);
	
	hull.push(p[0]);
	hull.push(p[1]);
	
	for(int i=2; i<N; i++){		
		Point2D top = hull.pop();
		
		while(Point2D.ccw(hull.peek(), top, p[i]) <=0){
			top = hull.pop();
		}
		hull.push(top);
		hull.push(p[i]);		
	}	*/
}
