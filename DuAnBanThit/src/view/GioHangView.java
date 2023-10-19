/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.GioHangServices;
import viewmodel.DonViTinhViewModel;
import viewmodel.HoaDonChiTietViewModel;
import viewmodel.HoaDonViewModel;
import viewmodel.HopThitViewModel;
import viewmodel.KhachHangViewModel;
import viewmodel.LoaiThitViewModel;
import viewmodel.NhanVienViewModel;

/**
 *
 * @author Toan
 */
public class GioHangView extends javax.swing.JPanel {

    /**
     * Creates new form GioHangView
     */
    private String idNV;
    private GioHangServices gioHangServ;
    private DefaultComboBoxModel<String> dcbm;
    private DefaultTableModel dtm;
    private SimpleDateFormat sdf;
    private String idHoaDon;
    private String idThanhVien;

    public GioHangView(String idNV) {
        this.idNV = idNV;
        gioHangServ = new GioHangServices();
        sdf = new SimpleDateFormat("dd-MM-yyyy");
        initComponents();
        NhanVienViewModel nhanVienBH = gioHangServ.getByID(idNV);
        txtTenNhanVien.setText(nhanVienBH.getChucVu() + ": " + nhanVienBH.getHoTen());
        loadCBBLoaiThit();
        loadCBBDonVi();
        loadTableHopThit();
        idHoaDon = gioHangServ.taoHoaDon(idNV);
        loadTableHoaDonCT(idHoaDon);
    }
//    public GioHangView

    private void loadCBBLoaiThit() {
        dcbm = (DefaultComboBoxModel<String>) cbbLoaiThit.getModel();
        dcbm.removeAllElements();
        for (LoaiThitViewModel x : gioHangServ.getAllLoaiThit()) {
            dcbm.addElement(x.getTenBoPhan() + " " + x.getTenGiaSuc());
        }
    }

    private void loadCBBDonVi() {
        dcbm = (DefaultComboBoxModel<String>) cbbDonVi.getModel();
        dcbm.removeAllElements();
        for (DonViTinhViewModel x : gioHangServ.getAllDonViTinh()) {
            dcbm.addElement(x.getTenDonVi());
        }
    }

    private void loadTableHopThit() {
        dtm = (DefaultTableModel) tblHopThit.getModel();
        dtm.setRowCount(0);
        for (HopThitViewModel x : gioHangServ.getAllHopThit()) {
            Object[] rowData = {
                x.getMaHopThit(),
                x.getTenLoaiThit(),
                x.getKhoiLuong() + x.getTenDonVi(),
                x.getGiaGoc(),
                x.getGiaBan(),
                x.getHSD(),
                x.getTinhTrang()
            };
            dtm.addRow(rowData);
        }
    }

