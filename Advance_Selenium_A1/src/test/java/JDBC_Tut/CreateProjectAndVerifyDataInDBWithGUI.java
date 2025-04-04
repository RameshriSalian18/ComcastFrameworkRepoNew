package JDBC_Tut;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class CreateProjectAndVerifyDataInDBWithGUI {

	public static void main(String[] args) throws SQLException {
		String projectName = "Insta_01";
		WebDriver driver =  new ChromeDriver();
		driver.get("http://localhost:8084");
		
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgyantra@999");
		driver.findElement(By.xpath("//button[text()=sign in]")).click();
		
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='create project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys("projectName");
		driver.findElement(By.name("createdBy")).sendKeys("Rameshri");
		
		Select sel = new Select(driver.findElement(By.name("Status")));
		sel.selectByIndex(0);
		
		driver.findElement(By.xpath("//input[@value='Add-Project']")).click();
		
		//Verify the project in DB
		
		boolean flag = false;
		
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pprojects" , "root" , "root");
		
		System.out.println("=======Done=========");
		
		Statement stat = conn.createStatement();
		ResultSet resultset = stat.executeQuery("Select*from project");
		
		
		while(resultset.next()){
			String actProjectName = resultset.getString(4);
			
			if(projectName.equals(actProjectName)) {
				flag = true;
				System.out.println(projectName + "is available DB=PASS");
			}
		}
		
		if (flag==false) {
			System.out.println(projectName + "is not available DB == FAIL");
			Assert.fail();
		}
		
		conn.close();
		
		
		
	}

}
