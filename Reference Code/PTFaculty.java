import java.text.NumberFormat;

/** Part Time Faculty Class contains all atributes specific to a Part time Faculty Employee
 * @author Wendy Carolina Velasquez Ebanks
*/
public class PTFaculty extends Employee {
	 private double ClassRate;
	 private int NumClasses;
	 NumberFormat fmt = NumberFormat.getCurrencyInstance();
	 /**initialize the constructor for a Part Time Faculty Object
	  * */
	 public PTFaculty(String n, String ln, int empNum, double cr, int nc){
	    	super(n, ln, empNum);
	    	ClassRate = cr;
	    	NumClasses = nc;
	    }
	 	
	    /** This Method presents the class rate */
	    public double getClassRate(){return ClassRate;}
	    
	    /**This Method presents the number of classes that the Part Time Faculty is teaching*/
	    public int getNumClasses(){return NumClasses;}
	    
	    /**This method makes the String representation of the object*/
		public String toString(){
			String result = "";
			
			//result = "Employee ID: " + getEmployeeID()+ "\n Name: "+ getName() +"\n Address: "+ getAddress() +" \nNumber of Classes: "+ NumClasses + " \nClass Rate: " + ClassRate +"\nWeekly Payment: "+ WeeklyPay() + "\n";
			result =  getEmployeeID() +" "+ getFName() +" " +getLName() +" "+ fmt.format(WeeklyPay())+ "\n";
					return result;
					}
	 
	/**This method Calculates the Weekly Payment for a Part Time Faculty*/
	public double WeeklyPay() {
		double payment = 0.0;
		
		payment = 400 + (ClassRate * NumClasses); 
		
		return payment;
	}
	
 
	 
	 
}
