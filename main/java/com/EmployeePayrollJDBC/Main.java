package com.EmployeePayrollJDBC;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public List<EmployeePayRollData> read() throws ClassNotFoundException, SQLException {
		   Scanner scan =new Scanner(System.in);
		   System.out.println("Give sql command to retrive employee data");
		   String  sql=scan.nextLine();
		   return EmployeePayRollData.readEmployeeListData_fromDatabase(sql);	
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	   Main m =new Main();
	   //establish connection
       EmployeePayRollData.getConnection();
       
       //  Execute a query and Extract data from result set
		m.read();
	   
	   
       
	}

}
