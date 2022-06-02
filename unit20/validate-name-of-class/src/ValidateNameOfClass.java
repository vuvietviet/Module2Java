import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNameOfClass {
    private static final String NAME_REGEX = "^[CAP]{1}[0-9]{4}[GHIKLM]$";

    public ValidateNameOfClass() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
