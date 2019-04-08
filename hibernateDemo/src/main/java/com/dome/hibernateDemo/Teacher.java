package com.dome.hibernateDemo;

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
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//一
@Entity
@Table(name="teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tid;
	
	//@Column(length = 30, unique = true)
	private String tname;
	
	//@OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
	//private List<Student> students = new ArrayList<Student>();

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + "]";
	}

//	public List<Student> getStudents() {
//		return students;
//	}
//
//	public void setStudents(List<Student> students) {
//		this.students = students;
//	}
//
//	@Override
//	public String toString() {
//		return "Teacher [tid=" + tid + ", tname=" + tname + ", students=" + students + "]";
//	}
	
	
}
