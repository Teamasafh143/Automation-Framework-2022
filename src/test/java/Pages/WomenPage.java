package Pages;

import org.openqa.selenium.By;

public class WomenPage extends WebCommands {
    By womenTabLocator = By.xpath("//a[@title='Women']");
    By blousesTabLocator = By.xpath("//a[@title='Blouses']");
    By blouseImageLocator=By.xpath("//img[@class=\"replace-2x img-responsive\"]");
    By whiteBlouseImageLocator=By.xpath("//img[@class=\"img-responsive\"]");
    By addToCartLocator=By.xpath("//span[text()=\"Add to cart\"]");
    By proceedToCheckOutLocator=By.xpath("//a[@title=\"Proceed to checkout\"]");
    By textAreaLocator=By.xpath("//textarea[@class=\"form-control\"]");
    By proceedToCheckOutLocator2=By.xpath("//span[text()='Proceed to checkout']");
    By deliveryOptionRadioButtonLocator=By.xpath("//input[@id=\"delivery_option_699531_0\"]");


    public void mouseHoverToWomenTab()
    {
        moveMouseToElement(womenTabLocator);
    }

    public void clickBlouseTab(){
        clickMoveMouseToElement(blousesTabLocator);
    }

    public void mouseHoverToBlouseImage()
    {
        moveMouseToElement(blouseImageLocator);
    }

    public void clickBlouseImageLocator(){
        clickMoveMouseToElement(blouseImageLocator);
    }

    public void mouseHoverToWhiteBlouseImage()
    {
        moveMouseToElement(whiteBlouseImageLocator);
    }

    public void clickAddToCartLocator(){
        clickThis(addToCartLocator);
    }
    public void clickProceedToCheckOutLocator(){
        clickThis(proceedToCheckOutLocator);
    }

    public void typeCommends(){
        type(textAreaLocator,"Birthday Party Dress");
    }
    public void clickProceedToCheckOutLocator2(){
        clickThis(proceedToCheckOutLocator2);
    }

    public void verifyDeliveryOptionRadioButton(){
        String  checked;
        String checked;

        radioButtonCheck(deliveryOptionRadioButtonLocator,checked,checked);
    }

}
