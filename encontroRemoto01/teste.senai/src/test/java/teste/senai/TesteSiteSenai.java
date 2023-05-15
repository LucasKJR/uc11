package teste.senai;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteSiteSenai {

 
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
		
		driver.get("https://sp.senai.br/unidade/informatica/");
	    driver.findElement(By.id("s1")).sendKeys("Excel");
	    driver.findElement(By.id("s1")).sendKeys(Keys.ENTER);
	   

	    // driver.findElement(By.id("nav-bar")).click();
	}	
	
	
	
	
}
