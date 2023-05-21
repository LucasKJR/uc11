package testeGameMania;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.Iterator;
import java.util.List;

public class pecasCanam {
	 private WebDriver driver;
	    public List<Integer> numeros;
	    public List<String> nomes;
	    public pecasCanam() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        getUiElements();
	    }

	    private void getUiElements() {
	        driver.get("https://epc.brp.com/#/Can-Am_Off-Road/001_-_Maverick_Turbo_-_DS_-_North_America%2c_2021_0009DMA00_0009DMB00_0009DMC00_0009DMD00_0009DMF00_0009DMG00/07-_Body_-_Decals/C2119/61CA024a/y");
	        WebElement elementoPai = driver.findElement(By.id("ariPartList"));
	        WebElement ul = elementoPai.findElement(By.tagName("ul"));
	        List<WebElement> listOfLi = ul.findElements(By.tagName("li"));
	        for (WebElement element : listOfLi) {
	            WebElement divInfo = element.findElement(By.className("ariPLSku"));
	            WebElement divNumber = divInfo.findElement(By.className("ariPartNumber"));
	            WebElement divName = divInfo.findElement(By.className("ariPLDesc"));

	            numeros.add(Integer.valueOf(divNumber.getText()));
	            nomes.add(divName.getText());
	        }
	    }
	    public void imprimirElementos() {
	        Iterator<String> iteratorNomes = nomes.iterator();
	        while(iteratorNomes.hasNext()) {

	        }

	        Iterator<Integer> iteratorNumeros = numeros.iterator();
	        while(iteratorNomes.hasNext()) {
	            System.out.println(iteratorNumeros.next());
	        }
	    }
	}