
/**Employee Class contains all attributes related to an employee.
 * @author Wendy C. Velasquez Ebanks  
 */
public abstract class Employee {

	   private String fname;
	   private String lname;
	   private int EmployeeID;
	   
	   /**
	    * Constructor of the employee Class*/
	   public Employee(String fn, String ln, int EmpID )
	   { fname= fn; lname =ln;  EmployeeID = EmpID;}
	   
	   /**
	    *This Method shows the first name of the employee */
	   public String getFName(){return fname;}
	   
	   /**
	    *This Method shows the first name of the employee */
	   public String getLName(){return lname;}
	   
	   
	   /**
	    *This Method shows the Employee Id for one Employee */
	   public int getEmployeeID(){return EmployeeID;}
	   
	   
	   /**
		   * This method will compare the ID's for two Employees
		   * @param otherElement
		   * @return >0 if this > otherElement, <0 if this < otherElement, 0 if this = otherElement
		   */
		
	   public  int compareTo(Object otherElement) {
		   int result= 0;
		     if(EmployeeID == getEmployeeID()){
	          result = 0;  
		  }else if(EmployeeID < getEmployeeID()){
	    	   result = -1;
		  }else if(EmployeeID < getEmployeeID()){
	    	   result = 1;
		  }
		  return result;
		}		  
	   
	   /**The Equals Method Compare the objects of Employee Type*/
	   
	   public boolean equals(Object obj){
		   Employee n = (Employee)obj;
		   if(EmployeeID == n.EmployeeID){
			   return true;
		   }
		   else return false;
	   }
	   
	
	   /**String representation of the Object Employee*/
	   public String toString(){
		   String result ="";
		   
		   result = "Employee ID " + getEmployeeID() + " First Name: " + getFName() + "Last Name: "+ getLName() + WeeklyPay() + "\n";
		   
		   return result;
	   }
	   
	   
	   /**This Method Calculate the payment of one employee */
	   public abstract double WeeklyPay();
}
