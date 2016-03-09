package practiceWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase2 {
	
	private static final String URL ="http://www.jobserve.com/in/en/Job-Search/";
	
	public void executeTestCase() throws InterruptedException, IOException{
		WebDriver driver = new FirefoxDriver();
		
		//maximize window
		driver.manage().window().maximize();
		
		//Implicit TimeOut
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(URL);
		
		
		driver.findElement(By.id("ddcl-selInd")).click();
		
		
		driver.findElement(By.xpath("//*[@id='ddcl-selInd-i0']")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//*[@id='ddcl-selInd-i9']")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//*[@id='ddcl-selInd-i14']")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//*[@id='btnSearch']")).click();
		
		if(driver.getTitle().equals("Find Jobs with JobServe.com")){
			writeExcel();
		}
	}
	
	
	
	

	private void writeExcel() throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream(new File("D:\\TestResults\\TestReport.xlsx")); 
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		 
		HSSFSheet sheet = workbook.getSheetAt(0);
        Cell resultCell= sheet.getRow(1).getCell(1);
        
        String keyword = sheet.getRow(1).getCell(1).getStringCellValue();
        resultCell.setCellValue("PASS");
        
        
        file.close();
       
        FileOutputStream outFile =new FileOutputStream(new File("D:\\testdata-result.xls"));
        workbook.write(outFile);
        outFile.close();
		
		System.out.println("Excel File Written.");
		
		
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestCase2 testObj = new TestCase2();
		try {
			testObj.executeTestCase();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
