import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.Arrays;
import java.util.List;


public class addToCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Basic Initialization of the web driver*/
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Lmori\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		//Array memory request is shortest than ArrayList.
		String[] itemsNeeded = {"Brocolli" , "Cucumber"};
		int counter = 0;
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		
		//Vamos a generar un lista de varios elementos localizado usando CSS Selector "h4.product-name"
		List<WebElement> product =driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0; i<product.size(); i++)
		{
			//Aqui almacenamos cada product el testo en una variable para poder identificar la que realmente queremos
			//We need to format the name to properly get Array item name, right now it will get the test "Cucumber - 1kg" that is not matching
			String[] fName = product.get(i).getText().split("-");
			String formattedName = fName[0].trim();
			
			//Convert Array(this is original declared as array because is less request than Array List) into Array list(during run time for complex search)
			//Check any string from your ArrayList is present or not then we click it to add into the cart.
	        List itemsNeededList = Arrays.asList(itemsNeeded);

			//He will search in the ArrayList just created for the value of our Array and add it to the cart.
			if(itemsNeededList.contains(formattedName))
			{
				counter++;
				//In order to save processing time we can create a count variable that will let us know how many time it clicks add cart
				//If that matches with all our test scenario just then we can break because we know is really over.
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				//We need to remove break because we want to iterate for all the element of the array.
				//break;
				
				if(counter == itemsNeededList.size())
				{
					break;
				}
			}
		}

	}

}
