package com.EmployeePayrollJDBC;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Employee_payrollTest {
    //uc2
	@Test
	public void retrivedSize_shouldMatchEmployeeCount() throws ClassNotFoundException, SQLException {
		Main emp =new Main();	
		List<EmployeePayRollData> list=emp.read();
		Assert.assertEquals(5, list.size());
	}
	
	//uc3
	@Test
	public void givenNewSalaryForEmployee_whenUpdated_shouldMatchSyncWithDBStatemnt() throws ClassNotFoundException {
		Main emp = new Main();
		long updatedRows = emp.updateData("SubhashreeNaik", 80000);
		Assert.assertEquals(1, updatedRows);
	}
	
	

}
