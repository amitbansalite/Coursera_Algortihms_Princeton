
import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Compare3Points();
    
    private class Compare3Points implements Comparator<Point>{
    
    	public int compare(Point pt1, Point pt2){
    	
    		double x = slopeTo(pt1);
    		double y = slopeTo(pt2);
    		
    		if ( x - y < 0)
    			return -1;
    		if (x - y > 0 )
    			return +1;
    		
    		return 0;
    	}    	
    };

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        
    	if (that.x == this.x && that.y == this.y)
    		return Double.NEGATIVE_INFINITY;
    	else if(that.x == this.x)
        	return Double.POSITIVE_INFINITY;
    	else if (that.y == this.y)
    		return 0;
    	else 
    		return (double)(that.y - this.y) / (that.x - this.x);        
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
    	
    	if (this.y < that.y)
    		return -1;
    	else if (this.y > that.y)
    		return 1;
    	else
    	{
    		if (this.x < that.x)
    			return -1;
    		else if (this.x > that.x)
    			return 1;
    		else
    			return 0;
    	}    	
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        
    	Point a = new Point(9,2);
    	
    	Point b = new Point(9,3);
    	
    	Point c = new Point(9,3);
    	
    	int x = a.SLOPE_ORDER.compare(b, c);
    	StdOut.print(x);    	
    }
}