package encapsulation;

import no.hal.jex.runtime.JExercise;
import no.hal.jex.standalone.JexStandalone;
import junit.framework.TestCase;

@JExercise(
	description="An Account must contain two double fields, balance and interestRate, and methods for getting balance as well as depositing and withdrawing amounts."
)
public class AccountTest extends TestCase {

	private double epsilon = 0.000001d;
	
	Account account;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		account = new Account(100, 5);
	}
	
	@JExercise(
			tests="Account(double, double)",
			description="The Account(double, double) constructor sets the state to argument values if positive, otherwise cast an IllegalArgumentException."
	)
	public void testAccount() {
		account = new Account(100, 5);
		assertEquals(100.0d, account.getBalance(), epsilon);
		assertEquals(5.0d, account.getInterestRate(), epsilon);
		try {
			account = new Account(-1, 5);
			fail();
		} catch (Exception e) {
			assertEquals(100.0d, account.getBalance(), epsilon);
			assertEquals(5.0d, account.getInterestRate(), epsilon);	
			assertTrue(e instanceof IllegalArgumentException);
		}
		
		try {
			account = new Account(100, -1);
			fail();
		} catch (Exception e) {
			assertEquals(100.0d, account.getBalance(), epsilon);
			assertEquals(5.0d, account.getInterestRate(), epsilon);
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

	@JExercise(
		tests="void deposit(double)",
		description="The deposit(double) method takes an amount as its only argument, and adds it to the balance."
	)
	public void testDeposit() {
		account.deposit(100);
		assertEquals(200.0d, account.getBalance(), epsilon);
	}
	
	@JExercise(
			tests="void deposit(double)",
			description="The deposit(double) method should ignore negative amounts and throw an IllegalArgumentException if so"
	)
	public void testDepositNegativeAmount() {
		try {
			account.deposit(-50);
			fail();
		} catch (Exception e) {
			assertEquals(100.0d, account.getBalance(), epsilon);
			assertTrue(e instanceof IllegalArgumentException);
		}
	}
	
	@JExercise(
			tests="double withdraw()",
			description="The withdraw(double amount) method withdraws the amount from the balance."
	)
	public void testWithdraw() {
		try {
			double i = account.withdraw(50);
			assertEquals(50.0d, i, epsilon);
		} catch (Exception e){
			fail();
		}
	}
	
	@JExercise(
			tests="double withdraw()",
			description="The withdraw(double amount) method should throw an IllegalStateException if the amount is larger than the current balance."
	)
	public void testWithdrawTooLargeAmount() {
		try {
			account.withdraw(150);
			fail("Expected IllegalStateException here");
		} catch (Exception e){
			assertEquals(100.0d, account.getBalance(), epsilon);
			assertTrue(e instanceof IllegalStateException);
		}
	}

	public static void main(String[] args) {
		JexStandalone.main(AccountTest.class);
	}
}