import org.openqa.selenium.By;  //testing library selenium
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class EngageTesting {

    private WebDriver driver;
    public EngageTesting() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\RohanThakur\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    void accessSite(){
        driver.navigate().to("https://anshu-engage.herokuapp.com/");
        String title = driver.getTitle();
        if(title.compareTo("React App")==0)
            System.out.println("1. Site accessed successfully");
    }

    void login() {
        driver.findElement(By.id("typeEmailX")).sendKeys("gupta@gmail.com");
        driver.findElement(By.id("typePasswordX")).sendKeys("pass");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-outline-light btn-lg px-5']"));
        loginButton.click();
        System.out.println("2. Login Successful");
    }

    void dismissAlert() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
    }

    void openFromNavbar(String nav) {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        for(WebElement element: anchors){
            if(element.getText().compareTo(nav) == 0){
                element.click();
                System.out.println(nav+" opened successfully");
                break;
            }
        }
    }

    void closeDriver(){
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException, AWTException {

        EngageTesting engageTesting = new EngageTesting();
        engageTesting.accessSite();
        engageTesting.login();
        Thread.sleep(2000);
        engageTesting.dismissAlert();
        Thread.sleep(2000);
        System.out.print("3. ");
        engageTesting.openFromNavbar("About");
        Thread.sleep(2000);
        System.out.print("4. ");
        engageTesting.openFromNavbar("Home");
        Thread.sleep(2000);
        System.out.print("5. ");
        engageTesting.openFromNavbar("Contact");
        Thread.sleep(2000);
        System.out.print("6. ");
        engageTesting.openFromNavbar("Logout");
        Thread.sleep(2000);
        engageTesting.closeDriver();

    }
}