    private void loadTableHoaDonCT(String id) {
        dtm = (DefaultTableModel) tblHoaDonCT.getModel();
        dtm.setRowCount(0);
        loadHoaDon:
        for (HoaDonChiTietViewModel x : gioHangServ.getAllHoaDonCTByID(id)) {
            Object[] rowData = {
                x.getMaHopThit(),
                null,
                x.getGiaBan()
            };
            for (HopThitViewModel y : gioHangServ.getAllHopThit()) {
                if (y.getMaHopThit().equals(x.getMaHopThit())) {
                    if (y.getTinhTrang().equals("Hết hạn")) {
                        continue loadHoaDon;
                    }
                    rowData[1] = y.getTenLoaiThit();
                }
            }
            dtm.addRow(rowData);
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

        pan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHSD = new javax.swing.JTextField();
        txtNgaySanXuat = new javax.swing.JTextField();
        txtKhoiLuong = new javax.swing.JTextField();
        btnThemHopThit = new javax.swing.JButton();
        btnClearFormHT = new javax.swing.JButton();
        cbbLoaiThit = new javax.swing.JComboBox<>();
        cbbDonVi = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtMaHopThit = new javax.swing.JTextField();
        btnLoad = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtHangThanhVien = new javax.swing.JLabel();
        btnXacNhanKH = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHopThit = new javax.swing.JTable();
        btnThemVaoGio = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDonCT = new javax.swing.JTable();
        btnHoaDonMoi = new javax.swing.JButton();
        btnXoaSP = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtSoTienGiamGia = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();

        pan.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hộp thịt"));

        jLabel1.setText("Loại thịt:");

        jLabel2.setText("Khối lượng:");

        jLabel3.setText("Đơn vị:");

        jLabel4.setText("Ngày sản xuất:");

        jLabel5.setText("Hạn sử dụng:");

        btnThemHopThit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThemHopThit.setText("Check");
        btnThemHopThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHopThitActionPerformed(evt);
            }
        });

        btnClearFormHT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Text.png"))); // NOI18N
        btnClearFormHT.setText("Mới");
        btnClearFormHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormHTActionPerformed(evt);
            }
        });

        cbbLoaiThit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbDonVi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Mã hộp thịt:");

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panLayout = new javax.swing.GroupLayout(pan);
        pan.setLayout(panLayout);
        panLayout.setHorizontalGroup(
            panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgaySanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panLayout.createSequentialGroup()
                        .addGroup(panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGroup(panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtHSD, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(cbbDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panLayout.createSequentialGroup()
                        .addGroup(panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addGap(20, 20, 20)
                        .addGroup(panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbLoaiThit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKhoiLuong)
                            .addComponent(txtMaHopThit))))
                .addGroup(panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addGroup(panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThemHopThit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClearFormHT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(panLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panLayout.setVerticalGroup(
            panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtMaHopThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnThemHopThit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbLoaiThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLoad)))
                .addGroup(panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtKhoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbbDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNgaySanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtHSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClearFormHT)
                        .addContainerGap())))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Khách hàng"));

        jLabel6.setText("Số điện thoại:");

        jLabel7.setText("Hạng thành viên:");

        txtHangThanhVien.setText(".................");

        btnXacNhanKH.setText("Xác nhận");
        btnXacNhanKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtHangThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXacNhanKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXacNhanKH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtHangThanhVien))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tblHopThit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hộp thịt", "Tên", "Khối lượng (g)", "Giá gốc", "Giá bán", "HSD", "Tình trạng"
            }
        ));
        tblHopThit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHopThitMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHopThit);

        btnThemVaoGio.setText("Thêm vào giỏ hàng");
        btnThemVaoGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVaoGioActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhân viên"));

        jLabel9.setText("Tên nhân viên:");

        txtTenNhanVien.setText("...........");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTenNhanVien))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblHoaDonCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã hộp thịt", "Tên ", "Giá bán"
            }
        ));
        jScrollPane2.setViewportView(tblHoaDonCT);

        btnHoaDonMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Text.png"))); // NOI18N
        btnHoaDonMoi.setText("Mới");
        btnHoaDonMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonMoiActionPerformed(evt);
            }
        });

        btnXoaSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnXoaSP.setText("Xóa sản phẩm");
        btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel13.setText("Số tiền giảm giá");

        txtSoTienGiamGia.setText("..............");

        jLabel11.setText("Tổng tiền:");

        txtTongTien.setText("...................");

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtSoTienGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtSoTienGiamGia))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtTongTien))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addComponent(btnThemVaoGio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnHoaDonMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaSP)
                        .addGap(94, 94, 94))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHoaDonMoi)
                            .addComponent(btnXoaSP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThemVaoGio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private void clearFormHopThit() {
        txtMaHopThit.setText("");
        txtHSD.setText("");
        txtNgaySanXuat.setText("");
        txtKhoiLuong.setText("");
        cbbLoaiThit.setSelectedIndex(0);
        cbbDonVi.setSelectedIndex(0);
    }
    private void btnThemHopThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHopThitActionPerformed
        HopThitViewModel hopThit = new HopThitViewModel();
        hopThit.setMaHopThit(txtMaHopThit.getText());
        hopThit.setTenLoaiThit(cbbLoaiThit.getSelectedItem().toString());
        hopThit.setKhoiLuong(txtKhoiLuong.getText());
        hopThit.setTenDonVi(cbbDonVi.getSelectedItem().toString());
        hopThit.setNSX(txtNgaySanXuat.getText());
        hopThit.setHSD(txtHSD.getText());
        String noti = gioHangServ.addHopThit(hopThit);
        JOptionPane.showMessageDialog(this, noti);
        if (!noti.contains("thành công")) {
            return;
        }
        loadTableHopThit();
        clearFormHopThit();
    }//GEN-LAST:event_btnThemHopThitActionPerformed

    private void tblHopThitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHopThitMouseClicked
        int row = tblHopThit.getSelectedRow();
        if (row == -1) {
            return;
        }
        HopThitViewModel hopThit = gioHangServ.getAllHopThit().get(row);
        txtMaHopThit.setText(hopThit.getMaHopThit());
        cbbLoaiThit.setSelectedItem(hopThit.getTenLoaiThit());
        txtKhoiLuong.setText(hopThit.getKhoiLuong());
        cbbDonVi.setSelectedItem(hopThit.getTenDonVi());
        txtNgaySanXuat.setText(hopThit.getNSX());
        txtHSD.setText(hopThit.getHSD());

    }//GEN-LAST:event_tblHopThitMouseClicked
    private void tinhTongTien() {
        double tongTienGoc = 0;
        double tongTienBan = 0;
        for (int i = 0; i < tblHoaDonCT.getRowCount(); i++) {
            for (int j = 0; j < tblHopThit.getRowCount(); j++) {
                if (tblHoaDonCT.getValueAt(i, 0).toString().equals(tblHopThit.getValueAt(j, 0).toString())) {
                    tongTienGoc += Double.parseDouble(tblHopThit.getValueAt(j, 3).toString());
                    tongTienBan += Double.parseDouble(tblHopThit.getValueAt(j, 4).toString());
                    break;
                }
            }
        }
        txtTongTien.setText(String.valueOf(tongTienBan));
        txtSoTienGiamGia.setText(String.valueOf(tongTienGoc - tongTienBan));
    }
    private void btnThemVaoGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVaoGioActionPerformed
        int row = tblHopThit.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần thêm");
            return;
        }
        HopThitViewModel hopThit = gioHangServ.getAllHopThit().get(row);
        if (hopThit.getTinhTrang().equals("Hết hạn")) {
            JOptionPane.showMessageDialog(this, "Sản phẩm hết hạn không được bán");
            return;
        }
        String noti = gioHangServ.themVaoGioHang(hopThit, idHoaDon);
        JOptionPane.showMessageDialog(this, noti);
        loadTableHoaDonCT(idHoaDon);
        tinhTongTien();

    }//GEN-LAST:event_btnThemVaoGioActionPerformed

    private void btnClearFormHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormHTActionPerformed
        clearFormHopThit();
    }//GEN-LAST:event_btnClearFormHTActionPerformed

    private void btnHoaDonMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonMoiActionPerformed
        idHoaDon = gioHangServ.taoHoaDon(idNV);
        loadTableHoaDonCT(idHoaDon);
    }//GEN-LAST:event_btnHoaDonMoiActionPerformed

    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPActionPerformed
        int row = tblHoaDonCT.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm cần xóa");
            return;
        }
        HoaDonChiTietViewModel hoaDonCTVM = gioHangServ.getAllHoaDonCTByID(idHoaDon).get(row);
        String noti = gioHangServ.xoaKhoiGioHang(hoaDonCTVM.getId());
        JOptionPane.showMessageDialog(this, noti);
        loadTableHoaDonCT(idHoaDon);
        tinhTongTien();
    }//GEN-LAST:event_btnXoaSPActionPerformed

    private void btnXacNhanKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanKHActionPerformed
        KhachHangViewModel khachHang = gioHangServ.getKhachHangBySDT(txtSDT.getText());
        if (JOptionPane.YES_OPTION != JOptionPane.showConfirmDialog(this, "Họ tên:" + khachHang.getHoTen() + "?")) {
            return;
        }
        txtHangThanhVien.setText(khachHang.getHangTV());
        idThanhVien = khachHang.getIDThanhVien();
    }//GEN-LAST:event_btnXacNhanKHActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        HoaDonViewModel hoaDon = new HoaDonViewModel(
                idHoaDon,
                null,
                sdf.format(new Date()),
                idNV,
                idThanhVien,
                null);
        String noti = gioHangServ.updateHoaDon(hoaDon);
        JOptionPane.showMessageDialog(this, noti);
        idHoaDon = gioHangServ.taoHoaDon(idNV);
        loadTableHoaDonCT(idHoaDon);
        txtSDT.setText("");
        txtHangThanhVien.setText("");
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        loadCBBLoaiThit();
    }//GEN-LAST:event_btnLoadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearFormHT;
    private javax.swing.JButton btnHoaDonMoi;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemHopThit;
    private javax.swing.JButton btnThemVaoGio;
    private javax.swing.JButton btnXacNhanKH;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JComboBox<String> cbbDonVi;
    private javax.swing.JComboBox<String> cbbLoaiThit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pan;
    private javax.swing.JTable tblHoaDonCT;
    private javax.swing.JTable tblHopThit;
    private javax.swing.JTextField txtHSD;
    private javax.swing.JLabel txtHangThanhVien;
    private javax.swing.JTextField txtKhoiLuong;
    private javax.swing.JTextField txtMaHopThit;
    private javax.swing.JTextField txtNgaySanXuat;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JLabel txtSoTienGiamGia;
    private javax.swing.JLabel txtTenNhanVien;
    private javax.swing.JLabel txtTongTien;
    // End of variables declaration//GEN-END:variables
}