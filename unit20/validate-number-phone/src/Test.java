public class Test {
    private static ValidateNumberPhone validateNumberPhone;
    public static final String[] validNumberPhone = new String[] {"(84)-(0978489648)","(04)-(0978555668)"};
    public static final String[] invalidNumberPhone = new String[] {"(a4)-(0978489648)","(04)-(1978555668)","(78)-(01234567891)",
            "(84)(0978489648)","(84-(0978489648)"};

    public static void main(String[] args) {
        validateNumberPhone = new ValidateNumberPhone();
        for (String number: validNumberPhone) {
            boolean isValidate = validateNumberPhone.validate(number);
            System.out.println("Number phone " + number + "is validate: " +isValidate);
        }

        for (String number: invalidNumberPhone) {
            boolean isValidate = validateNumberPhone.validate(number);
            System.out.println("Number phone " + number + "is validate: " +isValidate);
        }
    }
}
