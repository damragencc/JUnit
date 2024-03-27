import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class Day_Exersize extends TestBase_BeforeAfter {

    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[@href='/products']")).isEnabled());


        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();


        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed());
        //4. Click on 'Signup / Login' button
        WebElement signUpButon=driver.findElement(By.xpath("//a[@href='/login']"));
        signUpButon.click();

        //5. Verify 'New User Signup!' is visible
        String expectedText="New User Signup!";
        WebElement newUserText= driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(newUserText.isDisplayed());
        String actualText= newUserText.getText();
        Assert.assertEquals(expectedText,actualText);

        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@name='name']"))
                .sendKeys("Gokcen Yedi");
        driver.findElement(By.xpath("(//input[@name='email'])[2]"))
                .sendKeys("gokcenilk7@hotmail.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        ReusableMethods.bekle(5);
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("468236");
        WebElement dayDDM=driver.findElement(By.xpath("//select[@id='days']"));
        Select selectDay=new Select(dayDDM);
        selectDay.selectByVisibleText("21");
        WebElement monthDDM=driver.findElement(By.xpath("//select[@id='months']"));
        Select selectMonth=new Select(monthDDM);
        selectMonth.selectByVisibleText("October");
        WebElement yearDDM=driver.findElement(By.xpath("//select[@id='years']"));
        Select selectYear=new Select(yearDDM);
        selectYear.selectByVisibleText("1992");

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Gokcen");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Yedidag");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("ALP.CO");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Yenimahalle");
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Ankara");
        WebElement countryDD=driver.findElement(By.xpath("//select[@id='country']"));
        Select selectCountry=new Select(countryDD);
        selectCountry.selectByVisibleText("United States");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("XY");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("NYork");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("0651");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("+905438220618");

        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        //14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed());
        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[text()='Continue']")).click();





        //6. Enter correct email address and password



        //7. Click 'login' button

        //8. Verify that 'Logged in as username' is visible





        //9. Click 'Delete Account' button

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed());
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        ReusableMethods.bekle(2);
    }

}
