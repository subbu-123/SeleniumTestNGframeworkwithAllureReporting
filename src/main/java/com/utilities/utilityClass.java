package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class utilityClass extends BaseClass{

	
	public static List<Object[]> getDataFromExcel(String excelPath, String sheetname) throws FilloException
	{
		Fillo flo = new Fillo();
		Connection con = flo.getConnection(excelPath); // This connection class is of fillo not java
		String query = "Select * From "+ sheetname;
		Recordset rs = con.executeQuery(query);
		List<Object[]> testdata = new ArrayList<Object[]>();
		
		List<String> fieldNames = rs.getFieldNames();
		while(rs.next())
		{
			Object[] obj = new Object[fieldNames.size()];
			for(int i=0;i<fieldNames.size(); i++)
			{
				obj[i] = rs.getField(fieldNames.get(i));
			}
			testdata.add(obj);
		}

		rs.close();
		con.close();
		return testdata;
	}
	
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("d_M_YYYY_hh_mm_ss");
		String timestamp = sdf.format(new Date());
		File f1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imagePath = "./Artifacts/Screenshots/"+screenshotName+"_"+timestamp+".png";
		File s = new File(imagePath);
		FileUtils.copyFile(f1, s);
	
		return imagePath;

	}
	
	public static String getScreenshotAsBase64(WebDriver driver)
	{
		
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

	}
	
}
