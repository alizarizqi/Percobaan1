/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_hotel_system;

import java.sql.Date;
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
public class Reservation {
    // di tabel reservasi kita dapat menambahkan dua forgein keys
    //1 untuk klien
    //alter table reservation add CONSTRAINT fk_client_id FOREIGN KEY (client_id) REFERENCES clients(id) on DELETE CASCADE
    //2 untuk Room
    //alter table reservation add CONSTRAINT fk_room_number FOREIGN KEY (room_number) REFERENCES rooms(r_number) on DELETE CASCADE
    
    //dan menambahkan foreign key yg lain diantara tabel tipe dan room 
    
   
    My_Connection my_connection = new My_Connection();
    
    public boolean addReservation(int client_id, int room_number, String dateIn, String dateOut){
        PreparedStatement st;
        ResultSet rs;
        String addQuery= "INSERT INTO `reservation`(`client_id`, `room_number`, `date_in`, `date_out`) VALUES (?,?,?,?)";
        
        try {
            
            st = my_connection.createConnection().prepareStatement(addQuery);
            
            st.setInt(1, client_id);
            st.setInt(2, client_id);
            st.setString(3, dateIn);
            st.setString(4, dateOut);
            //ketika kita menambah room baru
            //kolom yang dipesen akan di atur 
            //kolom yang dipesan dipesan aka di atur atau tidak
            
            
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    } 
    public boolean editReservation(int reservation_id, int client_id, int room_number, String dateIn, String dateOut)
    {
       PreparedStatement st;
        String editQuery= "UPDATE `reservation` SET `client_id`=?,`room_number`=?,`date_in`=?,`date_out`=? WHERE id=?";
        
        try {
            
            st = my_connection.createConnection().prepareStatement(editQuery);
            
            
            st.setInt(1, client_id);
            st.setInt(2, room_number);
            st.setString(3, dateIn);
            st.setString(4, dateOut);
            st.setInt(5, reservation_id);
            
            return(st.executeUpdate() > 0);
              
            } 
            catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }  
    public boolean removeReservation(int reservation_id)
     {
         PreparedStatement st;
        ResultSet rs;
        String deleteQuery= "DELETE FROM `reservation` WHERE id=?";
        
        try {
            
            st = my_connection.createConnection().prepareStatement(deleteQuery);
            
            st.setInt(1, reservation_id);
            
            return(st.executeUpdate() > 0);
              
            } 
            catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     }
    
    public void fillReservationJTable(JTable table)
    {
        PreparedStatement ps;
        ResultSet rs;
        String selectQueryv = "SELECT * FROM `reservation`";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQueryv);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
               row = new Object[5];
               row[0] = rs.getInt(1);
               row[1] = rs.getInt(2);
               row[2] = rs.getInt(3);
               row[3] = rs.getString(4);
               row[4] = rs.getString(5);
               
               tableModel.addRow(row);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    
}
