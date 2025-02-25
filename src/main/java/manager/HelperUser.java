package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        click(By.cssSelector("a[href='/login']"));

    }


    public void fillLoginRegistrationForm(String email, String password) {
        type(By.name("email"), email);
        type(By.xpath("//input[last()]"), password);
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.xpath("//input[last()]"), user.getPassword());
    }


    public void sumitLogin() {
        click(By.xpath("//button[text()='Login']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text() = 'Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//button[text() = 'Sign Out']"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[text()='Registration']"));
    }

    public boolean isNoContactsHereDisplayed() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions
                .textToBePresentInElement(wd.findElement(By.cssSelector(".contact-page_message__2qafk>h1")),
                        "No Contacts here!"));
    }

    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        sumitLogin();

    }
}
