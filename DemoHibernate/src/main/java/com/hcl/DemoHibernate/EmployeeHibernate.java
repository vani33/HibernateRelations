package com.hcl.DemoHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeHibernate {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	// if we want to use fields in name like first & last names we can create
	// seperate class with getters & setters
	private Name name;

	public EmployeeHibernate() {

	}

	public EmployeeHibernate(int id, Name name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EmployeeHibernate [id=" + id + ", name=" + name + "]";
	}

}
