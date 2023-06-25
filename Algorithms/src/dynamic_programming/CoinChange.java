package dynamic_programming;

import divide_and_conquer.QuickSort;

public class CoinChange {

	private static final int INF = Integer.MAX_VALUE;

	public static void coinChange(int[] monedas, int monto) {
		QuickSort.quickSort(monedas, 0, monedas.length - 1);
		
		int numeroMonedas = monedas.length;
		int[][] numeroMonedasXMonto = new int[numeroMonedas + 1][monto + 1];

		for (int i = 1; i < monto + 1; i++) {
			numeroMonedasXMonto[0][i] = INF;
		}

		for (int i = 0; i < numeroMonedas + 1; i++) {
			numeroMonedasXMonto[i][0] = 0;
		}

		// j = monto actual
		for (int i = 1; i < numeroMonedas + 1; i++) {
			for (int j = 1; j < monto + 1; j++) {
				if (monedas[i - 1] > j) {
					numeroMonedasXMonto[i][j] = numeroMonedasXMonto[i - 1][j];
				} else {
					// Se ha de elegir si se coge la moneda o no
					// Se supone que se coge y se compara con valores previos
					// Obviamente si se supone que se coge se suma 1
					// j - monedas[i-1] me da la diferencia entre el monto actual y se se ha cogido
					// la moneda
					// Cuando se usa como indexador en la matriz indica el numero de monedas de las
					// otras que se necesitarian para suplir la diferencia (si existiera)
					int diferencia = j - monedas[i - 1];
					if (1 + numeroMonedasXMonto[i][diferencia] > numeroMonedasXMonto[i - 1][j]) {
						numeroMonedasXMonto[i][j] = numeroMonedasXMonto[i - 1][j];
					} else {
						numeroMonedasXMonto[i][j] = 1 + numeroMonedasXMonto[i][diferencia];
					}
				}
			}
		}

		System.out.println("Matriz resultado");
		System.out.println("----------------");
		System.out.println();

		for (int i = 1; i < numeroMonedas + 1; i++) {
			for (int j = 1; j < monto + 1; j++) {
				if (numeroMonedasXMonto[i][j] == INF) {
					System.out.print("INF ");
				} else {
					System.out.print(numeroMonedasXMonto[i][j] + " ");
				}
			}
			System.out.println();
		}

		System.out.println();

		int[] resultado = new int[numeroMonedas];
		int monedaEsEscogida = numeroMonedas;
		int montoVariable = monto;
		while (monedaEsEscogida != 0 && montoVariable != 0) {
			if (numeroMonedasXMonto[monedaEsEscogida][montoVariable] == numeroMonedasXMonto[monedaEsEscogida - 1][montoVariable]) {
				monedaEsEscogida--;
			} else {
				resultado[monedaEsEscogida - 1]++;
				montoVariable -= monedas[monedaEsEscogida - 1];
			}
		}

		System.out.println("Solucion");
		System.out.println("--------");
		System.out.println();

		for (int i = 0; i < resultado.length; i++) {
			System.out.println(monedas[i] + " --> " + resultado[i]);
		}
		
		System.out.println();
		System.out.println("Numero total monedas usadas: " + numeroMonedasXMonto[numeroMonedas][monto]);

	}

	public static void main(String[] args) {
		/*int n = 3 *  100000;
		int P = 9  *  100000;
		
		int[] coins = new int[n];
		
		for (int i = 0; i < coins.length; i++) {
			coins[i] = i;
		}*/
		int coins[] = { 1, 2, 3 };
		//int coins[] = { 4, 3, 1, 5 };
		//int coins[] = { 2, 3, 5 };
		
		int sum = 9;
		//int sum = 4;
		//int sum = 9;
		//int sum = 19;

		coinChange(coins, sum);
	}
}
