package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframe;
    public FramePage returnListOfFrames() {
        // iframe.size();  // by finding all webelements
        System.out.println("Tha total size" + iframe.size());
        return this;
    }

    public FramePage switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;
    public FramePage verifyIFrameByText(String text) {
        Assert.assertTrue(shouldHaveText(sampleHeading, text, 5));
        return this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;
    public FramePage switchToFrameById(){
        driver.switchTo().frame(frame1);
        return this;
    }

    public FramePage switchToMainPage() {
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(tagName = "h1")
    WebElement title;
    public FramePage verifyMainPageByTitle(String text) {
        Assert.assertTrue(title.getText().contains(text));
        return this;
    }

    @FindBy(tagName = "body")
    WebElement body;
    public FramePage handleNestedFrames() {
        driver.switchTo().frame(frame1);  // switch to frame1
        System.out.println("IFrame is " + body.getText());  // gettext from parent frame
        System.out.println("Number of IFrames inside iframe is " + iframe.size());  // number of Iframes in parent
        driver.switchTo().frame(0);  // switch to child
        System.out.println("IFrame is " + body.getText());
        driver.switchTo().parentFrame();// switch to parent
        System.out.println("IFrame is " + body.getText());
        return this;
    }
}
