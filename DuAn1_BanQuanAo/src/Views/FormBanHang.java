/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.DangNhapMoDel;
import Untility.Nv;
import DomainModels.GioHang;
import DomainModels.KhachHangMode;
import DomainModels.NhanVien_Model;
import DomainModels.SanPham;
import DomainModels.ThanhToan;
import Repository.SanPhaminBanHang_Repository;
import ServiceITF.GioHangITF;
import ServiceITF.SanPhamITF;
import ServiceITF.SanPhamITFinBanHang;
import ServiceIplm.DangNhapSevice;
import ServiceIplm.GioHangIplm;
import ViewModels.HoaDonViews;
import ServiceIplm.HoaDon_Service;
import ServiceIplm.KhachHangSevice;
import ServiceIplm.NhanVien_Service;
import ServiceIplm.SanPhamInBanHang_Service;
import ServiceIplm.ThemSuaThanhToanHoaDonImt;
import ServiceIplm.SanPhamIplm;
import ViewModels.SanPhamViews;
import java.awt.datatransfer.DataFlavor;
import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private DangNhapSevice dn = new DangNhapSevice();
    /**
     * Creates new form FormBanHang
     */
    Nv n = new Nv();

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
        loadGH();
        LoatNV();
    }
    private SanPhamITF service = new SanPhamIplm();
    DefaultTableModel modelSanPham = new DefaultTableModel();
    SanPhamInBanHang_Service SanPham_Service = new SanPhamInBanHang_Service();
    ArrayList<SanPhamViews> listSanPham = new ArrayList<>();
    HoaDon_Service sercive_hd = new HoaDon_Service();
    ArrayList<HoaDonViews> listHD = new ArrayList<>();
    private GioHangITF ghService = new GioHangIplm();
    private SanPhamITFinBanHang sv = new SanPhamInBanHang_Service();

    public void loadCbMau(ArrayList<String> listMau) {
        CbLocMau.removeAllItems();
        CbLocMau.addItem("Tất Cả");
        for (String x : listMau) {
            CbLocMau.addItem(x);
        }
    }

    public void loadCbSize(ArrayList<String> listSize) {
        cbLocSizze.removeAllItems();
        cbLocSizze.addItem("Tất Cả");
        for (String x : listSize) {
            cbLocSizze.addItem(x);
        }
    }

    public void loadDanhMuc(ArrayList<String> listMau) {
        cbDanhMuc.removeAllItems();
        cbDanhMuc.addItem("Tất Cả");
        for (String x : listMau) {
            cbDanhMuc.addItem(x);
        }
    }

    public void loadChatLieu(ArrayList<String> listMau) {
        cbChatLieu.removeAllItems();
        cbChatLieu.addItem("Tất Cả");
        for (String x : listMau) {
            cbChatLieu.addItem(x);
        }
    }

    public void loadKieuDang(ArrayList<String> listMau) {
        cbKieuDang.removeAllItems();
        cbKieuDang.addItem("Tất Cả");
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

    public void loadSP(ArrayList<SanPham> list) {
        modelSanPham = (DefaultTableModel) tblbangSanPham.getModel();
        modelSanPham.setRowCount(0);
        modelSanPham.setColumnIdentifiers(new String[]{"Mã Sản Phẩm", "Tên Sản Phẩm", "Danh Mục", "Màu", "Size", "Chất Liệu", "Kiểu Dáng", "Giá", "Số lượng"});
        for (SanPham s : list) {
            modelSanPham.addRow(new Object[]{s.getMaSP(), s.getTenSP(), s.getTenDanhMuc(), s.getTenMau(), s.getTenSize(), s.getTenChatLieu(), s.getTenKieuDang(), s.getGiaBan(), s.getSoLuong()});
        }
    }

    public void fillSP(ArrayList<SanPhamViews> list) {
        modelSanPham = (DefaultTableModel) tblbangSanPham.getModel();
        modelSanPham.setRowCount(0);
        listSanPham = (ArrayList<SanPhamViews>) SanPham_Service.getAllSanPham();
        for (SanPhamViews sanPhamViews : list) {
            modelSanPham.addRow(sanPhamViews.data());
        }
    }

    public void loadGH() {
        modelSanPham = (DefaultTableModel) tblGioHang.getModel();
        modelSanPham.setRowCount(0);
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
        btNhanVien = new javax.swing.JButton();
        btHoaDon = new javax.swing.JButton();
        btKhachHang = new javax.swing.JButton();
        btCuaHang = new javax.swing.JButton();
        btNhaCungCap = new javax.swing.JButton();
        btDoiMatKhau = new javax.swing.JButton();
        btDangXuat = new javax.swing.JButton();
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
        btThem = new javax.swing.JButton();
        btHuy = new javax.swing.JButton();
        btThanhToan = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        txtMaNv1 = new javax.swing.JTextField();
        btTimKiemHoaDon = new javax.swing.JButton();
        btTimKiemMaKH = new javax.swing.JButton();
        btTimKiemTenKH = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblbangSanPham = new javax.swing.JTable();
        txtTimKiemSP = new javax.swing.JTextField();
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

        btNhanVien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btNhanVien.setText("NHÂN VIÊN");
        btNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhanVienActionPerformed(evt);
            }
        });

        btHoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btHoaDon.setText("HÓA ĐƠN");
        btHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHoaDonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btCuaHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btNhaCungCap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btDoiMatKhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblHoaDonChoMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDonCho);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)))
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

        jButton33.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton33.setText("Thêm Khách Hàng");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Mã Hóa Đơn:");

        jLabel38.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel38.setText("Mã Khách Hàng:");

        jLabel39.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel39.setText("Tên Khách Hàng:");

        jLabel40.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel40.setText("SDT:");

        jLabel41.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel41.setText("Mã Nhân Viên:");

        jLabel42.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel42.setText("Ngày Tạo:");

        jLabel43.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel43.setText("Tổng Tiền:");

        jLabel44.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel44.setText("Tiền Khách Đưa:");

        txtMa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtMaKH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtTenKhachHang.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtSdt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtMaNv.setEditable(false);
        txtMaNv.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtngayTao.setEditable(false);
        txtngayTao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtTongTien.setEditable(false);
        txtTongTien.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        txtTiennKhachDua.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTiennKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiennKhachDuaActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel45.setText("Tiền Thừa:");

        txtTienThua.setEditable(false);
        txtTienThua.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btThem.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btHuy.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btHuy.setText("Hủy");
        btHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHuyActionPerformed(evt);
            }
        });

        btThanhToan.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btThanhToan.setText("Thanh Toán");
        btThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThanhToanActionPerformed(evt);
            }
        });

        jButton39.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton39.setText("Tạo Mới");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel46.setText("Tên Nhân Viên:");

        txtMaNv1.setEditable(false);
        txtMaNv1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btTimKiemHoaDon.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btTimKiemHoaDon.setText("Tìm Kiếm");
        btTimKiemHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemHoaDonActionPerformed(evt);
            }
        });

        btTimKiemMaKH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btTimKiemMaKH.setText("Tìm Kiếm");
        btTimKiemMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemMaKHActionPerformed(evt);
            }
        });

        btTimKiemTenKH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btTimKiemTenKH.setText("Tìm Kiếm");
        btTimKiemTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemTenKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jButton39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton33))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(btThem)
                .addGap(2, 2, 2)
                .addComponent(btHuy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(jLabel45)
                    .addComponent(jLabel43)
                    .addComponent(jLabel42)
                    .addComponent(jLabel44)
                    .addComponent(jLabel41)
                    .addComponent(jLabel40)
                    .addComponent(jLabel39)
                    .addComponent(jLabel10)
                    .addComponent(jLabel38))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSdt)
                    .addComponent(txtTiennKhachDua)
                    .addComponent(txtngayTao)
                    .addComponent(txtTongTien)
                    .addComponent(txtMaNv1)
                    .addComponent(txtTienThua)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btTimKiemHoaDon)
                            .addComponent(btTimKiemMaKH)
                            .addComponent(btTimKiemTenKH)))
                    .addComponent(txtMaNv)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton33)
                    .addComponent(jButton39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btTimKiemHoaDon, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTimKiemMaKH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel39)
                        .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btTimKiemTenKH, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtMaNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txtMaNv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem)
                    .addComponent(btHuy)
                    .addComponent(btThanhToan))
                .addContainerGap())
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

        txtTimKiemSP.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        cbLocSizze.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbLocSizze.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CbLocMau.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CbLocMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbChatLieu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbKieuDang.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbKieuDang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbDanhMuc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CbLocMau, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbLocSizze, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(txtTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CbLocMau)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbLocSizze, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        String ma = txtTimKiemSP.getText();
        String mau = CbLocMau.getSelectedItem().toString();
        String size = cbLocSizze.getSelectedItem().toString();
        String dm = cbDanhMuc.getSelectedItem().toString();
        String cl = cbChatLieu.getSelectedItem().toString();
        String kd = cbKieuDang.getSelectedItem().toString();
        SanPhaminBanHang_Repository x = new SanPhaminBanHang_Repository();
        try {
            if (ma.isEmpty()) {
                loadSP(x.getListLoc(mau, size, dm, cl, kd));
                if (tblbangSanPham.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Không có Sản Phẩm phù hợp");
                    return;
                }
                return;
            }
            loadSP(sv.getListTimKiem(ma));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblbangSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbangSanPhamMouseClicked
        // TODO add your handling code here:
        int row = tblbangSanPham.getSelectedRow();
        String ma = tblbangSanPham.getValueAt(row, 0).toString();
        int rowHD = tblHoaDonCho.getSelectedRow();
        if (rowHD == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn để thêm sản phẩm.");
            return;
        }
        String maHD = tblHoaDonCho.getValueAt(rowHD, 0).toString();
        GioHang gh = new GioHang();
        gh.setMaHD(maHD);
        gh.setMaSP(ma);
        try {
            int so = Integer.valueOf(JOptionPane.showInputDialog("Nhập Số Lượng bạn cần mua."));
            if (so <= 0) {
                JOptionPane.showMessageDialog(this, "Bạn phải nhập số lớn hơn 0");
                return;
            }
            if (checkMaSP(maHD) == false) {
                ghService.themGH(gh, 0);
            }
            ghService.tangSoLuongGH(ma, so, maHD);
            ghService.giamSoLuongSP(so, ma);
            loadDataTableGH(ghService.getListGH(maHD));
            fillDataSanPham();
            int i = 0;
            for (GioHang gioHang : ghService.getListGH(maHD)) {
                i = i + gioHang.tinhTong();
            }
            txtTongTien.setText(String.valueOf(i));
        } catch (Exception e) {
            e.getMessage();
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
        try {
            if (ghService.tangHD(ma, maHD)) {
                if (ghService.giamSP(ma)) {
                    loadDataTableGH(ghService.getListGH(maHD));
                    fillDataSanPham();
                    int i = 0;
                    for (GioHang gioHang : ghService.getListGH(maHD)) {
                        i = i + gioHang.tinhTong();
                    }
                    txtTongTien.setText(String.valueOf(i));
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
        int so = Integer.parseInt(tblGioHang.getValueAt(row, 2).toString());
        try {
            if (so == 1) {
                ghService.xoa(ma, maHD);
            }
            if (ghService.giamHD(ma, maHD)) {
                if (ghService.tangSP(ma)) {
                    loadDataTableGH(ghService.getListGH(maHD));
                    fillDataSanPham();
                    int i = 0;
                    for (GioHang gioHang : ghService.getListGH(maHD)) {
                        i = i + gioHang.tinhTong();
                    }
                    txtTongTien.setText(String.valueOf(i));
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
        int rowHD = tblHoaDonCho.getSelectedRow();
        String maHD = tblHoaDonCho.getValueAt(rowHD, 0).toString();
        if (rowHD == -1) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại do Hóa Đơn của Giỏ Hàng này chưa được tạo.");
            return;
        }
        int sl = Integer.parseInt(tblGioHang.getValueAt(row, 2).toString());
        try {
            if (ghService.xoa(ma, maHD)) {
                ghService.tangSoLuongSP(sl, ma);
                loadDataTableGH(ghService.getListGH(maHD));
                fillDataSanPham();
                int i = 0;
                for (GioHang gioHang : ghService.getListGH(maHD)) {
                    i = i + gioHang.tinhTong();
                }
                txtTongTien.setText(String.valueOf(i));
            }
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
        int i = 0;

        try {
            loadDataTableGH(ghService.getListGH(ma));
            for (GioHang gioHang : ghService.getListGH(ma)) {
                i = i + gioHang.tinhTong();
            }
            txtTongTien.setText(String.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtMa.setText(tblHoaDonCho.getValueAt(row, 0).toString());
        List<ThanhToan> hd = BanHang.select(txtMa.getText());
        for (ThanhToan hoaDonChiTiet : hd) {
            txtMa.setText(tblHoaDonCho.getValueAt(row, 0).toString());
            txtMaKH.setText(hoaDonChiTiet.getMaKH());
            txtngayTao.setText(hoaDonChiTiet.getNgayTao());

        }
        String MaKh = txtMaKH.getText();
        List<KhachHangMode> ListKh = Kh.select1(MaKh);
        for (KhachHangMode khachHangMode : ListKh) {
            txtTenKhachHang.setText(khachHangMode.getHoVaTen());
            txtSdt.setText(khachHangMode.getSdt());
        }
        txtTiennKhachDua.setText("");
        txtTienThua.setText("");
    }//GEN-LAST:event_tblHoaDonChoMouseClicked


    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        // TODO add your handling code here:
        txtngayTao.setText("");
        try {

            String makh = txtMaKH.getText();
            String TenKhachHang = txtTenKhachHang.getText();
            String MaND = txtMaNv.getText();
            String sdt = txtSdt.getText();
            String TrangThai = "Chưa Thanh Toán";
//            String NgayTao = txtngayTao.getText();
            String TienKhachDua = txtTiennKhachDua.getText();

            String TienThua = txtTienThua.getText();

            if (makh.trim().isEmpty()
                    || sdt.trim().isEmpty()
                    || MaND.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "có trường trống vui lòng nhập lại");
                return;
            }
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            Date ht = new Date();
            String NgayTao = fm.format(ht);
            try {

                BanHang.insert(makh, MaND, NgayTao, TrangThai);
                fillDataHoaDon();
                txtMa.setText("");
                txtMaKH.setText("");
                txtTenKhachHang.setText("");
                txtSdt.setText("");
                txtngayTao.setText("");
                txtTongTien.setText("");
                txtTiennKhachDua.setText("");
                txtTienThua.setText("");
            } catch (Exception e) {
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Vui Lòng nhập đúng định dạng ngày tạo (yyyy-MM-dd) và tiền là số");
            return;
        }
    }//GEN-LAST:event_btThemActionPerformed

    private void btHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyActionPerformed
        // TODO add your handling code here:
        int row = tblHoaDonCho.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Chưa Chọn Hóa Đơn");
            return;
        } else {
            String maHd = txtMa.getText();
            String trangthai = "Đã Hủy";
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            Date ht = new Date();
            String ngayHuy = fm.format(ht);
            try {
                BanHang.HuyHoaDon(maHd, ngayHuy, trangthai);
                modelSanPham.setRowCount(0);
                fillDataHoaDon();
                fillDataSanPham();
                txtMa.setText("");
                txtMaKH.setText("");
                txtTenKhachHang.setText("");
                txtSdt.setText("");
                txtngayTao.setText("");
                txtTongTien.setText("");
                txtTiennKhachDua.setText("");
                txtTienThua.setText("");
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btHuyActionPerformed

    private void btThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThanhToanActionPerformed
        // TODO add your handling code here:
        int row = tblHoaDonCho.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Chưa Chọn Hóa Đơn");
            return;
        } else {
            String maHd = txtMa.getText();
            String trangthai = "Đã Thanh Toán";
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            Date ht = new Date();
            String NgayThanhToan = fm.format(ht);
            String TongTien = txtTongTien.getText();
            String TienKhachDua = txtTiennKhachDua.getText();
            String TienThua = txtTienThua.getText();
            try {
                int tong = Integer.parseInt(TongTien);
                int dua = Integer.parseInt(TienKhachDua);
                txtTienThua.setText(String.valueOf(dua - tong));
                if (tong == 0) {
                    JOptionPane.showMessageDialog(null, "Giá Sản Phẩm Bằng 0 Không Thể Thanh Toán");
                    return;
                }

                if (dua - tong < 0) {
                    JOptionPane.showMessageDialog(null, "Khách Không Đưa Đủ Tiền Lỗi");
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Số Ở Tiền Khách Đưa");
                return;
            }

            try {
                BanHang.ThanhToanHoa(maHd, NgayThanhToan, trangthai);
                modelSanPham.setRowCount(0);
                fillDataHoaDon();
                fillDataSanPham();
                txtMa.setText("");
                txtMaKH.setText("");
                txtTenKhachHang.setText("");
                txtSdt.setText("");
                txtngayTao.setText("");
                txtTongTien.setText("");
                txtTiennKhachDua.setText("");
                txtTienThua.setText("");
            } catch (Exception e) {
            }
        }

    }//GEN-LAST:event_btThanhToanActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        // TODO add your handling code here:
        modelSanPham = (DefaultTableModel) tblGioHang.getModel();
        modelSanPham.setRowCount(0);
        fillDataHoaDon();
        fillDataSanPham();
        txtMa.setText("");
        txtMaKH.setText("");
        txtTenKhachHang.setText("");
        txtSdt.setText("");
        txtngayTao.setText("");
        txtTongTien.setText("");
        txtTiennKhachDua.setText("");
        txtTienThua.setText("");
    }//GEN-LAST:event_jButton39ActionPerformed


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

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
        int row = tblHoaDonCho.getSelectedRow();
        int i = 0;

        String ma = tblHoaDonCho.getValueAt(row, 0).toString();
        for (GioHang gioHang : ghService.getListGH(ma)) {
            i = i + gioHang.tinhTong();
        }
        txtTongTien.setText(String.valueOf(i));
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void txtTiennKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiennKhachDuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiennKhachDuaActionPerformed

    private void btHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHoaDonActionPerformed
        // TODO add your handling code here:
        FormHoaDon x = new FormHoaDon();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btHoaDonActionPerformed

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

    private void btTimKiemHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemHoaDonActionPerformed
        // TODO add your handling code here:
        int i = 0;

        try {
            loadDataTableGH(ghService.getListGH(txtMa.getText()));
            for (GioHang gioHang : ghService.getListGH(txtMa.getText())) {
                i = i + gioHang.tinhTong();
            }
            txtTongTien.setText(String.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<ThanhToan> hd = BanHang.select(txtMa.getText());
        if (hd.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hóa đơn không tồn tại");
            return;
        }
        for (ThanhToan hoaDonChiTiet : hd) {
            if (hoaDonChiTiet.getTrangThai().equalsIgnoreCase("Chưa Thanh Toán")) {
                txtMaKH.setText(hoaDonChiTiet.getMaKH());
                txtngayTao.setText(hoaDonChiTiet.getNgayTao());
                String MaKh = txtMaKH.getText();
                List<KhachHangMode> ListKh = Kh.select1(MaKh);
                for (KhachHangMode khachHangMode : ListKh) {
                    txtTenKhachHang.setText(khachHangMode.getHoVaTen());
                    txtSdt.setText(khachHangMode.getSdt());
                }
               
                txtTiennKhachDua.setText("");
                txtTienThua.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Hóa Đơn Đã Thanh Toán Hoặc Đã Hủy");
                modelSanPham.setRowCount(0);
                fillDataHoaDon();
                fillDataSanPham();
                txtMa.setText("");
                txtMaKH.setText("");
                txtTenKhachHang.setText("");
                txtSdt.setText("");
                txtngayTao.setText("");
                txtTongTien.setText("");
                txtTiennKhachDua.setText("");
                txtTienThua.setText("");
                return;
            }
        }

    }//GEN-LAST:event_btTimKiemHoaDonActionPerformed

    private void btTimKiemMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemMaKHActionPerformed
        // TODO add your handling code here:
        String MaKh = txtMaKH.getText();
        List<KhachHangMode> ListKh = Kh.select1(MaKh);
        if (ListKh.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Khách hàng không tồn tại");
            return;
        }
        for (KhachHangMode khachHangMode : ListKh) {
            txtTenKhachHang.setText(khachHangMode.getHoVaTen());
            txtSdt.setText(khachHangMode.getSdt());
        }

    }//GEN-LAST:event_btTimKiemMaKHActionPerformed

    private void btTimKiemTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemTenKHActionPerformed
        // TODO add your handling code here:
        String ten = txtTenKhachHang.getText();
        List<KhachHangMode> ListKh = Kh.selectTen(ten);
        if (ListKh.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Khách hàng không tồn tại");
            return;
        }
        for (KhachHangMode khachHangMode : ListKh) {
            txtMaKH.setText(khachHangMode.getMaKH());
            txtSdt.setText(khachHangMode.getSdt());
        }
    }//GEN-LAST:event_btTimKiemTenKHActionPerformed

    private void tblHoaDonChoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonChoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblHoaDonChoMouseEntered
    void LoatNV() {
        String a = n.getTen();
        List<DangNhapMoDel> dm = dn.Tk(a);
        for (DangNhapMoDel dangNhapMoDel : dm) {
            txtMaNv.setText(dangNhapMoDel.getMaNv());
            txtMaNv1.setText(dangNhapMoDel.getHoVaTen());
        }
    }

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
    private javax.swing.JButton btCuaHang;
    private javax.swing.JButton btDangXuat;
    private javax.swing.JButton btDoiMatKhau;
    private javax.swing.JButton btGiam;
    private javax.swing.JButton btHoaDon;
    private javax.swing.JButton btHuy;
    private javax.swing.JButton btKhachHang;
    private javax.swing.JButton btNhaCungCap;
    private javax.swing.JButton btNhanVien;
    private javax.swing.JButton btSanPham;
    private javax.swing.JButton btTang;
    private javax.swing.JButton btThanhToan;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btTimKiemHoaDon;
    private javax.swing.JButton btTimKiemMaKH;
    private javax.swing.JButton btTimKiemTenKH;
    private javax.swing.JButton btXoaSP;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbChatLieu;
    private javax.swing.JComboBox<String> cbDanhMuc;
    private javax.swing.JComboBox<String> cbKieuDang;
    private javax.swing.JComboBox<String> cbLocSizze;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton39;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
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
    private javax.swing.JTextField txtMaNv1;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTiennKhachDua;
    private javax.swing.JTextField txtTimKiemSP;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtngayTao;
    // End of variables declaration//GEN-END:variables
}
