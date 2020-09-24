package rest;
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

public class RestRunnerAllTests {
	
	@Test
	public void restRunner() throws XmlException, IOException, SoapUIException {
		WsdlProject project = new WsdlProject("/Users/aritramac/Desktop/SOAP/Library-project.xml");
		WsdlTestSuite testSuite = project.getTestSuiteByName("TestSuiteLibrary");

		for (int i = 0; i < testSuite.getTestCaseCount(); i++) {
			WsdlTestCase testCase = testSuite.getTestCaseAt(i);
			TestCaseRunner runner = testCase.run(new PropertiesMap(), false);

			Assert.assertEquals(Status.FINISHED, runner.getStatus());
		}
		
	}

}
