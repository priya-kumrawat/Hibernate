package com.uni.impl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.uni.AppMain.App;
import com.uni.entity.Employee;
import com.uni.util.HBSessionUtil;

public class EmployeeImpl {
	
	private Session session;
	Scanner sc = new Scanner(System.in);
	private int input;
	private int obj = 1;

	public void createEmp() {
		
		do {

			Employee emp = new Employee();
			
			System.out.print(" \t \t Enter name of employee : ");
			emp.setName(sc.nextLine());
			
			
			System.out.print("\t\t Enter designation of employee : ");
			emp.setDesignation(sc.nextLine());
			
			
			
			System.out.print("\t\t Enter age of employee : ");
			emp.setAge(sc.nextInt());
			sc.nextLine();
			
			
			System.out.print("\t\t Enter email of employee : ");
			emp.setEmail(sc.nextLine());
			

			
			session = HBSessionUtil.hbConSession();
			session.beginTransaction();
			session.persist(emp);
			System.out.println("\t\t***** Employee Inserted Successfully *****");
			session.getTransaction().commit();
			session.close();
			
			System.out.println();
			System.out.println("\t\t Insert More Employees Informations");
			System.out.println("\t\t 1.yes");
			System.out.println("\t\t 2.no");
			System.out.print("\t\t Enter Choice :");
			 input = sc.nextInt();
			 sc.nextLine();

			 
			
		}while(input == obj);
			App ap = new App();
			ap.print();
	}

	public void readEmp() {
		
			session = HBSessionUtil.hbConSession();
			session.beginTransaction();
			
			List<Employee> employeList = session.createQuery("FROM Employees", Employee.class).list(); // Employees is given in entity class @Entity annotation 

			for (Employee employee : employeList) {
				System.out.println("\t\t"+ employee.toString());
			}

			System.out.println("\t\t Found " + employeList.size() + " Employees");
			session.getTransaction().commit();
			session.close();
		
			App ap = new App();
			ap.print();
		
	
	}
	public void updateEmp() {
		do {
			session = HBSessionUtil.hbConSession();
			session.beginTransaction();
			
			System.out.print("Enter Id of Employee : ");
			int id = sc.nextInt();
			sc.nextLine();
			
			
			Employee emp = (Employee) session.get(Employee.class, id);
			
			System.out.print("\t\t Enter name of employee : ");
			emp.setName(sc.nextLine());
		
			
			System.out.print("\t\t Enter designation of employee : ");
			emp.setDesignation(sc.nextLine());
		
			
			System.out.print("\t\t Enter age of employee : ");
			emp.setAge(sc.nextInt());
			sc.nextLine();
			
			System.out.print("\t\t Enter email of employee : ");
			emp.setEmail(sc.nextLine());	;
			
			System.out.println();
			System.out.println("\t \t \t ************* Employee Information Update Successfully ********");
			System.out.println();
			
			session.getTransaction().commit();
			session.close();
			
			System.out.println();
			System.out.println("\t \t  Update Employee Information ");
			System.out.println("\t\t 1.yes");
			System.out.println("\t\t 2.no");
			System.out.print("\t\t Enter Choice :");
			 input = sc.nextInt();
			 sc.nextLine();

			
		}while(input == obj);
			App ap = new App();
			ap.print();
		
	
	}
	public void deleteByIdEmp() {
		do {
			session = HBSessionUtil.hbConSession();
			session.beginTransaction();

			System.out.print("\t \t Enter Id of Employee : ");
			int id = sc.nextInt();
			sc.nextLine();
			
			
			Employee emp = (Employee) session.get(Employee.class, id);
			session.remove(emp);
			System.out.println();
			System.out.println("\t \t \t ************* Employee Deleted Successfully ********");
			System.out.println();
			session.getTransaction().commit();
			session.close();
			System.out.println();
			System.out.println("\t \t  Delete Employee Information ");
			System.out.println("\t\t 1.yes");
			System.out.println("\t\t 2.no");
			System.out.print("\t\t Enter Choice :");
			 input = sc.nextInt();
			 sc.nextLine();
		}while(input == obj);
			App ap = new App();
			ap.print();
		
		
	}

	public void deleteAllEmp() {
		
			session = HBSessionUtil.hbConSession();
			session.beginTransaction();
			
			String hql = "DElETE FROM " + Employee.class.getName();
			int rowsDeleted = session.createQuery(hql).executeUpdate();
			System.out.println("\t\t Row deleted :" +rowsDeleted);
			System.out.println();
			System.out.println("\t \t \t ************* All Employee's Information Deleted Successfully ********");
			System.out.println();
			
			session.getTransaction().commit();
			session.close();
		
			App ap = new App();
			ap.print();
		
	}

	

	
}
