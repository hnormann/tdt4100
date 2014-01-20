package encapsulation;

import no.hal.jex.runtime.JExercise;
import java.util.Date;
import no.hal.jex.standalone.JexStandalone;
import junit.framework.TestCase;

@JExercise(
	description="An Account must contain two double fields, balance and interestRate, and methods for depositing amounts and computing and adding interest."
)
public class PersonTest extends TestCase {

	private double epsilon = 0.000001d;
	
	Person person;
	Date birthday;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		person = new Person();
		person.setName("Ola Nordmann");
		person.setEmail("ola.nordmann@ntnu.no");
		person.setGender('M');
		birthday = new Date(94,1,1);
		person.setBirthday(birthday);
	}
	
	@JExercise(
			tests="setName(String)",
			description="The setName(String) sets the name to the argument string, given that the name is within a valid format"
	)
	public void testSetName() {
		try {
			person.setName("Ola");
			fail();
		} catch (Exception e) {
			assertEquals("Ola Nordmann", person.getName());			
		}
		
		try {
			person.setName("O N");
			fail();
		} catch (Exception e) {
			assertEquals("Ola Nordmann", person.getName());			
		}
		
		try {
			person.setName("O. Nordmann");
			fail();
		} catch (Exception e) {
			assertEquals("Ola Nordmann", person.getName());			
		}
		
		try {
			person.setName("Espen Askeladd");
			assertEquals("Espen Askeladd", person.getName());			
		} catch (Exception e) {
			fail();
		}
	}

	@JExercise(
		tests="void setBirthday(String)",
		description="The setBirthday(String) should set birthday to input argument, given that the birthday is on a valid format."
	)
	public void testSetBirthday() {
		try {
			Date birth = new Date(115,11,31);
			person.setBirthday(birth);
			fail();
		} catch (Exception e) {
			assertEquals(birthday, person.getBirthday());	
		}
		try {
			Date birth = new Date(93, 11, 12);			
			person.setBirthday(birth);
			assertEquals(birth, person.getBirthday());	
		} catch (Exception e) {
			fail();
		}
	}
	
	@JExercise(
			tests="void setEmail(String)",
			description="The setEmail(String) should set email to input argument, given that the email is on a valid format"
	)
	public void testSetEmail() {
		try {
			person.setEmail("ola.nordmann@ntnu");
			fail();
		} catch (Exception e) {			
			assertEquals("ola.nordmann@ntnu.no", person.getEmail());			
		}
		
		try {
			person.setEmail("ola.nordmann(at)ntnu.no");
			fail();
		} catch (Exception e) {			
			assertEquals("ola.nordmann@ntnu.no", person.getEmail());			
		}
		
		try {
			person.setEmail("espen.askeladd@eventyr.no");
			assertEquals("espen.askeladd@eventyr.no", person.getEmail());
		} catch (Exception e) {			
			fail();		
		}
		
		try {
			person.setEmail("espenaskeladd@eventyr.no");
			fail();		
		} catch (Exception e) {			
			assertEquals("espen.askeladd@eventyr.no", person.getEmail());
		}
		
		try {
			person.setEmail("e.a@ev.no");
			fail();		
		} catch (Exception e) {			
			assertEquals("espen.askeladd@eventyr.no", person.getEmail());
		}
	}
	
	@JExercise(
			tests="void setGender(String)",
			description="The setGender(String) should set gedner to input argument, given that the gender is on a valid format"
	)	
	public void testSetGender() {
		try {
			person.setGender('F');
			assertEquals('F', person.getGender());		
		} catch(Exception e) {
			fail();
		}
		try {
			person.setGender('O');
			fail();
		} catch (Exception e) {
			assertEquals('F', person.getGender());			
		}
		try {
			person.setGender('\0');
			assertEquals('\0', person.getGender());			
		} catch (Exception e) {
			fail();
		}
	}
	
	public static void main(String[] args) {
		JexStandalone.main(PersonTest.class);
	}
}
