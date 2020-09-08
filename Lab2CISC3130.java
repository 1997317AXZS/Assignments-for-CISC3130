import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Lab2CISC3130 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("Lab2input.csv"));
		PrintStream op = new PrintStream("Lab2output.txt");
		
		int n = 0; 
		
		ArrayList<String> newl = new ArrayList<String>();
		ArrayList<String> Namelist = new ArrayList<String>();
		ArrayList<Integer> Count = new ArrayList<Integer>();
		
		String line = null;
		
		while (sc.hasNextLine()) {
			
			line = sc.nextLine();
			
			newl.add(ReadName(line));
			
		}
		
		int size = newl.size();
		
		Namelist = newl;
		
		for (int i = 0; i < size; i++){
			for (int j = 0; j < i; j++){
				if (newl.get(i) == newl.get(j)){
					Namelist.remove(i);
				} 
				
			}
		}
		
		for (int k = 0; k < Namelist.size(); k++){
			Count.add(Collections.frequency(newl, Namelist.get(k)));
			
		}
		
		Object[][] NameLIST = new Object[Namelist.size()+1][2];
		NameLIST[0][0] = "Artist";
		NameLIST[0][1] = "Times in the list";
		
		for (int h = 0; h < Namelist.size(); h++){
			NameLIST[h+1][0] = Namelist.get(h);
			NameLIST[h+1][1] = Count.get(h);
			
			}
		
		for (int m = 0; m < Namelist.size(); m++){
			for (int f = 0; f < 2; f++){
				op.print(NameLIST[m][f] +"\t\t\t");
			}
			op.println();
			
		}
			
		sc.close();
		op.close();
	}
	
	static String ReadName(String s){
		
		String str2 = s.substring(s.indexOf(",")+1);
		String str3 = str2.substring(str2.indexOf(",")+1);
		String str4 = str3.substring(0, str3.indexOf(",")+1);
		
		return str4;
		
	}

	
}
