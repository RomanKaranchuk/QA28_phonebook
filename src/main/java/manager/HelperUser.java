package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
//    WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
//    //xPath--> //a[text()='LOGIN']
//    loginTab.click();
        click(By.cssSelector("a[href='/login']"));

    }


    public void fillLoginRegistrationForm(String email, String password) {
        type(By.name("email"), email);
        type(By.xpath("//input[last()]"), password);
    }


    public void submitLogin() {
        click(By.xpath("//button[text()='Login']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text() = 'Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//button[text() = 'Sign Out']"));
    }

    public void openRegistrationForm() {

        click(By.cssSelector("a[href='/login']"));

    }

    public void fillRegistrationForm(String email, String password) {
        type(By.name("email"), email);
        type(By.xpath("//input[last()]"), password);
    }

    public void fillRegistrationForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void submitRegistration() {
        click(By.xpath("//button[text()='Registration']"));
    }

    public boolean isRegistration() {
        return isElementPresent(By.xpath("//button[text() = 'Sign Out']"));
    }


    public byte[] getMessage() {
        return null;
    }

    public void fillLogiRegistrationForm(User user) {
    }
}
