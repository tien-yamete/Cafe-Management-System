package com.tien.dao.interfaces;

import com.tien.model.ModelCustomer;
import java.util.Map;

public interface ICustomerDAO {
    void addCustomer(ModelCustomer modelCustomer);
    Map<Integer, ModelCustomer> getAllCustomersAsMap();
    void updateCustomer(ModelCustomer modelCustomer);
    void deleteCustomer(String customerID);
}
