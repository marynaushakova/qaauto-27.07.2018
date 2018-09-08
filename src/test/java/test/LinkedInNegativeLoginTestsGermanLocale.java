package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedInLoginSubmitPage;

public class LinkedInNegativeLoginTestsGermanLocale extends BaseTest{

    @DataProvider
     public Object[][] invalidUserEmailAndPasswordCombinations() {
            return new Object[][]{
                     {"a", "1", "Der von Ihnen eingegebene Text ist zu kurz (Mindestlänge ist 3 Zeichen, Ihr Text enthält 1 Zeichen).", "Das von Ihnen eingegebene Passwort muss mindestens 6 Zeichen umfassen."},
                     {"MF689799@GMAIL.COM", "MIRIAM123", "", "Das ist nicht das richtige Passwort. Versuchen Sie es erneut oder"},
                     {"1","1111111111111", "Geben Sie eine gültige E-Mail-Adresse ein.", ""},
                     {"qwertyuiop", "qwertyuiop", "Geben Sie eine gültige E-Mail-Adresse ein.", ""},
                     {"qwertyuiop@bla.bla", "qwertyuiop", "Ihre E-Mail-Adresse wurde nicht erkannt. Versuchen Sie es erneut. ", ""},
                     {"qwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiop", "qwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiop", "Der von Ihnen eingegebene Text ist zu lang (maximale Länge ist 128 Zeichen, Ihr Text enthält 150 Zeichen).", ""},
                     {"qwertyuiop@bla.bla","qwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwerty", "","Ihr Passwort muss mindestens 400 Zeichen umfassen." }
            };
    }

    @Test (dataProvider = "invalidUserEmailAndPasswordCombinations")
    public void validateWrongUserEmailAndPassword (String userEmail, String userPass, String userEmailValidationText, String userPasValidationText ){
            LinkedInLoginSubmitPage linkedInLoginSubmitPage = linkedInLoginPage.login(userEmail, userPass);
            Assert.assertTrue(linkedInLoginSubmitPage.isLoaded(), "User is not on LoginSubmit page.");

            Assert.assertEquals(linkedInLoginSubmitPage.getAlertBoxText(),
                        "Es ist mindestens ein Fehler aufgetreten. Bitte korrigieren Sie die markierten Felder.",
                        "Alert box has incorrect message when Short Email And Pass are set");

            Assert.assertEquals(linkedInLoginSubmitPage.getUserEmailValidationText(), userEmailValidationText,
                        "User Email Validation Field has wrong message text");

            Assert.assertEquals(linkedInLoginSubmitPage.getUserPasswordValidationText(), userPasValidationText,
                        "User Password Validation Field has wrong message text");
    }
}

