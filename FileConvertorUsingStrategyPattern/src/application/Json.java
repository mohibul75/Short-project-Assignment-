package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.CDL;
import org.json.XML;
import org.json.JSONArray;
import org.json.JSONObject;

public class Json implements IFile {
	
	private String fileName;
	 String JSONFormat;
	 String XMLFormat;
	 String CSVFormat;
	
	public Json(String fileName) {
		this.fileName = fileName;
	}

	List <Student> list=new ArrayList<>();
	private void prepareForJson( ) throws IOException, Exception {
	    // parser for reading strings
	/*    JSONParser parser = new JSONParser();
	    BufferedReader reader;
	    FileWriter fileToWriteTo=new FileWriter("json.josn");
	    try {
	        reader = new BufferedReader((new FileReader(new File(fileName))));
	        String line = reader.readLine();
	        
	        // convert that line to an json object
	        System.out.print(line);
	       // while (line != null) {
	        	System.out.print(line);
	            JSONObject lineConvertedToJson = (JSONObject) parser.parse(line);
	            // write to the file
	            fileToWriteTo.write(lineConvertedToJson.toJSONString());
	            // read the next line
	        //    line = reader.readLine();
	       // }
	        
	      /*  FileWriter writer = null;
	        File file = new File(fileName);
	        Scanner scan = new Scanner(file);
	        File file2 = new File("Myjson.json");
	        file.createNewFile();
	        writer = new FileWriter(file2);

	        while (scan.hasNext()) {
	        	JSONObject lineConvertedToJson = (JSONObject) parser.parse(scan.nextLine());
	            writer.append((CharSequence) lineConvertedToJson);
	            writer.append("\n");
	            writer.flush();
	            }
	             } catch(Exception ex) {
	    	
	    }
	
	    */
		createList();
		
		JSONArray jsonArray = new org.json.JSONArray();

        try {

            for (Student student: list) {

                JSONObject details = new JSONObject();

                details.put("Name", student.getName());
                details.put("Roll", student.getRoll());
                details.put("Phone",student.getPhone());

                jsonArray.put(details);
                
            }
            
           
            XMLFormat = XML.toString(jsonArray);
            CSVFormat = CDL.toString(jsonArray);
            JSONFormat = jsonArray.toString();

        } catch (Exception e) {
            System.out.println("Faild to Parse Text File! error: " + e.getMessage());
        }
        
        FileOutputStream outputStream = new FileOutputStream(new File("my.json"));
        outputStream.write(JSONFormat.getBytes());
        outputStream.close();

    }
		
		
	

	@Override
	public void convert() {
		// TODO Auto-generated method stub
		
		 try {
			prepareForJson();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}
	
	public void createList() throws Exception {

	        FileWriter writer = null;
	        File file = new File(fileName);
	        Scanner scan = new Scanner(file);
	        String line="";
	        while (scan.hasNext()) {
	          line=scan.nextLine();
	          String []str=line.split(" ");
	          list.add(new Student(str[0],str[1],str[2]));
	     } 
		
		
	}
}
