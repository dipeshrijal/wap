package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.model.Employee;
import com.java.util.DbUtil;

public class EmployeeDao {

	private Connection connection;

	public EmployeeDao() {
		connection = DbUtil.getConnection();
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from employees");

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setFirstname(rs.getString("firstname"));
				emp.setLastname(rs.getString("lastname"));
				employees.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}		
	

		return employees;
	}

	public void addEmployee(Employee emp) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into employees(firstname,lastname) values (?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, emp.getFirstname());
			preparedStatement.setString(2, emp.getLastname());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
