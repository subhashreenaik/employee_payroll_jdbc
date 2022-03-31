/**
 * 
 */
package com.EmployeePayrollJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import com.mysql.cj.jdbc.Driver;

/**
 * @author subhashree
 *
 */
public class EmployeePayRollData {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";	
	static final String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
	static final String username = "root";
	static final String password = "Shreemay@1";
	static Connection con = null;
	static Statement stmt = null;
	private int employee_Id;
	private String employee_name;
	
	private double employee_salary;
	
	public EmployeePayRollData(int employee_Id,String employee_name,double employee_salary) {
		this.employee_Id =employee_Id;
		this.employee_name = employee_name;
		this.employee_salary =employee_salary;
		
	}
	
	
	public EmployeePayRollData() {
		super();
	}


	public int getEmployee_Id() {
		return employee_Id;
	}
	public void setEmployee_Id(int employee_Id) {
		this.employee_Id = employee_Id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public double getEmployee_salary() {
		return employee_salary;
	}
	public void setEmployee_salary(double employee_salary) {
		this.employee_salary = employee_salary;
	}
	
	@Override
	public String toString() {
		return "EmployeePayRollData [employee_Id=" + employee_Id + ", employee_name=" + employee_name
				+ ", employee_salary=" + employee_salary + "]";
	}
	
	
	/**	Register JDBC driver and connect to sql 
	 * @throws ClassNotFoundException **/
	public  void getConnection() throws ClassNotFoundException {
		System.out.println("Connecting to database...");
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(jdbcURL,username,password);
			System.out.println("Connection is Successfull ::" + con);
		} catch (SQLException e) {
			System.out.println("not connected to database...");
			e.printStackTrace();
			
		}
	}
	
	private  void listDriver() {
		Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName());
		}
		

}
}
