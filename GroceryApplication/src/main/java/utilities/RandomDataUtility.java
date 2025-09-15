package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	
	Faker faker = new Faker();
	
	public String randomUsername() {
		
		return faker.name().username(); //creates random username
				
	}
	
	public String randomPassword() {
		
		return faker.internet().password(); //creates random password
				
	}

	public String randomEmail() {
	
		return faker.internet().emailAddress(); //creates random email
			
	}
	
	public String randomFullname() {
		
		return faker.name().fullName(); //creates random full name
			
	}
	
	

}
