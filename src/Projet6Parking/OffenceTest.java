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
		User r=new User("Gaetan", "Gortz", "0477688808", "he201732@students.ephec.be","87tx3", 0);
		User f=new User("Nath", "DL","0478262700", "he201742@students.ephec.be", "1gfp497",1);
		Place p = new Place();
		Date d=new Date();
		String commentLong="Intra reducti bellatores bellatores si quis insistebant moenia moenia ita quis se telaque bellatores telaque si reducti";
		String commentCourt="Intra reducti bellatores bellatores si quis insist";
		Offence test1 = new Offence(r, f, commentLong, p, d);
		assertEquals(commentCourt,test1.getComment());
		User r2=new User("Gaetan", "Gortz", "0477688808", "he201732@students.ephec.be","87tx3", 0);
		User f2=new User("Nath", "DL","0478262700", "he201742@students.ephec.be", "1gfp497",1);
		Place p2 = new Place(3,4,5);
		Date d2=new Date();
		String commentLong2="Intra reducti bellatores bellatores si quis insistebant moenia moenia ita quis se telaque bellatores telaque si reducti";
		String commentCourt2="Intra reducti bellatores bellatores si quis insist";
		Offence test2 = new Offence(r, f, "", p, d);
		test2.setComment(commentLong2);
		assertEquals(commentCourt,test1.getComment());
		
	}

}
