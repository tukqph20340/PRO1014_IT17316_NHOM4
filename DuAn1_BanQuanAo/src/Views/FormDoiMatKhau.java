/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.NhanVien_Model;
import Repository.DoiMatKhauRepository;
import ServiceITF.DoiMatKhauITF;
import ServiceITF.NhanVien_ITF;
import ServiceIplm.DoiMatKhauIplm;
import ServiceIplm.NhanVien_Service;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class FormDoiMatKhau extends javax.swing.JFrame {

    /**
     * Creates new form FormDoiMatKhau
     */
    public FormDoiMatKhau() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private NhanVien_ITF nvService = new NhanVien_Service();
    private DoiMatKhauITF service = new DoiMatKhauIplm();
    private DoiMatKhauRepository repo=new DoiMatKhauRepository();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btDangXuat = new javax.swing.JButton();
        btSanPham = new javax.swing.JButton();
        btBanHang = new javax.swing.JButton();
        btNhanVien = new javax.swing.JButton();
        btHoaDon = new javax.swing.JButton();
        btKhachHang = new javax.swing.JButton();
        btCuaHang = new javax.swing.JButton();
        btNhaCungCap = new javax.swing.JButton();
        btDoiMatKhau = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        passCu = new javax.swing.JPasswordField();
        passConfirm = new javax.swing.JPasswordField();
        passMoi = new javax.swing.JPasswordField();
        btXacNhan = new javax.swing.JButton();
        btLamMoi = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btDangXuat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btDangXuat.setText("????NG XU???T");
        btDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDangXuatActionPerformed(evt);
            }
        });

        btSanPham.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btSanPham.setText("S???N PH???M");
        btSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSanPhamActionPerformed(evt);
            }
        });

        btBanHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btBanHang.setText("B??N H??NG");
        btBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBanHangActionPerformed(evt);
            }
        });

        btNhanVien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btNhanVien.setText("NH??N VI??N");
        btNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhanVienActionPerformed(evt);
            }
        });

        btHoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btHoaDon.setText("H??A ????N");
        btHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHoaDonActionPerformed(evt);
            }
        });

        btKhachHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btKhachHang.setText("KH??CH H??NG");
        btKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKhachHangActionPerformed(evt);
            }
        });

        btCuaHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btCuaHang.setText("C???A H??NG");
        btCuaHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCuaHangActionPerformed(evt);
            }
        });

        btNhaCungCap.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btNhaCungCap.setText("NH?? CUNG C???P");
        btNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhaCungCapActionPerformed(evt);
            }
        });

        btDoiMatKhau.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btDoiMatKhau.setText("?????I M???T KH???U");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btBanHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCuaHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNhaCungCap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDoiMatKhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
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
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("?????i M???t Kh???u");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("M???t Kh???u C??:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("M???t Kh???u M???i:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("X??c Nh???n M???t Kh???u M???i:");

        passCu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        passConfirm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        passMoi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btXacNhan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btXacNhan.setText("X??c Nh???n");
        btXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXacNhanActionPerformed(evt);
            }
        });

        btLamMoi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btLamMoi.setText("L??m M???i");
        btLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLamMoiActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("T??i Kho???n:");

        txtTaiKhoan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(passConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(passMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(passCu, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(txtTaiKhoan)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btXacNhan)
                                .addGap(46, 46, 46)
                                .addComponent(btLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(290, 290, 290))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btXacNhan)
                    .addComponent(btLamMoi))
                .addGap(90, 90, 90))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDangXuatActionPerformed
        // TODO add your handling code here:
        DangNhap x = new DangNhap();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btDangXuatActionPerformed

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

    private void btHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHoaDonActionPerformed
        // TODO add your handling code here:
        FormHoaDon x = new FormHoaDon();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btHoaDonActionPerformed

    private void btKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhachHangActionPerformed
        // TODO add your handling code here:
        FormKhachHang x = new FormKhachHang();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btKhachHangActionPerformed

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

    private void btXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXacNhanActionPerformed
        // TODO add your handling code here:
        String mkc = new String(passCu.getPassword());
        String tk = txtTaiKhoan.getText();
        String mkm = new String(passMoi.getPassword());
        String cf = new String(passConfirm.getPassword());
        if (tk.isEmpty()) {
            JOptionPane.showMessageDialog(this, "B???n ch??a nh???p T??i Kho???n.");
            return;
        }
        if (mkc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "B???n ch??a nh???p M???t Kh???u C??.");
            return;
        }
        if (mkm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "B???n ch??a nh???p M???t Kh???u M???i.");
            return;
        }
        if (cf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "B???n ch??a nh???p l???i M???t Kh???u M???i.");
            return;
        }
        try {
            for (NhanVien_Model x : nvService.getallformNhanVien()) {
                if (txtTaiKhoan.getText().equals(x.getUsename())) {
                    if (mkc.equals(x.getPassword())) {
                        if (cf.equals(mkm)) {
                            if (repo.dmk(mkm, tk, mkc)) {
                                JOptionPane.showMessageDialog(this, "?????i M???t Kh???u Th??nh C??ng");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "M???t Kh???u Nh???p L???i kh??ng tr??ng kh???p.");
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "M???t Kh???u kh??ng ????ng.");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "T??n T??i Kho???n kh??ng t???n t???i.");
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btXacNhanActionPerformed

    private void btLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLamMoiActionPerformed
        // TODO add your handling code here:
        txtTaiKhoan.setText("");
        passCu.setText("");
        passMoi.setText("");
        passConfirm.setText("");
    }//GEN-LAST:event_btLamMoiActionPerformed

    private void btNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhanVienActionPerformed
        // TODO add your handling code here:
        FormNhanVien x = new FormNhanVien();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btNhanVienActionPerformed

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
            java.util.logging.Logger.getLogger(FormDoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDoiMatKhau().setVisible(true);
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
    private javax.swing.JButton btLamMoi;
    private javax.swing.JButton btNhaCungCap;
    private javax.swing.JButton btNhanVien;
    private javax.swing.JButton btSanPham;
    private javax.swing.JButton btXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passConfirm;
    private javax.swing.JPasswordField passCu;
    private javax.swing.JPasswordField passMoi;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
