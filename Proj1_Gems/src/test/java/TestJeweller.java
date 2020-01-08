import gems.controller.Jeweller;
import gems.model.Color;
import gems.model.GemBuilder;
import gems.model.Variety;
import gems.model.stones.AGem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestJeweller {

	private Jeweller jeweller = new Jeweller();
	private List<AGem> lace1 = new ArrayList<>();
	private List<AGem> lace2 = new ArrayList<>();

	@Before
	public void setUp() {

//		build necklace from 4 gems in descending order of their params
		for (int i = 4; i > 0; i--) {
			addGem(lace1, i - 1, i, i);
		}
//		build custom necklace
		addGem(lace2, 1, 12.6, 50);
		addGem(lace2, 3, 7.4, 100);
		addGem(lace2, 2, 25.0, 25);
		addGem(lace2, 1, 100.0, 80);
		addGem(lace2, 0, 77, 33);

		jeweller.setNeclace(lace1);
	}

	private void addGem(List<AGem> lace, int variety, double weight, int clarity) {
		GemBuilder builder = jeweller.getBuilder();
		builder.setVariety(Variety.valueOf(variety));
		builder.setWeight(weight);
		builder.setClarity(clarity);
		lace.add(builder.getGem());
	}

	@Test
	public void testAddGem() {
		List<AGem> lace = new ArrayList<>();
		jeweller.setNeclace(lace);
//		replace standard input with simulation
		ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n1\n".getBytes());
		System.setIn(in);
//		check if the element is added
		jeweller.addGem();
		assertEquals(1, lace.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBuilder1() {
//		invalid weight
		addGem(lace2, 1, 0, 50);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testBuilder2() {
//		invalid clarity
		addGem(lace2, 2, 50, 101);
	}

	@Test
	public void testCalcs() {
		jeweller.setNeclace(lace1);
		assertEquals(10.0, jeweller.calcWeight(), 0.001);
		assertEquals(1800, jeweller.calcPrice());

		jeweller.setNeclace(lace2);
		assertEquals(222.0, jeweller.calcWeight(), 0.001);
		assertEquals(1255625, jeweller.calcPrice());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveGem() {
		jeweller.setNeclace(lace1);
		assertEquals(4, jeweller.getNeclace().size());
//		remove the 1st elem and check if the size has changed
		jeweller.removeGem(1);
		assertEquals(3, jeweller.getNeclace().size());
//		make sure that the 2nd element became the 1st
		assertEquals(Variety.RUBY, jeweller.getNeclace().get(0).getVariety());
//		exception is expected
		jeweller.removeGem(4);
	}

	@Test
	public void testResetNecklace() {
		assertEquals(4, jeweller.getNeclace().size());
		jeweller.resetNecklace();
		assertEquals(0, jeweller.getNeclace().size());
	}


	@Test
	public void testSortNecklace() {
		boolean isSorted = true;
		for (int i = 0; i < lace1.size() - 1; i++) {
//			check if all elements are in descending order
			if (lace1.get(i).getPrice() > lace1.get(i + 1).getPrice())
				isSorted = false;
		}
		assertFalse(isSorted);

		jeweller.sortNecklace();

		for (int i = 0; i < lace1.size() - 1; i++) {
//			array should be in ascending order now
			assertTrue(lace1.get(i).getPrice() <= lace1.get(i + 1).getPrice());
		}
	}

	@Test
	public void testGetGemsByClarity() {

		List<AGem> selection = jeweller.getGemsByClarity(1, 3);
		assertTrue(selection.size() == 3);
		for (AGem g : selection) {
			assertTrue(g.getClarity() >= 1 && g.getClarity() <= 3);
		}

		jeweller.setNeclace(lace2);
		selection = jeweller.getGemsByClarity(80, 100);
		assertTrue(selection.size() == 2);
		for (AGem g : selection) {
			assertTrue(g.getClarity() >= 80 && g.getClarity() <= 100);
		}


	}


}

