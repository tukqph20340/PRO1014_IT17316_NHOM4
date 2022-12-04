/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.GioHang;
import DomainModels.KhachHangMode;
import DomainModels.SanPham;
import DomainModels.ThanhToan;
import ServiceITF.GioHangITF;
import ServiceITF.SanPhamITF;
import ServiceIplm.GioHangIplm;
import ViewModels.HoaDonViews;
import ServiceIplm.HoaDon_Service;
import ServiceIplm.KhachHangSevice;
import ServiceIplm.SanPhamInBanHang_Service;

import ServiceIplm.ThemSuaThanhToanHoaDonImt;

import ServiceIplm.SanPhamIplm;

import ViewModels.SanPhamViews;
import java.awt.datatransfer.DataFlavor;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import Views.FormSanPham;
import jdk.jfr.Event;

/**
 *
 * @author DELL
 */
public class FormBanHang extends javax.swing.JFrame {

    private ThemSuaThanhToanHoaDonImt BanHang = new ThemSuaThanhToanHoaDonImt();
    private KhachHangSevice Kh = new KhachHangSevice();

    /**
     * Creates new form FormBanHang
     */
    public FormBanHang() {
        initComponents();

        setLocationRelativeTo(this);

        loadCbMau(service.getListMauSac());
        loadCbSize(service.getListSize());
        loadDanhMuc(service.getListDanhMuc());
        loadChatLieu(service.getListChatLieu());
        loadKieuDang(service.getListKieuDang());
        fillDataSanPham();
        fillDataHoaDon();
        fillSP(listSanPham);
        //loadDataTableGH(ghService.getListGH("HD01"));
    }
    private SanPhamITF service = new SanPhamIplm();
    DefaultTableModel modelSanPham = new DefaultTableModel();
    SanPhamInBanHang_Service SanPham_Service = new SanPhamInBanHang_Service();
    ArrayList<SanPhamViews> listSanPham = new ArrayList<>();
    HoaDon_Service sercive_hd = new HoaDon_Service();
    ArrayList<HoaDonViews> listHD = new ArrayList<>();
    private GioHangITF ghService = new GioHangIplm();

    public void loadCbMau(ArrayList<String> listMau) {
        CbLocMau.removeAllItems();
        CbLocMau.addItem("Tất cả");
        for (String x : listMau) {
            CbLocMau.addItem(x);
        }
    }

    public void loadCbSize(ArrayList<String> listSize) {
        cbLocSizze.removeAllItems();
        cbLocSizze.addItem("Tất cả");
        for (String x : listSize) {
            cbLocSizze.addItem(x);
        }
    }

    public void loadDanhMuc(ArrayList<String> listMau) {
        cbDanhMuc.removeAllItems();
        cbDanhMuc.addItem("Tất cả");
        for (String x : listMau) {
            cbDanhMuc.addItem(x);
        }
    }

    public void loadChatLieu(ArrayList<String> listMau) {
        cbChatLieu.removeAllItems();
        cbChatLieu.addItem("Tất cả");
        for (String x : listMau) {
            cbChatLieu.addItem(x);
        }
    }

    public void loadKieuDang(ArrayList<String> listMau) {
        cbKieuDang.removeAllItems();
        cbKieuDang.addItem("Tất cả");
        for (String x : listMau) {
            cbKieuDang.addItem(x);
        }
    }

    public void fillDataSanPham() {
        modelSanPham = (DefaultTableModel) tblbangSanPham.getModel();
        modelSanPham.setRowCount(0);
        listSanPham = (ArrayList<SanPhamViews>) SanPham_Service.getAllSanPham();
        String[] hearch = {"Mã Sản Phẩm", "Tên Sản Phẩm", "Danh Mục", "Màu", "Size", "Chất Liệu", "Kiểu Dáng", "Giá", "Số lượng"};
        modelSanPham.setColumnIdentifiers(hearch);
        for (SanPhamViews s : listSanPham) {
            modelSanPham.addRow(new Object[]{s.getMaSP(), s.getTenSP(), s.getDanhMuc(), s.getMau(), s.getSize(), s.getChatLieu(), s.getKieuDang(), s.getGiaBan(), s.getSoLuong()});
        }
        tblbangSanPham.setModel(modelSanPham);
    }

