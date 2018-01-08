package game;

public class LifeLogic {
	int[][] cells;
	int count = 0;

	public LifeLogic(int width, int hieght) {

		int cells[][] = new int[width][hieght];
		this.cells = cells;
	}

	public int getNeighbors(int x, int y) {
		int count = 0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (i != j || i != 0 || j != 0) {
					if ((x + i < 0) || (y + j < 0) || (x + i > cells.length - 1) || (y + j > cells[1].length - 1)) {
						continue;
					} else {
						if (cells[x + i][y + j] == 1) {
							count++;
						}
					}
				}
			}
		}
		return count;
	}

	public void next() {
		int newCells[][] = new int[cells.length][cells[1].length];
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[1].length; j++) {
				int neighbors = getNeighbors(i, j);
				if (cells[i][j] == 1) {
					if (neighbors == 2 || neighbors == 3) {
						newCells[i][j] = 1;
					}
				} else {
					if (neighbors == 3) {
						newCells[i][j] = 1;
					}
				}
			}
		}
		cells = newCells;
		count++;
	}

	public int[][] getPopulation() {
		return cells;
	}

	public void setCell(int x, int y) {
		cells[x][y] = 1;
	}

	public int getCell(int x, int y) {
		return cells[x][y];
	}

	public void removeCell(int x, int y) {
		cells[x][y] = 0;
	}

	public int getCountPopulation() {
		return count;
	}

	public boolean isGameOver() {
		int count = 0;
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[1].length; j++) {
				if (cells[i][j] == 1) {
					count++;
				}
			}
		}
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}
}
