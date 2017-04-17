
/** Employees Class uses all the methods specified in EmployeesInterface
 * @author Wendy Carolina Velasquez Ebanks
 */
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.ArrayList;

public class Employees implements EmployeesInterface{

	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	private int NumAdmin = 0, NumMaintenance = 0, NumFTFac = 0, NumPTFac= 0, counter = 0;
	
	static ArrayList<Employee> staff = new ArrayList<Employee>(); 
	
	/**
	 * This Method adds an employee to the ArrayList.
	 * @param paycode Type of employee: 1-Full-time Faculty, 2-Part-time Faculty, 3-Administrator, 4-Maintenance
	 * @param fname First Name
	 * @param lname Last Name
	 * @param firstParam 1-pay per Credit, 2-pay per Class, 3-salary, 4-hourly rate
	 * @param secondParam 1-number of Credits, 2-number of Classes, 3-not needed, 4-number of hours
	 * @param empNum employee number
	 */
	public void addEmployee(int paycode, String fname, String lname,
			double firstParam, int secondParam, int empNum) {
					
		         switch (paycode){
		         
		                 case 1: {// adds a Full time Faculty
		                	 	  staff.add(counter, new FTFaculty(fname, lname, empNum, firstParam, secondParam));
		                	 	  counter++;
		                	 	  NumFTFac++;
		                	 	  break;}
		                 
		                 case 2: {// adds a part time faculty
		                	      staff.add(counter, new PTFaculty(fname, lname, empNum, firstParam, secondParam));
		                	      counter++;
		                	 	  NumPTFac++;
		                	      break;}
		                 
		                 case 3: {// adds an administrator
		                	      staff.add(counter, new Administrator(fname, lname, empNum, firstParam));
		                	      counter++;
		                	      NumAdmin++;
		                          break;}
		                 
		                 case 4: {// adds a maintenance 
		                       	  staff.add(counter, new Maintenance(fname, lname, empNum, firstParam, secondParam));
		                       	  counter++;
		                	      NumMaintenance++;
		                	      break;}
		           }
		
	}

	/**
	 * This Method returns the number of Administrators in the ArrayList
	 * @return number of Administrators
	 */
	public int getNumAdmin() {
		// TODO Auto-generated method stub
		return NumAdmin;
	}

	/**
	 * This Method returns the number of Maintenance in the ArrayList
	 * @return number of Maintenance
	 */
	public int getNumMaintenance() {
		// TODO Auto-generated method stub
		return NumMaintenance;
	}

	/**
	 * This Method returns the number of Full-time Faculty in the ArrayList
	 * @return number of Full-time Faculty
	 */
	public int getNumFTFac() {
		// TODO Auto-generated method stub
		return NumFTFac;
	}

	/**
	 * This Method returns the number of Part-time Faculty in the ArrayList
	 * @return number of Part-time Faculty
	 */
	public int getNumPTFac() {
		// TODO Auto-generated method stub
		return NumPTFac;
	}

	/**
	 * This Method sort the objects by employee Number
	 */
	public void sort() {
		// TODO Auto-generated method stub
				SortingArrays.insertionSort(staff);
				SortingArrays.selectionSort(staff);
	}
	
	/** This Method returns the first element in the Array List*/
	public Employee getFirstEmployee(){
		
		Employee Element;
		
		Element = staff.get(0);
		
		return Element;
		
	}

	/**
	 * This Method generates a weekly report of employee weekly pay
	 * @return String that contains the Weekly Report
	 */
	public String generateWeeklyReport() {
		
		String result = "WEEKLY PAY REPORT FOR HOGSMEADE COMMUNITY COLLEGE\n\n" +"\n\n EMPLOYEE             WEEKLY PAY \n";
		
		for(int i=0; i< staff.size(); i++)
	      { 
	         result = result + staff.get(i); 
	      }
	      
	      result = result + "\n\nTotal Payrroll: " + fmt.format(calculateTotalWeeklyPay()) +"\n Total Number of FT Faculty Paid: " + getNumFTFac() +
	        		 "\nTotal Number of PT Faculty Paid: " + getNumPTFac() + "\nTotal Number of Administrators Paid: " + getNumAdmin() + 
	        		 "\nTotal Number of Maintenance Paid: " + getNumMaintenance();
         
		return result;
	}

	/**
	 * THis Method calculate the total weekly pay for all employees in the ArrayList
	 * @return the total weekly pay for all employees
	 */
	public double calculateTotalWeeklyPay() {
		// TODO Auto-generated method stub
		double sum = 0.0;
		
		for(Employee s: staff){
			sum = sum + s.WeeklyPay();
		}
		return sum;
	}
	
	
	/**
	 * This Method creates a string representation of the object
	 * @return String that represents the objects in the ArrayList
	 */
	public String toString(){
		String result="";
		
		for(int i=0; i< staff.size(); i++){
			result = result + staff.get(i).getEmployeeID() + " " + staff.get(i).getFName() +" "+ staff.get(i).getLName() +" " + fmt.format(staff.get(i).WeeklyPay()) + " \n ";
		}
		
		return result;
	}
	

}
