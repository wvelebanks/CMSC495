package etmsclient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * The DatabaseAccess class contains functions that will be used to either read
 * from or write to the ETMS database.
 * 
 * @author Justin Mullins
 */
public class DatabaseAccess {

    /**
     * Load a timesheet from the database based on the pay period date which is
     * passed in as a parameter. This should be able to be passed to the web GUI
     * timesheet to load in data, or to the digitalSign(String) and
     * digitalVerify(String) functions.
     *
     * @param conn the connection to the database
     * @param payperiodDate date for the payperiod in yyyymmdd format
     * @return a String that contains all the fields for timesheet
     */
    public static String loadTimesheet(Connection conn, int payperiodDate) {
        String test = null;
        return test;
    }

    /**
     * Save the data in the web GUI timesheet to the database.
     *
     * @param conn the connection to the database
     */
    public static void saveTimesheet(Connection conn) {
        // First verify if the data in the web GUI timesheet is valid
        verifyTimesheet();

        // Save the data back into the database
    }

    /**
     * Verify if the data entered in the web GUI timesheet is valid before
     * saving to the database.
     *
     * @return true if timesheet validates, false otherwise
     */
    public static boolean verifyTimesheet() {
        boolean test = false;
        return test;
    }

    /**
     * Insert the digital signature for the users timesheet into the the
     * Signature table.
     *
     * @param conn a secure connection to the database server
     * @param employeeType set to 1 if saving the employee signature, set to 2
     * if saving the supervisor signature.
     * @param digitalSig the digital signature that is to be inserted into the
     * db
     * @param signatureId the primary key for the signature table in the etms db
     */
    public static void saveSignature(Connection conn, int employeeType, byte[] digitalSig, int signatureId) {
        try {
            String employee = null;

            switch (employeeType) {
                case 1:
                    employee = "SignatureEmployee";
                    break;
                case 2:
                    employee = "SignatureSupervisor";
                    break;
                /* TODO: Throw some error */
                default:
                    break;
            }

            String insertSignature = "UPDATE signature SET " + employee + " = ? where SignatureID = ?";

            try (PreparedStatement ps = conn.prepareStatement(insertSignature)) {
                ps.setBytes(1, digitalSig);
                ps.setInt(2, signatureId);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            // handle any errors
        }
    }

    /**
     * Load the digital signature from the database and return it to be
     * inspected. Identifies the signature to load based on the signatureId and
     * employeeType passed in. Digital signatures are stored in the etms
     * database under the signature table which has the following columns
     * (signatureId, SignatureEmployee, and SignatureSupervisor).
     *
     * @param conn a secure connection to the database server
     * @param employeeType specifies if the user is a supervisor or not (1 is
     * non-supervisor, 2 is supervisor)
     * @param signatureId the signature id of the row in the signature table
     * where the signature is stored.
     * @return the digital signature stored by the user of type employeeType in
     * the signature table in row signatureId.
     */
    public static byte[] loadSignature(Connection conn, int employeeType, int signatureId) {
        String employee = null;
        byte[] signature = null;

        switch (employeeType) {
            case 1:
                employee = "SignatureEmployee";
                break;
            case 2:
                employee = "SignatureSupervisor";
                break;
            /* TODO: Throw some error */
            default:
                break;
        }

        String grabSignature = "SELECT " + employee + " from signature where signatureID = ?";

        try (PreparedStatement ps = conn.prepareStatement(grabSignature)) {
            ps.setInt(1, signatureId);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            rs.next();
            signature = rs.getBytes(employee);
        } catch (SQLException ex) {
        }
        return signature;
    }

    /**
     * Add a new user to the ETMS database, this can only be done by an administrative
     * user (PositionID==1).
     * 
     * @param conn - the Connection to the ETMS database
     * @param user - a CurrentUser object
     * @param emp - a new Employee object
     * @param username - the new user's username
     * @param passHash - the new user's hashed password
     */
    public static void addUser(Connection conn, CurrentUser user, Employee emp, String username, String passHash) {
        // Check if current user is admin (positionID 1)
        if (user.getPosition() == 1) {
            try {
                String insertEmployee = "INSERT INTO `employee` (`FirstName`,`MiddleName`,`LastName`,`SSN`,`Birthdate`,`StreetNumber`,`City`,`State`,`ZipCode`,`Phone`,`Email`,`PositionID`,`EmployeeTypeID`) "
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                
                Properties certprop = Helper.loadConfig(2);
                byte[] pubEncodKey = Helper.loadKey(certprop.getProperty("keystore_path"), certprop.getProperty("keystore_password"), certprop.getProperty("alias")).getPublic().getEncoded();
                
                String insertUser = "INSERT INTO `usertable` (`UserName`,`UserPassWord`,`EmployeeID`, `UserPublicKey`) "
                        + "VALUES (?,?,?,?)";
                
                String getEmpID = "SELECT EmployeeID FROM employee WHERE SSN = ?";
                
                try (PreparedStatement ps = conn.prepareStatement(insertEmployee)) {
                    ps.setString(1, emp.getFirstName());
                    ps.setString(2, emp.getMiddleName());
                    ps.setString(3, emp.getLastName());
                    ps.setString(4, emp.getSSN());
                    ps.setDate(5, emp.getBirthDate());
                    ps.setString(6, emp.getStreet());
                    ps.setString(7, emp.getCity());
                    ps.setString(8, emp.getState());
                    ps.setString(9, emp.getZip());
                    ps.setString(10, emp.getPhone());
                    ps.setString(11, emp.getEmail());
                    ps.setInt(12, emp.getPosition());
                    ps.setInt(13, emp.getEmployeeType());
                    
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    // handle exception
                }
                
                PreparedStatement empID = conn.prepareStatement(getEmpID);
                empID.setString(1, emp.getSSN());
                ResultSet rs1 = empID.executeQuery();
                rs1.next();
                int employeeID = rs1.getInt("employee.EmployeeID");
                System.out.println(employeeID);
                
                try (PreparedStatement ps = conn.prepareStatement(insertUser)) {
                    ps.setString(1, username);
                    ps.setString(2, passHash);
                    ps.setInt(3, employeeID);
                    ps.setBytes(4, pubEncodKey);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    // handle exception
                }
                
            } catch (SQLException ex) {
                // handle exception
            }

        } else {
            // Some Alert Log
        }
    }
}
