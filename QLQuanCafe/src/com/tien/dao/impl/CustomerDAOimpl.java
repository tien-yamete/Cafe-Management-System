package com.tien.dao.impl;

import com.tien.dao.interfaces.ICustomerDAO;
import com.tien.model.ModelCustomer;
import com.tien.util.DatabaseConnection;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CustomerDAOimpl implements ICustomerDAO{

    private final Connection con = DatabaseConnection.getConnection();
    private int idCustomer= 0;
    
    @Override
    public void addCustomer(ModelCustomer modelCustomer) {
        String sql = "INSERT INTO Customer(FullName, Gender, DateCustomer, PhoneNumber, AddressCustomer, Email)"
                + "VALUES(?,?,?,?,?,?)";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, modelCustomer.getName());
            ps.setString(2, modelCustomer.getGender());
            ps.setString(3, modelCustomer.getDateOfBirth());
            ps.setString(4, modelCustomer.getPhone());
            ps.setString(5, modelCustomer.getAddress());
            ps.setString(6, modelCustomer.getEmail());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");      
        }catch(HeadlessException | SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Map<Integer, ModelCustomer> getAllCustomersAsMap() {
        idCustomer = 0;
        Map<Integer, ModelCustomer> customerMap = new HashMap<>();
        String sql = "SELECT * FROM Staff";
        try (Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // Thêm vào Map với ID làm key
                customerMap.put(
                    idCustomer,
                    new ModelCustomer(
                        rs.getInt("CustomerID"),
                        rs.getString("FullName"),
                        rs.getString("Gender"),
                        rs.getString("DateCustomer"),
                        rs.getString("PhoneNumber"),
                        rs.getString("AddressCustomer"),
                        rs.getString("Email")
                    )
                );
                idCustomer++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerMap;
    }

    @Override
    public void updateCustomer(ModelCustomer modelCustomer) {
        String sql = "UPDATE Customer SET FullName=?, Gender=?, DateCustomer=?, PhoneNumber=?, AddressCustomer=?, Email=? WHERE CustomerID = "+modelCustomer.getId();
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, modelCustomer.getName());
            ps.setString(2, modelCustomer.getGender());
            ps.setString(3, modelCustomer.getDateOfBirth());
            ps.setString(4, modelCustomer.getPhone());
            ps.setString(5, modelCustomer.getAddress());
            ps.setString(6, modelCustomer.getEmail());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        }catch(HeadlessException | SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Thêm thất bại !!!");
        }
    }

    @Override
    public void deleteCustomer(String customerID) {
        // 1. Xóa ChiTietHoaDon liên quan thông qua MaHD từ HoaDon
        String sqlDeleteChiTietHoaDon = "DELETE FROM ChiTietHoaDon WHERE MaHD IN (" +
            "SELECT MaHD FROM HoaDon WHERE CustomerID = ?)";
        try (PreparedStatement stmt0 = con.prepareStatement(sqlDeleteChiTietHoaDon)) {
            stmt0.setString(1, customerID);
            stmt0.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(StaffDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Xóa thất bại !!!");
            return;
        }

        // 2. Xóa các hóa đơn (HoaDon) liên quan đến Customer
        String sqlDeleteHoaDon = "DELETE FROM HoaDon WHERE CustomerID = ?";
        try (PreparedStatement stmt1 = con.prepareStatement(sqlDeleteHoaDon)) {
            stmt1.setString(1, customerID);
            stmt1.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(StaffDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Xóa thất bại !!!");
            return;
        }
        // 3. Xóa khách hàng từ bảng Customer
        String sqlDeleteCustomer = "DELETE FROM Customer WHERE CustomerID = ?";
        try (PreparedStatement stmt2 = con.prepareStatement(sqlDeleteCustomer)) {
            stmt2.setString(1, customerID);
            stmt2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        }catch (SQLException ex) {
            Logger.getLogger(StaffDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Xóa thất bại !!!");
        }
    }    
}
