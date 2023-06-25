package divide_and_conquer;

import java.util.Comparator;

public class ClosestPair_FuerzaBruta {

	protected static class Point {
		protected int x;
		protected int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
	
	protected static class PointXComparator implements Comparator<Point> {

		@Override
		public int compare(Point o1, Point o2) {
			// TODO Auto-generated method stub
			return Integer.compare(o1.x, o2.x);
		}
		
	}
	
	protected static class PointYComparator implements Comparator<Point> {

		@Override
		public int compare(Point o1, Point o2) {
			// TODO Auto-generated method stub
			return Integer.compare(o1.y, o2.y);
		}
		
	}
	
	protected static class Result {
		protected Point puntoA;
		protected Point puntoB;
		protected double distancia;

		public Result(Point puntoA, Point puntoB, double distancia) {
			this.puntoA = puntoA;
			this.puntoB = puntoB;
			this.distancia = distancia;
		}
	}

	public static double distanciaEuclidea(Point puntoA, Point puntoB) {
		return Math.sqrt(Math.pow(puntoA.x - puntoB.x, 2) + Math.pow(puntoA.y - puntoB.y, 2));
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static Result closestPairBruteForce(Point[] points) {
		Result result = new Result(points[0], points[1], distanciaEuclidea(points[0], points[1]));

		int tamano = points.length;

		for (int i = 0; i < tamano; i++) {
			for (int j = i + 1; j < tamano; j++) {
				double distanciaEuclidea = distanciaEuclidea(points[i], points[j]);
				if (distanciaEuclidea < result.distancia) {
					result.puntoA = points[i];
					result.puntoB = points[j];
					result.distancia = distanciaEuclidea;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Point[] P = new Point[] { new Point(2, 3), 
								  new Point(12, 30), 
								  new Point(40, 50), 
								  new Point(5, 1),
								  new Point(12, 10), 
								  new Point(3, 4) };

		Result result = closestPairBruteForce(P);
		System.out.println(
				"The smallest distancia is " + result.distancia + ". The distancia is between (" + result.puntoA.x
						+ ", " + result.puntoA.y + ") and (" + result.puntoB.x + ", " + result.puntoB.y + ")");
	}
}
