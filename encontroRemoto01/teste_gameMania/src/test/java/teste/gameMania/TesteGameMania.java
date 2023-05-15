package teste.gameMania;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGameMania {

 
	private WebDriver driver;
	
	
	
	@Before
	public void ConfigurarTeste ()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}	
	@Test
	public void TesteNavegabilidade ()
	{
		
		driver.get("http://localhost:4200/");
	    driver.findElement(By.id("s1")).sendKeys("Excel");
	    driver.findElement(By.id("s1")).sendKeys(Keys.ENTER);
	   

	
	}	
	
	
	
	
}
