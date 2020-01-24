package executionEngine;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.ExcelUtils;
import config.ActionKeywords;

public class DriverScript {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception
	{
		 String sPath = "E:\\selenium-project1\\CYTC_003key\\src\\dataEngine\\DataDriven1.xlsx";
		 
	     // Here we are passing the Excel path and SheetName as arguments to connect with Excel file 
	     ExcelUtils.setExcelFile(sPath, "Test Steps");
	 
	     //Hard coded values are used for Excel row & columns for now
	     //In later chapters we will replace these hard coded values with varibales
	     //This is the loop for reading the values of the column 3 (Action Keyword) row by row
	     for (int iRow=2;iRow<=13;iRow++){
	     //Storing the value of excel cell in sActionKeyword string variable
	     String sActionKeyword = ExcelUtils.getCellData(iRow, 3);
	 
	     //Comparing the value of Excel cell with all the project keywords
	     if(sActionKeyword.equals("openBrowser")){
	                        //This will execute if the excel cell value is 'openBrowser'
	     //Action Keyword is called here to perform action
	     ActionKeywords.openBrowser();}
	     else if(sActionKeyword.equals("navigate")){
	     ActionKeywords.navigate();}
	     else if(sActionKeyword.equals("Input_Username")){
	     ActionKeywords.Input_Username();}
	     else if(sActionKeyword.equals("Input_password")){
	     ActionKeywords.Input_password();}
	     else if(sActionKeyword.equals("click_login")){
	     ActionKeywords.click_login();}
	     else if(sActionKeyword.equals("Input_member")){
		     ActionKeywords.Input_member();}
	     else if(sActionKeyword.equals("click_member")){
		     ActionKeywords.click_member();}
	     else if(sActionKeyword.equals("click_group")){
		     ActionKeywords.click_group();}
	     else if(sActionKeyword.equals("Input_description")){
		     ActionKeywords.Input_description();}
	     else if(sActionKeyword.equals("click_submit")){
		     ActionKeywords.click_submit();}
	     else if(sActionKeyword.equals("click_popok"))
	     {
	    	 ActionKeywords.click_popok();
	     }
	
	     
			//String alerttitle=driver.switchTo().alert().getText();
			//System.out.println("Alert title is:"+alerttitle);
			//String expectedtitle="The member's group was changed, however, the activation mail could not be sent";
	     }
	}

}
