/*************************************************************************
 *  Compilation:  javac RangeSearchVisualizer.java
 *  Execution:    java RangeSearchVisualizer input.txt
 *  Dependencies: PointSET.java KdTree.java Point2D.java RectHV.java
 *                StdDraw.java In.java
 *
 *  Read points from a file (specified as a command-line arugment) and
 *  draw to standard draw. Also draw all of the points in the rectangle
 *  the user selects by dragging the mouse.
 *
 *  The range search results using the brute-force algorithm are drawn
 *  in red; the results using the kd-tree algorithms are drawn in blue.
 *
 *************************************************************************/

public class RangeSearchVisualizer {

    public static void main(String[] args) {

        String filename = args[0];
        In in = new In(filename);


        //StdDraw.show(0);

        // initialize the data structures with N points from standard input
        //PointSET brute = new PointSET();
        KdTree kdtree = new KdTree();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            kdtree.insert(p);
           // brute.insert(p);
        }

        double x0 = 0.1, y0 = 0.2;      // initial endpoint of rectangle
        double x1 = 0.4, y1 = 0.5;      // current location of mouse
        
        // draw the points
        /*StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.01);
        kdtree.draw();
        StdDraw.show(0);*/

        
        RectHV rect = new RectHV(x0, y0, x1, y1);
        
        // draw the rectangle
        /*    StdDraw.setPenColor(StdDraw.YELLOW);
            rect.draw();
            StdDraw.show(0);
*/            
            
            // draw the range search results for kd-tree in blue
            
            StdDraw.setPenRadius(0.04);
            StdDraw.setPenColor(StdDraw.BLUE);
            for (Point2D p : kdtree.range(rect)){
              /*  p.draw();
                StdDraw.show(0);*/
            	
            	StdOut.print(p.toString() + "\n");
            }
            
            StdOut.print("Done");
            
        
    }
}