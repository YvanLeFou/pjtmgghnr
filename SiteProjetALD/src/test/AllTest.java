package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTest {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTest.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TestCategorie.class);
		suite.addTestSuite(TestDroit.class);
		suite.addTestSuite(TestDepartementRegion.class);
		//$JUnit-END$
		return suite;
	}

}
