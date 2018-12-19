import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NopeCommerce {
    private static WebDriver driver;

    @Test
    public void registration_page() {
        String expectedRegistrationSusessMessage = "Your registration completed";
        System.setProperty("webdriver.chrome.driver", "\\Soft\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();


        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("nidhi");
        driver.findElement(By.id("LastName")).sendKeys("sharma");
        Select dateOfBirthDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        dateOfBirthDay.selectByValue("6");
        //enter day of dob

        Select dateOfBirthMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        dateOfBirthMonth.selectByIndex(12);
        //enter month of dob


        Select dateOfBirthYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        dateOfBirthYear.selectByVisibleText("1981");
        //enter year of dob


        DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        driver.findElement(By.id("Email")).sendKeys("nidhi_tondon" + date1 + "@yahoo.com");
        driver.findElement(By.id("Password")).sendKeys("daksh078");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("daksh078");
        driver.findElement(By.id("register-button")).click();
        String actualRegistrationSucessMessage = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        Assert.assertEquals("The tet case failed", expectedRegistrationSusessMessage, actualRegistrationSucessMessage);
        driver.findElement(By.xpath("//a[@href=\"/logout\"]")).click();
        driver.quit();

    }
@Test
     public void currency(){
    System.setProperty("webdriver.chrome.driver", "\\Soft\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
    driver.manage().window().maximize();


    driver.get("https://demo.nopcommerce.com/");
    driver.findElement(By.xpath("//select[@id=\"customerCurrency\"] / option[2]")).click();
    String actual = driver.findElement(By.xpath("// div[@class=\"item-box\"] / div[@data-productid=\"18\"] / div[2] / div[3] / div[1]  / span[@class=\"price actual-price\"]")).getText();
   String expected = "Ђ210.70";
   Assert.assertEquals("test case failed",expected,actual);
   driver.quit();
}

@Test
    public void email(){
    System.setProperty("webdriver.chrome.driver", "\\Soft\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
    driver.manage().window().maximize();


    driver.get("https://demo.nopcommerce.com/");
    driver.findElement(By.xpath("//div/a[@href=\"/htc-one-m8-android-l-50-lollipop\"]")).click();
    driver.findElement(By.xpath("//input[@value=\"Email a friend\"]")).click();
    driver.findElement(By.xpath("//input[@id=\"FriendEmail\"]")).sendKeys("aa@k.com");
    driver.findElement(By.xpath("//input[@id=\"YourEmailAddress\"]")).sendKeys("kk@d.com");
    driver.findElement(By.xpath("//textarea[@id=\"PersonalMessage\"]")).sendKeys("have a look");
    driver.findElement(By.xpath("//input[@value=\"Send email\"]")).click();
    String expected = "Only registered customers can use email a friend feature";
    String actual = driver.findElement(By.xpath("//form[@method=\"post\"]//div[@class=\"message-error validation-summary-errors\"]//li")).getText();
    Assert.assertEquals("test case fail",expected,actual);
    driver.quit();
}

}








