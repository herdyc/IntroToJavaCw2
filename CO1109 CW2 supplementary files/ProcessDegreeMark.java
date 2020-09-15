import java.util.*;
import java.io.*;

public class ProcessDegreeMark{

	public static ArrayList<Finalist> finalistsInList(String s) throws Exception{
		ArrayList<Finalist> finalists = new ArrayList<Finalist>();
		String id;
		double mark;
		Scanner in =new Scanner(new FileReader(s));
			while(in.hasNextLine()){
				id =in.nextLine();
				mark = Double.parseDouble(in.nextLine());
				finalists.add(new Finalist(id,mark));
			}
			in.close();//finished with the Scanner object, tidy up.
		return finalists;
	 }


	public static void displayFinalists(ArrayList<Finalist> finalists){
	  for (int i = 0; i < finalists.size(); i++) {
		   System.out.println(finalists.get(i));
	  }
  	}


	public static void findFinalistID(ArrayList<Finalist> a, String s){
		for (int i=1;i<a.size();i++)
			if (((a.get(i))).getId().equals(s))
				System.out.println(a.get(i));
	}


    public static void finalistsToFile(ArrayList<Finalist> finalists, String s) throws Exception{
		ArrayList<Finalist> sortedFinalists = new ArrayList<Finalist>();
		sortedFinalists.addAll(finalists);

		//sort by degree mark (descending)
		Collections.sort(sortedFinalists, new FinalistComparator());

		//save sorted arraylist to a file called s
		PrintStream out = new PrintStream(new FileOutputStream(s));
		for(int i = 0; i < sortedFinalists.size(); i++)
		out.println(sortedFinalists.get(i));
		out.close();
	}


    	public static void main(String[] args) throws Exception{
	 System.out.println("/****************************************************/");
			 System.out.println("/*******finalistsInList with invalid file name*******/");
			 System.out.println();
			 ArrayList<Finalist> testList = finalistsInList("***.txt");//find out what happens with an invalid file name
			 System.out.println();
			 System.out.println("/****************************************************/");
			 System.out.println("/********finalistsInList with valid file name********/");
			 System.out.println("/********display to check arraylist populated********/");
			 System.out.println();
			 ArrayList<Finalist> finalists = finalistsInList("finalMark.txt");//populate an arraylist of finalist from the file
			 displayFinalists(finalists); //check above successful
			 System.out.println();
			 System.out.println("/****************************************************/");
			 System.out.println("/*testing findFinalistID with valid and invalid data*/");
			 System.out.println();
			 findFinalistID(finalists, "75021");  //eheck method finds
			 findFinalistID(finalists, "21050");     //check no false positives, and not found message
			 System.out.println();
			 System.out.println("/****************************************************/");
			 System.out.println("/*test findFinalistClass with valid and invalid data*/");
			 System.out.println();
//			 findFinalistClass(finalists, "FIRST"); //check method finds
//			 findFinalistClass(finalists, "THIRD"); //check no false positives, and not found message
			 System.out.println();
			 System.out.println("/****************************************************/");
			 System.out.println("/*****run sortedFinalists then test with display*****/");
			 System.out.println();
//			 ArrayList<Finalist> sortedFinalists = sortDegreeMark(finalists); //make an arraylist of Finalist sorted by degreeMark
//			 displayFinalists(sortedFinalists); //test that the sorting worked
			 System.out.println();
			 System.out.println("/****************************************************/");
			 System.out.println("/*****test finalistsToFile2 with sorted arraylist*****/");
			 System.out.println("/**************check file testSorted.txt**************/");
			 System.out.println();
//			 finalistsToFile2(sortedFinalists, "testSorted.txt"); //save the sorted arraylist to a new file, check by opening file
			 System.out.println();
			 System.out.println("/****************************************************/");
			 System.out.println("/*test findAndSaveFinalistClass with valid and invalid data*/");
			 System.out.println();
//			 findAndSaveFinalistClass(finalists, "FIRST"); //test method finds
//			 findAndSaveFinalistClass(finalists, "THRID"); //check appropriate error message when nothing found, open new text file
			 System.out.println();
			 System.out.println("/*********************THE END************************/");
		 }
}
