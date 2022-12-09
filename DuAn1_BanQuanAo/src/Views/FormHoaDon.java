/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.HoaDon;
import DomainModels.HoaDonCT_Model;
import Repository.HoaDonRepository;
import ServiceITF.HoaDonITFa;
import ServiceIplm.HoaDonCT_Service;
import ServiceIplm.HoaDonIplm;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class FormHoaDon extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    HoaDonITFa service = new HoaDonIplm();

    /**
     * Creates new form FormBanHang
     */
    public FormHoaDon() {
        initComponents();
        setLocationRelativeTo(null);
        loadTable(service.getListHD());
    }

    private DateFormat x;

    public void loadTable(ArrayList<HoaDon> list) {
        model = (DefaultTableModel) tblQLHD.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Mã Hóa Đơn", "Tên Khách Hàng", "Tên Người Tạo", "Ngày Tạo", "Ngày Hủy", "Ngày Thanh Toán", "Trạng Thái"});
        for (HoaDon x : list) {
            model.addRow(new Object[]{x.getMaHD(), x.getMaKH(), x.getMaND(),
                x.getNgayTao(), x.getNgayHuy(), x.getNgayThanhToan(), x.getTrangThai()});
        }
    }

    public boolean validate(String a) {
        try {
            SimpleDateFormat fm = new SimpleDateFormat("dd/mm/yyyy");
            fm.parse(a);
            return false;
        } catch (Exception e) {
            //e.printStackTrace();
            e.getMessage();
        }
        return true;
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btSanPham = new javax.swing.JButton();
        btBanHang = new javax.swing.JButton();
        btNhanVien = new javax.swing.JButton();
        btHoaDon = new javax.swing.JButton();
        btKhachHang = new javax.swing.JButton();
        btCuaHang = new javax.swing.JButton();
        btNhaCungCap = new javax.swing.JButton();
        btDoiMatKhau = new javax.swing.JButton();
        btDangXuat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQLHD = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        rdChuaThanhToan = new javax.swing.JRadioButton();
        rdDaThanhToan = new javax.swing.JRadioButton();
        rdDaHuy = new javax.swing.JRadioButton();
        rdTatCa = new javax.swing.JRadioButton();
        btTimKiem = new javax.swing.JButton();
        txtMin = new javax.swing.JTextField();
        txtMax = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btSanPham.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btSanPham.setText("SẢN PHẨM");
        btSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSanPhamActionPerformed(evt);
            }
        });

        btBanHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btBanHang.setText("BÁN HÀNG");
        btBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBanHangActionPerformed(evt);
            }
        });

        btNhanVien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btNhanVien.setText("NHÂN VIÊN");
        btNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhanVienActionPerformed(evt);
            }
        });

        btHoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btHoaDon.setText("HÓA ĐƠN");

        btKhachHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btKhachHang.setText("KHÁCH HÀNG");
        btKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKhachHangActionPerformed(evt);
            }
        });

        btCuaHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btCuaHang.setText("CỬA HÀNG");
        btCuaHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCuaHangActionPerformed(evt);
            }
        });

        btNhaCungCap.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btNhaCungCap.setText("NHÀ CUNG CẤP");
        btNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhaCungCapActionPerformed(evt);
            }
        });

        btDoiMatKhau.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btDoiMatKhau.setText("ĐỔI MẬT KHẨU");
        btDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoiMatKhauActionPerformed(evt);
            }
        });

        btDangXuat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btDangXuat.setText("ĐĂNG XUẤT");
        btDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDangXuatActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblQLHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblQLHD);

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        buttonGroup1.add(rdChuaThanhToan);
        rdChuaThanhToan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdChuaThanhToan.setText("Chưa Thanh Toán");
        rdChuaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdChuaThanhToanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdDaThanhToan);
        rdDaThanhToan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdDaThanhToan.setText("Đã Thanh Toán");
        rdDaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdDaThanhToanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdDaHuy);
        rdDaHuy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdDaHuy.setText("Đã Hủy");
        rdDaHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdDaHuyActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdTatCa);
        rdTatCa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdTatCa.setText("Tất cả");
        rdTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTatCaActionPerformed(evt);
            }
        });

        btTimKiem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btTimKiem.setText("Tìm Kiếm");
        btTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemActionPerformed(evt);
            }
        });

        txtMin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtMax.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nhập Ngày Cần Tìm:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("-");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Trạng Thái:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(rdChuaThanhToan)
                                .addGap(47, 47, 47)
                                .addComponent(rdDaThanhToan)
                                .addGap(39, 39, 39)
                                .addComponent(rdDaHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdChuaThanhToan)
                    .addComponent(rdDaThanhToan)
                    .addComponent(rdDaHuy)
                    .addComponent(rdTatCa)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTimKiem)
                    .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btBanHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCuaHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNhaCungCap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btDoiMatKhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTatCaActionPerformed
        loadTable(service.getListHD());
    }//GEN-LAST:event_rdTatCaActionPerformed

    private void rdChuaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdChuaThanhToanActionPerformed
        loadTable(service.getListLocHD("Chưa Thanh Toán"));
    }//GEN-LAST:event_rdChuaThanhToanActionPerformed

    private void rdDaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdDaThanhToanActionPerformed
        loadTable(service.getListLocHD("Đã Thanh Toán"));
    }//GEN-LAST:event_rdDaThanhToanActionPerformed

    private void rdDaHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdDaHuyActionPerformed
        loadTable(service.getListLocHD("Đã Hủy"));
    }//GEN-LAST:event_rdDaHuyActionPerformed

    private void btSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSanPhamActionPerformed
        // TODO add your handling code here:
        FormSanPham x = new FormSanPham();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btSanPhamActionPerformed

    private void btBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBanHangActionPerformed
        // TODO add your handling code here:
        FormBanHang x = new FormBanHang();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btBanHangActionPerformed

    private void btNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhanVienActionPerformed
        // TODO add your handling code here:
        FormNhanVien x = new FormNhanVien();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btNhanVienActionPerformed

    private void btCuaHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCuaHangActionPerformed
        // TODO add your handling code here:
        FormCuaHang x = new FormCuaHang();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btCuaHangActionPerformed

    private void btNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhaCungCapActionPerformed
        // TODO add your handling code here:
        FormNhaCungCap x = new FormNhaCungCap();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btNhaCungCapActionPerformed

    private void btKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhachHangActionPerformed
        // TODO add your handling code here:
        FormKhachHang x = new FormKhachHang();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btKhachHangActionPerformed

    private void btDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoiMatKhauActionPerformed
        // TODO add your handling code here:
        FormDoiMatKhau x = new FormDoiMatKhau();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btDoiMatKhauActionPerformed

    private void btDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDangXuatActionPerformed
        // TODO add your handling code here:
        DangNhap x = new DangNhap();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btDangXuatActionPerformed

    private void btTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemActionPerformed
        // TODO add your handling code here:
        String tim = txtTimKiem.getText();
        String min = txtMin.getText();
        String max = txtMax.getText();

        try {
            if (tim.isEmpty()) {
                if (validate(max) || validate(min)) {
                    JOptionPane.showMessageDialog(this, "Bạn đã nhập sai định dạng ngày tháng(dd/mm/yyyy)");
                    return;
                }
                loadTable(service.getListTimNgayHD(min, max));
                return;
            }
            loadTable(service.getListTimHD(tim));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btTimKiemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBanHang;
    private javax.swing.JButton btCuaHang;
    private javax.swing.JButton btDangXuat;
    private javax.swing.JButton btDoiMatKhau;
    private javax.swing.JButton btHoaDon;
    private javax.swing.JButton btKhachHang;
    private javax.swing.JButton btNhaCungCap;
    private javax.swing.JButton btNhanVien;
    private javax.swing.JButton btSanPham;
    private javax.swing.JButton btTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdChuaThanhToan;
    private javax.swing.JRadioButton rdDaHuy;
    private javax.swing.JRadioButton rdDaThanhToan;
    private javax.swing.JRadioButton rdTatCa;
    private javax.swing.JTable tblQLHD;
    private javax.swing.JTextField txtMax;
    private javax.swing.JTextField txtMin;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
