package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;





public class Program {
	
	public static void main(String[]args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Map<String,Integer> candidate = new HashMap<>();
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		File file = new File(path);
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			
			String line = br.readLine();
			
			while(line != null) {
				
				String[] contentOfFile = line.split(",");
				
				if(candidate.containsKey(contentOfFile[0])){
					candidate.put(contentOfFile[0],candidate.get(contentOfFile[0]) + Integer.parseInt(contentOfFile[1]));
				}else {
				candidate.put(contentOfFile[0],Integer.parseInt(contentOfFile[1]));
				}	
				
				line = br.readLine();
			}
			
			for(String key : candidate.keySet()) {
				System.out.println(key + ": " + candidate.get(key));
			}
			
			sc.close();
			
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
	}

}
