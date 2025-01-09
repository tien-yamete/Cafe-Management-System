package com.tien.dao.interfaces;

import com.tien.model.ModelStaff;
import java.util.Map;

public interface IStaffDAO {
    void addStaff(ModelStaff modelStaff);
    Map<Integer, ModelStaff> getAllStaffsAsMap();
    void updateStaff(ModelStaff modelStaff);
    void deleteStaff(int StaffID);
    Map<Integer, ModelStaff> searchStaff(String staffName);
}
