package canam;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Canam {
	private WebDriver driver;
	public List<String> numeros = new ArrayList();
	public List<String> nomes = new ArrayList();

	public Canam() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		getUiElements();
	}

	private void getUiElements() {
		driver.get(
				"https://epc.brp.com/#/Can-Am_Off-Road/001_-_Maverick_Turbo_-_DS_-_North_America%2c_2021_0009DMA00_0009DMB00_0009DMC00_0009DMD00_0009DMF00_0009DMG00/07-_Body_-_Decals/C2119/61CA024a/y");
		WebElement elementoPai = driver.findElement(By.id("ariPartList"));
		WebElement ul = elementoPai.findElement(By.tagName("ul"));
		List<WebElement> listOfLi = ul.findElements(By.tagName("li"));
		for (WebElement element : listOfLi) {
			WebElement divInfo = element.findElement(By.className("ariPLSku"));
			WebElement divNumber = divInfo.findElement(By.className("ariPartNumber"));
			WebElement divName = divInfo.findElement(By.className("ariPLDesc"));

			if (divNumber.getText() != null) {
				numeros.add(divNumber.getText());

			}
			if (divName.getText() != null) {
				nomes.add(divName.getText().replaceFirst("This part replaces \\d+\\.", "").trim());
			}
		}

	}

	public void esperar() {

		this.esperar(7000);
	}

	public void esperar(int timer) {
		try {
			Thread.sleep(timer);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void SelectGrupo(int option) {

		driver.findElement(By.xpath("//*[@id=\"new_part\"]/div[3]/div/div/div[2]/div/div[" + option + "]")).click();

	}

	public void Execute() {
		Iterator<String> iteratorNumeros = numeros.iterator();
		Iterator<String> iteratorNomes = nomes.iterator();
		driver.get("https://motorok.com.br/users/sign_in");
		int contEr = -1;
		int contAt = 0;
		List<Integer> CodigosDuplicados = new ArrayList();
		driver.findElement(By.id("user_email")).sendKeys("crfalenastro@gmail.com");/* LOGANDO>>>> */
		driver.findElement(By.id("user_password")).sendKeys("12345678"); // LOGANDO
		driver.findElement(By.name("commit")).click();
		this.esperar(5000);
		while (iteratorNomes.hasNext()) {
			contEr++;
			try {
				this.esperar(5000);
				driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/h5/div/a[3]")).click();
				this.esperar(5000);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				
				CodigosDuplicados.add(contEr);
				driver.findElement(By.xpath("/html/body/div[2]/aside/ul/li[7]")).click();// ===================CADASTRO
				this.esperar();

				driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div/div[2]/div/div[1]/h4/a/i")).click();// =================PECAS
				this.esperar();
				driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/h5/div/a[3]")).click();// ===============NOVA PECA

				              
				
			}
			this.esperar(5000);
			
			contAt++;
			System.out.println(contAt);
			driver.findElement(By.xpath("//*[@id=\"new_part\"]/div[3]/div/div/div[1]")).click();// abrir select grupo

			//this.esperar();
			this.SelectGrupo(1);
			// this.esperar();

			driver.findElement(By.xpath("//*[@id=\"new_part\"]/div[4]/div/div/div[1]")).click();
		//	 this.esperar();
			driver.findElement(By.xpath("//*[@id=\"new_part\"]/div[4]/div/div/div[2]/div/div")).click();// PAREI AQUI
			WebElement as = driver.findElement(By.id("part_description"));
			as.sendKeys(Keys.chord(Keys.SHIFT, iteratorNomes.next().toUpperCase()));
		//	 this.esperar();
			driver.findElement(By.xpath("//*[@id=\"new_part\"]/div[7]/div/div/div[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"new_part\"]/div[7]/div/div/div[2]/div/div[2]")).click();
		//	 this.esperar();

			driver.findElement(By.id("part_code")).click();
			driver.findElement(By.id("part_code")).sendKeys(iteratorNumeros.next()); // ==========================INPUT
																						// CODIGO
		//	 this.esperar();
			driver.findElement(By.id("part_cfop")).click();
			driver.findElement(By.id("part_cfop")).sendKeys("1111"); // ==================INPUT CFOP
		//	 this.esperar();
			driver.findElement(By.id("part_ncm")).click();
			driver.findElement(By.id("part_ncm")).sendKeys("11111111");// ================= INPUT NCM
		//	 this.esperar();

			driver.findElement(By.xpath("//*[@id=\"new_part\"]/div[30]/div[7]/div/input")).click();/// =======BTN CRIAR
			this.esperar();

			
		}
		System.out.println(CodigosDuplicados);

	}
}