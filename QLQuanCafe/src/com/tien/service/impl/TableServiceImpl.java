package com.tien.service.impl;

import com.tien.dao.interfaces.ITableDAO;
import com.tien.model.ModelTable;
import com.tien.service.interfaces.ITableService;
import java.util.Map;

public class TableServiceImpl implements ITableService{
    private final ITableDAO iTableDAO;
    
    @Override
    public void addTable(ModelTable modelTable) {
        
    }

    @Override
    public Map<Integer, ModelTable> getAllTablesAsMap() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateTable(ModelTable modelTable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteTable(String tableID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
