package etmsclient;

import java.sql.Date;
import java.util.UUID;

/**
 *  @date created 
 *  @author Ian Spooner
 */

public class PunchTime {

    int employeeID;
    String timeID;
    Date timeIn;
    Date timeOut;
    Date clockDate;
    boolean completed;
    
    public PunchTime() {}

    public PunchTime(Date timeIn, Date clockDate, boolean completed) {
        UUID newID = UUID.randomUUID();
        String newTimeID = String.valueOf(newID);
        
        completed = false;
        timeID = newTimeID;
        timeIn = null;
        clockDate = null;
    }
    
    public PunchTime(Date timeIn, Date timeOut, Date clockDate, boolean completed) {
        completed = true;
        UUID newID = UUID.randomUUID();
        String newTimeID = String.valueOf(newID);
        
        timeID = newTimeID;
        timeIn = this.timeIn;
        timeOut = null;
        clockDate = null;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getTimeID() {
        return timeID;
    }

    public void setTimeID(String timeID) {
        this.timeID = timeID;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    public Date getClockDate() {
        return clockDate;
    }

    public void setClockDate(Date clockDate) {
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