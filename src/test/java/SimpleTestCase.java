import junit.framework.TestCase;

/**
 * Created by Aleksandra on 04.08.15.
 */
public class SimpleTestCase extends TestCase {

    public void testPlus() throws Exception {
        final double expected = 55;
        Parser parser = new Parser();
        final double actual = parser.evaluate("1+2+3+4+5+6+7+8+9+10");
        assertEquals(expected,actual);
    }
}
