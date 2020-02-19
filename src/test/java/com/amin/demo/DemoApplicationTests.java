package com.amin.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertTrue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	void testDB(){

		boolean cal = false;
		try {
			String url = "jdbc:mysql://localhost:3306/hb_student_tracker";
			String username= "hbstudent";
			String  password= "hbstudent";
			Connection connection = DriverManager.getConnection(url,username,password);
			cal = true;

		} catch (SQLException exception){

		}

		Assert.isTrue(cal,"Is not connected");
	}

}
