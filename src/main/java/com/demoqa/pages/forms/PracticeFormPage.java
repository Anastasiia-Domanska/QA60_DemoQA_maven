package com.demoqa.pages.forms;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userNumber")
    WebElement userNumber;
    public PracticeFormPage enterPersonalData(String name, String surName, String email, String phone) {
        typeWithJS(firstName, name, 0, 300);
        type(lastName, surName);
        type(userEmail, email);
        type(userNumber, phone);
        return this;
    }

    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;
    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;
    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;
    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Female")) {
            click(female);
        } else if (gender.equals("Male")){
            click(male);
        } else {
            click(other);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;
    public PracticeFormPage enterDate(String date) {
        click(dateOfBirthInput);
        String os = System.getProperty("os.name");
        System.out.println("My OS is " + os);
        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.COMMAND, "a");
        } else {
            dateOfBirthInput.sendKeys(Keys.CONTROL, "a");
        }
        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;
    public PracticeFormPage addSubject(String[] subject) {
        for (int i = 0; i < subject.length; i++) {
            if (subject[i] != null) {
                type(subjectsInput, subject[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }
}
