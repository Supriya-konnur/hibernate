package com.xworkz.supermarket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.xworkz.supermarket.dto.SupermarketDTO;
import com.xworkz.supermarket.service.SupermarketService;
import com.xworkz.supermarket.service.SupermarketServiceImpl;

public class Tester {

	public static void main(String[] args) throws IOException {
		
		System.out.println("supermarket data");
		Scanner sc = new Scanner(System.in);
		System.out.println("How do you prefer adding data:");
		System.out.println("Press \"D\" to enter dynamically or press \" E \"to import from Excel ");
		if(sc.next().equalsIgnoreCase("D")) {
		
		
		System.out.println("Enter no of new records to store");
		int rec = sc.nextInt();
		
		for(int i=0;i<rec;i++) {
			
			System.out.println("enter id");
			int id1 = sc.nextInt();
			
			System.out.println("enter supermarket  name");
			String s1 = sc.next();
			
			System.out.println("enter  item name");
			String s2 = sc.next();
			
			System.out.println("enter no_of_items");
			int p1 = sc.nextInt();
			
			System.out.println("enter price");
			double p2 = sc.nextDouble();
			
			SupermarketDTO dto = new SupermarketDTO();
			dto.setId(id1);
			dto.setSupermarket_name(s1);
			dto.setItem_name(s2);
			dto.setNo_of_items(p1);
			dto.setPrice(p2);
			
			SupermarketService service = new SupermarketServiceImpl();
			service.valideAndSave(dto);
		}
		}
		else {
			readXLSXFILE("E:\\excel\\supermarket.xlsx");
		}
		System.out.println("Enter no of details to get by Name:");
		int up = sc.nextInt();
		for(int j=0;j<up;j++) {
			
			System.out.println("Enter supermarket name");
			String name = sc.next();
			System.out.println("Enter correct id");
			int id2 = sc.nextInt();			
			SupermarketService service1 = new SupermarketServiceImpl();

			SupermarketDTO smDTO= service1.validateAndGetByName(id2, name);
			writeXLSXFile("E:\\excel\\supermarket.xlsx",smDTO);
	}
		
		
	}

	private static void writeXLSXFile(String file1, SupermarketDTO smDTO) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook wrk = new XSSFWorkbook();
		XSSFSheet sht = wrk.createSheet("Sheet2");
		
		sht.createRow(smDTO.getId());
		sht.getRow((smDTO.getId())).createCell(0).setCellValue(smDTO.getId());
		sht.getRow((smDTO.getId())).createCell(1).setCellValue(smDTO.getSupermarket_name());
		sht.getRow((smDTO.getId())).createCell(2).setCellValue(smDTO.getItem_name());
		sht.getRow((smDTO.getId())).createCell(3).setCellValue(smDTO.getNo_of_items());
		sht.getRow((smDTO.getId())).createCell(4).setCellValue(smDTO.getPrice());
		
		FileOutputStream osfile = null;
		try {
			osfile = new FileOutputStream(file1);
			wrk.write(osfile);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		wrk.close();
		
	}

	

	private static void readXLSXFILE(String file) {
		// TODO Auto-generated method stub
		try {
			XSSFWorkbook work=new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet=work.getSheet("Sheet1");
		//XSSFRow row=sheet.getRow(1);
			XSSFRow row =null;
			
			int i=1;
			while((row=sheet.getRow(i))!=null) {
				SupermarketDTO sdto=new SupermarketDTO();
			
				sdto.setSupermarket_name(row.getCell(1).getStringCellValue());
				
			
			sdto.setItem_name(row.getCell(2).getStringCellValue());
			//sdto.setNo_of_items(row.getCell(3).getNumericCellValue());
			int n =(int)(row.getCell(3).getNumericCellValue());
			sdto.setNo_of_items(n);
			int m=(int)(row.getCell(4).getNumericCellValue());
			sdto.setPrice(m);
			i++;
			SupermarketService iService = new SupermarketServiceImpl();
			iService.valideAndSave(sdto);
			
			}
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

