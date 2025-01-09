package com.tien.dao.impl;

import com.tien.dao.interfaces.IStaffDAO;
import com.tien.model.ModelStaff;
import com.tien.util.DatabaseConnection;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class StaffDAOImpl implements IStaffDAO{
    private final Connection con = DatabaseConnection.getConnection();
    private int idStaff= 0;
    @Override
    public void addStaff(ModelStaff modelStaff) {
        String sql = "INSERT INTO Staff(FullName, Gender, DateStaff, PhoneNumber, AddressStaff, UserName, PassWordStaff, Email, Position, ImageStaff)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, modelStaff.getName());
            ps.setString(2, modelStaff.getGender());
            ps.setString(3, modelStaff.getDateOfBirth());
            ps.setString(4, modelStaff.getPhone());
            ps.setString(5, modelStaff.getAddress());
            ps.setString(6, modelStaff.getUsername());
            ps.setString(7, modelStaff.getPassword());
            ps.setString(8, modelStaff.getEmail());
            ps.setString(9, modelStaff.getPosition());
            if (modelStaff.getImage()==null){
                ps.setNull(10, Types.BLOB);
            }else
                ps.setBytes(10, modelStaff.getImage());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");      
        }catch(HeadlessException | SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Map<Integer, ModelStaff> getAllStaffsAsMap() {
        idStaff = 0;
        Map<Integer, ModelStaff> staffMap = new HashMap<>();
        String sql = "SELECT * FROM Staff";
        try (Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // Thêm vào Map với ID làm key
                staffMap.put(
                    idStaff,
                    new ModelStaff(
                        rs.getInt("StaffID"),
                        rs.getString("FullName"),
                        rs.getString("Gender"),
                        rs.getString("DateStaff"),
                        rs.getString("PhoneNumber"),
                        rs.getString("AddressStaff"),
                        rs.getString("UserName"),
                        rs.getString("PasswordStaff"),
                        rs.getString("Email"),
                        rs.getString("Position"),
                        rs.getBytes("ImageStaff")
                    )
                );
                idStaff++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffMap;
    }

    @Override
    public void updateStaff(ModelStaff modelStaff) {
        String sql = "UPDATE Staff SET FullName=?, Gender=?, DateStaff=?, PhoneNumber=?, AddressStaff=?, UserName=?, PassWordStaff=?, Email=?, Position=?, ImageStaff=? WHERE StaffID = "+modelStaff.getId();
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, modelStaff.getName());
            ps.setString(2, modelStaff.getGender());
            ps.setString(3, modelStaff.getDateOfBirth());
            ps.setString(4, modelStaff.getPhone());
            ps.setString(5, modelStaff.getAddress());
            ps.setString(6, modelStaff.getUsername());
            ps.setString(7, modelStaff.getPassword());
            ps.setString(8, modelStaff.getEmail());
            ps.setString(9, modelStaff.getPosition());
            ps.setBytes(10, modelStaff.getImage());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        }catch(HeadlessException | SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Thêm thất bại !!!");
        }
    }

    @Override
    public void deleteStaff(int StaffID) {
        String sqlDeleteChiTietHoaDon = "DELETE FROM ChiTietHoaDon WHERE MaHD IN " +
                    "(SELECT MaHD FROM HoaDon WHERE StaffID = ?)";
        try (PreparedStatement stmt1 = con.prepareStatement(sqlDeleteChiTietHoaDon)) {
            stmt1.setInt(1, StaffID);
            stmt1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Xóa thất bại !!!");
            return;
        }

        // 2. Xóa hóa đơn (HoaDon) liên quan đến StaffID
        String sqlDeleteHoaDon = "DELETE FROM HoaDon WHERE StaffID = ?";
        try (PreparedStatement stmt2 = con.prepareStatement(sqlDeleteHoaDon)) {
            stmt2.setInt(1, StaffID);
            stmt2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Xóa thất bại !!!");
            return;
        }

        // 3. Xóa nhân viên (Staff)
        String sqlDeleteStaff = "DELETE FROM Staff WHERE StaffID = ?";
        try (PreparedStatement stmt3 = con.prepareStatement(sqlDeleteStaff)) {
            stmt3.setInt(1, StaffID);
            stmt3.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Xóa thất bại !!!");
        }
    }

    @Override
    public Map<Integer, ModelStaff> searchStaff(String staffName) {
        idStaff = 0;
        Map<Integer, ModelStaff> staffMap = new HashMap<>();
        String sql = "SELECT * FROM Staff where (FullName like N'%"+staffName+"%') or (FullName like N'"+staffName+"%') or (FullName like N'%"+staffName+"')";
        try (Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // Thêm vào Map với ID làm key
                staffMap.put(
                    idStaff,
                    new ModelStaff(
                        rs.getInt("StaffID"),
                        rs.getString("FullName"),
                        rs.getString("Gender"),
                        rs.getString("DateStaff"),
                        rs.getString("PhoneNumber"),
                        rs.getString("AddressStaff"),
                        rs.getString("UserName"),
                        rs.getString("PasswordStaff"),
                        rs.getString("Email"),
                        rs.getString("Position"),
                        rs.getBytes("ImageStaff")
                    )
                );
                idStaff++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffMap;
    }
    
}
