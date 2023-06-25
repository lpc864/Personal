package divide_and_conquer;

import java.util.Arrays;

import divide_and_conquer.ClosestPair_FuerzaBruta.Point;
import divide_and_conquer.ClosestPair_FuerzaBruta.Result;

public class ClosestPair_DyV extends ClosestPair_FuerzaBruta {

	private static Result closestPairPrivate(Point[] points, int inicio, int fin) {
		if ((fin - inicio) + 1 <= 3) {
			return closestPairBruteForce(points);
		}

		int mitad = (fin + inicio) / 2;
		Result resultLeft = closestPairPrivate(points, inicio, mitad);
		Result resultRight = closestPairPrivate(points, mitad, fin);

		Result smallerLeftRight = resultLeft.distancia < resultRight.distancia ? resultLeft : resultRight;
		double smallerLeftRightDistance = smallerLeftRight.distancia;

		Point middlePoint = points[mitad];
		Point[] strip = new Point[fin + 1];

		int i = 0;
		for (int j = 0; j < strip.length; j++) {
			if (points[j] != middlePoint && Math.abs(points[j].x - middlePoint.x) < smallerLeftRightDistance) {
				strip[j] = points[i];
				i++;
			}
		}
		
		Arrays.sort(strip, new PointYComparator());
		
		Result smallerStrip = closestPairBruteForce(strip);
		double smallerStripDistance = smallerStrip.distancia;

		return smallerLeftRightDistance < smallerStripDistance ? smallerLeftRight : smallerStrip;
	}

	public static Result closestPair(Point[] points) {
		Arrays.sort(points, new PointXComparator());

		return closestPairPrivate(points, 0, points.length - 1);
	}

	public static void main(String[] args) {
		Point[] P1 = new Point[] { 
				new Point(2, 3), 
				new Point(12, 30), 
				new Point(40, 50), 
				new Point(5, 1),
				new Point(12, 10), 
				new Point(3, 4) };

		Result result = closestPairBruteForce(P1);
		System.out.println(
				"\nThe smallest distancia is " + result.distancia + ". The distancia is between (" + result.puntoA.x
						+ ", " + result.puntoA.y + ") and (" + result.puntoB.x + ", " + result.puntoB.y + ")");
		
		Point[] P2 = new Point[] {
	            new Point(2, 3),
	            new Point(12, 30),
	            new Point(40, 50),
	            new Point(5, 1),
	            new Point(12, 10),
	            new Point(3, 4)
	        };
		
		result = closestPairBruteForce(P2);
		System.out.println(
				"\nThe smallest distancia is " + result.distancia + ". The distancia is between (" + result.puntoA.x
						+ ", " + result.puntoA.y + ") and (" + result.puntoB.x + ", " + result.puntoB.y + ")");
		
		 Point[] P3 = new Point[] {
		            new Point(0, 0),
		            new Point(5, 5),
		            new Point(10, 10),
		            new Point(15, 15),
		            new Point(20, 20),
		            new Point(25, 25)
		        };
		 
		 result = closestPairBruteForce(P3);
			System.out.println(
					"\nThe smallest distancia is " + result.distancia + ". The distancia is between (" + result.puntoA.x
							+ ", " + result.puntoA.y + ") and (" + result.puntoB.x + ", " + result.puntoB.y + ")");
		 
		 Point[] P4 = new Point[] {
		            new Point(1, 1),
		            new Point(2, 2),
		            new Point(3, 3),
		            new Point(4, 4),
		            new Point(5, 5),
		            new Point(6, 6)
		        };
		 
		 result = closestPairBruteForce(P4);
			System.out.println(
					"\nThe smallest distancia is " + result.distancia + ". The distancia is between (" + result.puntoA.x
							+ ", " + result.puntoA.y + ") and (" + result.puntoB.x + ", " + result.puntoB.y + ")");
	
	}
}
