/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.net.ssl.*;
/**
 *
 * @author Justin
 */
public class JavaDB {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.setProperty("javax.net.ssl.keyStore","C:/Users/Justin/Desktop/mysql/pk_certs/keystore");
            System.setProperty("javax.net.ssl.keyStorePassword","P@$$w0rd");
            System.setProperty("javax.net.ssl.trustStore","C:/Users/Justin/Desktop/mysql/pk_certs/truststore");
            System.setProperty("javax.net.ssl.trustStorePassword","P@$$w0rd");
        } catch (Exception ex) {
            // handle the error
        }
        
        Connection conn = null;
        String username = "root";
        String password = "P@$$w0rd#787!$";
        String dbURL = "jdbc:mysql://localhost/mysql"
                + "?verifyServerCertificate=true"
                + "&clientCertificateKeyStoreUrl=file:///C:/Users/Justin/Desktop/mysql/pk_certs/keystore"
                + "&clientCertificateKeyStorePassword=P@$$w0rd"
                + "&useSSL=true"
                + "&requireSSL=true";
        
        try {
            conn =
            DriverManager.getConnection(dbURL, username, password);

            Statement stmt = null;
            ResultSet rs = null;
            try{
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT USER FROM USER");
                while(rs.next()) {
                    System.out.println(rs.getString(1));
                }
            }
            catch (SQLException ex){
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException sqlEx) { } // ignore

                    rs = null;
                }

                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException sqlEx) { } // ignore

                    stmt = null;
                }
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }    
}