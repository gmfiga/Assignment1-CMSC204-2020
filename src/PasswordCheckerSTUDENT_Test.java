import Exceptions.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * STUDENT tests for the methods of PasswordChecker
 *
 * @author Gabriel Martins Figueiredo
 */
public class PasswordCheckerSTUDENT_Test {

    String shortPassword = "abc";
    String noUpperAlphaPassword = "abc!123";
    String noLowerAlphaPassword = "ABC!123";
    String noDigitPassword = "abcABC!";
    String invalidSequencePassword = "aaaABC!123";
    String noSpecialCharacterPassword = "abcABC123";
    String perfectPassword = "abcABC!123";
    String password2 = "1";
    String sevenCharPassword = "aB123!7";
    ArrayList<String> passwordsList;
    ArrayList<String> validPasswordsList;


    @Before
    public void setUp() throws Exception {
        String[] invalidPwds = {shortPassword, noUpperAlphaPassword, noLowerAlphaPassword, noDigitPassword
                ,invalidSequencePassword, noSpecialCharacterPassword, password2, sevenCharPassword};
        passwordsList = new ArrayList<String>();
        passwordsList.addAll(Arrays.asList(invalidPwds));

        String[] allValidPasswords = {perfectPassword,sevenCharPassword};
        validPasswordsList = new ArrayList<String>();
        validPasswordsList.addAll(Arrays.asList(allValidPasswords));
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * Test if the passwords are equal
     * This test should throw a UnmatchedException for second case.
     */
    @Test
    public void testComparePasswords() {
        try {
            PasswordCheckerUtility.comparePasswords(perfectPassword, password2);
        } catch (UnmatchedException exception) {
            assertEquals("Passwords do not match", exception.getMessage());
        }
    }

    /**
     * Test if the password is less than 6 characters long.
     * This test should not throw a LengthException for second case.
     */
    @Test
    public void testValidLength() {
        try {
            assertTrue(PasswordCheckerUtility.isValidLength(perfectPassword));
        } catch (LengthException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test if the password is less than 6 characters long.
     * This test should throw a LengthException for second case.
     */
    @Test
    public void testInValidLength() {
        try {
            PasswordCheckerUtility.isValidLength(shortPassword);
        } catch (LengthException exception) {
            assertEquals("The password must be at least 6 characters long", exception.getMessage());
        }
    }

    /**
     * Test if the password has at least one uppercase alpha character
     * This test should not throw a NoUpperAlphaException for second case
     */
    @Test
    public void tesHasUpperAlpha() {
        try {
            assertTrue(PasswordCheckerUtility.hasUpperAlpha(perfectPassword));
        } catch (NoUpperAlphaException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test if the password has at least one uppercase alpha character
     * This test should throw a NoUpperAlphaException for second case
     */
    @Test
    public void testDoesNotHaveUpperAlpha() {
        try {
            PasswordCheckerUtility.hasUpperAlpha(noUpperAlphaPassword);
        } catch (NoUpperAlphaException exception) {
            assertEquals("The password must contain at least one uppercase alphabetic character", exception.getMessage());
        }
    }

    /**
     * Test if the password has at least one lowercase alpha character
     * This test should not throw a NoLowerAlphaException for second case
     */
    @Test
    public void testHasLowerAlpha() {
        try {
            assertTrue(PasswordCheckerUtility.hasLowerAlpha(perfectPassword));
        } catch (NoLowerAlphaException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test if the password has at least one lowercase alpha character
     * This test should throw a NoLowerAlphaException for second case
     */
    @Test
    public void testDoesNotHaveLowerAlpha() {
        try {
            PasswordCheckerUtility.hasLowerAlpha(noLowerAlphaPassword);
        } catch (NoLowerAlphaException exception) {
            assertEquals("The password must contain at least one lower case alphabetic character", exception.getMessage());
        }
    }


    /**
     * Test if the password has at least one special character
     * This test should not throw a NoSpecialCharacterException for second case
     */
    @Test
    public void testHasSpecialChar() {
        try {
            assertTrue(PasswordCheckerUtility.hasSpecialChar(perfectPassword));
        } catch (NoSpecialCharacterException e) {
            e.printStackTrace();
        }
    }


    /**
     * Test if the password has at least one special character
     * This test should throw a NoSpecialCharacterException for second case
     */
    @Test
    public void testDoesNotHaveSpecialChar() {
        try {
            PasswordCheckerUtility.hasSpecialChar(noSpecialCharacterPassword);
        } catch (NoSpecialCharacterException exception) {
            assertEquals("The password must contain at least one special character", exception.getMessage());
        }
    }

    /**
     * Test if the password has at least one digit
     * This test should not throw a NoDigitException
     */
    @Test
    public void testHasDigit() {
        try {
            assertTrue(PasswordCheckerUtility.hasDigit(perfectPassword));
        } catch (NoDigitException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test if the password has at least one digit
     * This test should throw a NoDigitException
     */
    @Test
    public void testDoesNotHaveDigit() {
        try {
            PasswordCheckerUtility.hasDigit(noDigitPassword);
        } catch (NoDigitException exception) {
            assertEquals("The password must contain at least one digit", exception.getMessage());
        }
    }

    /**
     * Test if the password has more than 2 of the same character in sequence
     * This test should not throw a InvalidSequenceException for second case
     */
    @Test
    public void testDoesNotHaveSameCharInSequence() {
        try {
            assertTrue(PasswordCheckerUtility.hasSameCharInSequence(perfectPassword));
        } catch (InvalidSequenceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test if the password has more than 2 of the same character in sequence
     * This test should throw a InvalidSequenceException for second case
     */
    @Test
    public void testHasSameCharInSequence() {
        try {
            PasswordCheckerUtility.hasSameCharInSequence(invalidSequencePassword);
        } catch (InvalidSequenceException exception) {
            assertEquals("The password cannot contain more than two of the same character in sequence", exception.getMessage());
        }
    }

    /**
     * Test if the password has between 6 and 9 characters
     */
    @Test
    public void testHasBetweenSixAndNineC() {
        assertTrue(PasswordCheckerUtility.hasBetweenSixAndNineChars(sevenCharPassword));
    }

    /**
     * Test is list of invalid passwords contain the right passwords and formatting
     */
    @Test
    public void testGetInvalidPasswords() {
        ArrayList<String> results;
        results = PasswordCheckerUtility.getInvalidPasswords(passwordsList);
        assertEquals(results.size(), 7);
        assertEquals(results.get(0), "abc -> The password must be at least 6 characters long");
        assertEquals(results.get(1), "abc!123 -> The password must contain at least one uppercase alphabetic character");
        assertEquals(results.get(2), "ABC!123 -> The password must contain at least one lower case alphabetic character");
        assertEquals(results.get(3), "abcABC! -> The password must contain at least one digit");
        assertEquals(results.get(4), "aaaABC!123 -> The password cannot contain more than two of the same character in sequence");
        assertEquals(results.get(5), "abcABC123 -> The password must contain at least one special character");
        assertEquals(results.get(6), "1 -> The password must be at least 6 characters long");
    }

    /**
     * Test is list of valid passwords are not written in invalid passwords output
     */
    @Test
    public void testGetValidPasswords() {
        ArrayList<String> results;
        results = PasswordCheckerUtility.getInvalidPasswords(validPasswordsList);
        assertTrue(results.isEmpty());
    }
}