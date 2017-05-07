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
    public int getTimeSheetID() {
        return TimeSheetID;
    }

    public void setTimeSheetID(int TimeSheetID) {
        this.TimeSheetID = TimeSheetID;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public int getPayPeriod() {
        return PayPeriod;
    }

    public void setPayPeriod(int PayPeriod) {
        this.PayPeriod = PayPeriod;
    }

    public Date getTimeIn() {
        return TimeIn;
    }

    public void setTimeIn(Date TimeIn) {
        this.TimeIn = TimeIn;
    }

    public Date getTimeOut() {
        return TimeOut;
    }

    public void setTimeOut(Date TimeOut) {
        this.TimeOut = TimeOut;
    }

    public Date getDateSubbmitted() {
        return DateSubbmitted;
    }

    public void setDateSubbmitted(Date DateSubbmitted) {
        this.DateSubbmitted = DateSubbmitted;
    }

    public int getApproval() {
        return Approval;
    }

    public void setApproval(int Approval) {
        this.Approval = Approval;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public int getSchedule_ScheduleID() {
        return Schedule_ScheduleID;
    }

    public void setSchedule_ScheduleID(int Schedule_ScheduleID) {
        this.Schedule_ScheduleID = Schedule_ScheduleID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public int getLeaveID() {
        return LeaveID;
    }

    public void setLeaveID(int LeaveID) {
        this.LeaveID = LeaveID;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public int getSignatureID() {
        return SignatureID;
    }

    public void setSignatureID(int SignatureID) {
        this.SignatureID = SignatureID;
    }

    public int getHoursTableID() {
        return HoursTableID;
    }

    public void setHoursTableID(int HoursTableID) {
        this.HoursTableID = HoursTableID;
    }

    @Override
    public String toString() {
        return "Timesheet{" + "TimeSheetID=" + TimeSheetID + ", StartDate=" + StartDate + ", PayPeriod=" + PayPeriod + ", TimeIn=" + TimeIn + ", TimeOut=" + TimeOut + ", DateSubbmitted=" + DateSubbmitted + ", Approval=" + Approval + ", Notes=" + Notes + ", Schedule_ScheduleID=" + Schedule_ScheduleID + ", EmployeeID=" + EmployeeID + ", LeaveID=" + LeaveID + ", DepartmentID=" + DepartmentID + ", SignatureID=" + SignatureID + ", HoursTableID=" + HoursTableID + '}';
    }
    
}