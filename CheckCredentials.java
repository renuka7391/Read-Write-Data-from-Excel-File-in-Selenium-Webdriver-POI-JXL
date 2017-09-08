package main_package;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckCredentials {

	public static void main(String[] args) {
		
	   
	   
	   try{
		   String username[] = new String[100];
			String pwd[] = new String[100];
			String casestatus[]=new String[100];
		   data_read_write data_obj = new data_read_write();
		   username=data_obj.read_file("uid");  // imp 
		   pwd= data_obj.read_file("pwd");
		    int rownum = data_obj.rowcount;
		    for(int i=0;i<rownum;i++){
				System.setProperty("webdriver.gecko.driver", "/Users/renuka/Documents/selenium software/geckodriver");
				WebDriver driver =new FirefoxDriver();
				driver.get("http://www.demo.guru99.com/V4/");
				driver.manage().window().maximize();
				driver.findElement(By.name("uid")).sendKeys(username[i]);
				driver.findElement(By.name("password")).sendKeys(pwd[i]);
				driver.findElement(By.name("btnLogin")).click();
				String expectedTitle = "Guru99 Bank Manager HomePage";
				WebDriverWait wait=new WebDriverWait(driver,10);
				try{
					boolean status=wait.until(ExpectedConditions.titleIs(expectedTitle));// explicit timeout
				if(status){
					System.out.println("Test Case No."+i+" login successfull");
					casestatus[i]="Case Successful";
					driver.quit();
					}
				}catch(Exception e){
				
				
					casestatus[i]="Case UnSuccessful";
					System.out.println("Test Case No."+i+" login unsuccessfull");
					driver.quit();
				}
				
			
				
				
				
				}
		    for(int i=0;i<rownum;i++){
				System.out.println(casestatus[i]);
			}
		    data_obj.write_data(casestatus);
		    
		    
		    } catch(Exception Any_variable){
		   System.out.println("file error exception");
		   }
			   
		

}
}
