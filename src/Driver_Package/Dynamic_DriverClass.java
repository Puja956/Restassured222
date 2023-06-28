package Driver_Package;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import Common_API_Methods.Common_Utlity_Method;

public class Dynamic_DriverClass {

	public static void main(String[] args)
			throws IOException, NoSuchMethodException, SecurityException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		ArrayList<String> TestCasetoRun = Common_Utlity_Method.ReadDataExcel("TestCase", "TCtoExecute");
		System.out.println(TestCasetoRun);

		int count=TestCasetoRun.size();
		for(int i=1; i<count; i++)
		{
			String TestCaseName = TestCasetoRun.get(i);
			System.out.println("TestCase to execute is:"+TestCaseName+".");
			// call the testcaseclass on runtime by using java.lang.reflect package
			Class<?> testclassname = Class.forName("Test_Classes." + TestCaseName);

			// call the execute method belonging to test class captured in variable
			// test class name by using java.lang.reflect.method class
			Method executemethod = testclassname.getDeclaredMethod("extractor");

			// set the accessibility of method true
			executemethod.setAccessible(true);

			// create the instance of test class captured in variable name test class name
			Object instanceoftestclass = testclassname.getDeclaredConstructor().newInstance();
			
			// execute the test class captured in variable name test class name
			executemethod.invoke(instanceoftestclass);
		}
//		String TestCaseName = TestCasetoRun.get(1);
//		System.out.println(TestCaseName);
//		Class<?> testclassname = Class.forName("testClass." + TestCaseName);
//
//		// call the execute method belonging to test class captured in variable
//		// testclassname by using java.lang.reflect.method class
//		Method executemethod = testclassname.getDeclaredMethod("extractor");
//
//		// set the accessibility of method true
//		executemethod.setAccessible(true);
//
//		// create the instance of testclass captured in variable name testclassname
//		Object instanceoftestclass = testclassname.getDeclaredConstructor().newInstance();
//		
//		// execute the testclass captured in variable name testclass name
//		executemethod.invoke(instanceoftestclass);
	}

}
