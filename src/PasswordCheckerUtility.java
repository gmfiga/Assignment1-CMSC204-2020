import Exceptions.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {


    public PasswordCheckerUtility() {
    }

    public static void comparePasswords(String password, String passwordConfirm){
        if (password.compareTo(passwordConfirm) != 0)
            throw new UnmatchedException("Passwords do not match");
    }

    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm){
        if (password.compareTo(passwordConfirm) != 0)
            return false;
        return true;
    }

    public static boolean hasBetweenSixAndNineChars(String password) {

        if (password.length() >= 6 && password.length() <= 9)
            return true;

        return false;

    }

    public static boolean hasDigit(String password) throws NoDigitException{
        for (int i = 0; i < password.length(); i++) {
            Character c = password.charAt(i);
            if (Character.isDigit(c)) {
                return true;
            }
        }
        throw new NoDigitException("The password must contain at least one digit");
    }

    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
        for (int i = 0; i < password.length(); i++) {
            Character c = password.charAt(i);
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        throw new NoLowerAlphaException("The password must contain at least one lower case alphabetic character");
    }

    public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException{
        for (int i = 0; i < (password.length()) - 2; i++) {
            Character character1 = password.charAt(i);
            Character character2 = password.charAt(i + 1);
            Character character3 = password.charAt(i + 2);
            if (character1 == character2 && character2 == character3)
                throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
        }
        return true;
    }

    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(password);
        boolean hasSpecialChar = matcher.find();
        if (hasSpecialChar == false) {
            throw new NoSpecialCharacterException("The password must contain at least one special character");
        }
        return true;
    }

    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
        for (int i = 0; i < password.length(); i++) {
            Character c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
    }

    public static boolean isValidLength(String password) throws LengthException{
        if (password.length() < 6) {
            throw new LengthException("The password must be at least 6 characters long");
        }
        return true;
    }


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
        } else if (!(hasSpecialChar(password))){
            throw new NoSpecialCharacterException("The password must contain at least one special character"); //check special
        } else if (!(hasSameCharInSequence(password))){
            throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence"); //check sequence
        }

        return true;
    }


    public static boolean isWeakPassword(String password) {
        return hasBetweenSixAndNineChars(password);
    }

    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {

        ArrayList<String> invalidPasswords = new ArrayList<>();

        for (String password : passwords) {
            try{
                isValidPassword(password);
            }
            catch (Exception e){
                invalidPasswords.add(password+" -> "+e.getMessage());
            }
        }
        return invalidPasswords;
    }
}
