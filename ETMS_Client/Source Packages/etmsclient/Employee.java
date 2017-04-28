package etmsclient;

import java.sql.Date;

/**
 *
 * @author Justin
 */
public class Employee {

    int employeeID;
    String firstName, middleName, lastName;
    String ssn;
    Date birthdate;
    String street, city, state, zipC;
    String phone, email;
    int positionID;
    int employeTypeID;

    public Employee(int employee, String firstN, String middleN, String lastN,
            String soc, Date birth, String str, String cit, String stat, String zip, String pho, String mail,
            int position, int employeType) {

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
        employeTypeID = employeType;
    }

    public Employee(String firstN, String middleN, String lastN,
            String soc, Date birth, String str, String cit, String stat, String zip, String pho, String mail,
            int position, int employeType) {

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
        employeTypeID = employeType;
    }

    public void setFirstName(String name) {
        firstName = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setMiddleName(String name) {
        middleName = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setLastName(String name) {
        lastName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setSSN(String social) {
        ssn = social;
    }

    public String getSSN() {
        return ssn;
    }

    public void setBirthDate(Date date) {
        birthdate = date;
    }

    public Date getBirthDate() {
        return birthdate;
    }

    public void setStreet(String someStreet) {
        street = someStreet;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String someCity) {
        city = someCity;
    }

    public String getCity() {
        return city;
    }

    public void setState(String someState) {
        state = someState;
    }

    public String getState() {
        return state;
    }

    public void setZip(String someZip) {
        zipC = someZip;
    }

    public String getZip() {
        return zipC;
    }

    public void setPhone(String somePhone) {
        phone = somePhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String someEmail) {
        email = someEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setPosition(int somePosition) {
        positionID = somePosition;
    }

    public int getPosition() {
        return positionID;
    }

    public void setEmployeeType(int someType) {
        employeTypeID = someType;
    }

    public int getEmployeeType() {
        return employeTypeID;
    }
}