    public void fillDataHoaDon() {
        modelSanPham = (DefaultTableModel) tblHoaDonCho.getModel();
        modelSanPham.setRowCount(0);
        listHD = (ArrayList<HoaDonViews>) sercive_hd.getAllForm();
        modelSanPham.setColumnIdentifiers(new String[]{"Mã Hóa Đơn", "Mã Khách hàng", "Tên Khách Hàng", "Ngày Tạo"});
        for (HoaDonViews sa : listHD) {
            modelSanPham.addRow(new Object[]{sa.getMaHD(), sa.getMaKH(), sa.getTenKH(), sa.getNgayTao()});
        }
        tblHoaDonCho.setModel(modelSanPham);

    }

    public void fillSP(ArrayList<SanPhamViews> list) {
        modelSanPham = (DefaultTableModel) tblbangSanPham.getModel();
        modelSanPham.setRowCount(0);
        listSanPham = (ArrayList<SanPhamViews>) SanPham_Service.getAllSanPham();
        for (SanPhamViews sanPhamViews : list) {
            modelSanPham.addRow(sanPhamViews.data());
        }
    }

    public void loadDataTableGH(ArrayList<GioHang> list) {
        modelSanPham = (DefaultTableModel) tblGioHang.getModel();
        modelSanPham.setRowCount(0);
        modelSanPham.setColumnIdentifiers(new String[]{"Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Thành Tiền"});
        for (GioHang x : list) {
            modelSanPham.addRow(new Object[]{x.getMaSP(), x.getTenSP(), x.getSoLuong(), x.tinhTong()});
        }
    }

