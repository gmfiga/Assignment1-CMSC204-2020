import Exceptions.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * PasswordCheckerUtility
 *
 * @author Gabriel Martins Figueiredo
 */
public class PasswordCheckerUtility {


    /**
     * Standard constructor
     */
    public PasswordCheckerUtility() {
    }


    /**
     * Compare two passwords
     *
     * @param password        - - password string to be checked for length
     * @param passwordConfirm - - passwordConfirm string to be checked against password for length
     * @throws UnmatchedException - thrown if not same length
     */
    public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
        if (password.compareTo(passwordConfirm) != 0)
            throw new UnmatchedException("Passwords do not match");
    }

    /**
     * Compare two passwords
     *
     * @param password        - - password string to be checked for length
     * @param passwordConfirm - - passwordConfirm string to be checked against password for length
     * @return true if both are equal
     */
    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
        if (password.compareTo(passwordConfirm) != 0)
            return false;
        return true;
    }

    /**
     * Weak password length check - Password contains 6 to 9 characters , still considers valid, just weak
     *
     * @param password - - password string to be checked for Sequence requirement
     * @return true if password contains 6 to 9 characters
     */
    public static boolean hasBetweenSixAndNineChars(String password) {

        if (password.length() >= 6 && password.length() <= 9)
            return true;

        return false;

    }

    /**
     * Checks the password Digit requirement - Password must contain a numeric character
     *
     * @param password - - password string to be checked for Digit requirement
     * @return true if meet Digit requirement
     * @throws NoDigitException - thrown if does not meet Digit requirement
     */
    public static boolean hasDigit(String password) throws NoDigitException {
        for (int i = 0; i < password.length(); i++) {
            Character c = password.charAt(i);
            if (Character.isDigit(c)) {
                return true;
            }
        }
        throw new NoDigitException("The password must contain at least one digit");
    }

    /**
     * Checks the password lowercase requirement - Password must contain a lowercase alpha character
     *
     * @param password - - password string to be checked for lowercase requirement
     * @return true if meet lowercase requirement
     * @throws NoLowerAlphaException - thrown if does not meet lowercase requirement
     */
    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
        for (int i = 0; i < password.length(); i++) {
            Character c = password.charAt(i);
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        throw new NoLowerAlphaException("The password must contain at least one lower case alphabetic character");
    }

    /**
     * Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
     *
     * @param password - - password string to be checked for Sequence requirement
     * @return true if meets Sequence requirement
     * @throws InvalidSequenceException - thrown if does not meet Sequence requirement
     */
    public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException {
        for (int i = 0; i < (password.length()) - 2; i++) {
            Character character1 = password.charAt(i);
            Character character2 = password.charAt(i + 1);
            Character character3 = password.charAt(i + 2);
            if (character1 == character2 && character2 == character3)
                throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
        }
        return true;
    }

    /**
     * Checks the password SpecialCharacter requirement - Password must contain a Special Character
     *
     * @param password - - password string to be checked for SpecialCharacter requirement
     * @return true if meet SpecialCharacter requirement
     * @throws NoSpecialCharacterException - thrown if does not meet SpecialCharacter requirement
     */
    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(password);
        boolean hasSpecialChar = matcher.find();
        if (hasSpecialChar == false) {
            throw new NoSpecialCharacterException("The password must contain at least one special character");
        }
        return true;
    }

    /**
     * Checks the password alpha character requirement - Password must contain an uppercase alpha character
     *
     * @param password - - password string to be checked for alpha character requirement
     * @return true if meet alpha character requirement
     * @throws NoUpperAlphaException - thrown if does not meet alpha character requirement
     */
    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
        for (int i = 0; i < password.length(); i++) {
            Character c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
    }

    /**
     * Checks the password length requirement - – The password must be at least 6 characters long
     *
     * @param password - - password string to be checked for length
     * @return true if meet min length requirement
     * @throws LengthException - thrown if does not meet min length requirement
     */
    public static boolean isValidLength(String password) throws LengthException {
        if (password.length() < 6) {
            throw new LengthException("The password must be at least 6 characters long");
        }
        return true;
    }


    /**
     * Return true if valid password (follows all rules from above), returns false if an invalid password
     *
     * @param password - - string to be checked for validity
     * @return true if valid password (follows all rules from above)
     * @throws LengthException             - thrown if length is less than 6 characters
     * @throws NoDigitException            - thrown if no digit
     * @throws NoUpperAlphaException       - thrown if no uppercase alphabetic
     * @throws NoLowerAlphaException       - thrown if no lowercase alphabetic
     * @throws NoSpecialCharacterException - thrown if does not meet SpecialCharacter requirement
     * @throws InvalidSequenceException    - thrown if more than 2 of same character.
     */
    public static boolean isValidPassword(String password) throws LengthException,
            NoDigitException,
            NoUpperAlphaException,
            NoLowerAlphaException,
            NoSpecialCharacterException,
            InvalidSequenceException {

        if (!(isValidLength(password))) {
            throw new LengthException("The password must be at least 6 characters long"); //check length
        } else if (!(hasUpperAlpha(password))) {
            throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character"); //check upper case
        } else if (!(hasLowerAlpha(password))) {
            throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character"); //check lower case
        } else if (!(hasDigit(password))) {
            throw new NoDigitException("The password must contain at least one digit"); //check digit
        } else if (!(hasSpecialChar(password))) {
            throw new NoSpecialCharacterException("The password must contain at least one special character"); //check special
        } else if (!(hasSameCharInSequence(password))) {
            throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence"); //check sequence
        }

        return true;
    }


    /**
     * Checks if password is valid but between 6 -9 characters
     *
     * @param password - - string to be checked if weak password
     * @return true if length of password is between 6 and 9 (inclusive).
     */
    public static boolean isWeakPassword(String password) {
        return hasBetweenSixAndNineChars(password);
    }

    /**
     * Reads a file of passwords and the passwords that failed the check will be added to an invalidPasswords with the reason
     *
     * @param passwords - - list of passwords read from a file
     * @return invalidPasswords - ArrayList of invalid passwords in the correct format
     */
    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {

        ArrayList<String> invalidPasswords = new ArrayList<>();

        for (String password : passwords) {
            try {
                isValidPassword(password);
            } catch (Exception e) {
                invalidPasswords.add(password + " -> " + e.getMessage());
            }
        }
        return invalidPasswords;
    }
}
