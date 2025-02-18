package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }

    @Test
    public void RegistrationSuccess() {
        // app.getHelperUser().openLoginRegistrationForm();
        //app.getHelperUser().fillLoginRegistrationForm("romabcd112@maile.com", "Aabcd12345$");
        //app.getHelperUser().submitRegistration();

        //Assert.assertTrue(app.getHelperUser().isRegistration());

    }

    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        System.out.println(i);


        System.out.println(System.currentTimeMillis());
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);
        System.out.println(z);

        User user = new User()
                .setFirsName("Lisa")
                .setLastName("Snow")
                .setEmail("snow" + i + "@gmail.com")
                .setPassword("Snow123456$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);


        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");


    }

    @Test
    public void RegistrationWrongEmail() {
        User user = new User().setEmail("romaabcmaile.com").setPassword("Abcd1234$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("romabcd112@maile.com", "Aabcd12345$");
        app.getHelperUser().submitRegistration();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"It' snot look like email");
        Assert.assertTrue(app.getHelperUser().isRegistrationButtonNoteActive());
    }

    @Test
    public void RegistrationWrongPassword() {
        User user = new User().setEmail("romaabc@maile.com").setPassword("Abcd");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("romabcd112@maile.com", "Aabcd12345$");
        app.getHelperUser().submitRegistration();
    }

    @Test
    public void RegistrationEmptyEmail() {
        User user = new User().setEmail("").setPassword("Abcd1234$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("romabcd112@maile.com", "Aabcd12345$");
        app.getHelperUser().submitRegistration();
    }

    @Test
    public void RegistrationEmptyPassword() {
        User user = new User().setEmail("romaabc@maile.com").setPassword("");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("romabcd112@maile.com", "Aabcd12345$");
        app.getHelperUser().submitRegistration();
    }
}
