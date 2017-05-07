package etmsclient;

import java.sql.Date;

/**
 *
 * @author Ian
 * This is an object class for loading the components of a timesheet from the DB.
 * Several consturctors are given, based on the view needed
 */
public class Timesheet {

    int TimeSheetID;
    Date StartDate;
    int PayPeriod;
    Date TimeIn;
    Date TimeOut;
    Date DateSubbmitted;
    int Approval;
    String Notes;
    int Schedule_ScheduleID;
    int EmployeeID;
    int LeaveID;
    int DepartmentID;
    int SignatureID;
    int HoursTableID;

    //Default constructor, no params, no args
    public Timesheet() {}

    //initial load constructor, just basic sheet data, no actual times. 
    //@params TimeSheetID an int of a date from the database
    //@params StartDate a date object from the database
    //@params PayPeriod an int of a date from the database
    //@params HoursTableID an int of id number from the database
    //@params testingDate a date object NOT from the database for internal testing
    public Timesheet(int TimeSheetID, Date StartDate, int PayPeriod, int HoursTableID, Date testingDate) {
      TimeSheetID = 0;
      StartDate = testingDate;
      PayPeriod = 0;
      HoursTableID = 0;
    }

    //constructs a full timesheet object for retrival.
    //@params TimeSheetID an int of a date from the database
    //@params StartDate a date object from the database
    //@params PayPeriod an int of a date from the database
    //@params HoursTableID an int of id number from the database
    //@params testingDate a date object NOT from the database for internal testing
    //@params TimeIn, TimeOut, DateSubmitted, Approval, Notes, Schedule_ScheduleID, EmployeeID, 
    // LeaveID, DepartmentID,SignatureID, HoursTableID are all straight from the database
    //@params testingDate a date object NOT from the database for internal testing
    public Timesheet(int TimeSheetID, Date StartDate, int PayPeriod, Date TimeIn,
    Date TimeOut, Date DateSubmitted, int Approval, String Notes, int Schedule_ScheduleID,
    int EmployeeID, int LeaveID, int DepartmentID, int SignatureID, int HoursTableID, Date testingDate) {
      TimeSheetID = 0;
      StartDate = testingDate;
      PayPeriod = 0;
      TimeIn = testingDate;
      TimeOut = testingDate;
      DateSubmitted = testingDate;
      Approval = 0;
      Notes = ("None");
      Schedule_ScheduleID = 0;
      EmployeeID = 0;
      LeaveID = 0;
      DepartmentID = 0;
      SignatureID = 0;
      HoursTableID = 0;
    }

    //---------getters and setters, no args--------//
    
    //get timsheet ID passed from database query
    //@return timesheet ID int
    public int getTimeSheetID() {
        return TimeSheetID;
    }

    //set timesheetID - should NOT be used to switch timesheets
    //@params timesheet ID int
    public void setTimeSheetID(int TimeSheetID) {
        this.TimeSheetID = TimeSheetID;
    }

    //get pay peroid start date
    //@return StartDate of type java.sql.date Date
    public Date getStartDate() {
        return StartDate;
    }

    //set pay period start date - also should NOT be used to switch timesheets
    //@params java.sql.date Date StartDate
    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    //int identifying the pay period
    //@return int PayPeriod
    public int getPayPeriod() {
        return PayPeriod;
    }

    //set the pay period identifier
    //@params int PayPeriod
    public void setPayPeriod(int PayPeriod) {
        this.PayPeriod = PayPeriod;
    }

    //get the individual punch in
    //@return java.sql.Date Date TimeIn
    public Date getTimeIn() {
        return TimeIn;
    }

    //set the individual punch in
    //@params Date TimeIn
    public void setTimeIn(Date TimeIn) {
        this.TimeIn = TimeIn;
    }

    //get the individual punch out
    //@return java.sql.Date Date TimeOut
    public Date getTimeOut() {
        return TimeOut;
    }

    //set the individual punch out
    //@params Date TimeOut
    public void setTimeOut(Date TimeOut) {
        this.TimeOut = TimeOut;
    }

    //gets the date that the timesheet was submitted
    //@return Date DateSubmitted
    public Date getDateSubbmitted() {
        return DateSubbmitted;
    }

    //set date that the timesheet was submitted
    //@params Date DateSubmitted
    public void setDateSubbmitted(Date DateSubbmitted) {
        this.DateSubbmitted = DateSubbmitted;
    }

    //int flag to denote supervisory approval of timesheet
    //@return int Approval
    public int getApproval() {
        return Approval;
    }

    //set the int flag approval
    //@params int Approval
    public void setApproval(int Approval) {
        this.Approval = Approval;
    }

    //gets the String Notes
    //@return Spring Notes
    public String getNotes() {
        return Notes;
    }

    //sets the String Notes
    //@params String Notes
    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    //gets the int scheduleID
    //@return int scheduleID
    public int getSchedule_ScheduleID() {
        return Schedule_ScheduleID;
    }

    //sets the int scheduleID
    //@params int scheduleID
    public void setSchedule_ScheduleID(int Schedule_ScheduleID) {
        this.Schedule_ScheduleID = Schedule_ScheduleID;
    }

    //gets the int Employee ID
    //@return int EmployeeID
    public int getEmployeeID() {
        return EmployeeID;
    }

    //sets the int employee ID
    //@params int employeeID
    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    //get int flag leave ID
    //@return int LeaveID
    public int getLeaveID() {
        return LeaveID;
    }

    //set int flag leave ID
    //@params int leaveID
    public void setLeaveID(int LeaveID) {
        this.LeaveID = LeaveID;
    }

    //gets the int emplyoyee's separtment ID
    //@return int DepartmentID
    public int getDepartmentID() {
        return DepartmentID;
    }

    //sets the int emplyoyee's department ID
    //@params int DepartmentID
    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    //gets the int signatureID
    //@return int signatureID
    public int getSignatureID() {
        return SignatureID;
    }

    //sets the int signature ID
    //@params int signatureID
    public void setSignatureID(int SignatureID) {
        this.SignatureID = SignatureID;
    }

    //gets the int identifier of the hours sql table
    //@return int HoursTableID
    public int getHoursTableID() {
        return HoursTableID;
    }

    //sets the int identifier of the hours sql table
    //@params int HoursTableID
    public void setHoursTableID(int HoursTableID) {
        this.HoursTableID = HoursTableID;
    }

    @Override
    //auto-generated toString, not used so far
    public String toString() {
        return "Timesheet{" + "TimeSheetID=" + TimeSheetID + ", StartDate=" + StartDate + ", PayPeriod=" + PayPeriod + ", TimeIn=" + TimeIn + ", TimeOut=" + TimeOut + ", DateSubbmitted=" + DateSubbmitted + ", Approval=" + Approval + ", Notes=" + Notes + ", Schedule_ScheduleID=" + Schedule_ScheduleID + ", EmployeeID=" + EmployeeID + ", LeaveID=" + LeaveID + ", DepartmentID=" + DepartmentID + ", SignatureID=" + SignatureID + ", HoursTableID=" + HoursTableID + '}';
    }
    
}
