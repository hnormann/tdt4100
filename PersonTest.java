package stateandbehavior;

import no.hal.jex.runtime.JExercise;
import no.hal.jex.standalone.JexStandalone;
import junit.framework.TestCase;

@JExercise(
	description="An Account must contain two double fields, balance and interestRate, and methods for depositing amounts and computing and adding interest."
)
public class PersonTest extends TestCase {

	private double epsilon = 0.000001d;
	
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
			tests="setName(String)",
			description="The setName(String) sets the name to the argument string, given that the name is within a valid format"
	)
	public void testSetName() {
		person.setName("Ola");
		assertEquals("Ola Nordmann", person.getName());
		person.setName("O N");
		assertEquals("Ola Nordmann", person.getName());
		person.setName("O. Nordmann");
		assertEquals("Ola Nordmann", person.getName());
		person.setName("Espen Askeladd");
		assertEquals("Espen Askeladd", person.getName());
	}

	@JExercise(
		tests="void setBirthday(String)",
		description="The setBirthday(String) should set birthday to input argument, given that the birthday is on a valid format."
	)
	public void testSetBirthday() {
		person.setBirthday("420194");
		assertEquals("010194", person.getBirthday());
		person.setBirthday("121293");
		assertEquals("121293", person.getBirthday());
		person.setBirthday("121393");
		assertEquals("121293", person.getBirthday());
	}
	
	@JExercise(
			tests="void setEmail(String)",
			description="The setEmail(String) should set email to input argument, given that the email is on a valid format"
	)
	public void testSetEmail() {
		person.setEmail("ola@nordmann");
		assertEquals("ola.nordmann@idi.ntnu.no", person.getEmail());
		person.setEmail("ola.normann(at)idi.ntnu.no");
		assertEquals("ola.nordmann@idi.ntnu.no", person.getEmail());
		person.setEmail("x@y.zz");
		assertEquals("x@y.zz", person.getEmail());
		person.setEmail("xx@.zz");
		assertEquals("x@y.zz", person.getEmail());
		person.setEmail("x@y.z");
		assertEquals("x@y.zz", person.getEmail());
	}
	
	@JExercise(
			tests="void setGender(String)",
			description="The setGender(String) should set gedner to input argument, given that the gender is on a valid format"
	)	
	public void testSetGender() {
		person.setGender('F');
		assertEquals('F', person.getGender());
		person.setGender('O');
		assertEquals('F', person.getGender());
	}
}