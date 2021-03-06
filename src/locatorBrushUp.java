import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class locatorBrushUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//Primer paso open browser
System.setProperty("webdriver.edge.driver",
				   "C:\\Users\\Lmori\\Downloads\\edgedriver_win64\\msedgedriver.exe");

//Creamos el objeto el cual se usara para asignar el EdgeDriver con los metodos del WebDriver
WebDriver driver = new EdgeDriver();

//Aqui creamos el Explicit Wait de 5 para todo los componenete no solo para el error
//esto afecta de manera general a todo el codigo.
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//Seguno Paso abrimos la URL que vamos a navegar
driver.get("https://www.rahulshettyacademy.com/locatorspractice/");

//Tercer Paso buscamos el elemento dentro del pagina y le pasamos la inforamcion a testear.
driver.findElement(By.id("inputUsername")).sendKeys("rahul");
driver.findElement(By.name("inputPassword")).sendKeys("hellow123");
driver.findElement(By.className("signInBtn")).click();

//Selenium esta procesando rapidamente linea por linea y cuando entra aqui
//trata de buscar el elemento que aun no existe por que el error dura aproximadamente 2s
//en aparecer y por ende el p tag aun no existe, por esto hay que ponerle un wait
//par que espere al menos 5 segundo si un elemento aun no esta visible
System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
driver.findElement(By.linkText("Forgot your password?")).click();

//Esto se usa para esperar que los elementos renderisen completamente
Thread.sleep(1000);

driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");

driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");

driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");

driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

System.out.println(driver.findElement(By.cssSelector("form p")).getText());

driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

Thread.sleep(1000);

driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

driver.findElement(By.id("chkboxOne")).click();

driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

	}

}
