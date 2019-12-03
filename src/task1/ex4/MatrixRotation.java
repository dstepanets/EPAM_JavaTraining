package task1.ex4;

import java.util.Random;

class MatrixRotation {

	private int size;
	private int[][] matrix;

	MatrixRotation(int size) throws IllegalArgumentException {
		if (size < 1 || size > 1000) {
			throw new IllegalArgumentException("Matrix size should be in range 1-1000");
		}

		this.size = size;
		generateMatrix();
	}

	private void generateMatrix() {
		matrix = new int[size][size];
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = rand.nextInt(200) - 100;
			}
		}
	}

	private int[][] rotateCounterClockwise() {
		int[][] rotated = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				rotated[i][j] = matrix[j][size - i - 1];
			}
		}
		return rotated;
	}

	private void printMatrix(int[][] m) {
		for (int i = 0; i < size; i++) {
			System.out.print("|");
			for (int j = 0; j < size; j++) {
				System.out.printf("%3d|", m[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		try {
			MatrixRotation rotator = new MatrixRotation(5);
			rotator.printMatrix(rotator.matrix);
			System.out.println();
			rotator.printMatrix(rotator.rotateCounterClockwise());
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}

	}

}