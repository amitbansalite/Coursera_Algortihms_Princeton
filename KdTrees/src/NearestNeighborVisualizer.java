/*************************************************************************
 *  Compilation:  javac NearestNeighborVisualizer.java
 *  Execution:    java NearestNeighborVisualizer input.txt
 *  Dependencies: PointSET.java KdTree.java Point2D.java In.java StdDraw.java
 *
 *  Read points from a file (specified as a command-line argument) and
 *  draw to standard draw. Highlight the closest point to the mouse.
 *
 *  The nearest neighbor according to the brute-force algorithm is drawn
 *  in red; the nearest neighbor using the kd-tree algorithm is drawn in blue.
 *
 *************************************************************************/

public class NearestNeighborVisualizer {

    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        StdDraw.show(0);

        // initialize the two data structures with point from standard input
        KdTree kdtree = new KdTree();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            kdtree.insert(p);
        }

        // draw the points
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.01);
        //kdtree.draw();
        StdDraw.show(0);
                  

        // draw in blue the nearest neighbor (using kd-tree algorithm)        
        Point2D p = new Point2D(0.40, 0.28);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.setPenRadius(.03);
        p.draw();
        StdDraw.show(0);
        
        
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.02);
        Point2D nearestPoint = kdtree.nearest(p);
        StdDraw.line(p.x(), p.y(), nearestPoint.x(), nearestPoint.y());
        StdDraw.show(0);        
        
        StdOut.print("Nearest point to given point " + p.toString() + " is : " + nearestPoint.toString());
    }
}