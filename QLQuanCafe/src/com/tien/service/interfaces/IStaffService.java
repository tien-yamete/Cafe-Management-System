package com.tien.service.interfaces;

import com.tien.model.ModelStaff;
import java.util.Map;

public interface IStaffService {
    void addStaff(ModelStaff modelStaff);
    Map<Integer, ModelStaff> getAllStaffs();
    void updateStaff(ModelStaff modelStaff);
    void deleteStaff(int id);
    Map<Integer, ModelStaff> searchStaff(String name);   
}
