package testeGameMania;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class testeLogin {
	
private WebDriver driver;
	//=================== EMAIL E SENHA CORRETO ==================================
//correto@gmail.com
//senhacorreta
//================================================================================
	
	
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
		try {
			//====================somente senha certa
			driver.get("http://localhost:4200");
			//driver.findElement(By.id("s1")).sendKeys("Excel");
			//  driver.findElement(By.id("s1")).sendKeys(Keys.ENTER);
			 Thread.sleep(2000);
			driver.findElement(By.id("login")).click();
			
			
			driver.findElement(By.id("email")).sendKeys("erro@gmail.com");
			driver.findElement(By.id("senha")).sendKeys("senhacorreta");
			driver.findElement(By.id("enviar")).click();
			
	   
	   
			 Thread.sleep(2000);
	       //===================limpar
	       driver.findElement(By.id("email")).clear();
	       driver.findElement(By.id("senha")).clear();
	       
		   Thread.sleep(2000);
		   
		   //==================================somente email certo
		   driver.findElement(By.id("email")).sendKeys("correto@gmail.com");
		   driver.findElement(By.id("senha")).sendKeys("senhaErro");
		   driver.findElement(By.id("enviar")).click();
		   
		   Thread.sleep(2000);
		   
	       //===================limpar
	       driver.findElement(By.id("email")).clear();
	       driver.findElement(By.id("senha")).clear();
	       
		   Thread.sleep(2000);
		   
		   //==================================email e senha certo
		   driver.findElement(By.id("email")).sendKeys("correto@gmail.com");
		   driver.findElement(By.id("senha")).sendKeys("senhacorreta");
		   driver.findElement(By.id("enviar")).click();
		   Thread.sleep(2000);

		   
	 }	catch(Exception e) {}
	}
	@After
	public void Final() {
		driver.quit();
	}
	

}
