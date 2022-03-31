package com.EmployeePayrollJDBC;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Employee_payrollTest {

	@Test
	public void retrivedSize_shouldMatchEmployeeCount() throws ClassNotFoundException, SQLException {
		Main emp =new Main();	
		List<EmployeePayRollData> list=emp.read();
		Assert.assertEquals(5, list.size());
	}

}
