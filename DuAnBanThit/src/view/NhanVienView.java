/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import repositories.NhanVienRepository;
import services.NhanVienServices;
import viewmodel.ChucVuViewModel;
import viewmodel.NhanVienViewModel;
import viewmodel.TaiKhoanViewModel;

/**
 *
 * @author Toan
 */
public class NhanVienView extends javax.swing.JPanel {

    private final NhanVienServices nhanVienServ;
    private SimpleDateFormat sdf;
    /**
     * Creates new form SanPhamThit
     */
    public NhanVienView() {
        initComponents();
        nhanVienServ = new NhanVienServices();
        sdf = new SimpleDateFormat("dd-MM-yyyy");
        loadCBBTaiKhoan();
        loadCBBChucVu();
        loadTable();
        New();
    }

    public void New(){
        txtDiaChi.setText("");
        txtHoTen.setText("");
        txtMaNhanVien.setText("");
        txtMatKhau.setText("");
        txtNgaySinh.setText("");
        txtSDT.setText("");
        txtTrangThai.setText("");
        rdoNam.setSelected(true);
        lbID.setText("");
        cbbChucVu.setSelectedIndex(0);
        
    }
    public void loadCBBTaiKhoan() {
        ArrayList<TaiKhoanViewModel> list = nhanVienServ.getAllTaiKhoan();
        DefaultComboBoxModel<String> dcbm = (DefaultComboBoxModel<String>) cbbTaiKhoan.getModel();
        dcbm.removeAllElements();
        for (TaiKhoanViewModel x : list) {
            dcbm.addElement(x.getTenTK());
        }
    }

    public void loadCBBChucVu() {
        ArrayList<ChucVuViewModel> list = nhanVienServ.getAllChuVu();
        DefaultComboBoxModel<String> dcbm = (DefaultComboBoxModel<String>) cbbChucVu.getModel();
        dcbm.removeAllElements();
        for(ChucVuViewModel x : list){
            dcbm.addElement(x.getTen());
        }
    }

