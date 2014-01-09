import java.util.Arrays;

public class Fast {

	public static void main(String[] args) {

		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);

		String filename = args[0];
		In in = new In(filename);

		int count = in.readInt();
		Point[] pts = new Point[count];

		for (int i = 0; i < count; i++) {
			int x = in.readInt();
			int y = in.readInt();
			pts[i] = new Point(x, y);
			pts[i].draw();
		}

		Point[] slopeOrder = new Point[count];
		for (int i = 0; i < count; i++) {
			slopeOrder[i] = pts[i];
		}

		for (int i = 0; i < count; i++) {
			Arrays.sort(slopeOrder, pts[i].SLOPE_ORDER);

			for (int j = 0; j < count; j++) {

				double a = pts[i].slopeTo(slopeOrder[j]);

				if (j + 2 < count) {
					double b = pts[i].slopeTo(slopeOrder[j + 1]);
					double c = pts[i].slopeTo(slopeOrder[j + 2]);
					
					if (a == b && b == c) {
						
						Point[] tmp = new Point[4];
						tmp[0] = pts[i];
						tmp[1] = slopeOrder[j];
						tmp[2] = slopeOrder[j+1];
						tmp[3] = slopeOrder[j+2];
						
						
						Arrays.sort(tmp);
						if(tmp[0].compareTo(pts[i]) == 0){
							
							StdOut.print(tmp[0].toString() + " -> ");
							StdOut.print(tmp[1].toString() + " -> ");
							StdOut.print(tmp[2].toString() + " -> ");
							StdOut.print(tmp[3].toString() + "\n");

							tmp[0].drawTo(tmp[3]);							
						}
						j = j + 2;
					}
				}
			}
		}

	}
}
