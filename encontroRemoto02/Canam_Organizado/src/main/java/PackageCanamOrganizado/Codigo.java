package PackageCanamOrganizado;

// importando pacotes

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Codigo {

	private WebDriver d; //driver
	public List<String> ListaNumeros = new ArrayList();// ARMAZENAR NUMEROS DE CODIGOS
	public List<String> ListaNomes = new ArrayList();// ARMAZENAR NUMEROS DE CODIGOS
	
	public Codigo() {
		
		System.setProperty("webdriver.chrome.driver",  "C:\\Program Files\\ChromeDriver\\chromedriver.exe");
		d= new ChromeDriver();
		d.manage().window().maximize();
		getUiElements();
	}

		
		
	private void getUiElements() {
	d.get("https://epc.brp.com/#/Can-Am_Off-Road/001_-_Maverick_Turbo_-_DS_-_North_America%2c_2021_0009DMA00_0009DMB00_0009DMC00_0009DMD00_0009DMF00_0009DMG00/07-_Body_-_Decals/C2119/61CA024a/y"); // LINK DA PAGINA DAS PECAS
		this.esperar(10000);
		// 	ENTRANDO NA DIV DA LISTA
	
		WebElement Pai = FId("ariPartList");
		WebElement ul = Pai.findElement(By.tagName("ul"));
		List<WebElement> listOfLi = ul.findElements(By.tagName("li"));
		for (WebElement element : listOfLi) 
		{
			WebElement divInfo = element.findElement(By.className("ariPLSku"));
			WebElement divNumber = divInfo.findElement(By.className("ariPartNumber"));
			WebElement divName = divInfo.findElement(By.className("ariPLDesc"));
		

		if (divNumber.getText() != null) {
			ListaNumeros.add(divNumber.getText()); // SALVANDO NUMEROS NA LISTA

		}
		if (divName.getText() != null) {
			ListaNomes.add(divName.getText().replaceFirst("This part replaces \\d+\\.", "").trim()); // SALVANDO NOMES NA LISTA
		}
		}
	}
	public WebElement FName(String name) // FUNCAO FIND.ELEMENT(BY.ID)
	{
		return d.findElement(By.tagName(name));
	}

	
	public WebElement FId(String id) // FUNCAO FIND.ELEMENT(BY.ID)
	{
		return d.findElement(By.id(id));
	}
	
	public WebElement FClass(String clas) // FUNCAO FIND.ELEMENT(BY.CLASSNAME)
	{
		return d.findElement(By.className(clas));
	}
	
	public WebElement FXpath(String Xpath) // FUNCAO FIND.ELEMENT(BY.XPATH)
	{
		return d.findElement(By.xpath(Xpath));
	}
	
	public void esperar () {	// FUNCAO SLEEP
		this.esperar(5000);
	}
	
	public void SelectGrupo(int option) {	// SELECIONAR GRUPO

		d.findElement(By.xpath("//*[@id=\"new_part\"]/div[3]/div/div/div[2]/div/div[" + option + "]")).click();

	}
	
	public void esperar(int timer) {		// FUNCAO SLEEP
		try {
			Thread.sleep(timer);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Execute() {
		Iterator<String> iteratorNumeros = ListaNumeros.iterator();
		Iterator<String> iteratorNomes = ListaNomes.iterator();
		
		d.get("https://motorok.com.br/users/sign_in");
		
		int contadorErros = -1;
		int contadorAtual = 0;
		
		List<Integer> CodDuplicados = new ArrayList();
		
	
		
		FId("user_email").sendKeys("crfalencastro@gmail.com");
		FId("user_password").sendKeys("12345678");			// LOGANDA 
		FXpath("//*[@id=\"new_user\"]/input[3]").click();
		this.esperar(5000);
	
		
		//			PAREI AQUI
		while (iteratorNomes.hasNext()) 
		{
			contadorErros++;

			try {
				
				this.esperar();
				FXpath("/html/body/div[2]/div/div[5]/h5/div/a[3]").click();		// 	CLICA NOVA PECA
				this.esperar();
				
			}catch(org.openqa.selenium.NoSuchElementException e) 
			{
				
			CodDuplicados.add(contadorErros);
			
			FXpath("/html/body/div[2]/aside/ul/li[7]").click(); // BOTAO CADASTRO
			this.esperar();
			FXpath("/html/body/div[2]/div/div[5]/div/div[2]/div/div[1]/h4/a/i").click(); // BOTAO PECAS
			this.esperar();
			FXpath("/html/body/div[2]/div/div[5]/h5/div/a[3]").click(); // BOTAO NOVA PECA
			}
			this.esperar();
	
			contadorAtual++;
			
			System.out.println(contadorAtual);
			
			FXpath("//*[@id=\"new_part\"]/div[3]/div/div/div[1]").click(); 			// ABRIR LISTA DO GRUPO
			this.SelectGrupo(2);
			
			FXpath("//*[@id=\"new_part\"]/div[4]/div/div/div[1]").click(); // ABRIR LISTA FABRICANTE
			FXpath("//*[@id=\"new_part\"]/div[4]/div/div/div[2]/div/div[1]").click();// SELECIONAR FABRICANTE
			
			WebElement prenche_caixa = FId("part_description"); // SELECIONANDO CAIXA DE TEXTO E SALVANDO EM VARIAVEL
			prenche_caixa.sendKeys(Keys.chord(Keys.SHIFT,iteratorNomes.next().toUpperCase())); // PREENCHENDO O NOME EM DESCRICAO EM LETRS MAISCULAS
			
			FXpath("//*[@id=\"new_part\"]/div[7]/div/div/div[1]").click();// ABRIR LISTA CATEGORIA
			FXpath("//*[@id=\"new_part\"]/div[7]/div/div/div[2]/div/div[2]").click();// SELECIONANDO CATEGORIA

			FId("part_code").click();	// SELECIONANDO O CAMPO CODIGO
			FId("part_code").sendKeys(iteratorNumeros.next()); // PREENCHENDO O CAMPO CODIGO
			
			FId("part_cfop").click();	// SELECIONANDO O CAMPO CFOP
			FId("part_cfop").sendKeys("1111"); // PREENCHENDO O CAMPO CFOP
			
			FId("part_ncm").click();	// SELECIONANDO O CAMPO NCM
			FId("part_ncm").sendKeys("11111111"); // PREENCHENDO O CAMPO NCM

			FXpath("//*[@id=\"new_part\"]/div[30]/div[7]/div/input").click(); //  BOTAO CADASTRAR

		}
		System.out.println(CodDuplicados);
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

