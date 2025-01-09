package com.tien.controller;

import com.tien.service.interfaces.IStaffService;

public class StaffController {
    private final IStaffService productService;

    public StaffController(IStaffService productService) {
        this.productService = productService;
    }

    // Thêm sản phẩm mới
    public void addProduct(String name, double price, String description) {
        Product product = new Product(0, name, price, description);
        productService.addProduct(product);
        System.out.println("Sản phẩm đã được thêm thành công!");
    }

    // Lấy danh sách tất cả sản phẩm
    public void displayAllProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm nào.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    // Tìm sản phẩm theo ID
    public void findProductById(int id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm với ID: " + id);
        } else {
            System.out.println("Thông tin sản phẩm: " + product);
        }
    }

    // Cập nhật sản phẩm
    public void updateProduct(int id, String name, double price, String description) {
        Product product = new Product(id, name, price, description);
        productService.updateProduct(product);
        System.out.println("Sản phẩm đã được cập nhật thành công!");
    }

    // Xóa sản phẩm
    public void deleteProduct(int id) {
        productService.deleteProduct(id);
        System.out.println("Sản phẩm đã được xóa thành công!");
    }
}
