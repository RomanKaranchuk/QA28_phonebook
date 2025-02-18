package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        //if SignOut present --->logout
        if (app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }


    @Test
    public void loginSuccess() {
        User user = new User().setEmail("romaabc@maile.com").setPassword("Abcd1234$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("romaabcd@maile.com", "Abcd12345$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());

    }

    @Test
    public void loginSuccess1() {
        User user = new User().setEmail("romaabcd@maile.com").setPassword("Abcd12345$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void loginSuccessModel() {
        User user = new User().setEmail("romaabc@maile.com").setPassword("Abcd1234$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("romaabcd@maile.com", "Abcd12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void loginWrongEmail() {
        User user = new User().setEmail("romaabc@maile.com").setPassword("Abcd1234$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("romaabcd@maile.com", "Abcd12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @Test
    public void loginWrongPassword() {
        User user = new User().setEmail("romaabc@maile.com").setPassword("Abcd1234$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("romaabcd@maile.com", "Abcd12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }

    @Test
    public void loginUnregisteredUser() {
        User user = new User().setEmail("romaabc@maile.com").setPassword("Abcd1234$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("romaabcd@maile.com", "Abcd12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }


}
