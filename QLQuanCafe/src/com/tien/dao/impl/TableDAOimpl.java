package com.tien.dao.impl;

import com.tien.dao.interfaces.ITableDAO;
import com.tien.model.ModelTable;
import com.tien.util.DatabaseConnection;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TableDAOimpl implements ITableDAO{
    private final Connection con = DatabaseConnection.getConnection();
    private int idTable= 0;
    @Override
    public void addTable(ModelTable modelTable) {
        String sql = "INSERT INTO Ban(MaBan, TenBan, TrangThai)"
                + "VALUES(?,?,?)";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, modelTable.getTableID());
            ps.setString(2, modelTable.getTableName());
            ps.setString(3, modelTable.getStatus());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");      
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }
    }

    @Override
    public Map<Integer, ModelTable> getAllTablesAsMap() {
        idTable = 0;
        Map<Integer, ModelTable> tableMap = new HashMap<>();
        String sql = "SELECT * FROM Ban";
        try (Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // Thêm vào Map với ID làm key
                tableMap.put(
                    idTable,
                    new ModelTable(
                        rs.getString("MaBan"),
                        rs.getString("TenBan"),
                        rs.getString("TrangThai")
                    )
                );
                idTable++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableMap;
    }

    @Override
    public void updateTable(ModelTable modelTable) {
        String sql = "UPDATE Ban SET MaBan=?, TenBan=?, TrangThai=? WHERE MaBan = '"+modelTable.getTableID()+"'";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, modelTable.getTableID());
            ps.setString(2, modelTable.getTableName());
            ps.setString(3, modelTable.getStatus());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Thêm thất bại !!!");
        }
    }

    @Override
    public void deleteTable(String tableID) {
        // 1. Xóa ChiTietHoaDon liên quan thông qua MaHD từ HoaDon
        String sqlDeleteChiTietHoaDon = "DELETE FROM ChiTietHoaDon WHERE MaHD IN (" +
            "SELECT MaHD FROM HoaDon WHERE MaBan = ?)";
        try (PreparedStatement stmt0 = con.prepareStatement(sqlDeleteChiTietHoaDon)) {
            stmt0.setString(1, tableID);
            stmt0.executeUpdate();
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
            return;
        }

        // 2. Xóa các hóa đơn (HoaDon) liên quan đến bàn
        String sqlDeleteHoaDon = "DELETE FROM HoaDon WHERE MaBan = ?";
        try (PreparedStatement stmt1 = con.prepareStatement(sqlDeleteHoaDon)) {
            stmt1.setString(1, tableID);
            stmt1.executeUpdate();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
            return;
        }

        // 3. Xóa bàn từ bảng Ban
        String sqlDeleteBan = "DELETE FROM Ban WHERE MaBan = ?";
        try (PreparedStatement stmt2 = con.prepareStatement(sqlDeleteBan)) {
            stmt2.setString(1, tableID);
            stmt2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
        }
    }
    
}
