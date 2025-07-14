package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.forms.PracticeFormPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm().hideIFrames();
    }

    @Test
    public void createStudentAccount(){
        new PracticeFormPage(driver).enterPersonalData("Ana", "Smith", "test@gmail.com", "0123456789")
                .selectGender("Female")
                .enterDate("16 Aug 1987")
                .addSubject(new String[]{"Maths", "Chemistry"})
//                .selectHobbies(new String[]{"Sports", "Music"})
//                .apployedFile("C:/Users/akvad/Desktop/img 1.webp")
//                .inputState("NCR")
//                .inputCity("Delhi")
//                .submit()
//                .verifySuccessRegistration("")
                ;
    }
}
