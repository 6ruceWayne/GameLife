package game;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LifeTest {

	@Test
	public void testGetNeighbors() {
		LifeLogic life = new LifeLogic(10, 10);
		assertTrue(life.getNeighbors(3, 5) == 0);
		life.setCell(1, 0);
		life.setCell(0, 1);
		life.setCell(1, 1);
		assertTrue(life.getNeighbors(0, 0) == 3);
	}

	@Test
	public void testSetCell() {
		LifeLogic life = new LifeLogic(200, 100);
		life.setCell(3, 5);
		assertTrue(life.cells[3][5] == 1);
	}

	@Test
	public void testRemoveCell() {
		LifeLogic life = new LifeLogic(200, 100);
		life.removeCell(3, 5);
		assertTrue(life.cells[3][5] == 0);
	}

	@Test
	public void testNext() {
		LifeLogic life = new LifeLogic(7, 7);
		life.setCell(5, 3);
		life.setCell(5, 4);
		life.setCell(5, 5);
		life.next();
		assertTrue(life.getCell(4, 4) == 1);
		assertTrue(life.getCell(5, 4) == 1);
		assertTrue(life.getCell(6, 4) == 1);
	}

	@Test
	public void testGetPopulation() {
		LifeLogic life = new LifeLogic(200, 100);
		assertTrue(life.getPopulation() != null);
	}

	@Test
	public void testGetCell() {
		LifeLogic life = new LifeLogic(200, 100);
		assertTrue(life.getCell(3, 5) == 0);
	}

	@Test
	public void textGetCountPopulation() {
		LifeLogic life = new LifeLogic(10, 10);
		life.next();
		assertTrue(life.getCountPopulation() == 1);
	}

	@Test
	public void textIsGameOver() {
		LifeLogic life = new LifeLogic(200, 100);
		assertTrue(life.isGameOver());
	}

}
