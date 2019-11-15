/**
 * 
 */
package Projet6Parking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author nathdl
 *
 */
class ParkingTest {

	/**
	 * Test method for {@link Projet6Parking.Parking#placeAvail()}.
	 */
	@Test
	void testPlaceAvail() {
		Parking test1 = new Parking("Boulevard Baudoin Ier", 284);
		assertEquals(284, test1.placeAvail());
		test1.setPlacesDispo(test1.getPlacesDispo() - 1); // Simulation de la réservation d'une place
		assertEquals(283, test1.placeAvail());
		Parking test2 = new Parking("Boulevard Baudoin Ier", 284);
		assertEquals(284, test2.placeAvail());
		test2.setPlacesDispo(test2.getPlacesDispo() + 1); // Simulation de la libération d'une place
		assertEquals(285, test2.placeAvail());
		
	}
	
	/**
	 * Test method for {@link Projet6Parking.Parking#addPlace(int)}.
	 */
	@Test
	void testAddPlace() {
		Parking test1 = new Parking("Boulevard Baudoin Ier", 284);
		test1.addPlace(3);
		assertEquals(287, test1.getPlacesTot());
		assertEquals(287, test1.getPlacesDispo());
		Parking test2 = new Parking("Boulevard Baudoin Ier", 284);
		test2.addPlace(-3);
		assertEquals(284, test2.getPlacesTot());
		assertEquals(284, test2.getPlacesDispo());
		Parking test3 = new Parking("Boulevard Baudoin Ier", 284);
		test3.addPlace(0);
		assertEquals(284, test3.getPlacesTot());
		assertEquals(284, test3.getPlacesDispo());
	}

	/**
	 * Test method for {@link Projet6Parking.Parking#deletePlace(int)}.
	 */
	@Test
	void testDeletePlace() {
		Parking test1 = new Parking("Boulevard Baudoin Ier", 284);
		test1.deletePlace(3);
		assertEquals(281, test1.getPlacesTot());
		assertEquals(281, test1.getPlacesDispo());
		Parking test2 = new Parking("Boulevard Baudoin Ier", 284);
		test2.deletePlace(-3);
		assertEquals(284, test2.getPlacesTot());
		assertEquals(284, test2.getPlacesDispo());
		Parking test3 = new Parking("Boulevard Baudoin Ier", 284);
		test3.deletePlace(0);
		assertEquals(284, test3.getPlacesTot());
		assertEquals(284, test3.getPlacesDispo());
	}

}
