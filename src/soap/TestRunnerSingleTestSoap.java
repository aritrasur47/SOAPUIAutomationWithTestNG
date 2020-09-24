package soap;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class TestRunnerSingleTestSoap {

	@Test
	public void singleTest() throws XmlException, IOException, SoapUIException {
		WsdlProject project = new WsdlProject("/Users/aritramac/Desktop/AutomatingwithGroovy-soapui-project.xml");
		WsdlTestSuite testSuite = project.getTestSuiteByName("TestSuite");

		WsdlTestCase testCase = testSuite.getTestCaseByName("addEmployee");
		TestCaseRunner runner = testCase.run(new PropertiesMap(), false);

		Assert.assertEquals(Status.FINISHED, runner.getStatus());
	}
}
