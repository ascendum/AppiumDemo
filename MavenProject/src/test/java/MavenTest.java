import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MavenTest {
	WebDriver dr;
@Test
public void test(){
	dr=new FirefoxDriver();
	dr.manage().window().maximize();
	dr.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
	Assert.assertTrue(dr.getTitle().contains("IRCTC"));
	System.out.println("IRCTC Test Passed");
	dr.close();
}
}
