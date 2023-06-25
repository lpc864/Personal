package divide_and_conquer;

public class MatrixMultiplication_DyV extends MatrixMultiplication {

	public static int[][] subtractMatrix(int[][] matrixA, int[][] matrixB) {
		int matrixResultDimension = matrixA.length;
		int[][] result = new int[matrixResultDimension][matrixResultDimension];
		for (int i = 0; i < matrixResultDimension; i++) {
			for (int j = 0; j < matrixResultDimension; j++) {
				result[i][j] = matrixA[i][j] - matrixB[i][j];
			}
		}
		return result;
	}

	public static int[][]addMatrix(int[][] matrixA, int[][] matrixB) {
		int matrixResultDimension = matrixA.length;
		int[][] result = new int[matrixResultDimension][matrixResultDimension];
		for (int i = 0; i < matrixResultDimension; i++) {
			for (int j = 0; j < matrixResultDimension; j++) {
				result[i][j] = matrixA[i][j] + matrixB[i][j];
			}
		}
		return result;
	}

	public static void fillMatrix(int[][] matrix, int[][] matrix11, int[][] matrix12, int[][] matrix21,
			int[][] matrix22, int splitIndex) {
		for (int i = 0; i < splitIndex; i++) {
			for (int j = 0; j < splitIndex; j++) {
				matrix11[i][j] = matrix[i][j];
				matrix12[i][j] = matrix[i][j + splitIndex];
				matrix21[i][j] = matrix[i + splitIndex][j];
				matrix22[i][j] = matrix[i + splitIndex][j + splitIndex];
			}
		}
	}

	public static int[][] matrixMultiplication_DyV(int[][] matrixA, int[][] matrixB) {
		if (matrixA[0].length != matrixB.length) {
			throw new RuntimeException(
					"Deben coincidir las columnas de la primera matriz con respecto a las filas de la segunda matriz");
		}
		if (matrixA.length != matrixA[0].length || matrixB.length != matrixB[0].length) {
			throw new RuntimeException("Las matrices deben ser cuadradas");
		}
		if (matrixA.length == 1) {
			return new int[][] { { matrixA[0][0] * matrixB[0][0] } };
		}
		if (matrixA.length % 2 != 0) {
			throw new RuntimeException("Las matrices deben ser potencia de dos");
		}

		int splitIndex = matrixA.length / 2;

		int[][] matrixA11 = new int[splitIndex][splitIndex];
		int[][] matrixA12 = new int[splitIndex][splitIndex];
		int[][] matrixA21 = new int[splitIndex][splitIndex];
		int[][] matrixA22 = new int[splitIndex][splitIndex];

		int[][] matrixB11 = new int[splitIndex][splitIndex];
		int[][] matrixB12 = new int[splitIndex][splitIndex];
		int[][] matrixB21 = new int[splitIndex][splitIndex];
		int[][] matrixB22 = new int[splitIndex][splitIndex];

		int[][] result11 = new int[splitIndex][splitIndex];
		int[][] result12 = new int[splitIndex][splitIndex];
		int[][] result21 = new int[splitIndex][splitIndex];
		int[][] result22 = new int[splitIndex][splitIndex];

		int[][] result = new int[matrixA.length][matrixB[0].length];

		fillMatrix(matrixA, matrixA11, matrixA12, matrixA21, matrixA22, splitIndex);
		fillMatrix(matrixB, matrixB11, matrixB12, matrixB21, matrixB22, splitIndex);

		result11 = addMatrix(matrixMultiplication(matrixA11, matrixB11), matrixMultiplication(matrixA12, matrixB21));
		result12 = addMatrix(matrixMultiplication(matrixA11, matrixB12), matrixMultiplication(matrixA12, matrixB22));
		result21 = addMatrix(matrixMultiplication(matrixA21, matrixB11), matrixMultiplication(matrixA22, matrixB21));
		result22 = addMatrix(matrixMultiplication(matrixA21, matrixB12), matrixMultiplication(matrixA22, matrixB22));

		for (int i = 0; i < splitIndex; i++) {
			for (int j = 0; j < splitIndex; j++) {
				result[i][j] = result11[i][j];
				result[i][j + splitIndex] = result12[i][j];
				result[i + splitIndex][j] = result21[i][j];
				result[i + splitIndex][j + splitIndex] = result22[i][j];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println("Multiplicacion de matrices");
		System.out.println("--------------------------\n");

		int[][] matrixA = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 2, 2, 2, 2 } };

		System.out.println("Matrix A");
		System.out.println("--------");
		printMatrix(matrixA);

		int[][] matrixB = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 2, 2, 2, 2 } };

		System.out.println("Matrix B");
		System.out.println("--------");
		printMatrix(matrixB);

		System.out.println("Matrix AxB");
		System.out.println("----------");
		int[][] result = matrixMultiplication_DyV(matrixA, matrixB);
		printMatrix(result);
	}
}
