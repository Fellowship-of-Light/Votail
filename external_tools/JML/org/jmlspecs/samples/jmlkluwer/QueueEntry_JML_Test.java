// This file was generated by jmlunit on Tue May 20 17:42:54 EDT 2008.

package org.jmlspecs.samples.jmlkluwer;

import org.jmlspecs.models.JMLType;

/** Automatically-generated test driver for JML and JUnit based
 * testing of QueueEntry. The superclass of this class should be edited
 * to supply test data. However it's best not to edit this class
 * directly; instead use the command
 * <pre>
 *  jmlunit QueueEntry.java
 * </pre>
 * to regenerate this class whenever QueueEntry.java changes.
 */
public class QueueEntry_JML_Test
     extends QueueEntry_JML_TestData
{
    /** Initialize this class. */
    public QueueEntry_JML_Test(java.lang.String name) {
        super(name);
    }

    /** Run the tests. */
    public static void main(java.lang.String[] args) {
        org.jmlspecs.jmlunit.JMLTestRunner.run(suite());
        // You can also use a JUnit test runner such as:
        // junit.textui.TestRunner.run(suite());
    }

    /** Test to see if the code for class QueueEntry
     * has been compiled with runtime assertion checking (i.e., by jmlc).
     * Code that is not compiled with jmlc would not make an effective test,
     * since no assertion checking would be done. */
    public void test$IsRACCompiled() {
        junit.framework.Assert.assertTrue("code for class QueueEntry"
                + " was not compiled with jmlc"
                + " so no assertions will be checked!",
            org.jmlspecs.jmlrac.runtime.JMLChecker.isRACCompiled(QueueEntry.class)
            );
    }

    /** Return the test suite for this test class.  This will have
    * added to it at least test$IsRACCompiled(), and any test methods
    * written explicitly by the user in the superclass.  It will also
    * have added test suites for each testing each method and
    * constructor.
    */
    //@ ensures \result != null;
    public static junit.framework.Test suite() {
        QueueEntry_JML_Test testobj
            = new QueueEntry_JML_Test("QueueEntry_JML_Test");
        junit.framework.TestSuite testsuite = testobj.overallTestSuite();
        // Add instances of Test found by the reflection mechanism.
        testsuite.addTestSuite(QueueEntry_JML_Test.class);
        testobj.addTestSuiteForEachMethod(testsuite);
        return testsuite;
    }

    /** A JUnit test object that can run a single test method.  This
     * is defined as a nested class solely for convenience; it can't
     * be defined once and for all because it must subclass its
     * enclosing class.
     */
    protected static abstract class OneTest extends QueueEntry_JML_Test {

        /** Initialize this test object. */
        public OneTest(String name) {
            super(name);
        }

        /** The result object that holds information about testing. */
        protected junit.framework.TestResult result;

        //@ also
        //@ requires result != null;
        public void run(junit.framework.TestResult result) {
            this.result = result;
            super.run(result);
        }

        /* Run a single test and decide whether the test was
         * successful, meaningless, or a failure.  This is the
         * Template Method pattern abstraction of the inner loop in a
         * JML/JUnit test. */
        public void runTest() throws java.lang.Throwable {
            try {
                // The call being tested!
                doCall();
            }
            catch (org.jmlspecs.jmlrac.runtime.JMLEntryPreconditionError e) {
                // meaningless test input
                addMeaningless();
            } catch (org.jmlspecs.jmlrac.runtime.JMLAssertionError e) {
                // test failure
                int l = org.jmlspecs.jmlrac.runtime.JMLChecker.getLevel();
                org.jmlspecs.jmlrac.runtime.JMLChecker.setLevel
                    (org.jmlspecs.jmlrac.runtime.JMLOption.NONE);
                try {
                    java.lang.String failmsg = this.failMessage(e);
                    junit.framework.AssertionFailedError err
                        = new junit.framework.AssertionFailedError(failmsg);
                    err.setStackTrace(new java.lang.StackTraceElement[]{});
                    err.initCause(e);
                    result.addFailure(this, err);
                } finally {
                    org.jmlspecs.jmlrac.runtime.JMLChecker.setLevel(l);
                }
            } catch (java.lang.Throwable e) {
                // test success
            }
        }

        /** Call the method to be tested with the appropriate arguments. */
        protected abstract void doCall() throws java.lang.Throwable;

        /** Format the error message for a test failure, based on the
         * method's arguments. */
        protected abstract java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e);

        /** Inform listeners that a meaningless test was run. */
        private void addMeaningless() {
            if (result instanceof org.jmlspecs.jmlunit.JMLTestResult) {
                ((org.jmlspecs.jmlunit.JMLTestResult)result)
                    .addMeaningless(this);
            }
        }
    }

    /** Create the tests that are to be run for testing the class
     * QueueEntry.  The framework will then run them.
     * @param overallTestSuite$ The suite accumulating all of the tests
     * for this driver class.
     */
    //@ requires overallTestSuite$ != null;
    public void addTestSuiteForEachMethod
        (junit.framework.TestSuite overallTestSuite$)
    {
        try {
            this.addTestSuiteFor$TestQueueEntry(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestEquals(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestHashCode(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestClone(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestGetLevel(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestGetObj(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestToString(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
    }

    /** Add tests for the QueueEntry contructor
     * to the overall test suite. */
    private void addTestSuiteFor$TestQueueEntry
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("QueueEntry");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                vjava_lang_Object$1$iter
                = this.vjava_lang_ObjectIter("QueueEntry", 2);
            this.check_has_data
                (vjava_lang_Object$1$iter,
                 "this.vjava_lang_ObjectIter(\"QueueEntry\", 2)");
            while (!vjava_lang_Object$1$iter.atEnd()) {
                org.jmlspecs.jmlunit.strategies.IntIterator
                    vint$2$iter
                    = this.vintIter("QueueEntry", 1);
                this.check_has_data
                    (vint$2$iter,
                     "this.vintIter(\"QueueEntry\", 1)");
                while (!vint$2$iter.atEnd()) {
                    org.jmlspecs.jmlunit.strategies.LongIterator
                        vlong$3$iter
                        = this.vlongIter("QueueEntry", 0);
                    this.check_has_data
                        (vlong$3$iter,
                         "this.vlongIter(\"QueueEntry\", 0)");
                    while (!vlong$3$iter.atEnd()) {
                        final java.lang.Object argObj
                            = (java.lang.Object) vjava_lang_Object$1$iter.get();
                        final int argLevel
                            = vint$2$iter.getInt();
                        final long argTimeStamp
                            = vlong$3$iter.getLong();
                        methodTests$.addTest
                            (new TestQueueEntry(argObj, argLevel, argTimeStamp));
                        vlong$3$iter.advance();
                    }
                    vint$2$iter.advance();
                }
                vjava_lang_Object$1$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the QueueEntry contructor. */
    protected static class TestQueueEntry extends OneTest {
        /** Argument argObj */
        private java.lang.Object argObj;
        /** Argument argLevel */
        private int argLevel;
        /** Argument argTimeStamp */
        private long argTimeStamp;

        /** Initialize this instance. */
        public TestQueueEntry(java.lang.Object argObj, int argLevel, long argTimeStamp) {
            super("QueueEntry"+ ":" + (argObj==null? "null" :"{java.lang.Object}")+ "," +argLevel+ "," +argTimeStamp);
            this.argObj = argObj;
            this.argLevel = argLevel;
            this.argTimeStamp = argTimeStamp;
        }

        protected void doCall() throws java.lang.Throwable {
            new QueueEntry(argObj, argLevel, argTimeStamp);
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tContructor 'QueueEntry' applied to";
            msg += "\n\tArgument argObj: " + this.argObj;
            msg += "\n\tArgument argLevel: " + this.argLevel;
            msg += "\n\tArgument argTimeStamp: " + this.argTimeStamp;
            return msg;
        }
    }

    /** Add tests for the equals method
     * to the overall test suite. */
    private void addTestSuiteFor$TestEquals
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("equals");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_samples_jmlkluwer_QueueEntryIter("equals", 1));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_jmlkluwer_QueueEntryIter(\"equals\", 1))");
            while (!receivers$iter.atEnd()) {
                org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                    vjava_lang_Object$1$iter
                    = this.vjava_lang_ObjectIter("equals", 0);
                this.check_has_data
                    (vjava_lang_Object$1$iter,
                     "this.vjava_lang_ObjectIter(\"equals\", 0)");
                while (!vjava_lang_Object$1$iter.atEnd()) {
                    final org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$
                        = (org.jmlspecs.samples.jmlkluwer.QueueEntry) receivers$iter.get();
                    final java.lang.Object o
                        = (java.lang.Object) vjava_lang_Object$1$iter.get();
                    methodTests$.addTest
                        (new TestEquals(receiver$, o));
                    vjava_lang_Object$1$iter.advance();
                }
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the equals method. */
    protected static class TestEquals extends OneTest {
        /** The receiver */
        private org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$;
        /** Argument o */
        private java.lang.Object o;

        /** Initialize this instance. */
        public TestEquals(org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$, java.lang.Object o) {
            super("equals"+ ":" + (o==null? "null" :"{java.lang.Object}"));
            this.receiver$ = receiver$;
            this.o = o;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.equals(o);
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'equals' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            msg += "\n\tArgument o: " + this.o;
            return msg;
        }
    }

    /** Add tests for the hashCode method
     * to the overall test suite. */
    private void addTestSuiteFor$TestHashCode
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("hashCode");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_samples_jmlkluwer_QueueEntryIter("hashCode", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_jmlkluwer_QueueEntryIter(\"hashCode\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$
                    = (org.jmlspecs.samples.jmlkluwer.QueueEntry) receivers$iter.get();
                methodTests$.addTest
                    (new TestHashCode(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the hashCode method. */
    protected static class TestHashCode extends OneTest {
        /** The receiver */
        private org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$;

        /** Initialize this instance. */
        public TestHashCode(org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$) {
            super("hashCode");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.hashCode();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'hashCode' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Add tests for the clone method
     * to the overall test suite. */
    private void addTestSuiteFor$TestClone
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("clone");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_samples_jmlkluwer_QueueEntryIter("clone", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_jmlkluwer_QueueEntryIter(\"clone\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$
                    = (org.jmlspecs.samples.jmlkluwer.QueueEntry) receivers$iter.get();
                methodTests$.addTest
                    (new TestClone(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the clone method. */
    protected static class TestClone extends OneTest {
        /** The receiver */
        private org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$;

        /** Initialize this instance. */
        public TestClone(org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$) {
            super("clone");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.clone();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'clone' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Add tests for the getLevel method
     * to the overall test suite. */
    private void addTestSuiteFor$TestGetLevel
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("getLevel");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_samples_jmlkluwer_QueueEntryIter("getLevel", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_jmlkluwer_QueueEntryIter(\"getLevel\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$
                    = (org.jmlspecs.samples.jmlkluwer.QueueEntry) receivers$iter.get();
                methodTests$.addTest
                    (new TestGetLevel(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the getLevel method. */
    protected static class TestGetLevel extends OneTest {
        /** The receiver */
        private org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$;

        /** Initialize this instance. */
        public TestGetLevel(org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$) {
            super("getLevel");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.getLevel();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'getLevel' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Add tests for the getObj method
     * to the overall test suite. */
    private void addTestSuiteFor$TestGetObj
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("getObj");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_samples_jmlkluwer_QueueEntryIter("getObj", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_jmlkluwer_QueueEntryIter(\"getObj\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$
                    = (org.jmlspecs.samples.jmlkluwer.QueueEntry) receivers$iter.get();
                methodTests$.addTest
                    (new TestGetObj(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the getObj method. */
    protected static class TestGetObj extends OneTest {
        /** The receiver */
        private org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$;

        /** Initialize this instance. */
        public TestGetObj(org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$) {
            super("getObj");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.getObj();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'getObj' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Add tests for the toString method
     * to the overall test suite. */
    private void addTestSuiteFor$TestToString
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("toString");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_samples_jmlkluwer_QueueEntryIter("toString", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_jmlkluwer_QueueEntryIter(\"toString\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$
                    = (org.jmlspecs.samples.jmlkluwer.QueueEntry) receivers$iter.get();
                methodTests$.addTest
                    (new TestToString(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the toString method. */
    protected static class TestToString extends OneTest {
        /** The receiver */
        private org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$;

        /** Initialize this instance. */
        public TestToString(org.jmlspecs.samples.jmlkluwer.QueueEntry receiver$) {
            super("toString");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.toString();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'toString' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Check that the iterator is non-null and not empty. */
    private void
    check_has_data(org.jmlspecs.jmlunit.strategies.IndefiniteIterator iter,
                   String call)
    {
        if (iter == null) {
            junit.framework.Assert.fail(call + " returned null");
        }
        if (iter.atEnd()) {
            junit.framework.Assert.fail(call + " returned an empty iterator");
        }
    }

    /** Converts a char to a printable String for display */
    public static String charToString(char c) {
        if (c == '\n') {
            return "NL";
        } else if (c == '\r') {
            return "CR";
        } else if (c == '\t') {
            return "TAB";
        } else if (Character.isISOControl(c)) {
            int i = (int)c;
            return "\\u"
                    + Character.forDigit((i/2048)%16,16)
                    + Character.forDigit((i/256)%16,16)
                    + Character.forDigit((i/16)%16,16)
                    + Character.forDigit((i)%16,16);
        }
        return Character.toString(c);
    }
}