    public void loadTable(){
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        for(NhanVienViewModel x:nhanVienServ.getAll()){
            Object[] rowData = {
                x.getMaNhanVien(),
                x.getHoTen(),
                x.getSdt(),
                x.isGioiTinh() ? "Nam":"Nữ",
                x.getNgaySinh(),
                x.getDiaChi(),
                x.getTrangThai(),
                x.getTaiKhoan(),
                x.getChucVu()
            };
            model.addRow(rowData);
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        btnAddNhanVien = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        txtMaNhanVien = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTrangThai = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbbChucVu = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbbTaiKhoan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        bntAddTaiKhoan = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Họ & Tên nhân viên:");

        jLabel11.setText("Mã nhân viên:");

        jLabel13.setText("ID:");

        btnAddNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnAddNhanVien.setText("Thêm");
        btnAddNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNhanVienActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Text.png"))); // NOI18N
        jButton13.setText("Mới");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel1.setText("Số điện thoại:");

        jLabel2.setText("Giới tính:");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel3.setText("Địa chỉ:");

        jLabel4.setText("Trạng thái:");

        jLabel5.setText("Chức vụ:");

        cbbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChucVuActionPerformed(evt);
            }
        });

        jLabel6.setText("Tài khoản:");

        cbbTaiKhoan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTaiKhoanActionPerformed(evt);
            }
        });

        jLabel7.setText("Mật khẩu:");

        bntAddTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        bntAddTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAddTaiKhoanActionPerformed(evt);
            }
        });

        jLabel8.setText("Ngày sinh:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNgaySinh)
                    .addComponent(txtHoTen)
                    .addComponent(lbID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSDT)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rdoNam)
                        .addGap(33, 33, 33)
                        .addComponent(rdoNu))
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel5)))))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cbbTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bntAddTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(btnAddNhanVien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel3)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5)
                    .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel6)
                        .addComponent(cbbTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bntAddTaiKhoan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu)
                    .addComponent(jLabel7)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddNhanVien)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)
                            .addComponent(jButton13))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ tên", "SĐT", "Giới tính", "Ngày sinh", "Địa chỉ", "Trạng thái", "Tài khoản", "Chức vụ"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bntAddTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAddTaiKhoanActionPerformed
        String tenTK = JOptionPane.showInputDialog("Tên tài khoản");
    
        String matKhau = JOptionPane.showInputDialog("Mật khẩu");
    
        String[] obj = {
            "Nhân viên",
            "Quản lý"
        };
        int chucVu = JOptionPane.showOptionDialog(this, "Chọn chức vụ","Chọn chức vụ",JOptionPane.DEFAULT_OPTION,JOptionPane.DEFAULT_OPTION , null, obj,obj[0]);
        TaiKhoanViewModel taiKhoan = new TaiKhoanViewModel(tenTK, matKhau);       
        nhanVienServ.addTaiKhoan(taiKhoan, obj[chucVu]);
        loadCBBTheoChucVu(cbbChucVu.getSelectedItem().toString());
    }//GEN-LAST:event_bntAddTaiKhoanActionPerformed

    private void btnAddNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNhanVienActionPerformed
        // TODO add your handling code here:
        NhanVienViewModel nhanVien = new NhanVienViewModel();
        
        nhanVien.setMaNhanVien(txtMaNhanVien.getText());
        nhanVien.setHoTen(txtHoTen.getText());
        nhanVien.setSdt(txtSDT.getText());
        nhanVien.setGioiTinh(rdoNam.isSelected() ? true: false);
        try {
                    nhanVien.setNgaySinh(sdf.parse(txtNgaySinh.getText()));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Bạn cần nhập đúng định dạng date: "+sdf.toPattern());
            return;
        }
        nhanVien.setDiaChi(txtDiaChi.getText());
        nhanVien.setTrangThai(txtTrangThai.getText());
        nhanVien.setChucVu(cbbChucVu.getSelectedItem().toString());
        nhanVien.setTaiKhoan(cbbTaiKhoan.getSelectedItem().toString());
        nhanVien.setMatKhau(txtMatKhau.getText());
        
        nhanVienServ.add(nhanVien);
        loadTable();
    }//GEN-LAST:event_btnAddNhanVienActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        // TODO add your handling code here:   
        int row = tblNhanVien.getSelectedRow();
        if(row == -1){
            return;
        }
        NhanVienViewModel nhanVien = nhanVienServ.getAll().get(row);
        lbID.setText(nhanVien.getIdNhanVien());
        txtMaNhanVien.setText(nhanVien.getMaNhanVien());
        txtHoTen.setText(nhanVien.getHoTen());
        txtSDT.setText(nhanVien.getSdt());
        txtNgaySinh.setText(nhanVien.getNgaySinh().toString());
        if(nhanVien.isGioiTinh()){
            rdoNam.setSelected(true);
        }else{
            rdoNu.setSelected(true);
        }
        txtDiaChi.setText(nhanVien.getDiaChi());
        txtTrangThai.setText(nhanVien.getTrangThai());
        cbbChucVu.setSelectedItem(nhanVien.getChucVu());
        cbbTaiKhoan.setSelectedItem(nhanVien.getTaiKhoan());
        txtMatKhau.setText(nhanVien.getMatKhau());
    }//GEN-LAST:event_tblNhanVienMouseClicked

    public void loadCBBTheoChucVu(String tenChucVu){
        ArrayList<TaiKhoanViewModel> list = nhanVienServ.getAllTaiKhoanByChucVu(tenChucVu);
        DefaultComboBoxModel<String> dcbm = (DefaultComboBoxModel<String>) cbbTaiKhoan.getModel();
        dcbm.removeAllElements();
        for (TaiKhoanViewModel x : list) {
            dcbm.addElement(x.getTenTK());
        }
    }
    private void cbbChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChucVuActionPerformed
        if(cbbChucVu.getSelectedItem() != null){
            loadCBBTheoChucVu(cbbChucVu.getSelectedItem().toString());
        }
        
    }//GEN-LAST:event_cbbChucVuActionPerformed

    private void cbbTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTaiKhoanActionPerformed

    }//GEN-LAST:event_cbbTaiKhoanActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
        NhanVienViewModel nhanVien = new NhanVienViewModel();
        nhanVien.setIdNhanVien(lbID.getText());
        nhanVien.setMaNhanVien(txtMaNhanVien.getText());
        nhanVien.setHoTen(txtHoTen.getText());
        nhanVien.setSdt(txtSDT.getText());
        nhanVien.setGioiTinh(rdoNam.isSelected() ? true: false);
        try {
                    nhanVien.setNgaySinh(sdf.parse(txtNgaySinh.getText()));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Bạn cần nhập đúng định dạng date: "+sdf.toPattern());
            return;
        }
        nhanVien.setDiaChi(txtDiaChi.getText());
        nhanVien.setTrangThai(txtTrangThai.getText());
        nhanVien.setChucVu(cbbChucVu.getSelectedItem().toString());
        nhanVien.setTaiKhoan(cbbTaiKhoan.getSelectedItem().toString());
        nhanVien.setMatKhau(txtMatKhau.getText());
        int chose = JOptionPane.showConfirmDialog(this,"Bạn có muốn update chứ");
        if(chose != JOptionPane.YES_OPTION){
            return;
        }
        nhanVienServ.update(nhanVien);
        loadTable();
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row =tblNhanVien.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(this, "Chưa chọn nhân viên để xóa");
            return;
        }
        int chose = JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa");
        if(chose != JOptionPane.YES_OPTION){
            return;
        }
        NhanVienViewModel nhanVien = new NhanVienViewModel();
        nhanVien.setIdNhanVien(lbID.getText());
        if(tblNhanVien.getValueAt(row, 7) != null){
        nhanVien.setTaiKhoan(tblNhanVien.getValueAt(row, 7).toString());
        }
        nhanVienServ.delete(nhanVien);
        loadTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        New();
    }//GEN-LAST:event_jButton13ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAddTaiKhoan;
    private javax.swing.JButton btnAddNhanVien;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JComboBox<String> cbbTaiKhoan;
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbID;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
