package java_hotel_system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wahyu devi
 */
public class Client { //kelas client
    
    My_Connection my_connection = new My_Connection();
    
    //membuat sebuah fungsi untuk add seorang client
    public boolean addClient(String fname, String lname, String phone, String email){
        PreparedStatement st;
        ResultSet rs;
        String addQuery= "INSERT INTO `clients`(`first_nama`, `last_name`, `phone`, `email`) VALUES (?,?,?,?)";
        
        try {
            
            st = my_connection.createConnection().prepareStatement(addQuery);
            
            st.setString(1, fname);
            st.setString(2, lname);
            st.setString(3, phone);
            st.setString(4, email);
            
            return(st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    } 
    
    //membuat fungsi edit di selected client
    public boolean editClient(int id,String fname, String lname, String phone, String email)
    {
       PreparedStatement st;
        String editQuery= "UPDATE `clients` SET `first_nama`=?,`last_name`=?,`phone`=?,`email`=? WHERE `id`=?";
        
        try {
            
            st = my_connection.createConnection().prepareStatement(editQuery);
            
            st.setString(1, fname);
            st.setString(2, lname);
            st.setString(3, phone);
            st.setString(4, email);
            st.setInt(5, id);
            
            return(st.executeUpdate() > 0);
              
            } 
            catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    //membuat sebuah fungsi  untuk meRemove selected client
     public boolean removeClient(int id)
     {
         PreparedStatement st;
        ResultSet rs;
        String deleteQuery= "DELETE FROM `clients` WHERE `id`=?";
        
        try {
            
            st = my_connection.createConnection().prepareStatement(deleteQuery);
            
            st.setInt(1, id);
            
            return(st.executeUpdate() > 0);
              
            } 
            catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     }
    
    // membuat sebuah fungsi untuk mengisi tabel dengan semua client di database
    public void fillClientJTable(JTable table)
    {
        PreparedStatement ps;
        ResultSet rs;
        String selectQueryv = "SELECT * FROM `clients`";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQueryv);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
               row = new Object[5];
               row[0] = rs.getInt(1);
               row[1] = rs.getString(2);
               row[2] = rs.getString(3);
               row[3] = rs.getString(4);
               row[4] = rs.getString(5);
               
               tableModel.addRow(row);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
