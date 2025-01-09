package com.tien.service.impl;

import com.tien.dao.interfaces.ICustomerDAO;
import com.tien.model.ModelCustomer;
import com.tien.service.interfaces.ICustomerService;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService{
    private final ICustomerDAO iCustomerDAO;

    public CustomerServiceImpl(ICustomerDAO iCustomerDAO) {
        this.iCustomerDAO = iCustomerDAO;
    }
      
    @Override
    public void addCustomer(ModelCustomer modelCustomer) {
        iCustomerDAO.addCustomer(modelCustomer);
    }

    @Override
    public Map<Integer, ModelCustomer> getAllCustomersAsMap() {
        return iCustomerDAO.getAllCustomersAsMap();
    }

    @Override
    public void updateCustomer(ModelCustomer modelCustomer) {
        iCustomerDAO.updateCustomer(modelCustomer);
    }

    @Override
    public void deleteCustomer(String customerID) {
        iCustomerDAO.deleteCustomer(customerID);
    }
    
}
