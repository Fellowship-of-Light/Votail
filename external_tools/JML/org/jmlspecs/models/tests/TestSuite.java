/* Generated by org.multijava.util.testing.Main */

package org.jmlspecs.models.tests;

/**
 * This class is automatically generated using 
 * org.multijava.util.testing.Main and is used to 
 * group a collection of JUnit tests for the local 
 * package and perhaps some subpackages. 
 */
public class TestSuite extends junit.framework.TestSuite {
    public TestSuite() {
        super();
    }

    public TestSuite( String name ) {
        super( name );
    }

    public static junit.framework.Test suite() {
        junit.framework.TestSuite suite = 
            new junit.framework.TestSuite() {
                    public String toString() { return TEST_DESC; }
                };
        suite.addTest( org.jmlspecs.models.tests.JMLObjectSequenceTest.suite() );
        suite.addTest( org.jmlspecs.models.tests.JMLObjectBagTest.suite() );
        suite.addTest( org.jmlspecs.models.tests.JMLObjectSetTest.suite() );
        return suite;
    }

    public static final String TEST_DESC = 
        "Test suite for org.jmlspecs.models.tests";
}
