package com.EmployeePayrollJDBC;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
	/**
	 *  Listing the data 
	 * @throws SQLException 
	 */
	public List<EmployeePayRollData> read() throws ClassNotFoundException, SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Give sql command to retrive employee data");
		String sql = scan.nextLine();
		return EmployeePayRollData.readEmployeeListData_fromDatabase(sql);
	}
    
	/**
	 *  updating the database using  statement
	 * @throws SQLException 
	 */
	public long updateData(String name, double salary) throws ClassNotFoundException {

		// System.out.println("
		// "+EmployeePayRollData.updateEmployeePayrollDataUsingStatement(name,salary));
		return EmployeePayRollData.updateEmployeePayrollDataUsingStatement(name, salary);

	}
    
	/**
	 *  updating the database using  prepared statement
	 * @throws SQLException 
	 */
	public long updateUsingPreparedStatement(String name, int salary) throws ClassNotFoundException {

		// System.out.println("
		// "+EmployeePayRollData.updateUsingPreparedStatement(name,salary));
		return EmployeePayRollData.updateUsingPreparedStatement(name, salary);

	}
	/**
	 *  retriving the data on given date of range
	 * @throws SQLException 
	 */

	public List<EmployeePayRollData> inAgivenRangeReturnEmployeeList(String startDate, String endDate)
			throws ClassNotFoundException, SQLException {
		return EmployeePayRollData.queryEmployeePayrollDBReturnEmployeeList(startDate, endDate);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Main m = new Main();
		// establish connection
		EmployeePayRollData.getConnection();

		// Execute a query and Extract data from result set
		m.read();

		// Updating the data
		m.updateData("SubhashreeNaik", 50000);

		// Updating the data using prepared statement
		m.updateUsingPreparedStatement("SubhashreeNaik", 57000);
        
		//Retriving data on a given range of Date
		m.inAgivenRangeReturnEmployeeList("2022-03-25", "2022-03-27");

	}

}
