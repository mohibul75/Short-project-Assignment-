package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Csv implements IFile{
	
	private String fileName;
	
	public Csv(String fileName) {
		this.fileName = fileName;
	}

	public void csvConverting() throws Exception {
		 FileWriter writer = null;
	        File file = new File(fileName);
	        Scanner scan = new Scanner(file);
	        File file2 = new File("CSV.csv");
	        file.createNewFile();
	        writer = new FileWriter(file2);

	        while (scan.hasNext()) {
	            String csv = scan.nextLine().replace(" ", ",");
	            System.out.println(csv);
	            writer.append(csv);
	            writer.append("\n");
	            writer.flush();
	}
	}

	@Override
	public void convert() {
		// TODO Auto-generated method stub
		
		try {
			csvConverting();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
