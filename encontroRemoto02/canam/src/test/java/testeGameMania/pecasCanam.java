package testeGameMania;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class pecasCanam {
	
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
		int cont=0;
		
		try {
			do
			{			
				cont++;
				driver.get("file:///C:/Users/Lucas/Desktop/Canam/index.html");
				
			   //COPIANDO NOME ============================================
				
			      // Localizar o elemento <span> pelo ID
		        WebElement nome = driver.findElement(By.id("serial"+cont));

		        // Copiar o texto do elemento <span>
		        String nomeCola = nome.getText();
		          //========================================================
		        
		        //COPIANDO CODIGO ============================================
				
			      // Localizar o elemento <span> pelo ID
		        WebElement codigo = driver.findElement(By.id("ref"+cont));

		        // Copiar o texto do elemento <span>
		        String codigoCola = codigo.getText();
		          //========================================================
		        
		        
		        
		        // COLANDO NOME ============================================
		        
		        // Localizar a caixa de texto para colar o texto
		        WebElement caixaTextoNome = driver.findElement(By.id("Nome"));

		        // Colar o texto na caixa de texto
		        caixaTextoNome.sendKeys(nomeCola);
		        //==========================================================
		        
		        // COLANDO CODIGO ============================================
		        
		        // Localizar a caixa de texto para colar o texto
		        WebElement caixaTextoCodigo = driver.findElement(By.id("Cod"));

		        // Colar o texto na caixa de texto
		        caixaTextoCodigo.sendKeys(codigoCola);
		        //==========================================================
		        driver.get("https://motorok.com.br/users/sign_in");
				                                                                                                                                  driver.findElement(By.id("user_email")).sendKeys("crfalencastro@gmail.com");
				 
				
				                                                                                                                                 driver.findElement(By.id("user_password")).sendKeys("12345678");
		        	 
				driver.findElement(By.name("commit")).click();
				 Thread.sleep(2000);
			
				 driver.get("https://motorok.com.br/parts/new");
				 Thread.sleep(2000);
				 //localiza a caixa de texto e coloca o nome
			
				 driver.findElement(By.id("part_generic_id-selectized")).click();
				  WebElement caixaTexto = driver.findElement(By.id("part_generic_id-selectized"));
				  caixaTexto.sendKeys(nomeCola);
				 Thread.sleep(2000);
				 driver.findElement(By.id("part_workgroup_id-selectized")).click();
				   driver.findElement(By.id("part_generic_id-selectized")).sendKeys("B");
				  caixaTexto.sendKeys(nomeCola);
			
				}
			while(cont<49);
		

		   
	 }	catch(Exception e) {}
	}
	
	

}
