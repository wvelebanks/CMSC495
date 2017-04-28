package etmsclient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Employee's Time Management System
 *
 * @author Justin Mullins
 */
public class DatabaseConnection {

    /**
     * Connects a client to a MySQL server using the Connector/J driver. Only
     * connects to the database using SSL/TLS connection.
     *
     * @param applicationProp a set of properties from the etms.cfg file to
     * establish a db connection
     * @return a secure Connection to a MySQL database
     */
    public static Connection dbConnect(Properties applicationProp) {
        // the username to connect to the database with
        String username = applicationProp.getProperty("client_username");
        // the password to connect to the database with
        String password = applicationProp.getProperty("client_password");
        // the database server to connect to
        String server = applicationProp.getProperty("server_address");
        // the path to the keystore
        String keystorePath = applicationProp.getProperty("keystore_path");
        // the password used to protect the keystore
        String keystorePassword = applicationProp.getProperty("keystore_password");
        // the path to the truststore
        String truststorePath = applicationProp.getProperty("truststore_path");
        // the password used to protect the truststore
        String truststorePassword = applicationProp.getProperty("truststore_password");
        // Set the database to be used
        String database = "etms_schemma";
        
   

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // The below four lines should have parameters that are read-in to set the paths and passwords
            System.setProperty("javax.net.ssl.keyStore", keystorePath);
            System.setProperty("javax.net.ssl.keyStorePassword", keystorePassword);
            System.setProperty("javax.net.ssl.trustStore", truststorePath);
            System.setProperty("javax.net.ssl.trustStorePassword", truststorePassword);
        } catch (ClassNotFoundException ex) {
            // handle any errors
        }

        Connection conn = null;
        String dbURL = "jdbc:mysql://" + server + "/" + database
                + "?verifyServerCertificate=true"
                + "&useSSL=true"
                + "&requireSSL=true";
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }
}
