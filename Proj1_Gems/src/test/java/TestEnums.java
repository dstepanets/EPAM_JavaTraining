import gems.model.Color;
import gems.model.Variety;
import gems.view.MenuOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEnums {

	@Test
	public void testVariety() {
//		test enum method that returns value from index
		assertEquals(Variety.DIAMOND, Variety.valueOf(0)) ;
		assertEquals(Variety.EMERALD, Variety.valueOf(1)) ;
		assertEquals(Variety.RUBY, Variety.valueOf(2)) ;
		assertEquals(Variety.SAPPHIRE, Variety.valueOf(3)) ;

		assertEquals("Sapphire", Variety.SAPPHIRE.getName()) ;
		assertEquals("Emerald", Variety.EMERALD.getName()) ;
	}

	@Test
	public void testColor() {
		assertEquals("green", Color.GREEN.getColorName()) ;
		assertEquals("red", Color.RED.getColorName()) ;
	}

	@Test
	public void testMenuOption() {
		assertEquals("Exit the program", MenuOption.EXIT.getDescription()) ;
	}



}
