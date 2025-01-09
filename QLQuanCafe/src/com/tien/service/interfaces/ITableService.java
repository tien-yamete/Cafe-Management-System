package com.tien.service.interfaces;

import com.tien.model.ModelTable;
import java.util.Map;

public interface ITableService {
    void addTable(ModelTable modelTable);
    Map<Integer, ModelTable> getAllTablesAsMap();
    void updateTable(ModelTable modelTable);
    void deleteTable(String tableID);
}
