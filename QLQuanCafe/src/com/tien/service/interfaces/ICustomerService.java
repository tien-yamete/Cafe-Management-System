package com.tien.service.interfaces;

import com.tien.model.ModelCustomer;
import java.util.Map;

public interface ICustomerService {
    void addCustomer(ModelCustomer modelCustomer);
    Map<Integer, ModelCustomer> getAllCustomersAsMap();
    void updateCustomer(ModelCustomer modelCustomer);
    void deleteCustomer(String customerID); 
}
