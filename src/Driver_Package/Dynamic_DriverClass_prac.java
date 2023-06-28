package Driver_Package;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import Common_API_Methods.Common_Utlity_Method;

public class Dynamic_DriverClass_prac {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		ArrayList<String> TestCasetoRun =Common_Utlity_Method.ReadDataExcel("TestCase","TCtoExecute");
		System.out.println(TestCasetoRun);
		
		int count=TestCasetoRun.size();
		for(int i=1; i<count; i++) {
			
			String TestCaseName=TestCasetoRun.get(i);
			System.out.println(TestCaseName);
			
			Class<?> Testclassname=Class.forName("Test_Classes."+ TestCaseName);
			Method executemethod=Testclassname.getDeclaredMethod("extractor");
			executemethod.setAccessible(true);
			Object instanceoftestclass=Testclassname.getDeclaredConstructor().newInstance();
			executemethod.invoke(instanceoftestclass);
		}
				
			
	}

}
