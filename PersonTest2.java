package encapsulation;

import no.hal.jex.runtime.JExercise;
import no.hal.jex.standalone.JexStandalone;
import junit.framework.TestCase;

@JExercise(
	description="An Account must contain two double fields, balance and interestRate, and methods for depositing amounts and computing and adding interest."
)
public class PersonTest2 extends TestCase {

	private double epsilon = 0.000001d;
	private static int[] factors1 = {3, 7, 6, 1, 8, 9, 4, 5, 2}, factors2 = {5, 
		4, 3, 2, 7, 6, 5, 4, 3, 2}; 
	
	Person person;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		person = new Person();
		person.setName("Ola Nordmann");
		person.setEmail("ola.nordmann@idi.ntnu.no");
		person.setGender('M');
		person.setBirthday("010194");
	}
	
	@JExercise(
			tests="setSocialsec(String socialsec)",
			description="The setSocialsec(String socialsec) sets the social security number to the argument string, given that the social security number t is within a valid format"
	)
	public void testSetSocialsec() {
		try {
			person.setSocialsec("010194111" + generateValid(1, 1, 1, "010194"));
			assertEquals("01019411156", person.getSocialsec());			
		} catch (Exception e ) {
			fail();
		}
		try {
			person.setSocialsec("010194112" + generateValid(1, 1, 2, "010194"));	
			fail();
		} catch (Exception e) {
			assertEquals("01019411156", person.getSocialsec());
		}
		try {
			person.setSocialsec("01019411122");
			fail();
		} catch (Exception e) {
			assertEquals("01019411156", person.getSocialsec());
		}
	}
	
	private static String generateValid(int n1, int n2, int n3, String birthday) {
		birthday = birthday + n1 + n2 + n3;
		System.out.println(birthday);
		int K1 = 0;
		int K2 = 0;
		for(int i = 0; i < birthday.length(); i++) {
			K1 += factors1[i]*Character.getNumericValue(birthday.charAt(i));
			K2 += factors2[i]*Character.getNumericValue(birthday.charAt(i));
		}
		K1 = 11- (K1 % 11);
		if (K1 == 11) {
			K1 = 0;
		}
		K2 += K1*factors2[9];
		K2 = 11 - (K2 % 11);
		if (K2 == 11) {
			K2 = 0;
		}
		return K1 + "" + K2;
	}
	
	public static void main(String[] args) {
		JexStandalone.main(PersonTest2.class);
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/master
