package transport;

public class Validator {
    public static String validateString(String stringValidation) {
        String defaultValue = "default";
        return stringValidation == null
                || stringValidation.isEmpty()
                || stringValidation.isBlank() ? defaultValue : stringValidation;
    }
    public static Boolean validateBoolean (Boolean value) {
        return value != null && value;
    }
}
