package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import utils.DataInputProvider;

public class AppSpecificWrapper extends GenericWrappers{
	
	public String dataSheetName;
	
	@BeforeSuite
	public void bs() {
		startResult();
	}
	
	
	@BeforeClass
	public void bc() {
		startTestModule(testCaseName, testDescription);
	}
	
	
	@BeforeMethod
	public void bm() {
		startTestCase(testNodes);
		launchAndroidApp("emulator-5554", "com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity", "", "");
		switchWebview();
	}
	
	@AfterMethod
	public void am() {
		closeApp();
	}
	
	
	@AfterSuite
	public void as() {
		endResult();
	}

	@DataProvider(name = "fetchData")
	public Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);
	}
	
}
