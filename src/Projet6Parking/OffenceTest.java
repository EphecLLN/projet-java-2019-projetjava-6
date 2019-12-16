/**
 * 
 */
package Projet6Parking;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

/**
 * @author gaeta_2b6psqs
 *
 */
class OffenceTest {

	/**
	 * Test method for {@link Projet6Parking.Offence#setComment(java.lang.String)}.
	 */
	@Test
	void testSetComment() {
		User r=new User(1, "gGortz", "motdepasse", "Gaetan", "Gortz", "0477688808", "he201732@students.ephec.be","87tx3");
		User f=new User(2, "nDL", "nathan", "Nath", "DL","0478262700", "he201742@students.ephec.be", "1gfp497");
		Parking test1 = new Parking(1, "Baudoin 1er", "Boulevard Baudoin Ier", 284, 284, "Gratuit");
		Place p = new Place(3, test1, 5);
		Date d=new Date();
		String commentLong="Intra reducti bellatores bellatores si quis insistebant moenia moenia ita quis se telaque bellatores telaque si reducti";
		String commentCourt="Intra reducti bellatores bellatores si quis insist";
		Offence test12 = new Offence(1, r, f, commentLong, p, d);
		assertEquals(commentCourt,test12.getComment());
		User r2=new User(1, "gGortz", "motdepasse", "Gaetan", "Gortz", "0477688808", "he201732@students.ephec.be","87tx3");
		User f2=new User(2, "nDL", "nathan","Nath", "DL","0478262700", "he201742@students.ephec.be", "1gfp497");
		Parking test2 = new Parking(2, "Baudoin 1er", "Boulevard Baudoin Ier", 284, 284, "Gratuit");
		Place p2 = new Place(3, test2, 5);
		Date d2=new Date();
		String commentLong2="Intra reducti bellatores bellatores si quis insistebant moenia moenia ita quis se telaque bellatores telaque si reducti";
		String commentCourt2="Intra reducti bellatores bellatores si quis insist";
		Offence test3 = new Offence(2, r2, f2, "", p2, d2);
		test3.setComment(commentLong2);
		assertEquals(commentCourt2,test3.getComment());
		
	}

}
