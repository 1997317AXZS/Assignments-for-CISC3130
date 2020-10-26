import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Lab4CISC3130{

	public static void main(String[] args) throws FileNotFoundException {
		
		String[] myFile = {"Lab4Week1.csv", "Lab4Week2.csv", "Lab4Week3.csv", "Lab4Week4.csv"};
			
		PrintStream op = new PrintStream("Lab4output.txt");
		
		ArrayList<String> newl = new ArrayList<String>(); 
		ArrayList<String> Songlist = new ArrayList<String>();
		ArrayList<Integer> Count = new ArrayList<Integer>();
		
		String line;
		
		// read the songs' names from the tables.
		for(int i = 0; i < myFile.length; i++) {
			Scanner sc = new Scanner(new File(myFile[i]));
			
			while (sc.hasNextLine()) {
				
				line = sc.nextLine();
				
				newl.add(ReadSong(line));
				
			}
			
			sc.close();
		}
		
		int size = newl.size();
		
		// list each different song's name one time in the list.
		for (int j = 0; j < size; j++){
			if (!Songlist.contains(newl.get(j))){
				Songlist.add(newl.get(j));
			}
		}
		
		// count how many times a song appears on the list newl.
		for (int k = 0; k < Songlist.size(); k++){
			Count.add(Collections.frequency(newl, Songlist.get(k)));	
		}
		
		
		// create a new 2D array to put the songs' names and the time they appear on newl together.
		Object[][] SongLIST = new Object[Songlist.size()+1][2];
		SongLIST[0][0] = "Songs";
		SongLIST[0][1] = "Times in the list";
		
		for (int h = 0; h < Songlist.size(); h++){
			SongLIST[h+1][0]= Songlist.get(h);
			SongLIST[h+1][1] = Count.get(h);
			
			}
		
		// call the method Sortsongs to do the bubble sort for the name in the array.
		SongLIST = Sortsongs(SongLIST, Songlist.size());
		
		// print the array.
		for (int m = 0; m < Songlist.size(); m++){
			for (int f = 0; f < 2; f++){
				op.print(SongLIST[m][f] +"\t\t\t\t\t\t\t");
			}
			op.println();
			
		}
			
		op.close();
	}
	
	// pick up the songs' names from each line of form.
	static String ReadSong(String s){
		
		String str2 = s.substring(s.indexOf(",")+1);
		String str3 = str2.substring(0, str2.indexOf(",")+1);
		
		return str3;
		
	}
	
	
	// Do the bubble sort to sort the songs' names in alphabetical order.
	static Object[][] Sortsongs(Object[][] SongLIST, int l){
		
		String t;
		int d;
		
		for (int p = 1; p < l; p++){
			for (int q = p+1; q < l; q++){
				if (((String) SongLIST[q][0]).compareTo((String) SongLIST[p][0]) < 0){
					t = (String) SongLIST[p][0];
					SongLIST[p][0] = SongLIST[q][0];
					SongLIST[q][0] = t;
					d = (int) SongLIST[p][1];
					SongLIST[p][1] = SongLIST[q][1];
					SongLIST[q][1] = d;
				}
			}
		}
		
		return SongLIST;
	}
	
}