    public boolean checkMaSP(String maHD) {
        int row = tblbangSanPham.getSelectedRow();
        String maSP = tblbangSanPham.getValueAt(row, 0).toString();
        for (GioHang x : ghService.getListGH(maHD)) {
            if (maSP.equals(x.getMaSP())) {
                return true;
            }
        }
        return false;
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
        btSanPham = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonCho = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btXoaSP = new javax.swing.JButton();
        btTang = new javax.swing.JButton();
        btGiam = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        txtMaTimkiem = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtMaNv = new javax.swing.JTextField();
        txtngayTao = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtTiennKhachDua = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblbangSanPham = new javax.swing.JTable();
        txtname = new javax.swing.JTextField();
        cbLocSizze = new javax.swing.JComboBox<>();
        CbLocMau = new javax.swing.JComboBox<>();
        cbChatLieu = new javax.swing.JComboBox<>();
        cbKieuDang = new javax.swing.JComboBox<>();
        cbDanhMuc = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btSanPham.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btSanPham.setText("SẢN PHẨM");
        btSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSanPhamActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("BÁN HÀNG");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("NHÂN VIÊN");

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setText("HÓA ĐƠN");

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setText("KHÁCH HÀNG");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("CỬA HÀNG");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("NHÀ CUNG CẤP");

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton8.setText("ĐỔI MẬT KHẨU");

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton9.setText("ĐĂNG XUẤT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblHoaDonCho.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHoaDonCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonChoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDonCho);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        btXoaSP.setText("Xóa Sản Phẩm");
        btXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaSPActionPerformed(evt);
            }
        });

        btTang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btTang.setText("+");
        btTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTangActionPerformed(evt);
            }
        });

        btGiam.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btGiam.setText("-");
        btGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGiamActionPerformed(evt);
            }
        });

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblGioHang);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btGiam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btTang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btXoaSP)
                .addContainerGap())
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btXoaSP)
                    .addComponent(btTang)
                    .addComponent(btGiam))
                .addGap(5, 5, 5))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 33, Short.MAX_VALUE)))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jButton33.setText("Thêm Khách Hàng");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton34.setText("Tìm Kiếm");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jLabel10.setText("Mã Hóa Đơn:");

        jLabel38.setText("Mã Khách Hàng:");

        jLabel39.setText("Tên Khách Hàng:");

        jLabel40.setText("SDT:");

        jLabel41.setText("Mã Nhân Viên:");

        jLabel42.setText("Ngày Tạo:");

        jLabel43.setText("Tổng Tiền:");

        jLabel44.setText("Tiền Khách Đưa:");

        txtTongTien.setEditable(false);

        jLabel45.setText("Tiền Thừa:");

        txtTienThua.setEditable(false);

        jButton36.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton36.setText("Thêm");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButton37.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton37.setText("Xóa");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jButton38.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton38.setText("Thanh Toán");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setText("Tạo Mới");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtMaTimkiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton34))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTiennKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaNv, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jButton36)
                .addGap(2, 2, 2)
                .addComponent(jButton37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jButton39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton33))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton33)
                    .addComponent(jButton39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton34)
                    .addComponent(txtMaTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtMaNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txtngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txtTiennKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton36)
                    .addComponent(jButton37)
                    .addComponent(jButton38))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tblbangSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        tblbangSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbangSanPhamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblbangSanPham);

        txtname.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        cbLocSizze.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        cbLocSizze.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocSizze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocSizzeActionPerformed(evt);
            }
        });

        CbLocMau.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        CbLocMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbLocMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbLocMauActionPerformed(evt);
            }
        });

        cbChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbChatLieuActionPerformed(evt);
            }
        });

        cbKieuDang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbKieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKieuDangActionPerformed(evt);
            }
        });

        cbDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDanhMucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CbLocMau, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbLocSizze, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLocSizze, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbLocMau, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean check_1(ArrayList<SanPhamViews> list, String ma) {
        for (SanPhamViews sanPhamViews : list) {
            if (sanPhamViews.getMaSP().equalsIgnoreCase(ma)) {
                JOptionPane.showMessageDialog(this, "Mã không tồn tại");
                return false;
            }
        }
        return true;
    }
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String ma = txtname.getText();

        if (txtname.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return;
        }
        listSanPham = (ArrayList<SanPhamViews>) SanPham_Service.seachname(ma);
        fillSP(listSanPham);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblbangSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbangSanPhamMouseClicked
        // TODO add your handling code here:
        ArrayList<GioHang> list = new ArrayList<>();
        int row = tblbangSanPham.getSelectedRow();
        String ma = tblbangSanPham.getValueAt(row, 0).toString();
        int so = Integer.parseInt(JOptionPane.showInputDialog("Nhập Số Lượng bạn cần mua."));
        int rowHD = tblHoaDonCho.getSelectedRow();
        if (rowHD == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn để thêm sản phẩm.");
            return;
        }
        String maHD = tblHoaDonCho.getValueAt(rowHD, 0).toString();
        //String maHD = "HD01";
        GioHang gh = new GioHang();
        gh.setMaHD(maHD);
        gh.setMaSP(ma);
        try {
            if (checkMaSP(maHD) == false) {
                ghService.themGH(gh, so);
            }
            ghService.soLuongSP(so, ma);
            ghService.soLuongHD(ma, so, maHD);
            loadDataTableGH(ghService.getListGH(maHD));
            fillDataSanPham();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblbangSanPhamMouseClicked

    private void btTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTangActionPerformed
        // TODO add your handling code here:
        int row = tblGioHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Không thể sửa số lượng do bạn chưa chọn sản phẩm.");
        }
        String ma = tblGioHang.getValueAt(row, 0).toString();
        int rowHD = tblHoaDonCho.getSelectedRow();
        if (rowHD == -1) {
            JOptionPane.showMessageDialog(this, "Sửa số lượng thất bại do Hóa Đơn của Giỏ Hàng này chưa được tạo");
            return;
        }
        String maHD = tblHoaDonCho.getValueAt(rowHD, 0).toString();
        //String maHD = "HD01";
        try {
            if (ghService.tangHD(ma, maHD)) {
                if (ghService.giamSP(ma)) {
                    loadDataTableGH(ghService.getListGH(maHD));
                    fillDataSanPham();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btTangActionPerformed

    private void btGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGiamActionPerformed
        // TODO add your handling code here:
        int row = tblGioHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Không thể sửa số lượng do bạn chưa chọn sản phẩm.");
            return;
        }
        String ma = tblGioHang.getValueAt(row, 0).toString();
        int rowHD = tblHoaDonCho.getSelectedRow();
        if (rowHD == -1) {
            JOptionPane.showMessageDialog(this, "Sửa số lượng thất bại do Hóa Đơn của Giỏ Hàng này chưa được tạo");
            return;
        }
        String maHD = tblHoaDonCho.getValueAt(rowHD, 0).toString();
        //String maHD = "HD01";
        try {
            if (ghService.giamHD(ma, maHD)) {
                if (ghService.tangSP(ma)) {
                    loadDataTableGH(ghService.getListGH(maHD));
                    fillDataSanPham();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btGiamActionPerformed

    private void btXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaSPActionPerformed
        // TODO add your handling code here:
        int row = tblGioHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Không thể xóa sản phẩm do bạn chưa chọn sản phẩm.");
            return;
        }
        String ma = tblGioHang.getValueAt(row, 0).toString();

        String maHD = "HD01";
        SanPham sp = new SanPham();
        GioHang gh = new GioHang();

        int rowHD = tblHoaDonCho.getSelectedRow();
        if (rowHD == -1) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại do Hóa Đơn của Giỏ Hàng này chưa được tạo.");
            return;
        }
        //String maHD = tblHoaDonCho.getValueAt(rowHD, 0).toString();
        //String maHD = "HD01";

        int sl = Integer.parseInt(tblGioHang.getValueAt(row, 2).toString());
        try {
            if (ghService.xoa(ma, maHD)) {
                for (int i = 1; i <= sl; i++) {
                    ghService.tangSP(ma);
                }
                loadDataTableGH(ghService.getListGH(maHD));
            }/*else{
                JOptionPane.showMessageDialog(this, "Xóa thất bại do Hóa Đơn của Giỏ Hàng này chưa được tạo");
            }*/
        } catch (Exception e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_btXoaSPActionPerformed

    private void tblHoaDonChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonChoMouseClicked
        // TODO add your handling code here:
        int row = tblHoaDonCho.getSelectedRow();


        /*if (row==-1) {
            JOptionPane.showMessageDialog(this, "Hóa Đơn chưa được chọn");
            return;
        }*/
        String ma = tblHoaDonCho.getValueAt(row, 0).toString();
        try {
            loadDataTableGH(ghService.getListGH(ma));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblHoaDonChoMouseClicked


    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        // TODO add your handling code here:
        int row = tblGioHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "vui lòng chọn sp để thanh toán");
            return;
        } else {
            try {
                String maHd = txtMa.getText();
                String makh = txtMaKH.getText();
                String TenKhachHang = txtTenKhachHang.getText();
                String SoLuong = tblGioHang.getValueAt(row, 2).toString();;
                String MaND = txtMaNv.getText();
                String sdt = txtSdt.getText();
                String Sp = tblGioHang.getValueAt(row, 0).toString();
                String TrangThai = "Chờ Thanh Thoán";
                String NgayTao = txtngayTao.getText();
                String TongTien = tblGioHang.getValueAt(row, 3).toString();
                String TienKhachDua = txtTiennKhachDua.getText();

                String TienThua = txtTienThua.getText();

                if (maHd.trim().isEmpty()
                        || makh.trim().isEmpty()
                        || sdt.trim().isEmpty()
                        || MaND.trim().isEmpty()
                        || NgayTao.trim().isEmpty()
                        || TongTien.trim().isEmpty()
                        || TienKhachDua.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "có trường trống vui lòng nhập lại");
                    return;
                }
                try {
                    Integer tongtien1 = Integer.parseInt(TongTien);
                    Integer TienKhachDua1 = Integer.parseInt(TienKhachDua);
                    txtTienThua.setText(String.valueOf(tongtien1 - TienKhachDua1));
                    if (TienKhachDua1 < 0) {
                        JOptionPane.showMessageDialog(null, "tiền phải lớn hơn 0");
                        return;
                    }
                } catch (Exception e) {
                }
                try {
                    BanHang.insert(maHd, makh, MaND, NgayTao, TrangThai);
                    BanHang.insertGH(maHd, Sp, SoLuong, TongTien, TienKhachDua, TienThua, TrangThai);
                } catch (Exception e) {
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Vui Lòng nhập đúng định dạng ngày tạo (yyyy-MM-dd) và tiền là số");
                return;
            }
        }
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        // TODO add your handling code here:

        String maHd = txtMa.getText();
        String trangthai = "Đã Hủy";
        if (maHd.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "mã ko đc để trống");
            return;
        }

        try {
            BanHang.HuyHoaDon(maHd, trangthai);
            BanHang.Huy(maHd, trangthai);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        // TODO add your handling code here:
        String maHd = txtMa.getText();
        String trangthai = "Đã Thanh Toán";
        String TongTien = txtTongTien.getText();
        String TienKhachDua = txtTiennKhachDua.getText();
        Integer tongtien1 = Integer.parseInt(TongTien);
        Integer TienKhachDua1 = Integer.parseInt(TienKhachDua);
        String TienThua = txtTienThua.getText();
        txtTienThua.setText(String.valueOf(tongtien1 - TienKhachDua1));
        try {
            BanHang.ThanhToanHoa(maHd, trangthai);
            BanHang.ThanhToanHoaDonChiTiet(maHd, TongTien, TienKhachDua, TienThua, trangthai);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton38ActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        // TODO add your handling code here:
        int row = tblGioHang.getSelectedRow();
        txtTongTien.setText(tblGioHang.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        // TODO add your handling code here:
        modelSanPham = (DefaultTableModel) tblGioHang.getModel();
        modelSanPham.setRowCount(0);
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:
        String Mat = txtMaTimkiem.getText();
        if (Mat.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "mã hóa đơn đang tìm để trống");
        }
        List<ThanhToan> hd = BanHang.select(Mat);
        for (ThanhToan hoaDonChiTiet : hd) {
            txtMa.setText(hoaDonChiTiet.getMaHD());
            txtMaKH.setText(hoaDonChiTiet.getMaKH());
            txtMaNv.setText(hoaDonChiTiet.getMaND());
            txtngayTao.setText(hoaDonChiTiet.getNgayTao());
            txtTongTien.setText(hoaDonChiTiet.getTongTien());
            txtTiennKhachDua.setText(hoaDonChiTiet.getTienKhachDua());
            txtTienThua.setText(hoaDonChiTiet.getTienThua());
        }
        String MaKh = txtMaKH.getText();
        List<KhachHangMode> ListKh = Kh.select1(MaKh);
        for (KhachHangMode khachHangMode : ListKh) {
            txtTenKhachHang.setText(khachHangMode.getHoVaTen());
            txtSdt.setText(khachHangMode.getSdt());
        }


    }//GEN-LAST:event_jButton34ActionPerformed

    private void CbLocMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbLocMauActionPerformed
        //locMau
        String mau = (String) CbLocMau.getSelectedItem();
        try {
            if (CbLocMau.getSelectedIndex() == 0) {
                listSanPham = (ArrayList<SanPhamViews>) SanPham_Service.getAllSanPham();
                fillSP(listSanPham);

                return;
            } else {
                listSanPham = (ArrayList<SanPhamViews>) SanPham_Service.LocMau(mau);
                fillSP(listSanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_CbLocMauActionPerformed

    private void cbLocSizzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocSizzeActionPerformed
        //locsize
        String size = (String) cbLocSizze.getSelectedItem();
        try {
            if (cbLocSizze.getSelectedIndex() == 0) {
                listSanPham = (ArrayList<SanPhamViews>) SanPham_Service.getAllSanPham();
                fillSP(listSanPham);
                return;
            } else {
                listSanPham = (ArrayList<SanPhamViews>) SanPham_Service.LocSize(size);
                fillSP(listSanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbLocSizzeActionPerformed


    private void btSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSanPhamActionPerformed
        // TODO add your handling code here:
        FormSanPham x = new FormSanPham();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btSanPhamActionPerformed


    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
        new KhachHang(this, true).setVisible(true);
    }//GEN-LAST:event_jButton33ActionPerformed

    private void cbChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbChatLieuActionPerformed
        //locMau
        String cl = (String) cbChatLieu.getSelectedItem();
        try {
            if (cbChatLieu.getSelectedIndex() == 0) {
                listSanPham = (ArrayList<SanPhamViews>) SanPham_Service.getAllSanPham();
                fillSP(listSanPham);
            } else {
                listSanPham = (ArrayList<SanPhamViews>) SanPham_Service.LocChatLieu(cl);
                fillSP(listSanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbChatLieuActionPerformed

    private void cbKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKieuDangActionPerformed
        String cl = (String) cbKieuDang.getSelectedItem();
        try {
            if (cbKieuDang.getSelectedIndex() == 0) {
                listSanPham = (ArrayList<SanPhamViews>) SanPham_Service.getAllSanPham();
                fillSP(listSanPham);
                return;
            } else {
                listSanPham = (ArrayList<SanPhamViews>) SanPham_Service.LocKieuDang(cl);
                fillSP(listSanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbKieuDangActionPerformed

    private void cbDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDanhMucActionPerformed
        String dm = (String) cbDanhMuc.getSelectedItem();
        try {
            if (cbDanhMuc.getSelectedIndex() == 0) {
                listSanPham = (ArrayList<SanPhamViews>) SanPham_Service.getAllSanPham();
                fillSP(listSanPham);
                return;
            } else {
                listSanPham = (ArrayList<SanPhamViews>) SanPham_Service.LocDanhMuc(dm);
                fillSP(listSanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbDanhMucActionPerformed

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
            java.util.logging.Logger.getLogger(FormBanHang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBanHang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBanHang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBanHang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbLocMau;
    private javax.swing.JButton btGiam;
    private javax.swing.JButton btSanPham;
    private javax.swing.JButton btTang;
    private javax.swing.JButton btXoaSP;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbChatLieu;
    private javax.swing.JComboBox<String> cbDanhMuc;
    private javax.swing.JComboBox<String> cbKieuDang;
    private javax.swing.JComboBox<String> cbLocSizze;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDonCho;
    private javax.swing.JTable tblbangSanPham;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNv;
    private javax.swing.JTextField txtMaTimkiem;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTiennKhachDua;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtngayTao;
    // End of variables declaration//GEN-END:variables
}
