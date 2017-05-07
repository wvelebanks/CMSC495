package etmsclient;

/**
 * @date created
 * @author Ian Spooner
 */
public class PunchTime {

    int employeeID;
    int timeID;
    String timeIn;
    String timeOut;
    String clockDate;
    boolean completed;

    //Default constructor, no params, no args
    public PunchTime(){}

    //*****Test Constructor ****** Creates Incomplete time entry; that is, a clockin
    //@params employeeID, timeID, timeIn, clockDate should be fetched from the database on load, through clockin or dashboard
    public PunchTime(int employeeID, int timeID, String timeIn, String clockDate) {
        this.employeeID = employeeID;
        this.completed = false;
        this.timeID = timeID;
        this.timeIn = timeIn;
        this.timeOut = null;
        this.clockDate = clockDate;
    }

    //*****TEST CONSTRUCTOR ******* complete time entry, that is, a clockout
    //@params employeeID, timeID, timeIn, clockDate should be fetched from the database on load, through clockin or dashboard
    //@params 
    public PunchTime(int employeeID, int timeID, String timeIn, String timeOut, String clockDate) {
        this.completed = true;
        this.employeeID = employeeID;
        this.timeID = timeID;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.clockDate = clockDate;
    }

    //---------getters and setters, no args--------//
    
    //gets the int employee ID
    //@return employeeID
    public int getEmployeeID() {
        return employeeID;
    }

    //sets the int employee ID
    //@params int employeeID
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    //sets the time punch UUID
    //@return int timeID
    public int getTimeID() {
        return timeID;
    }

    //sets the UUID time punch ID, used by clock in and out classes
    //@params int timeID
    public void setTimeID(int timeID) {
        this.timeID = timeID;
    }

    //gets the individual punch in time
    //@return String timeIn
    public String getTimeIn() {
        return timeIn;
    }

    //sets the individual punch in time
    //@params String timeIn
    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    //gets the individual punch out time
    //@return String timeOut
    public String getTimeOut() {
        return timeOut;
    }

    //sets the individual punch out time
    //@params String timeOut
    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    //gets the individual punch out date
    //@return String clockDate
    public String getClockDate() {
        return clockDate;
    }

    //sets the individual punch out date
    //@params String clockDate
    public void setClockDate(String clockDate) {
        this.clockDate = clockDate;
    }

    //boolean flag for determining whether the punch in is paired with a punch out
    //@return boolean completed
    public boolean isCompleted() {
        return completed;
    }

    //sets the boolean flag for a paired punch
    //@params boolean completed
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    //generic toString, not used so far
    public String toString() {
        return "Time{" + "employeeID=" + employeeID + ", timeID=" + timeID + ", timeIn=" + timeIn + ", timeOut=" + timeOut + ", clockDate=" + clockDate + ", completed=" + completed + '}';
    }
}
