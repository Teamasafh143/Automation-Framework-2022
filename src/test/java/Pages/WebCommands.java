package Pages;

import Helper.Misc;
import Web.UseDriver;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class WebCommands {

    //get element without wait
    public WebElement getElement(By locator)
    {return UseDriver.getDriver().findElement(locator);
    }


    // scroll to find element
    public WebElement getElementByScrollInWebpage(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) UseDriver.getDriver();     // Casting
        js.executeScript("scrollBy(0,800);");
        Misc.sleep(1);
        return UseDriver.getDriver().findElement(locator);
    }

//scroll down and click element
    public WebElement getWebElementByScrollInWebPage(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) UseDriver.getDriver();     // Casting
        js.executeScript("scrollBy(0,800);");
        Misc.sleep(1);
         UseDriver.getDriver().findElement(locator).click();
        return UseDriver.getDriver().findElement(locator);
    }
    //scroll down and click element with diff pixel
    public WebElement getWebElementByScroll(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) UseDriver.getDriver();     // Casting
        js.executeScript("scrollBy(0,1000);");
        Misc.sleep(1);
        UseDriver.getDriver().findElement(locator).click();
        return UseDriver.getDriver().findElement(locator);
    }
//scroll over method
    public String  getWebElementByScrollOver(By element,By element1) {
        JavascriptExecutor js = (JavascriptExecutor) UseDriver.getDriver();
        js.executeScript("scrollBy(0,800);");
        Misc.sleep(1);
        UseDriver.getDriver().findElement(element).click();
       String value= UseDriver.getDriver().findElement(element1).getText();
       return value;
    }
//scroll down with for loop
    public WebElement getElementWithScroll(By locator) {
        WebElement element = null;
        for (int i=1 ; i <= 20 ; i++) {
        try{
                scrollDown(800);
                element = UseDriver.getDriver().findElement(locator);
                break;}
        catch(NoSuchElementException e){
                scrollDown(800);}

            try {
                element = UseDriver.getDriver().findElement(locator);
                break;}
            catch (ElementNotInteractableException e) {
                scrollDown(800);}
            System.out.println("Hi ele");

            }
        return element;
    }
//scroll down with for loop and pixel value
    public WebElement getElementWithScroll(By locator,int value) {
        WebElement element = null;
        for (int i=1 ; i <= 6 ; i++) {
            try {
                element = UseDriver.getDriver().findElement(locator);
                break;}
             catch (NoSuchElementException e) {
                scrollDown(value);}
            System.out.println(element);}
        return element;
    }
//clear
    public void clear(By locator){
        clear(locator);
    }

//get element with wait
    public WebElement getElementWithWait(By locator) {
        Wait fWait = new FluentWait(UseDriver.getDriver())
                .withTimeout(Duration.ofSeconds(45))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoAlertPresentException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Element is not found within 30 seconds");

        WebElement element = (WebElement) fWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return element;
    }
//get web elements
    public List<WebElement> getElements(By locator) {
        return UseDriver.getDriver().findElements(locator);
    }
//get web element and type and click
    public void type(By locator, String data) {
        getElement(locator).sendKeys(data);
        clickThis(locator);
        Misc.sleep(10);}
    //get web element and type
        public void type(WebElement element, String data) {
        element.sendKeys(data);
        Misc.sleep(2);}

