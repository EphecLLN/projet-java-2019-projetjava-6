package Projet6Parking;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void testPenalty() {
		User test1 = new User(1, "bLuk", "1234", "Luk", "Brian", "047768985", "he201676@hotmail.com", "A32FE");
		assertEquals(0, test1.getPenalty());
		User test2 = new User(2, "bLuk", "1234", "Luk", "Brian", "047768985", "he201676@hotmail.com", "A32FE");
		test2.setPenalty(5);
		assertEquals(5, test2.getPenalty());
	}

}