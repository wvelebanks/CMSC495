package etmsclient;

import java.sql.Date;

/**
 * The Employee class creates a Employee object which holds values of the
 * Employee table from the ETMS database. This can be used to hold information
 * about an employee or to add a new set of employee information to the
 * database, like when you add a new user.
 *
 * @author Justin Mullins
 */
public class Employee {

    int employeeID;
    String firstName, middleName, lastName;
    String ssn;
    Date birthdate;
    String street, city, state, zipC;
    String phone, email;
    int positionID;
    int employeeTypeID;

    /**
     * This constructor is for reading in and storing an existing employees
     * information from the database.
     *
     * @param employee - the employee's EmployeeID
     * @param firstN - the employee's first name
     * @param middleN - the employee's middle name
     * @param lastN - the employee's last name
     * @param soc - the employee's social security number
     * @param birth - the employee's date of birth (yyyy-mm-dd)
     * @param str - the employee's street address
     * @param cit - the employee's city
     * @param stat - the employee's state of residence
     * @param zip - the employee's zip code
     * @param pho - the employee's phone number
     * @param mail - the employee's email address
     * @param position - the employee's PositionID
     * @param employeeType - the employee's EmployeeTypeID
     */
    public Employee(int employee, String firstN, String middleN, String lastN,
            String soc, Date birth, String str, String cit, String stat, String zip, String pho, String mail,
            int position, int employeeType) {

        employeeID = employee;
        firstName = firstN;
        middleName = middleN;
        lastName = lastN;
        ssn = soc;
        birthdate = birth;
        street = str;
        city = cit;
        state = stat;
        zipC = zip;
        phone = pho;
        email = mail;
        positionID = position;
        employeeTypeID = employeeType;
    }

    /**
     * This constructor is for creating a new user and adding his employee
     * information to the ETMS database.
     *
     * @param firstN - the employee's first name
     * @param middleN - the employee's middle name
     * @param lastN - the employee's last name
     * @param soc - the employee's social security number
     * @param birth - the employee's date of birth (yyyy-mm-dd)
     * @param str - the employee's street address
     * @param cit - the employee's city
     * @param stat - the employee's state of residence
     * @param zip - the employee's zip code
     * @param pho - the employee's phone number
     * @param mail - the employee's email address
     * @param position - the employee's PositionID
     * @param employeeType - the employee's EmployeeTypeID
     */
    public Employee(String firstN, String middleN, String lastN,
            String soc, Date birth, String str, String cit, String stat, String zip, String pho, String mail,
            int position, int employeeType) {

        employeeID = -1;
        firstName = firstN;
        middleName = middleN;
        lastName = lastN;
        ssn = soc;
        birthdate = birth;
        street = str;
        city = cit;
        state = stat;
        zipC = zip;
        phone = pho;
        email = mail;
        positionID = position;
        employeeTypeID = employeeType;
    }

    /**
     * Set the Employee's first name
     *
     * @param firstName - the Employee's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Return the Employee's first name
     *
     * @return - the Employee's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the Employee's middle name
     *
     * @param middleName - the Employee's middle name
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Return the Employee's middle name
     *
     * @return - the Employee's middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Set the Employee's last name
     *
     * @param lastName - the Employee's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Return the Employee's last name
     *
     * @return - the Employee's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the Employee's social security number
     *
     * @param ssn - the Employee's social security number
     */
    public void setSSN(String ssn) {
        this.ssn = ssn;
    }

    /**
     * Return the Employee's social security number
     *
     * @return - the Employee's social security number
     */
    public String getSSN() {
        return ssn;
    }

    /**
     * Set the Employee's date of birth
     *
     * @param birthdate - the Employee's date of birth (yyyy-mm-dd)
     */
    public void setBirthDate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Return the Employee's date of birth
     *
     * @return - the Employee's date of birth (yyyy-mm-dd)
     */
    public Date getBirthDate() {
        return birthdate;
    }

    /**
     * Set the Employee's street address
     *
     * @param street - the Employee's street address
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Return the Employee's street address
     *
     * @return - the Employee's street address
     */
    public String getStreet() {
        return street;
    }

    /**
     * Set the Employee's city of residence
     *
     * @param city - the Employee's city of residence
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Return the Employee's city of residence
     *
     * @return - the Employee's city of residence
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the Employee's state of residence
     *
     * @param state - the Employee's state of residence
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Return the Employee's state of residence
     *
     * @return - the Employee's state of residence
     */
    public String getState() {
        return state;
    }

    /**
     * Set the Employee's zip code
     *
     * @param zipC - the Employee's zip code
     */
    public void setZip(String zipC) {
        this.zipC = zipC;
    }

    /**
     * Return the Employee's zip code
     *
     * @return - the Employee's zip code
     */
    public String getZip() {
        return zipC;
    }

    /**
     * Set the Employee's phone number
     *
     * @param phone - the Employee's phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Return the Employee's phone number
     *
     * @return - the Employee's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the Employee's email address
     *
     * @param email - the Employee's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return the Employee's email address
     *
     * @return - the Employee's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the Employee's PositionID, by default 1 is admin, 2 is Supervisor, and
     * 3 is non-supervisory
     *
     * @param positionID - the Employee's PositionID
     */
    public void setPosition(int positionID) {
        this.positionID = positionID;
    }

    /**
     * Return the Employee's PositionID
     *
     * @return - the Employee's PositionID
     */
    public int getPosition() {
        return positionID;
    }

    /**
     * Set the Employee's EmployeeTypeID
     *
     * @param employeeTypeID -the Employee's EmployeeTypeID
     */
    public void setEmployeeType(int employeeTypeID) {
        this.employeeTypeID = employeeTypeID;
    }

    /**
     * Return the Employee's EmployeeTypeID
     *
     * @return - the Employee's EmployeeTypeID
     */
    public int getEmployeeType() {
        return employeeTypeID;
    }

    /**
     * Returns a String representation of the Employee object
     *
     * @return - a String representing the Employee object
     */
    @Override
    public String toString() {
        if (employeeID == -1) {
            return "Employee{" + "EmployeeID=NOT_YET_DEFINED" + ", FirtName=" + firstName
                    + ", MiddleName=" + middleName + ", LastName=" + lastName + ", SSN=" + ssn
                    + ", Birthdate=" + birthdate + ", StreetNumber=" + street + ", City="
                    + city + ", State=" + state + ", ZipCode=" + zipC + ", Phone="
                    + phone + ", Email=" + email + ", PositionID=" + positionID + ", EmployeeTypeID"
                    + employeeTypeID + "}";
        } else {
            return "Employee{" + "EmployeeID=" + employeeID + ", FirtName=" + firstName
                    + ", MiddleName=" + middleName + ", LastName=" + lastName + ", SSN=" + ssn
                    + ", Birthdate=" + birthdate + ", StreetNumber=" + street + ", City="
                    + city + ", State=" + state + ", ZipCode=" + zipC + ", Phone="
                    + phone + ", Email=" + email + ", PositionID=" + positionID + ", EmployeeTypeID"
                    + employeeTypeID + "}";
        }
    }
}
