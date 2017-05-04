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
    String birthdate;
    String street, city, state, zipC;
    String phone, email;
    int positionID;
    int employeeTypeID;

  
    public Employee(int employee, String firstN, String middleN, String lastN,
            String soc, String birth, String str, String cit, String stat, String zip, String pho, String mail) {

        this.employeeID = employee;
        this.firstName = firstN;
        this.middleName = middleN;
        this.lastName = lastN;
        this.ssn = soc;
        this.birthdate = birth;
        this.street = str;
        this.city = cit;
        this.state = stat;
        this.zipC = zip;
        this.phone = pho;
        this.email = mail;        
    }


	public int getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getSsn() {
		return ssn;
	}


	public void setSsn(String ssn) {
		this.ssn = ssn;
	}


	public String getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZipC() {
		return zipC;
	}


	public void setZipC(String zipC) {
		this.zipC = zipC;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getPositionID() {
		return positionID;
	}


	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}


	public int getEmployeeTypeID() {
		return employeeTypeID;
	}


	public void setEmployeeTypeID(int employeeTypeID) {
		this.employeeTypeID = employeeTypeID;
	}
    
}