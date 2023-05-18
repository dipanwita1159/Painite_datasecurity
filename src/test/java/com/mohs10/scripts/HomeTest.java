package com.mohs10.scripts;

import org.testng.annotations.Test;

import com.mohs10.ActionDriver.Action;
import com.mohs10.ActionDriver.SSreuseclass;
import com.mohs10.ActionDriver.XLUtils;
import com.mohs10.ActionDriver.dataEncryptDecrypt;
import com.mohs10.ActionDriver.dataEncrypt_Decrypt2;
import com.mohs10.ActionDriver.dataMasking2;
import com.mohs10.base.StartBrowser;
import com.mohs10.or.HomePage;
import com.mohs10.reuse.CommonFuns;

public class HomeTest extends StartBrowser {

	String excelFilePath = "C:\\Users\\DELL\\eclipse-workspace\\Data encrypt\\TestData\\Data.xlsx";
	String excelsheet = "Login";

	

	

	@Test
	public void LoginTestCase3() throws Exception {
		CommonFuns hm2 = new CommonFuns();

		int rowcount = XLUtils.getRowCount(excelFilePath, excelsheet);

		for (int i = 1; i < rowcount; i++) {
			System.out.print("loop started");
			String Email = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 0);
			String Pwd = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 1);
			String occopetion = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 2);
			String rel = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 3);
			String contactnumber = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 4);
			String age = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 5);
			String phcname = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 6);

			String name = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 7);

			String education = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 8);
			String par_edu = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 9);
			String parT_name = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 10);
			String dis = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 11);
			String city = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 12);
			String country = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 13);
			String state = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 14);
			String family_mem = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 15);
			String earning_mem = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 16);
			String url = XLUtils.getStringCellData(excelFilePath, excelsheet, i, 17);
			hm2.login(url, Email, Pwd);
			hm2.maskedData(Email, Pwd, name, rel, occopetion, phcname, excelFilePath, excelsheet);
			SSreuseclass.SSReusablemethod(driver, "login");
			hm2.unMasked_data(dis, education, country, par_edu, parT_name, family_mem, earning_mem, age, contactnumber);
			hm2.unmasked_data2(city, education, country, par_edu, parT_name, family_mem, earning_mem, dis, state,
					family_mem, earning_mem);
			SSreuseclass.SSReusablemethod(driver, "enter credtential");

			SSreuseclass.SSReusablemethod(driver, "logout");
			Thread.sleep(5000);

		}
	}

}
