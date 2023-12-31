/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import services.DoanhThuServices;
import viewmodel.DoanhThuViewModel;

/**
 *
 * @author Toan
 */
public class DoanhThuView extends javax.swing.JPanel {

    /**
     * Creates new form DoanhThuView
     */
    DefaultComboBoxModel<String> dcbm;
    DoanhThuServices doanhThuServ;
    DefaultTableModel dtm;

    public DoanhThuView() {
        initComponents();
        doanhThuServ = new DoanhThuServices();
        loadCBBYearDT2();
        loadCBBYearDT1();
        cbbYearDT2.setSelectedIndex(0);
        cbbYearDT1.setSelectedIndex(0);
    }

    private void loadCBBMonthDT1(String year) {
        dcbm = (DefaultComboBoxModel<String>) cbbMonthDT1.getModel();
        dcbm.removeAllElements();
        for (String x : doanhThuServ.getAllMonthsByYear(year)) {
            dcbm.addElement(x);
        }
    }

    private void loadCBBYearDT1() {
        dcbm = (DefaultComboBoxModel<String>) cbbYearDT1.getModel();
        dcbm.removeAllElements();
        for (String x : doanhThuServ.getAllYears()) {
            dcbm.addElement(x);
        }
    }

    private void loadCBBYearDT2() {
        dcbm = (DefaultComboBoxModel<String>) cbbYearDT2.getModel();
        dcbm.removeAllElements();
        for (String x : doanhThuServ.getAllYears()) {
            dcbm.addElement(x);
        }
    }

    private void loadDoanhThu1ByMonthAndYear(String month, String year) {
        dtm = (DefaultTableModel) tblDoanhThuNgay.getModel();
        dtm.setRowCount(0);
        for (DoanhThuViewModel x : doanhThuServ.getAllDoanhThuTheoNgay(month, year)) {
            Object[] obj = {
                x.getDate(),
                x.getNumberOfHoaDon(),
                x.getTotal()
            };
            dtm.addRow(obj);
        }
    }

    private void loadDoanhThu2ByYear(String year) {
        dtm = (DefaultTableModel) tblDoanhThuTheoThang.getModel();
        dtm.setRowCount(0);
        for (DoanhThuViewModel x : doanhThuServ.getAllDoanhThuTheoThang(year)) {
            Object[] obj = {
                x.getDate(),
                x.getNumberOfHoaDon(),
                x.getTotal()
            };
            dtm.addRow(obj);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoanhThuTheoThang = new javax.swing.JTable();
        cbbYearDT2 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDoanhThuNgay = new javax.swing.JTable();
        cbbYearDT1 = new javax.swing.JComboBox<>();
        cbbMonthDT1 = new javax.swing.JComboBox<>();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Doanh thu theo tháng"));

        tblDoanhThuTheoThang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tháng", "Tổng hóa đơn", "Tổng tiền"
            }
        ));
        jScrollPane1.setViewportView(tblDoanhThuTheoThang);

        cbbYearDT2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbYearDT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbYearDT2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbbYearDT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(cbbYearDT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Doanh thu theo ngày"));

        tblDoanhThuNgay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ngày", "Tổng hóa đơn", "Tổng tiền"
            }
        ));
        jScrollPane2.setViewportView(tblDoanhThuNgay);

        cbbYearDT1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbYearDT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbYearDT1ActionPerformed(evt);
            }
        });

        cbbMonthDT1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMonthDT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMonthDT1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbbMonthDT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbYearDT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbYearDT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMonthDT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(143, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbYearDT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbYearDT1ActionPerformed

        if (cbbYearDT1.getSelectedItem() != null) {
            loadCBBMonthDT1(cbbYearDT1.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cbbYearDT1ActionPerformed

    private void cbbYearDT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbYearDT2ActionPerformed
        if (cbbYearDT2.getSelectedItem() != null) {
            loadDoanhThu2ByYear(cbbYearDT2.getSelectedItem().toString());
        }

    }//GEN-LAST:event_cbbYearDT2ActionPerformed

    private void cbbMonthDT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMonthDT1ActionPerformed

        if(cbbMonthDT1.getSelectedItem()!=null){
                 loadDoanhThu1ByMonthAndYear(cbbMonthDT1.getSelectedItem().toString(), cbbYearDT1.getSelectedItem().toString());   
        }
    }//GEN-LAST:event_cbbMonthDT1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbMonthDT1;
    private javax.swing.JComboBox<String> cbbYearDT1;
    private javax.swing.JComboBox<String> cbbYearDT2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDoanhThuNgay;
    private javax.swing.JTable tblDoanhThuTheoThang;
    // End of variables declaration//GEN-END:variables
}
