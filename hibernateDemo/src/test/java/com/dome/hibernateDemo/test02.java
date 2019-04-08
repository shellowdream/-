package com.dome.hibernateDemo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;

import com.dome.hibernateDemo.Utils.HibernateUtils;

public class test02 {
	@Test
	public void test00() {
		HibernateUtils hibernateUtils = new HibernateUtils();
		Session session = hibernateUtils.getCurrentSession();
		session.beginTransaction();
		
		//事务代码
		Teacher teacher = new Teacher();
		teacher.setTname("李老师");
		session.save(teacher);
		Teacher teacher1 = new Teacher();
		teacher1.setTname("zhang老师");
		session.save(teacher1);
		
		Student student = new Student();
		student.setSname("小红");
		student.setTeacher(teacher);
		session.save(student);
		
		Student student1 = new Student();
		student1.setSname("小z");
		student1.setTeacher(teacher);
		session.save(student1);
		
		Student student2 = new Student();
		student2.setSname("小k");
		student2.setTeacher(teacher1);
		session.save(student2);
		
		session.getTransaction().commit();
	}
	
	//多表查询
    @Test
    public void test02() {
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();
           
           //HQL：内连接
           List<Object[]> list = session.createQuery("from Student s inner join  s.teacher").list();
           
           for (Object[] objects : list) {
                  System.out.println(Arrays.toString(objects));
           }
           
           
           session.getTransaction().commit();
    }
	
	@Test
	public void test01() {
		HibernateUtils hibernateUtils = new HibernateUtils();
		Session session = hibernateUtils.getCurrentSession();
		session.beginTransaction();
		
		//HQL：迫切内连接，在join后加fetch
		List<Student> list = session.createQuery("from Student s inner join fetch s.teacher").list();
		
		for (Student student : list) {
			System.out.println(student);
		}
		
		
		session.getTransaction().commit();
	}
	
	//SQL查询
    @Test
    public void test03() {
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();
           
           //SQL
           List<Object[]> list = session.createSQLQuery("select * from Student").list();
           
           for (Object[] objects : list) {
                  System.out.println(Arrays.toString(objects));
           }
           
           
           session.getTransaction().commit();
    }
  //SQL查询
    @Test
    public void test04() {
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();
           
           //SQL
           SQLQuery sqlQuery = session.createSQLQuery("select * from Student");
           sqlQuery.addEntity(Student.class);
           List<Student> list = sqlQuery.list();
           for (Student student : list) {
			System.out.println(student);
		}
           
           session.getTransaction().commit();
    }
	
}
