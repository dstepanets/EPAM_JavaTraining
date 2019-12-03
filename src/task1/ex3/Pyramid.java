package task1.ex3;

class Pyramid {

	private int height;
	private int width;
	private int[][] pyramid;

	Pyramid(int height) throws IllegalArgumentException {
		if (height < 1 || height > 9)
			throw new IllegalArgumentException("Pyramid height must be in range 1-9.");

		this.height = height;
		this.width = height * 2 - 1;
		pyramid = new int[height][width];
	}

	private int[][] fillPyramid() {

		for (int row = height - 1; row >= 0; row--) {
			int val = row + 1;
			for (int l = height - 1, r = height - 1; val > 0; l--, r++) {
				pyramid[row][l] = val;
				pyramid[row][r] = val;
				val--;
			}
		}

		return pyramid;
	}

	private void printPyramid() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (pyramid[i][j] == 0) {
					System.out.print(" ");
				} else {
					System.out.print(pyramid[i][j]);
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		try {
			Pyramid pyra = new Pyramid(9);
			pyra.fillPyramid();
			pyra.printPyramid();

		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}

	}
}