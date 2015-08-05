import java.io.IOException;

/**
 * Created by Aleksandra on 04.08.15.
 */
public class UnclosedParenthesisException extends IOException {
    @Override
    public String toString() {
        return "UnclosedParenthesis";
    }
}
