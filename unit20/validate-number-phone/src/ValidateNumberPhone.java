import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNumberPhone {
    private static final String NUMBERPHONE_REGEX = "\\([0-9]{2}\\)-\\(0{1}[0-9]{9}\\)";

    public ValidateNumberPhone() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(NUMBERPHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
