package stateandbehavior;

import no.hal.jex.runtime.JExercise;
import no.hal.jex.standalone.JexStandalone;
import junit.framework.TestCase;

@JExercise(
	description="An Account must contain two double fields, balance and interestRate, and methods for depositing amounts and computing and adding interest."
)
public class AdvancedAccountTest extends TestCase {

	private double epsilon = 0.000001d;
	
	AdvancedAccount account;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		account = new AdvancedAccount(100, 5);
	}
	
	@JExercise(
			tests="AdvancedAccount(double, double)",
			description="The AdvancedAccount(double, double) constructor sets the state to argument values if positive, otherwise 0."
	)
	public void testAdvancedAccount() {
		account = new AdvancedAccount(100, 5);
		assertEquals(100.0d, account.getBalance(), epsilon);
		assertEquals(5.0d, account.getInterestRate(), epsilon);
		account = new AdvancedAccount(-1, 5);
		assertEquals(0.0d, account.getBalance(), epsilon);
		assertEquals(5.0d, account.getInterestRate(), epsilon);
		account = new AdvancedAccount(100, -1);
		assertEquals(100.0d, account.getBalance(), epsilon);
		assertEquals(0.0d, account.getInterestRate(), epsilon);
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
			description="The deposit(double) method should ignore negative amounts."
			)
	public void testDepositNegativeAmount() {
		account.deposit(-50);
		assertEquals(100.0d, account.getBalance(), epsilon);
	}
	
	@JExercise(
		tests="void addInterest()",
		description="The addInterest() method computes the interest, based on the current balance and interestRate, and adds it to the balance. The method should ignore negative interest rates."
	)
	public void testAddInterest() {
		account.addInterest();
		assertEquals(105.0d, account.getBalance(), epsilon);
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
			description="The withdraw(double amount) method should throw an IllegalArgumentException if the amount is larger than the current balance."
	)
	public void testWithdrawTooLargeAmount() {
		try {
			account.withdraw(150);
			fail("Expected IllegalArgumentException here");
		} catch (Exception e){
			assertTrue(e.getMessage().length() > 0);
		}
	}

	public static void main(String[] args) {
		JexStandalone.main(AccountTest.class);
	}
}