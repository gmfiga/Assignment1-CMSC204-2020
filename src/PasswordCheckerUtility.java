import Exceptions.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {


    public PasswordCheckerUtility() {
    }

    public static boolean isValidPassword(String passwordString) throws LengthException,
            NoDigitException,
            NoUpperAlphaException,
            NoLowerAlphaException,
            NoSpecialCharacterException,
            InvalidSequenceException {

        /*Check Length*/
        if (passwordString.length() < 6) {
            throw new LengthException("The password must be at least 6 characters long");
        }


        /*Check for Lower and Upper Character and Digit*/
        boolean hasUpperChar = false;
        boolean hasLowerChar = false;
        boolean hasDigit = false;

        for (int i = 0; i < passwordString.length(); i++) {
            Character c = passwordString.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUpperChar = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerChar = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        if (hasUpperChar == false) {
            throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
        } else if (hasLowerChar == false) {
            throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
        } else if (hasDigit == false) {
            throw new NoDigitException("The password must contain at least one digit");
        }


        /*Check Special Character*/
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(passwordString);
        boolean hasSpecialChar = matcher.find();
        if (hasSpecialChar == false) {
            throw new NoSpecialCharacterException("The password must contain at least one special character");
        }


        /*Check Sequence*/
        for (int i = 0; i < (passwordString.length()) - 2; i++) {
            Character character1 = passwordString.charAt(i);
            Character character2 = passwordString.charAt(i + 1);
            Character character3 = passwordString.charAt(i + 2);

            if (character1 == character2 && character2 == character3)
                throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
        }

        return true;
    }


    public static boolean isWeakPassword(String passwordString) {

        if (passwordString.length() >= 6 && passwordString.length() <= 9)
            return true;

        return false;
    }


    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {

        ArrayList<String> invalidPasswords = null;

        for (String password: passwords) {
            if (!(isValidPassword(password)))
                invalidPasswords.add(password);
        }

        return invalidPasswords;
    }
}
