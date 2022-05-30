package Pages;

import Helper.Misc;
import Pages.WebCommands;
import org.openqa.selenium.By;
import java.util.NoSuchElementException;
import java.util.NoSuchElementException;

public class LoginPage extends WebCommands {

        By signInButtonLocator=By.xpath("//a[contains(text(),\"Sign\")]");
        By loginEmailLocator=By.xpath("//input[@id='email']");
        By loginPasswordLocator=By.xpath("//input[@id='passwd']");
        By signInLoginButtonLocator=By.xpath("//i[@class='icon-lock left']");
        By errorMessageDisplayLocator=By.xpath("//p[text()='There is 1 error']");



        public void clickSignInButton(){
                clickThis(signInButtonLocator);
        }

        public void clickSignInLoginButton()
        {
            clickThis(signInLoginButtonLocator);
        }

        public void enterLoginEmailAddress(String inputEmail) {
            type(loginEmailLocator, inputEmail);
            Misc.sleep(2);
        }

        public void enterLoginPassword(String inputPassword) {
            type(loginPasswordLocator, inputPassword);
            Misc.sleep(2);
        }

        public String homepageDisplayed(){
          return getWebPageTitle();
        }


        public boolean loginFailErrorMessage(){
            return isWebElementDisplayed(errorMessageDisplayLocator);

        }
    }


