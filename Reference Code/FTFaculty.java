import java.text.NumberFormat;

/** Full Time Faculty Class contains all atributes specific to a full time faculty employee
 * @author Wendy Carolina Velasquez Ebanks
 */

public class FTFaculty extends Employee{
 
	private double CreditRate;
    private int NumCredits;
    NumberFormat fmt = NumberFormat.getCurrencyInstance();
 
 /**initialize the constructor for a Full Time Faculty Object
  * */
  
    public FTFaculty(String fname, String lname, int EmID, double cr, int nc){
    	super(fname, lname, EmID);
    	CreditRate = cr;
    	NumCredits = nc;
    }

    /**
 	 * This Method presents the credit rate */
    public double getCreditRate(){return CreditRate;}
    
    /**This Method presents the number of credits that the Part Time Faculty is teaching*/
    public int getNumCredits(){return NumCredits;}
	
    
    /**This method makes the String representation of the object*/
    public String toString(){
		String result = "";
		
		//result = "Employee ID: " + getEmployeeID()+ "\n "+ "Name: "+ getName() +" \n"+" Address: " + getAddress() +"\n Number of Credits: "+ NumCredits + " \nCredit Rate: " + CreditRate + " \nWeekly Payment: " + WeeklyPay() + "\n";
		result =    getEmployeeID() +" "+ getFName() +" " +getLName() +" "+ fmt.format(WeeklyPay())+ "\n";
		return result;
	}
    
    
    /**This method Calculates the Weekly Payment for a Part Time Faculty*/
	public double WeeklyPay() {
		double payment = 0.0;
		
		payment = NumCredits*CreditRate;
		
		return payment;
	}
}
