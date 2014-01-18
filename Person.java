package encapsulation;

public class Person {
	private String name;
	private String email;
	private String birthday;
	private char gender;
	private String socialsec;

	private static int[] factors1 = {3, 7, 6, 1, 8, 9, 4, 5, 2}, factors2 = {5, 
	4, 3, 2, 7, 6, 5, 4, 3, 2}; 
	 
	private static int computeControlDigit(String digits, int[] factors) { 
		int sum = 0; 
		for (int i = 0; i < factors.length; i++) { 
			sum += (digits.charAt(i) - '0') * factors[i]; 
		} 
		return 11 - (sum % 11); 
	} 
	 
	private static boolean checkDigits(String digits, int pos, int num) { 
		return (num / 10 == digits.charAt(pos) - '0' && num % 10 == 
		digits.charAt(pos + 1) - '0'); 
	} 
	 
	private boolean validatePID(String pid) { 
		if (pid.length() != 11) { 
			return false; 
		} 
		for (int i = 0; i < pid.length(); i++) { 
			if (! Character.isDigit(pid.charAt(i))) { 
				return false; 
			} 
		}
		int day = Integer.parseInt(birthday.substring(0, 2));
		int month = Integer.parseInt(birthday.substring(2, 4));
		int year = Integer.parseInt(birthday.substring(4, 6));
		
		if (! (checkDigits(pid, 0, day) && checkDigits(pid, 2, month)) && checkDigits(pid, 4, year)) { 
			return false; 
		} 
		boolean isOdd = ((pid.charAt(8) - '0') % 2) == 1; 
		if ((gender == 'M') != isOdd) { 
			return false; 
		} 
		int k1 = computeControlDigit(pid, factors1), k2 = computeControlDigit(pid, factors2); 
		if (k1 != pid.charAt(9) - '0' || k2 != pid.charAt(10) - '0') { 
			return false; 
		} 
		return true; 
	} 
	 
	public String getSocialsec() { 
		 return socialsec;
	} 
	 
	public void setSocialsec(String socialsec) { 
		if (! validatePID(socialsec)) { 
			throw new IllegalArgumentException(socialsec + " is not a valid PID for " + gender + " and " + birthday); 
		} 
		this.socialsec = socialsec; 
	}
	
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		int day = Integer.parseInt(birthday.substring(0, 2));
		int month = Integer.parseInt(birthday.substring(2, 4));
		int year = Integer.parseInt(birthday.substring(4, 6));
		
		if (day > 0 && day < 32 && month > 0 && month < 13 && year > -1 && year < 100) {
			this.birthday = birthday;			
		}
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		if (gender == 'F' || gender == 'M') {
			this.gender = gender;
		}
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setName(String name) {
		if (checkValidName(name)) {
			this.name = name;
		}
	}
	
	public void setEmail(String email) {
		if (checkValidEmail(email)) {
			this.email = email;
		}
	}
	
	private boolean checkValidName(String name) {
		for (char a : name.toCharArray()) {
			if (!(Character.isLetter(a) || a == ' ')) {
				return false;
			}
		}
		return name.length() > 5 && name.contains(" ");
	}
	
	private boolean checkValidEmail(String email) {
		boolean valid = email.contains("@");
		if (valid) {
			valid = Character.isLetter(email.charAt(email.indexOf("@")+1));
			valid = valid && email.substring(email.indexOf("@")).contains(".");	
			if (valid) {
				valid = email.substring(email.lastIndexOf('.')).length() > 2;
			}
		}
		return email.length() > 5 && valid;
	}
}
