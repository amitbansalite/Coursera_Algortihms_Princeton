import java.util.Arrays;

public class Brute {

	public static void main(String[] args) {

		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);

		String filename = args[0];
		In in = new In(filename);

		int N = in.readInt();
		Point[] pts = new Point[N];

		for (int i = 0; i < N; i++) {
			int x = in.readInt();
			int y = in.readInt();
			pts[i] = new Point(x, y);
			pts[i].draw();
		}

		Arrays.sort(pts);

		for (int i = 0; i < N; i++) {

			for (int j = i + 1; j < N; j++) {
				double a = pts[i].slopeTo(pts[j]);

				for (int m = j + 1; m < N; m++) {
					double b = pts[i].slopeTo(pts[m]);

					boolean flag = false;
					if (Double.isInfinite(a) && Double.isInfinite(b))
						flag = true;
					else if (Double.compare(a, b) == 0)
						flag = true;
					else
						continue;

					for (int n = m + 1; n < N; n++) {
						double c = pts[i].slopeTo(pts[n]);
						flag = false;

						if (Double.isInfinite(a) && Double.isInfinite(b)
								&& Double.isInfinite(c))
							flag = true;
						else if (Double.compare(a, b) == 0
								&& Double.compare(b, c) == 0)
							flag = true;

						if (flag) {
							StdOut.print(pts[i].toString() + " -> "
									+ pts[j].toString() + " -> "
									+ pts[m].toString() + " -> "
									+ pts[n].toString() + "\n");
							pts[i].drawTo(pts[n]);
						}
					}
				}
			}
		}

	}

}
