package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.forms.PracticeFormPage;
import com.demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm().hideIFrames();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "addNewStudentWithCsv")
    public void createStudentAccount(String name, String lastName, String email, String phone){
        new PracticeFormPage(driver).enterPersonalData(name, lastName, email, phone)
                .selectGender("Female")
                .enterDate("16 Aug 1987")
                .addSubject(new String[]{"Maths", "Chemistry"})
                .selectHobbies(new String[]{"Sports", "Music"})
                .apploadFile("C:/Users/akvad/Desktop/img 1.webp")
                .inputState("NCR")
                .inputCity("Delhi")
                .submit()
                .verifySuccessRegistration("Thanks for submitting the form")
                ;
    }

    @Test
    public void createStudentAccountWithSelectDate(){
        new PracticeFormPage(driver).enterPersonalData("Ana", "Smith", "test@gmail.com", "0123456789")
                .selectGender("Female")
                .selectDate("August", "1987", "16")
                .addSubject(new String[]{"Maths", "Chemistry"})
                .selectHobbies(new String[]{"Sports", "Music"})
                .apploadFile("C:/Users/akvad/Desktop/img 1.webp")
                .inputState("NCR")
                .inputCity("Delhi")
                .submit()
                .verifySuccessRegistration("Thanks for submitting the form")
        ;
    }
}
