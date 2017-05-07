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
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getTimeID() {
        return timeID;
    }

    public void setTimeID(int timeID) {
        this.timeID = timeID;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getClockDate() {
        return clockDate;
    }

    public void setClockDate(String clockDate) {
        this.clockDate = clockDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Time{" + "employeeID=" + employeeID + ", timeID=" + timeID + ", timeIn=" + timeIn + ", timeOut=" + timeOut + ", clockDate=" + clockDate + ", completed=" + completed + '}';
    }
}