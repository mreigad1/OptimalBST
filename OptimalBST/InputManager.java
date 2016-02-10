
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class InputManager {

	ArrayList<NodeSort> st = new ArrayList<NodeSort>();
	
	void loadFile(String filename){
		BufferedReader br = null;
		try{
			FileReader inputStream = new FileReader(filename);
			br = new BufferedReader(inputStream);
			
			String str = "";
			while ((str = br.readLine()) != null){
				String[] lineItems = str.split(" ");
				if(lineItems.length == 2){
					double prob = Double.parseDouble(lineItems[1]);
					st.add(new NodeSort(prob, lineItems[0]));
				}else{
					System.out.println("Invalid Line Format:(\"" + str + "\")");
				}
			}
			
			Collections.sort(st);
			
			
		} catch (FileNotFoundException e) {
			System.err.print("Input file not found.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.print("Ioexception.");
			e.printStackTrace();
		}finally{

		}
	}
	
	void output(String filename, String out) throws IOException{
		FileWriter outputStream = null;
		try{
			outputStream = new FileWriter(filename);
			outputStream.write(out);
		}finally{
			if(outputStream != null){
				outputStream.close();
			}
		}
	}
}
