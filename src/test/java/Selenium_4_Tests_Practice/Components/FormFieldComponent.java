package Selenium_4_Tests_Practice.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public abstract class FormFieldComponent {

    private enum Using {
        ERROR_MESSAGES(By.xpath("//div[@class='text-danger']")),
        EMAIL_ERROR_MESSAGE(By.xpath("//input[@id='input-email']"));

        public final By selector;

        Using(By selector) {
            this.selector = selector;
        }
    }

    private final WebElement element;
    private final WebDriver page;

    /**
     * Constructor for the FormFieldComponent abstract class.
     *
     * @param element WebElement
     */
    public FormFieldComponent(WebElement element, WebDriver page) {
        this.element = element;
        this.page = page;
    }

    /**
     * Get the WebElement of the FormFieldComponent.
     * Send the WebElement to the InputTextComponent.
     */
    public WebElement getElement() {
        return element;
    }

    public WebDriver getPage() {
        return page;
    }

    /**
     * Get the Error Message of the Web Element: 'First Name and Last name' fields
     */
    public String getErrorMessage() {
        return element.findElement(Using.ERROR_MESSAGES.selector).getText();
    }

    /**
     * Get the Error Message of the Web Element: 'Email' using Relative Locators Selenium 4.0.
     * Element to search with the BELOW method.
     */
    public String getEmailErrorMessage() {
        WebElement errorMsg = element.findElement(Using.ERROR_MESSAGES.selector);
        WebElement relativeEmail = element.findElement(RelativeLocator.with(Using.EMAIL_ERROR_MESSAGE.selector).above(errorMsg));
        return relativeEmail.getText();
    }
}
