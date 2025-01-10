package com.mystou.javadb.v;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.mystou.javadb.db.Database;

public class BooksView extends JFrame {
    private JTextField txtBookName;
    private JButton btnAdd, btnEdit, btnDelete;
    private JComboBox<String> comboBooks;

    public BooksView() {
        setTitle("ฐานข้อมูลหนังสือ");
        setSize(450, 350); // ปรับขนาด JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // เพิ่มไอคอนใน JFrame
        setIconImage(new ImageIcon("src/com/mystou/javadb/img/logo.png").getImage());

        // พื้นหลังสีแดงเข้ม
        getContentPane().setBackground(new Color(128, 0, 0));

        // ฟอนต์ภาษาไทย
        Font thaiFont = new Font("Tahoma", Font.PLAIN, 14);

        // ตั้งค่า UIFont สำหรับ JOptionPane
        setUIFont(thaiFont);

        // รายชื่อหนังสือ
        JLabel lblBookList = new JLabel("รายชื่อหนังสือ:");
        lblBookList.setFont(thaiFont);
        lblBookList.setForeground(Color.YELLOW);
        lblBookList.setBounds(30, 10, 120, 25);

        comboBooks = new JComboBox<>();
        comboBooks.setFont(thaiFont);
        comboBooks.setBounds(150, 10, 250, 25);

        // Panel "จัดการข้อมูล"
        JPanel managePanel = new JPanel();
        managePanel.setBackground(new Color(224, 255, 255)); // สีฟ้า
        TitledBorder titledBorder = BorderFactory.createTitledBorder("จัดการข้อมูล");
        titledBorder.setTitleFont(thaiFont);
        managePanel.setBorder(titledBorder);

        // ปรับขนาด Panel
        managePanel.setBounds(30, 50, 380, 220); // เพิ่มความกว้างและความสูง
        managePanel.setLayout(null);

        // TextField สำหรับชื่อหนังสือ
        txtBookName = new JTextField();
        txtBookName.setFont(thaiFont);
        txtBookName.setBounds(20, 30, 340, 30); // ขยายความกว้าง TextField
        managePanel.add(txtBookName);

        // ปุ่มเพิ่ม
        btnAdd = new JButton("เพิ่ม", resizeIcon("src/com/mystou/javadb/img/add.png", 30, 30));
        btnAdd.setFont(thaiFont);
        btnAdd.setBounds(20, 80, 100, 40); // ขยายปุ่ม
        btnAdd.addActionListener(e -> {
            String bookName = txtBookName.getText();
            if (bookName.isEmpty()) {
                ImageIcon warningIcon = new ImageIcon("src/com/mystou/javadb/img/warning.png");
                JOptionPane.showMessageDialog(this,
                        "กรุณากรอกชื่อหนังสือก่อนเพิ่ม!",
                        "ข้อผิดพลาด",
                        JOptionPane.WARNING_MESSAGE,
                        warningIcon);
                return;
            }

            try {
                Database db = new Database();
                if (db.addBook(bookName)) {
                    ImageIcon successIcon = new ImageIcon("src/com/mystou/javadb/img/success.png");
                    JOptionPane.showMessageDialog(this,
                            "เพิ่มหนังสือสำเร็จ!",
                            "การทำงานสำเร็จ",
                            JOptionPane.INFORMATION_MESSAGE,
                            successIcon);
                    comboBooks.addItem(bookName);
                    txtBookName.setText("");
                } else {
                    ImageIcon errorIcon = new ImageIcon("src/com/mystou/javadb/img/error.png");
                    JOptionPane.showMessageDialog(this,
                            "ไม่สามารถเพิ่มหนังสือได้!",
                            "ข้อผิดพลาด",
                            JOptionPane.ERROR_MESSAGE,
                            errorIcon);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // ปุ่มแก้ไข
        btnEdit = new JButton("แก้ไข", resizeIcon("src/com/mystou/javadb/img/edit.png", 30, 30));
        btnEdit.setFont(thaiFont);
        btnEdit.setBounds(140, 80, 100, 40); // ขยายปุ่ม
        btnEdit.addActionListener(e -> {
            String selectedBook = (String) comboBooks.getSelectedItem();
            String newBookName = txtBookName.getText();

            if (selectedBook == null) {
                ImageIcon warningIcon = new ImageIcon("src/com/mystou/javadb/img/warning.png");
                JOptionPane.showMessageDialog(this,
                        "กรุณาเลือกหนังสือที่ต้องการแก้ไข!",
                        "ข้อผิดพลาด",
                        JOptionPane.WARNING_MESSAGE,
                        warningIcon);
                return;
            }

            if (newBookName.isEmpty()) {
                ImageIcon warningIcon = new ImageIcon("src/com/mystou/javadb/img/warning.png");
                JOptionPane.showMessageDialog(this,
                        "กรุณากรอกชื่อใหม่!",
                        "ข้อผิดพลาด",
                        JOptionPane.WARNING_MESSAGE,
                        warningIcon);
                return;
            }

            try {
                Database db = new Database();
                if (db.updateBook(selectedBook, newBookName)) {
                    ImageIcon successIcon = new ImageIcon("src/com/mystou/javadb/img/success.png");
                    JOptionPane.showMessageDialog(this,
                            "แก้ไขข้อมูลสำเร็จ!",
                            "การทำงานสำเร็จ",
                            JOptionPane.INFORMATION_MESSAGE,
                            successIcon);

                    comboBooks.removeItem(selectedBook);
                    comboBooks.addItem(newBookName);
                    comboBooks.setSelectedItem(newBookName);

                    txtBookName.setText("");
                } else {
                    ImageIcon errorIcon = new ImageIcon("src/com/mystou/javadb/img/error.png");
                    JOptionPane.showMessageDialog(this,
                            "ไม่สามารถแก้ไขข้อมูลได้!",
                            "ข้อผิดพลาด",
                            JOptionPane.ERROR_MESSAGE,
                            errorIcon);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // ปุ่มลบ
        btnDelete = new JButton("ลบ", resizeIcon("src/com/mystou/javadb/img/delete.png", 30, 30));
        btnDelete.setFont(thaiFont);
        btnDelete.setBounds(260, 80, 100, 40); // ขยายปุ่ม
        btnDelete.addActionListener(e -> {
            String selectedBook = (String) comboBooks.getSelectedItem();
            if (selectedBook == null) {
                ImageIcon warningIcon = new ImageIcon("src/com/mystou/javadb/img/warning.png");
                JOptionPane.showMessageDialog(this,
                        "กรุณาเลือกหนังสือที่ต้องการลบ!",
                        "ข้อผิดพลาด",
                        JOptionPane.WARNING_MESSAGE,
                        warningIcon);
                return;
            }
            try {
                Database db = new Database();
                if (db.deleteBook(selectedBook)) {
                    ImageIcon successIcon = new ImageIcon("src/com/mystou/javadb/img/success.png");
                    JOptionPane.showMessageDialog(this,
                            "ลบหนังสือสำเร็จ!",
                            "การทำงานสำเร็จ",
                            JOptionPane.INFORMATION_MESSAGE,
                            successIcon);
                    comboBooks.removeItem(selectedBook);
                } else {
                    ImageIcon errorIcon = new ImageIcon("src/com/mystou/javadb/img/error.png");
                    JOptionPane.showMessageDialog(this,
                            "ไม่สามารถลบหนังสือได้!",
                            "ข้อผิดพลาด",
                            JOptionPane.ERROR_MESSAGE,
                            errorIcon);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        managePanel.add(btnAdd);
        managePanel.add(btnEdit);
        managePanel.add(btnDelete);

        // เพิ่ม Components ลงในหน้าต่าง
        add(lblBookList);
        add(comboBooks);
        add(managePanel);

        loadBooks();
        setVisible(true);
    }

    private void loadBooks() {
        try {
            Database db = new Database();
            String sql = "SELECT book_name FROM books";
            ResultSet rs = db.executeQuery(sql);

            while (rs.next()) {
                comboBooks.addItem(rs.getString("book_name"));
            }
            rs.close();
        } catch (Exception e) {
            ImageIcon errorIcon = new ImageIcon("src/com/mystou/javadb/img/error.png");
            JOptionPane.showMessageDialog(this,
                    "ไม่สามารถดึงข้อมูลจากฐานข้อมูลได้!",
                    "ข้อผิดพลาด",
                    JOptionPane.ERROR_MESSAGE,
                    errorIcon);
            e.printStackTrace();
        }
    }

    private void setUIFont(Font font) {
        UIManager.put("OptionPane.messageFont", font);
        UIManager.put("OptionPane.buttonFont", font);
    }

    private ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    public static void main(String[] args) {
        new BooksView();
    }
}
