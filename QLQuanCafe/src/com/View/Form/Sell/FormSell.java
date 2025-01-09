package Com.View.Form.Sell;

import com.tien.model.ModelImageWrapper;
import com.tien.model.ModelCustomer;
import com.tien.model.ModelOrder;
import com.tien.model.ModelOrderDetail;
import com.tien.model.ModelProductDetail;
import com.tien.model.ModelTable;
import Com.Swing.Scrollbar.ScrollBarCustom;
import Com.View.Login.Login;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FormSell extends javax.swing.JPanel {
    DefaultTableModel model;
    DefaultTableModel modelHD;
    boolean kt;
    boolean daVaoBan = false;
    String maBanSelected =null;
    private Frame Dashboard;
    ModelProductDetail modelProductDetail;
    ModelTable modelTable;
    ModelTable banSD = null;
    ModelOrder modelOrderUse;
    ModelOrderDetail modelOrderDetailUse;
    String pricePattern = "^[0-9]*$";
    private double tongTien;
    
    public FormSell() {
        initComponents();
        setOpaque(false);
        
        searchText2.setHint("Search");
        tableSP.addTableStyle(jScrollPane1);
        tableHD.addTableStyle(jScrollPane2);
        jScrollPane3.setVerticalScrollBar(new ScrollBarCustom());
        //jScrollPane3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa ô nào
            }
        };
        
        model.setColumnIdentifiers(new Object[]{
            "Ảnh", "Mã Chi Tiết SP","Mã Sản Phẩm","Tên Sản Phẩm","Loại Sản Phẩm", "Ngày Nhập","Số Lượng","Giá Bán","Trạng Thái"
        });
        tableSP.setModel(model); // Gán lại mô hình dữ liệu
        
        // Ngăn thay đổi vị trí và kích thước cột
        tableSP.getTableHeader().setReorderingAllowed(false); // Không cho phép kéo cột
        tableSP.getTableHeader().setResizingAllowed(false);   // Không cho phép thay đổi kích thước cột

        ListSelectionModel selectionModel = tableSP.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        initDataTableSP();
        initListenerTable();
        
        //Dữ liệu cho bảng hóa đơn
        modelHD = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa ô nào
            }
        };
        
        modelHD.setColumnIdentifiers(new Object[]{
            "Mã CTSP","Tên Sản Phẩm","Loại Sản Phẩm","Số Lượng", "Đơn Giá","Thành Tiền"
        });
        tableHD.setModel(modelHD); // Gán lại mô hình dữ liệu
        
        // Ngăn thay đổi vị trí và kích thước cột
        tableHD.getTableHeader().setReorderingAllowed(false); // Không cho phép kéo cột
        tableHD.getTableHeader().setResizingAllowed(false);   // Không cho phép thay đổi kích thước cột

        SpinnerNumberModel modelS = new SpinnerNumberModel(1, 1, 100, 1); 
        soLuongSpinner.setModel(modelS);
        
        ListSelectionModel selectionModelHD = tableHD.getSelectionModel();
        selectionModelHD.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        initListenerTableHD();
             
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InsertTablePopupMenu = new javax.swing.JPopupMenu();
        themBanMenuItem = new javax.swing.JMenuItem();
        EditTablePopupMenu = new javax.swing.JPopupMenu();
        taoDonMenuItem = new javax.swing.JMenuItem();
        vaoBanMenuItem = new javax.swing.JMenuItem();
        xoaBanMenuItem = new javax.swing.JMenuItem();
        banMenu = new javax.swing.JMenu();
        donBanMenuItem = new javax.swing.JMenuItem();
        hoanThanhMenuItem = new javax.swing.JMenuItem();
        EditOrderPopupMenu = new javax.swing.JPopupMenu();
        editMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        roundPanel2 = new Com.View.Swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSP = new Com.View.Swing.Table();
        roundPanel4 = new Com.View.Swing.RoundPanel();
        jLabel3 = new javax.swing.JLabel();
        imageAvatar1 = new Com.View.Swing.ImageAvatar();
        jLabel4 = new javax.swing.JLabel();
        maCTSPText = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tenText = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        loaiSPText = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        giaBanText = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        soLuongSpinner = new javax.swing.JSpinner();
        resetButton = new javax.swing.JButton();
        thenMonButton = new javax.swing.JButton();
        roundPanel5 = new Com.View.Swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableHD = new Com.View.Swing.Table();
        roundPanel6 = new Com.View.Swing.RoundPanel();
        searchText2 = new Com.View.Swing.SearchText();
        roundPanel7 = new Com.View.Swing.RoundPanel();
        jLabel14 = new javax.swing.JLabel();
        maHoaDonText = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        maKHText = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tongTienText = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tienKhachTraText = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        ngayTaoText = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        tenNhanVienText = new javax.swing.JLabel();
        thanhToanButton = new javax.swing.JButton();
        huyDonButton = new javax.swing.JButton();
        tienTraLaiText = new javax.swing.JLabel();
        roundPanel8 = new Com.View.Swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        roundPanel1 = new Com.View.Swing.RoundPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        maBanSDText = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tenBanSDText = new javax.swing.JLabel();
        roiBanButton = new javax.swing.JButton();

        themBanMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Com/Icon/add.png"))); // NOI18N
        themBanMenuItem.setText("Thêm Bàn");
        themBanMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themBanMenuItemActionPerformed(evt);
            }
        });
        InsertTablePopupMenu.add(themBanMenuItem);

        taoDonMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Com/Icon/order.png"))); // NOI18N
        taoDonMenuItem.setText("Tạo Đơn");
        taoDonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taoDonMenuItemActionPerformed(evt);
            }
        });
        EditTablePopupMenu.add(taoDonMenuItem);

        vaoBanMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Com/Icon/join.png"))); // NOI18N
        vaoBanMenuItem.setText("Vào Bàn");
        vaoBanMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaoBanMenuItemActionPerformed(evt);
            }
        });
        EditTablePopupMenu.add(vaoBanMenuItem);

        xoaBanMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Com/Icon/delete.png"))); // NOI18N
        xoaBanMenuItem.setText("Xóa Bàn");
        xoaBanMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaBanMenuItemActionPerformed(evt);
            }
        });
        EditTablePopupMenu.add(xoaBanMenuItem);

        banMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Com/Icon/table.png"))); // NOI18N
        banMenu.setText("Bàn");

        donBanMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Com/Icon/sync.png"))); // NOI18N
        donBanMenuItem.setText("Dọn Bàn");
        donBanMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donBanMenuItemActionPerformed(evt);
            }
        });
        banMenu.add(donBanMenuItem);

        hoanThanhMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Com/Icon/check-mark.png"))); // NOI18N
        hoanThanhMenuItem.setText("Hoàn Thành Dọn Bàn");
        hoanThanhMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoanThanhMenuItemActionPerformed(evt);
            }
        });
        banMenu.add(hoanThanhMenuItem);

        EditTablePopupMenu.add(banMenu);

        editMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Com/Icon/sync.png"))); // NOI18N
        editMenuItem.setText("Sửa");
        editMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuItemActionPerformed(evt);
            }
        });
        EditOrderPopupMenu.add(editMenuItem);

        deleteMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Com/Icon/delete.png"))); // NOI18N
        deleteMenuItem.setText("Xóa");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        EditOrderPopupMenu.add(deleteMenuItem);

        roundPanel2.setBackground(new java.awt.Color(60, 60, 60));

        tableSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableSP);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel4.setBackground(new java.awt.Color(60, 60, 60));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sản Phẩm");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Mã CTSP :");

        maCTSPText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        maCTSPText.setForeground(new java.awt.Color(255, 255, 255));
        maCTSPText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        maCTSPText.setText("NULL");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Tên Sản Phẩm :");

        tenText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tenText.setForeground(new java.awt.Color(255, 255, 255));
        tenText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tenText.setText("NULL");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Loại Sản Phẩm :");

        loaiSPText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loaiSPText.setForeground(new java.awt.Color(255, 255, 255));
        loaiSPText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        loaiSPText.setText("NULL");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Giá Bán :");

        giaBanText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        giaBanText.setForeground(new java.awt.Color(255, 255, 255));
        giaBanText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        giaBanText.setText("NULL");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Số Lượng :");

        soLuongSpinner.setBorder(null);

        resetButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        thenMonButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        thenMonButton.setText("Thêm");
        thenMonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thenMonButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maCTSPText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tenText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loaiSPText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(giaBanText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(roundPanel4Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(resetButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(soLuongSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                                .addComponent(thenMonButton)
                                .addGap(37, 37, 37)))))
                .addGap(37, 37, 37))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(maCTSPText))
                .addGap(20, 20, 20)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tenText))
                .addGap(20, 20, 20)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(loaiSPText))
                .addGap(20, 20, 20)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(giaBanText))
                .addGap(20, 20, 20)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(soLuongSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetButton)
                    .addComponent(thenMonButton))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        roundPanel5.setBackground(new java.awt.Color(60, 60, 60));

        tableHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableHD);

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel6.setBackground(new java.awt.Color(60, 60, 60));

        searchText2.setBackground(new java.awt.Color(204, 204, 204));
        searchText2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchText2.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Com/Icon/search.png"))); // NOI18N
        searchText2.setSelectionColor(new java.awt.Color(0, 0, 51));
        searchText2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchText2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout roundPanel6Layout = new javax.swing.GroupLayout(roundPanel6);
        roundPanel6.setLayout(roundPanel6Layout);
        roundPanel6Layout.setHorizontalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchText2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel6Layout.setVerticalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchText2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel7.setBackground(new java.awt.Color(60, 60, 60));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Mã Hóa Đơn :");

        maHoaDonText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        maHoaDonText.setForeground(new java.awt.Color(255, 255, 255));
        maHoaDonText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        maHoaDonText.setText("NULL");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Khách Hàng :");

        maKHText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        maKHText.setForeground(new java.awt.Color(255, 255, 255));
        maKHText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        maKHText.setText("NULL");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Tổng Tiền :");

        tongTienText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tongTienText.setForeground(new java.awt.Color(255, 255, 255));
        tongTienText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tongTienText.setText("NULL");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Tiền Khách Trả :");

        tienKhachTraText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tienKhachTraTextKeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Tiền Trả Lại :");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Ngày Tạo :");

        ngayTaoText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ngayTaoText.setForeground(new java.awt.Color(255, 255, 255));
        ngayTaoText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ngayTaoText.setText("NULL");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Nhân Viên :");

        tenNhanVienText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tenNhanVienText.setForeground(new java.awt.Color(255, 255, 255));
        tenNhanVienText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tenNhanVienText.setText("NULL");

        thanhToanButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        thanhToanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Com/Icon/bill.png"))); // NOI18N
        thanhToanButton.setText("Thanh Toán");
        thanhToanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thanhToanButtonActionPerformed(evt);
            }
        });

        huyDonButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        huyDonButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Com/Icon/delete.png"))); // NOI18N
        huyDonButton.setText("Hủy Bàn");
        huyDonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyDonButtonActionPerformed(evt);
            }
        });

        tienTraLaiText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tienTraLaiText.setForeground(new java.awt.Color(255, 255, 255));
        tienTraLaiText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout roundPanel7Layout = new javax.swing.GroupLayout(roundPanel7);
        roundPanel7.setLayout(roundPanel7Layout);
        roundPanel7Layout.setHorizontalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel7Layout.createSequentialGroup()
                        .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel7Layout.createSequentialGroup()
                                .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(roundPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(maHoaDonText, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(roundPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tongTienText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maKHText, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundPanel7Layout.createSequentialGroup()
                                .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tienTraLaiText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tienKhachTraText, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(15, 15, 15))
                    .addGroup(roundPanel7Layout.createSequentialGroup()
                        .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(roundPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tenNhanVienText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ngayTaoText, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(thanhToanButton)
                            .addComponent(huyDonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        roundPanel7Layout.setVerticalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(maHoaDonText)
                    .addComponent(jLabel16)
                    .addComponent(maKHText))
                .addGap(20, 20, 20)
                .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(tongTienText))
                .addGap(20, 20, 20)
                .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(tienKhachTraText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(tienTraLaiText))
                .addGap(22, 22, 22)
                .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(ngayTaoText)
                    .addComponent(thanhToanButton))
                .addGap(20, 20, 20)
                .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(tenNhanVienText)
                    .addComponent(huyDonButton))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        roundPanel8.setBackground(new java.awt.Color(60, 60, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thông Tin Hóa Đơn");

        javax.swing.GroupLayout roundPanel8Layout = new javax.swing.GroupLayout(roundPanel8);
        roundPanel8.setLayout(roundPanel8Layout);
        roundPanel8Layout.setHorizontalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel8Layout.setVerticalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bàn");

        jScrollPane3.setBackground(new java.awt.Color(60, 60, 60));
        jScrollPane3.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(60, 60, 60));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel1);

        roundPanel1.setBackground(new java.awt.Color(60, 60, 60));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Bàn Đang Sử Dụng");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Mã Bàn :");

        maBanSDText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        maBanSDText.setForeground(new java.awt.Color(255, 255, 255));
        maBanSDText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        maBanSDText.setText("Chưa Sử Dụng");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Tên Bàn :");

        tenBanSDText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tenBanSDText.setForeground(new java.awt.Color(255, 255, 255));
        tenBanSDText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tenBanSDText.setText("Chưa Sử Dụng");

        roiBanButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        roiBanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Com/Icon/join.png"))); // NOI18N
        roiBanButton.setText("Rời Bàn");
        roiBanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roiBanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(maBanSDText))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tenBanSDText)))
                .addGap(24, 24, 24))
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(roiBanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(maBanSDText))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tenBanSDText))
                .addGap(18, 18, 18)
                .addComponent(roiBanButton)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchText2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchText2KeyReleased

    }//GEN-LAST:event_searchText2KeyReleased

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        if(SwingUtilities.isRightMouseButton(evt)){
            InsertTablePopupMenu.show(jPanel1, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jPanel1MousePressed

    private void themBanMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themBanMenuItemActionPerformed
        InputTable inputTable = new InputTable(Dashboard, true);
        inputTable.setVisible(true);
        if(inputTable.isKt()){
            updateTable();
        }
    }//GEN-LAST:event_themBanMenuItemActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        refreshTableSP();
        searchText2.setText("");
        soLuongSpinner.setValue(0);
        modelProductDetail = null;
    }//GEN-LAST:event_resetButtonActionPerformed

    private void xoaBanMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaBanMenuItemActionPerformed

    }//GEN-LAST:event_xoaBanMenuItemActionPerformed

    private void vaoBanMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaoBanMenuItemActionPerformed
 
    }//GEN-LAST:event_vaoBanMenuItemActionPerformed

    private void donBanMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donBanMenuItemActionPerformed

    }//GEN-LAST:event_donBanMenuItemActionPerformed

    private void thanhToanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thanhToanButtonActionPerformed

    }//GEN-LAST:event_thanhToanButtonActionPerformed

    private void taoDonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taoDonMenuItemActionPerformed

    }//GEN-LAST:event_taoDonMenuItemActionPerformed

    private void hoanThanhMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoanThanhMenuItemActionPerformed

    }//GEN-LAST:event_hoanThanhMenuItemActionPerformed

    private void roiBanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roiBanButtonActionPerformed
        lamMoiKhiRoiBan();
    }//GEN-LAST:event_roiBanButtonActionPerformed

    private void thenMonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thenMonButtonActionPerformed

    }//GEN-LAST:event_thenMonButtonActionPerformed

    private void editMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuItemActionPerformed

    }//GEN-LAST:event_editMenuItemActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed

    }//GEN-LAST:event_deleteMenuItemActionPerformed

    private void tienKhachTraTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tienKhachTraTextKeyReleased
        if(daVaoBan){
            if(tienKhachTraText.getText().matches(pricePattern)&& !tienKhachTraText.getText().equals("") && (Integer.parseInt(tienKhachTraText.getText())>=tongTien)){
                tienTraLaiText.setText(String.valueOf(Integer.parseInt(tienKhachTraText.getText())-tongTien));
            }
            else{
                tienTraLaiText.setText("");
            }
        }
    }//GEN-LAST:event_tienKhachTraTextKeyReleased

    private void huyDonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyDonButtonActionPerformed

    }//GEN-LAST:event_huyDonButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu EditOrderPopupMenu;
    private javax.swing.JPopupMenu EditTablePopupMenu;
    private javax.swing.JPopupMenu InsertTablePopupMenu;
    private javax.swing.JMenu banMenu;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenuItem donBanMenuItem;
    private javax.swing.JMenuItem editMenuItem;
    private javax.swing.JLabel giaBanText;
    private javax.swing.JMenuItem hoanThanhMenuItem;
    private javax.swing.JButton huyDonButton;
    private Com.View.Swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel loaiSPText;
    private javax.swing.JLabel maBanSDText;
    private javax.swing.JLabel maCTSPText;
    private javax.swing.JLabel maHoaDonText;
    private javax.swing.JLabel maKHText;
    private javax.swing.JLabel ngayTaoText;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton roiBanButton;
    private Com.View.Swing.RoundPanel roundPanel1;
    private Com.View.Swing.RoundPanel roundPanel2;
    private Com.View.Swing.RoundPanel roundPanel4;
    private Com.View.Swing.RoundPanel roundPanel5;
    private Com.View.Swing.RoundPanel roundPanel6;
    private Com.View.Swing.RoundPanel roundPanel7;
    private Com.View.Swing.RoundPanel roundPanel8;
    private Com.View.Swing.SearchText searchText2;
    private javax.swing.JSpinner soLuongSpinner;
    private Com.View.Swing.Table tableHD;
    private Com.View.Swing.Table tableSP;
    private javax.swing.JMenuItem taoDonMenuItem;
    private javax.swing.JLabel tenBanSDText;
    private javax.swing.JLabel tenNhanVienText;
    private javax.swing.JLabel tenText;
    private javax.swing.JButton thanhToanButton;
    private javax.swing.JMenuItem themBanMenuItem;
    private javax.swing.JButton thenMonButton;
    private javax.swing.JTextField tienKhachTraText;
    private javax.swing.JLabel tienTraLaiText;
    private javax.swing.JLabel tongTienText;
    private javax.swing.JMenuItem vaoBanMenuItem;
    private javax.swing.JMenuItem xoaBanMenuItem;
    // End of variables declaration//GEN-END:variables
    private void refreshTableSP(){
        model = (DefaultTableModel) tableSP.getModel();
        model.setRowCount(0);
        initDataTableSP();
    }
    private void refreshTableHD(){
        modelHD = (DefaultTableModel) tableHD.getModel();
        modelHD.setRowCount(0);
        initDataTableHD();
    }
    private  void initDataTableHD() {

    }
    private  void initDataTableSP() {

    }
    
    private void initListenerTable() {
        
    }
    private void initListenerTableHD() {
    }
    private void initPanel1() {

    }
    private void updateTable(){
        jPanel1.removeAll();
        initPanel1();
    }

    private void setTongTien() {

    }

    private void lamMoiKhiRoiBan() {
        maBanSDText.setText("Chưa Sử Dụng");
        tenBanSDText.setText("Chưa Sử Dụng");
        modelHD = (DefaultTableModel) tableHD.getModel();
        modelHD.setRowCount(0);
        maHoaDonText.setText("NULL");
        maKHText.setText("NULL");
        tongTienText.setText("NULL");
        tienKhachTraText.setText("");
        tienTraLaiText.setText("");
        ngayTaoText.setText("NULL");
        tenNhanVienText.setText("NULL");
        daVaoBan= false;
    }
}
