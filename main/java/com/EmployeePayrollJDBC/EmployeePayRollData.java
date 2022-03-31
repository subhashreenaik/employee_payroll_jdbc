/**
 * 
 */
package com.EmployeePayrollJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

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
	 * @return con
	 * @throws ClassNotFoundException **/
	public static  Connection getConnection() throws ClassNotFoundException {
		System.out.println("Connecting to database...");
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(jdbcURL,username,password);
			System.out.println("Connection is Successfull ::" + con);
		} catch (SQLException e) {
			System.out.println("not connected to database...");
			e.printStackTrace();
			
		}
		return con;
	}
	
	private  void listDriver() {
		Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName());
		}
	}
	
	
	/**	Read data from empoyee_payroll database
	 * Extract data from result set
	 * @return employeePayRollJDBCList
	 * @throws ClassNotFoundException , SQLException **/
	
	public static List<EmployeePayRollData> readEmployeeListData_fromDatabase(String query) throws SQLException, ClassNotFoundException {
		Connection connection;
		List<EmployeePayRollData> employeePayRollJDBCList = new ArrayList<>();
		connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while (rs.next())
			employeePayRollJDBCList.add(
					new EmployeePayRollData(rs.getInt("id"), rs.getString("name"), rs.getDouble("salary")));
		System.out.println(employeePayRollJDBCList.size());
		employeePayRollJDBCList.forEach(System.out::println);
		statement.close();
		rs.close();
		connection.close();
		return employeePayRollJDBCList;
	}
	
	public static long updateEmployeePayrollDataUsingStatement(String name, Double salary) throws ClassNotFoundException {
		String query = String.format("UPDATE employee_payroll SET salary=%.2f WHERE name='%s';", salary, name);
		Connection connection;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			return statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static long updateUsingPreparedStatement(String name, int salary) throws ClassNotFoundException {

		String query = "UPDATE employee_payroll SET salary = ? WHERE name = ? ";
		Connection connection;
		try {
			connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, salary);
			preparedStatement.setString(2, name);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static List<EmployeePayRollData> queryEmployeePayrollDBReturnEmployeeList(String startDate, String endDate) throws SQLException, ClassNotFoundException {
		String query = String.format("SELECT * FROM employee_payroll WHERE StartDate   BETWEEN '%s' AND '%s';",Date.valueOf(startDate), Date.valueOf(endDate));
		return readEmployeeListData_fromDatabase(query);
	}
	
	

}
