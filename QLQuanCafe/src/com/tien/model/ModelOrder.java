package com.tien.model;

public class ModelOrder {
    private int orderId;
    private int employeeID;
    private ModelTable modelTable; 
    private int customerID;
    private String createdDate;
    private double total;
    private String status;

    public ModelOrder() {
    }

    public ModelOrder(int orderId, int employeeID, ModelTable modelTable, int customerID, String createdDate, double total, String status) {
        this.orderId = orderId;
        this.employeeID = employeeID;
        this.modelTable = modelTable;
        this.customerID = customerID;
        this.createdDate = createdDate;
        this.total = total;
        this.status = status;
    }

    public ModelOrder(int employeeID, ModelTable modelTable, int customerID, String createdDate, double total, String status) {
        this.employeeID = employeeID;
        this.modelTable = modelTable;
        this.customerID = customerID;
        this.createdDate = createdDate;
        this.total = total;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public ModelTable getModelTable() {
        return modelTable;
    }

    public void setModelTable(ModelTable modelTable) {
        this.modelTable = modelTable;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total=  total;
    }
    
}
