package beans;

import java.util.Date;

public class Employee { 
	 
	private String firstName;
	private Date dob;

	public String getFirstName() {
	    return firstName;
	}
	public void setFirstName(String firstName) {
	    this.firstName = firstName;
	}
	public Date getDob() {
	    return dob;
	}
	public void setDob(Date dob) {
	    this.dob = dob;
	}
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", dob=" + dob + "]";
	}

	    
	    
}
