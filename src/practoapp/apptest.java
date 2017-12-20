package practoapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class apptest 
{
	static File src=new File(".\\excel\\automation.xlsx");
	public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFCell cell;
    public static WebElement searchelement;
    
    static methods obj = new methods();
    
 
  @Test
  public void automation() throws IOException, InterruptedException 
  {
	  	FileInputStream finput = new FileInputStream(src);
		// Load the workbook.
		workbook = new XSSFWorkbook(finput);
		// Load the sheet in which data is stored.
		sheet= workbook.getSheetAt(0);
		
		
		int rc=sheet.getLastRowNum();
		
		for(int i=1; i<=rc; i++)       
		    
	    {     
	      Row row = sheet.getRow(i); 
	      
	      if(row == null || row.getCell(1)==null) {      
	       continue;
	    }
	           
	      String testcase = row.getCell(1).toString();         
	      System.out.println(testcase);
	      
	      String testcaseid = row.getCell(0).toString();         
	      
	      switch(testcase)
	      {
	      
	      case "Installation": 
	    	  
	    	  System.out.println(testcaseid + ":" + testcase);
	          obj.installation();     
	          Thread.sleep(5000);
	          updateresult("//android.widget.Button[@resource-id='com.practo.droid:id/next_btn']", i);
	    	  break;
	    	  
	      case	"Home":
	    	  
	    	  System.out.println(testcaseid + ":" + testcase);
	          obj.home();     
	          Thread.sleep(5000); 
	          updateresult("//android.widget.Button[@text='Login']",i);
	    	  break;
	    	  
	      case	"Login":
	    	  
	    	  System.out.println(testcaseid + ":" + testcase);
	          obj.login();    
	          Thread.sleep(5000);
	          updateresult("//android.widget.TextView[@text='Login']", i);
	    	  break;  
	    	  
	    	  
	      case	"Login Credentials":
	    	  
	    	  System.out.println(testcaseid + ":" + testcase);
	          obj.logincredentials();
	          Thread.sleep(5000);
	          updateresult("//android.widget.ImageButton[@resource-id='com.practo.droid:id/toolbar_notifications']",i);
	    	  break;  
	    	  
	    	  
	    	  
	
	      }
	     
	      
	    }       
	      
	      
}
		 @SuppressWarnings("static-access")
		 public static void updateresult(String componentname,int i) throws IOException, InterruptedException {
		    
		    int a = obj.driver.findElements(By.xpath(componentname)).size();
		    
		    
		    // Specify the message needs to be written.           
		       String message = "Pass";
		       String message1 = "Fail";
		       if(a==1)
		     
		    {    
		     
		    Thread.sleep(3000);  
		   sheet.getRow(i).createCell(4).setCellValue(message);
		   
		    }
		   
		   else 
		         {
		          Thread.sleep(3000);
		          sheet.getRow(i).createCell(4).setCellValue(message1);                     
		          
		         }
		       FileOutputStream foutput=new FileOutputStream(src);
		     
		       workbook.write(foutput);
		           
		       foutput.close();   
		         
		    
		    }
}
