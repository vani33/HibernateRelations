package com.hcl.ManyToManyRelationsHibernate;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

public class Student {

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private int studentId;
	private String studentName;
	private String city;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Student_id")
	private List<Laptop> laptops = new ArrayList<Laptop>();

	public Student() {

	}

	public Student(int studentId, String studentName, String city) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.city = city;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Laptop> getLaptops() {
		return laptops;
	}

	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}

	/*
	 * public Laptop getLaptop() { return laptop; }
	 * 
	 * public void setLaptop(Laptop laptop) { this.laptop = laptop; }
	 * 
	 * public int getStudentId() { return studentId; }
	 */

}