//click the web element
    public void clickThis(By locator) {
        getElementWithWait(locator).click();
        Misc.sleep(2);}

    public void clickThisWithScroll(By locator,int value){
        getElementWithScroll(locator,value).click();
    }

    public void clickThisByLocator(By locator) {
        getElement(locator).click();
        Misc.sleep(2);
    }

    public void clickThis(WebElement element) {
        element.click();
        Misc.sleep(2);
    }
    public void selectFromDropdown(By locator, String dataToSelect) {
        WebElement dropdownElement = getElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(dataToSelect);
        Misc.sleep(2);}

    public void selectFromDropdownMonth(By locator, String dataToSelect) {
        WebElement dropdownElement = getElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(dataToSelect);
        Misc.sleep(2);}

    public void selectFromDropdownText(By locator, String dataToSelect) {
        WebElement dropdownElement = getElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(dataToSelect);
        Misc.sleep(2);}

    public void selectFromDropdownDate(By locator, String dataToSelect) {
        WebElement dropdownElement = getElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(dataToSelect);
        Misc.sleep(2);}

    public void selectFromDropdownYear(By locator, int indexValue) {
        WebElement dropdownElement = getElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(indexValue);
        Misc.sleep(2);}

    public String getHandle() {
        return UseDriver.getDriver().getWindowHandle();}

    public Set<String> getAllHandles() {
        return UseDriver.getDriver().getWindowHandles();}

    public String getWebPageTitle() {
        return UseDriver.getDriver().getTitle();}

    public String getWebPageUrl() {
        return UseDriver.getDriver().getCurrentUrl();}

    public void switchToHandle(String handle) {
        UseDriver.getDriver().switchTo().window(handle);}

    public void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) UseDriver.getDriver();     // Casting
        js.executeScript("scrollBy(0,"+pixels+");");
        Misc.sleep(2);}

    public void scrollUp(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) UseDriver.getDriver();     // Casting
        js.executeScript("scrollBy(0,-"+pixels+");");
        Misc.sleep(2);
    }

    public void pageScrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) UseDriver.getDriver();     // Casting
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Misc.sleep(2);
    }

    public void moveMouseToElement(By locator) {
        WebElement element = getElement(locator);
        Actions act = new Actions(UseDriver.getDriver());
        act.moveToElement(element).build().perform();
        Misc.sleep(2);
    }

    public void moveMouseToElement(WebElement element) {
        Actions act = new Actions(UseDriver.getDriver());
        act.moveToElement(element);
    }

    public void clickMoveMouseToElement(By locator) {
        WebElement element = getElement(locator);
        Actions act = new Actions(UseDriver.getDriver());
        act.click(element).build().perform();
        Misc.sleep(2);
    }


    public void clickOneOfElementsUsingText(By locator, String text) {
        List<WebElement> allElements = getElements(locator);
        for (WebElement element : allElements) {
            String elementText = element.getText();
            if (elementText.equalsIgnoreCase(text)) {
                clickThis(element);
                Misc.sleep(2);
                break;
            }
        }
    }

    public void clickOneOfElementsUsingAttributeValue(By locator, String attributeName, String attributeValue) {
        List<WebElement> allElements = getElements(locator);
        for (WebElement element : allElements) {
            String attributeValueFromWeb = element.getAttribute(attributeName);
            if (attributeValueFromWeb.equalsIgnoreCase(attributeValue)) {
                clickThis(element);
                Misc.sleep(2);
                break;
            }
        }
    }

    public boolean radioButtonCheck(By locator ,String attributeName,String attributeValue){
        boolean value;
        WebElement element = getElement(locator);
        String attributeValueFromWeb = element.getAttribute(attributeName);
        if (attributeValueFromWeb.equalsIgnoreCase(attributeValue)) {
             value = true;
        }
        else {
            value = false;
        }
        return value;
    }


    public void switchToFrame(String idValue) {
        UseDriver.getDriver().switchTo().frame(idValue);
    }

    public void switchToFrame(By locator) {
        WebElement element = getElementWithScroll(locator);
        UseDriver.getDriver().switchTo().frame(element);
    }

    public boolean isWebElementDisplayed(By locator) {
        return getElement(locator).isDisplayed();
    }

    public boolean isWebElementEnabled(By locator) {
        return getElementWithWait(locator).isEnabled();
    }

    public boolean isWebElementSelected(By locator) {
        return getElementWithWait(locator).isSelected();
    }


    public String getTextValueFromWebElement(By locator){
        return getElement(locator).getText();
    }

    public String getTextFromWebElement(By locator){
    WebElement j=getElementWithWait(locator);
    Select ss=new Select(j);
    WebElement o = ss.getFirstSelectedOption();
    String selectedoption = o.getText();
//    System.out.println("The selected option is :"+selectedoption);
    return selectedoption;
}


//DATE TEXT
public List<String> getTextFromListOfElements(By locator) {
   List<String> textValues=new ArrayList<String>();
    List<WebElement> allElements = getElements(locator);
    for (WebElement element : allElements) {
        textValues.add(element.getText());

        }
    System.out.println("The text from date values are :"+textValues);
    return textValues;}


    public void switchHandleToAnotherPage(By locator,int scrollValue){
        try {
            String mainWindowHandle = getHandle();
            // System.out.println("The mainWindowHandle is :"+mainWindowHandle);
            Set<String> hotelCareHandles = getAllHandles();
            //  System.out.println("The list are :"+hotelCareHandles);
            //  System.out.println("The size of handles:" + hotelCareHandles.size());
            for (String myHandle : hotelCareHandles) {
                if (!myHandle.equals(mainWindowHandle)) {
                    String newHandle = myHandle;
                   switchToHandle(myHandle);
                    //System.out.println("The new handle after switch value is :" + newHandle);
                }}
            String newWindowHandle = getHandle();
            //System.out.println("The newWindowHandle is :"+newWindowHandle);
            UseDriver.getDriver().manage().window().maximize();
            clickThisWithScroll(locator,scrollValue);
        }

        catch (NoSuchElementException e) {
            pageScrollToBottom();
            clickThis(locator);
        }
    }

}