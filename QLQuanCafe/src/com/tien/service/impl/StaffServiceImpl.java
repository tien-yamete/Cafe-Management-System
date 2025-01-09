package com.tien.service.impl;

import com.tien.dao.interfaces.IStaffDAO;
import com.tien.model.ModelStaff;
import com.tien.service.interfaces.IStaffService;
import java.util.Map;

public class StaffServiceImpl implements IStaffService{
    private final IStaffDAO iStaffDAO;

    public StaffServiceImpl(IStaffDAO iStaffDAO) {
        this.iStaffDAO = iStaffDAO;
    }

    @Override
    public void addStaff(ModelStaff modelStaff) {
        iStaffDAO.addStaff(modelStaff);
    }

    @Override
    public Map<Integer, ModelStaff> getAllStaffs() {
        return iStaffDAO.getAllStaffsAsMap();
    }

    @Override
    public void updateStaff(ModelStaff modelStaff) {
        iStaffDAO.updateStaff(modelStaff);
    }

    @Override
    public void deleteStaff(int id) {
        iStaffDAO.deleteStaff(id);
    }

    @Override
    public Map<Integer, ModelStaff> searchStaff(String name) {
        return iStaffDAO.searchStaff(name);
    }
    
}
