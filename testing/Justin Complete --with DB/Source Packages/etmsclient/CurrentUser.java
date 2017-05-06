package etmsclient;

import java.util.Arrays;

/**
 * The CurrentUser class creates a CurrentUser object which holds values of the
 * user who is currently logged into the ETMS Client software. It holds the
 * user's EmployeeID, PositionID, and if the user is a supervisor the
 * EmployeeID's of his subordinates. This class is meant to help keep track of
 * who is logged into the ETMS client and who's information they should be able
 * to access.
 *
 * @author Justin Mullins
 */
public class CurrentUser {

   public static void clear() {
        user = -1;
        position = -1;
        employees = null;
    }

    static int user;
    static int position;
    static int[] employees;

    /**
     * This Constructor is for non-supervisory PositionIDs.
     *
     * @param userID - the current user's EmployeeID
     * @param positionID - the current user's PositionID
     */
    public CurrentUser(int userID, int positionID) {
        user = userID;
        position = positionID;
        employees = new int[0];
    }

    /**
     * This Constructor is for supervisory PositionIDs.
     *
     * @param userID - the current user's EmployeeID
     * @param positionID - the current user's PositionID
     * @param employeesID - the EmployeeID's of the supervisors subordinates
     */
    public CurrentUser(int userID, int positionID, int[] employeesID) {
        user = userID;
        position = positionID;
        employees = employeesID;
    }

    /**
     * Set the CurrentUser's EmployeeID
     * 
     * @param user - the EmployeeID
     */
    public void setUser(int user) {
        this.user = user;
    }

    /**
     * Return the CurrentUser's EmployeeID
     * 
     * @return an integer representing the user's EmployeeID
     */
    public int getUser() {
        return user;
    }

    /**
     * Set the CurrentUsr's PostionID
     * 
     * @param position - the PositionID
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Return the CurrentUser's PositionID
     * 
     * @return an integer representing the user's PositionID
     */
    public int getPosition() {
        return position;
    }

    /**
     * Set the CurrentUser's list of employees EmployeeID numbers
     * 
     * @param employees - an integer array representing the user's list of employees
     * EmployeeID's
     */
    public void setEmployees(int[] employees) {
        this.employees = employees;
    }
    
    /**
     * Return the CurrentUser's list of employees EmployeeID numbers
     * 
     * @return an integer array representing the user's list of employee EmployeeID's
     */
    public int[] getEmployees() {
        return employees;
    }

    /**
     * Returns a String representation of the Employee object
     * 
     * @return a String that shows the values of CurrentUser
     */
    @Override
    public String toString() {
        if(employees.length == 0) {
            return "CurrentUser{" + "EmployeeID=" + user + "PositionID=" + position + "}";  
        }
        else {
            return "CurrentUser{" + "EmployeeID=" + user + "PositionID=" + position + "EmployeeList="
                    + Arrays.toString(employees) + "}";
        }
    }
}
