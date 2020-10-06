import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class LAB3 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("Lab3input.csv"));
		PrintStream op = new PrintStream("Lab3output.txt");
		
		ArrayList<String> newl = new ArrayList<String>(); 
		ArrayList<String> Namelist = new ArrayList<String>();
		ArrayList<Integer> Count = new ArrayList<Integer>();
		
		String line;
		
		// read the artists' names from the table.
		while (sc.hasNextLine()) {
			
			line = sc.nextLine();
			
			newl.add(ReadName(line));
			
		}
		
		int size = newl.size();
		
		// list each different artist's name one time in a list.
		for (int i = 0; i < size; i++){
			if (!Namelist.contains(newl.get(i))){
				Namelist.add(newl.get(i));
			}
		}
		
		// count how many times a name appears on the list newl.
		for (int k = 0; k < Namelist.size(); k++){
			Count.add(Collections.frequency(newl, Namelist.get(k)));	
		}
		
		
		// create a new 2D array to put the artists' names and the time they appear on newl together.
		Object[][] NameLIST = new Object[Namelist.size()+1][2];
		NameLIST[0][0] = "Artist";
		NameLIST[0][1] = "Times in the list";
		
		for (int h = 0; h < Namelist.size(); h++){
			NameLIST[h+1][0] = Namelist.get(h);
			NameLIST[h+1][1] = Count.get(h);
			
			}
		
		// call the method Sortnames to do the bubble sort for the name in the array.
		NameLIST = Sortnames(NameLIST, Namelist.size());
		
		// print the array.
		for (int m = 0; m < Namelist.size(); m++){
			for (int f = 0; f < 2; f++){
				op.print(NameLIST[m][f] +"\t\t\t\t\t");
			}
			op.println();
			
		}
			
		sc.close();
		op.close();
	}
	
	// pick up the artists names from each line of form.
	static String ReadName(String s){
		
		String str2 = s.substring(s.indexOf(",")+1);
		String str3 = str2.substring(str2.indexOf(",")+1);
		String str4 = str3.substring(0, str3.indexOf(",")+1);
		
		return str4;
		
	}
	
	// Do the bubble sort to sort the artists' names in alphabetical order.
	static Object[][] Sortnames(Object[][] NameLIST, int l){
		
		String t;
		int d;
		
		for (int p = 1; p < l; p++){
			for (int q = p+1; q < l; q++){
				if (((String) NameLIST[q][0]).compareTo((String) NameLIST[p][0]) < 0){
					t = (String) NameLIST[p][0];
					NameLIST[p][0] = NameLIST[q][0];
					NameLIST[q][0] = t;
					d = (int) NameLIST[p][1];
					NameLIST[p][1] = NameLIST[q][1];
					NameLIST[q][1] = d;
				}
			}
		}
		
		return NameLIST;
	}
	
}
