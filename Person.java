package stateandbehavior;

public class Person {
	private String name;
	private String email;
	private String birthday;
	private char gender;
	
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
