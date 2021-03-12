
package com.hcl.DemoHibernate;

import javax.persistence.Embeddable;

//we use embeddable because we need to have firstname and lastname columns in name column itself.
@Embeddable
public class Name {

	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
