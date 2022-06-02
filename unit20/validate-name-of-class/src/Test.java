public class Test {
    private static ValidateNameOfClass validateNameOfClass;
    public static final String[] validName = new String[] {"C0318G","P8764H"};
    public static final String[] invalidName = new String[] {"M0318G","P8764A"};
    public static void main(String[] args) {
        validateNameOfClass = new ValidateNameOfClass();
        for (String name: validName) {
            boolean isValidate = validateNameOfClass.validate(name);
            System.out.println("Name is " + name + " is validate: " + isValidate);
        }

        for (String name: invalidName) {
            boolean isValidate = validateNameOfClass.validate(name);
            System.out.println("Name is " + name + " is validate: " + isValidate);
        }
    }
}
