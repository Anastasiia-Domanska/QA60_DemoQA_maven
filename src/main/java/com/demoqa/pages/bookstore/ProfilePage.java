package com.demoqa.pages.bookstore;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#userName-value")
    WebElement userName;
    public ProfilePage verifyUserName(String text) {
        Assert.assertTrue(userName.getText().contains(text));
        return this;
    }

    @FindBy(id = "searchBox")
    WebElement searchBox;
    public ProfilePage typeKeyInSearchInput(String text) {
        type(searchBox, text);
        return this;
    }

    @FindBy(css = ".mr-2 a")
    WebElement nameBook;
    public ProfilePage verifyNameBook(String text) {
        Assert.assertTrue(shouldHaveText(nameBook, text, 5));
        return this;
    }

}
