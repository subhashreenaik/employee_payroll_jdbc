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
	
	//uc4
	@Test
	public void whenUpdatedWithPreparedStatement_shouldMatchSyncWithDBStatemnt() throws ClassNotFoundException {
		Main emp = new Main();
		long updatedRows = emp.updateData("SubhashreeNaik", 80000);
		Assert.assertEquals(1, updatedRows);
	}
	
	//uc5
	public void givenDateRange_shouldMatchSyncWithDB_ReturnCountOfEmployee() throws SQLException, ClassNotFoundException {
		Main emp = new Main();
		
		List<EmployeePayRollData> updatedRowsInDB = emp.inAgivenRangeReturnEmployeeList("2022-03-25","2022-03-27");
		Assert.assertEquals(3, updatedRowsInDB.size());
	}
	
	//uc6
	@Test
	public void givenEmployeesDB_shouldFindOperation_ReturnOperationData() throws ClassNotFoundException, SQLException {
		Main emp =new Main();	
		int list=emp.executeDifferentOperation();
		Assert.assertEquals(2, list);
	}

}
