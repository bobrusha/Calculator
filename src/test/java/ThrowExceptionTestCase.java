import org.junit.Test;

/**
 * Created by Aleksandra on 04.08.15.
 */
public class ThrowExceptionTestCase {
    @Test(expected = UnclosedParenthesisException.class)
    public void testUnclosedLeftParenthesis() throws Exception {
        Parser parser = new Parser();
        parser.evaluate("(1+2");
    }

    @Test(expected = UnclosedParenthesisException.class)
    public void testUnclosedParenthesis() throws Exception {
        Parser parser = new Parser();
        parser.evaluate("1+2)");
    }


}
