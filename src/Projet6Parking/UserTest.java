package Projet6Parking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void testPenalty() {
		User test1 = new User("Luk", "Brian", "047768985", "he201676@hotmail.com", "A32FE", 2);
		assertEquals(2, test1.getPenalty());
		User test2 = new User("Luk", "Brian", "047768985", "he201676@hotmail.com", "A32FE", 5);
		assertEquals(5, test2.getPenalty());
	}

}