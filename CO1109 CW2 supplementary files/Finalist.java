public class Finalist{

    private String id;
    private double degreeMark;
    private String degreeClass;
    private boolean borderline;


  public Finalist(String id, double degreeMark) {
        this.id = id;
        this.degreeMark = degreeMark;
        borderline = calcBorderline();
        degreeClass = assignDegreeClass();
    }

    private String assignDegreeClass(){//change method name
		if (degreeMark<40) return "FAIL";
        if (degreeMark<50) return "THIRD";
        if (degreeMark<60) return "LOWER_SECOND";
        if (degreeMark<70) return "UPPER_SECOND";
        return "FIRST";
    }

     private boolean calcBorderline(){
		 double x;
		 if (degreeMark<40){
			 x = 40.0-degreeMark;
			 if (x < 1.0) return true;
		 }
         if (degreeMark<50){
			 x = 50.0-degreeMark;
			 if (x < 1.0) return true;
		 }
         if (degreeMark<60){
			 x = 60.0-degreeMark;
			 if (x < 1.0) return true;
		 }
         if (degreeMark<70){
			 x = 70.0-degreeMark;
         	 if (x < 1.0) return true;
		 }
         return false;
    }

   	public String getId(){
		return id;
	}

     public String toString() {
  		String s = "ID: " + id + ", Final Mark: " + degreeMark + ", Classification: " + degreeClass + System.lineSeparator();
  		//https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#lineSeparator--
  		//returns the appropriate newline code for the system the class is run on
  		return s;
	}
}
