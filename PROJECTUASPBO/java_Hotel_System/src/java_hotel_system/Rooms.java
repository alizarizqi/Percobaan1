package java_hotel_system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Rooms {
    
    
        My_Connection my_connection = new My_Connection();
    
    //membuat fungsi di tampilan semua type kamar di jtable
    public void fillRooms_TYPE_JTable(JTable table)
    {
        PreparedStatement ps;
        ResultSet rs;
        String selectQueryv = "SELECT * FROM `type`";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQueryv);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
               row = new Object[3];
               row[0] = rs.getInt(1);
               row[1] = rs.getString(2);
               row[2] = rs.getString(3);
               
               tableModel.addRow(row);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //membuat fungsi di tampilan semua type kamar di jtable
    public void fillRoomsJTable(JTable table)
    {
        PreparedStatement ps;
        ResultSet rs;
        String selectQueryv = "SELECT * FROM `rooms`";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQueryv);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
               row = new Object[4];
               row[0] = rs.getInt(1);
               row[1] = rs.getInt(2);
               row[2] = rs.getString(3);
               row[3] = rs.getString(4);
               
               tableModel.addRow(row);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    // memubuat fungsi untuk mengisi kotak kombo dengan id type kamar
     public void fillRooms_TYPE_JCombobox(JComboBox combobox)
    {
        PreparedStatement ps;
        ResultSet rs;
        String selectQueryv = "SELECT * FROM `type`";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQueryv);
            
            rs = ps.executeQuery();
            
            while(rs.next())
            {
               combobox.addItem(rs.getInt(1));
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        //membuat fungsi penambahan room baru
      public boolean addRoom(int number, int type, String phone){
        PreparedStatement st;
        ResultSet rs;
        String addQuery= "INSERT INTO `rooms`(`r_number`, `type`, `phone`, `reserved`) VALUES (?,?,?,?)";
        
        try {
            
            st = my_connection.createConnection().prepareStatement(addQuery);
            
            st.setInt(1, number);
            st.setInt(2, type);
            st.setString(3, phone);
            //ketika kita menambah room baru
            //kolom yang dipesen akan di atur 
            //kolom yang dipesan dipesan aka di atur atau tidak
            st.setString(4, "No");
            
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    } 
      
     //membuat fungsi edit di selected room
    public boolean editRoom(int number, int type, String phone, String isReserved)
    {
       PreparedStatement st;
        String editQuery= "UPDATE `rooms` SET `type`=?,`phone`=?,`reserved`=? WHERE `r_number`=?";
        
        try {
            
            st = my_connection.createConnection().prepareStatement(editQuery);
            
            st.setInt(1, type);
            st.setString(2, phone);
            st.setString(3, isReserved);
            st.setInt(4, number);
            
            return(st.executeUpdate() > 0);
              
            } 
            catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }  
    
     //membuat sebuah fungsi  untuk meRemove selected Rooms
     public boolean removeRoom(int roomNumber)
     {
         PreparedStatement st;
        ResultSet rs;
        String deleteQuery= "DELETE FROM `rooms` WHERE `r_number`=?";
        
        try {
            
            st = my_connection.createConnection().prepareStatement(deleteQuery);
            
            st.setInt(1, roomNumber);
            
            return(st.executeUpdate() > 0);
              
            } 
            catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     }
      
      
      
}
