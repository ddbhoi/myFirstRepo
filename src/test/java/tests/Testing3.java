package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {
	
	SoftAssert softAssert = new SoftAssert();
	
	  @Test(priority = 1) // create new user test@test.com
	  public void createUser() {			//smoke,sanity and regression testing concept
		  									//add groups= "smoke or sanity" to any test case you want
		  									//if you want to run smoke test, run as>run configurations>groups>browse>Smoke>run
		  System.out.println("I am in home test");
		  System.out.println("Before Assertion");
		  Assert.assertTrue(2>3, "Verifying Element"); // We use regular assert in industry
		  System.out.println("After Assertion");
		  AssertJUnit.assertEquals("abc", "abc");
  }
	  @Test(priority = 2, dependsOnMethods = "createUser",  groups = "Smoke") // Edit user test@test.com
	  public void editUser() {							// we use dependsOn in case one test case fails but noting is wrong with
		  												// other that depends on the result of previous one,it skips the test case
		  												//and prevents it from failing, we will have less failed test cases at the end
		  System.out.println("Before Assertion");
		  Assert.assertTrue(2>3, "Verifying Element"); // We use regular assert in industry
		  System.out.println("After Assertion");
		  softAssert.assertAll(); // similar to error collector in Junit
	  
  }
	  @Test(priority = 3, dependsOnMethods = "editUser") // Delete user test@test.com
	  public void deleteUser() {
		  System.out.println("I am in end test");
		  System.out.println("Before Assertion");
		  Assert.assertTrue(2>3, "Verifying Element"); // We use regular assert in industry
		  System.out.println("After Assertion");
		  AssertJUnit.assertEquals("abc", "abc1");
		  System.out.println("After second assertion");
		  softAssert.assertAll();
}
	  
}
