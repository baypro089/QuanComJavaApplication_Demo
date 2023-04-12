package main.java.GUI;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.*;

import com.formdev.flatlaf.FlatLightLaf;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class StaffsGUI extends JPanel implements MouseListener, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentField;
	private JPanel staffListPanel;
	private JTable staffTable;
	private DefaultTableModel detailTableModel;
	private JScrollPane staffScrollPane;
	private DefaultTableCellRenderer centerRenderer;
	private JPanel searchPanel;
	private JLabel staffPhoto;
	private JLabel lblNewLabel;
	private JTextField IdStaffTxt;
	private JTextField nameStaffTxt;
	private JTextField addressStaffTxt;
	private JTextField phoneNumbTxt;
	private JTextField textField;
	private JButton searchButton;
	private JPanel staffInfoPanel;
	private JButton addStaffBtn;
	private JButton fixStaffBtn;
	private JButton delStaffBtn;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton maleRadioBtn;
	private JRadioButton femaleRadioBtn;
	/**
	 * Create the panel.
	 */
	public StaffsGUI() {
		init();
	}
	private void init() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1080, 700));
		
		centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		//End
		
		    
		// Panel table
		contentField = new JPanel(null);
			
		this.add(contentField, BorderLayout.CENTER);
	   
        //Panel table nhan vien
        staffListPanel = new JPanel(null);
        staffListPanel.setBackground(new Color(30, 144, 255));
        staffListPanel.setBounds(0, 380, 1080, 320);
        
        contentField.add(staffListPanel);
        
        detailTableModel = new DefaultTableModel(new Object[]{"Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày sinh", "Số điện thoại", "Địa chỉ", "Chức vụ"}, 0);		
        staffTable = new JTable(detailTableModel);
        staffTable.setFont(new Font("Arial", Font.PLAIN, 14));
        staffTable.setDefaultRenderer(String.class, centerRenderer);
	    staffTable.setRowHeight(30);
	    for(int i = 0; i < 7; i++) {
	    	if(i == 1 || i == 5) {
	    		staffTable.getColumnModel().getColumn(i).setPreferredWidth(150);
	    		staffTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	    	}
	    	else {
	    		//staffTable.getColumnModel().getColumn(i).setPreferredWidth(125);
	    		staffTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	    	}
	    }
	    
        staffScrollPane = new JScrollPane(staffTable);
        staffScrollPane.setBounds(5, 5, 1070, 310);
        staffListPanel.add(staffScrollPane);
        
        staffInfoPanel = new JPanel();
        staffInfoPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        staffInfoPanel.setBounds(0, 50, 800, 330);
        contentField.add(staffInfoPanel);
        staffInfoPanel.setLayout(null);
        
        staffPhoto = new JLabel("Ảnh");
        staffPhoto.setBackground(new Color(255, 255, 255));
        staffPhoto.setHorizontalAlignment(SwingConstants.CENTER);
        staffPhoto.setBounds(40, 50, 140, 140);
        staffPhoto.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        staffInfoPanel.add(staffPhoto);
        
        lblNewLabel = new JLabel("Thông tin nhân viên");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(306, 0, 150, 40);
        staffInfoPanel.add(lblNewLabel);
        
        JLabel idsStaffLabel = new JLabel("Mã NV");
        idsStaffLabel.setFont(new Font("Arial", Font.BOLD, 13));
        idsStaffLabel.setBounds(270, 50, 70, 30);
        staffInfoPanel.add(idsStaffLabel);
        
        IdStaffTxt = new JTextField();
        IdStaffTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        IdStaffTxt.setColumns(10);
        IdStaffTxt.setBounds(340, 50, 170, 30);
        staffInfoPanel.add(IdStaffTxt);
        
        nameStaffTxt = new JTextField();
        nameStaffTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        nameStaffTxt.setColumns(10);
        nameStaffTxt.setBounds(600, 50, 170, 30);
        staffInfoPanel.add(nameStaffTxt);
        
        JLabel nameStaffLabel = new JLabel("Tên NV");
        nameStaffLabel.setFont(new Font("Arial", Font.BOLD, 13));
        nameStaffLabel.setBounds(530, 50, 70, 30);
        staffInfoPanel.add(nameStaffLabel);
        
        JLabel addressStaffLabel = new JLabel("Địa chỉ");
        addressStaffLabel.setFont(new Font("Arial", Font.BOLD, 13));
        addressStaffLabel.setBounds(530, 150, 70, 30);
        staffInfoPanel.add(addressStaffLabel);
        
        addressStaffTxt = new JTextField();
        addressStaffTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        addressStaffTxt.setColumns(10);
        addressStaffTxt.setBounds(600, 150, 170, 30);
        staffInfoPanel.add(addressStaffTxt);
        
        JLabel phoneNumbLabel = new JLabel("SĐT");
        phoneNumbLabel.setFont(new Font("Arial", Font.BOLD, 13));
        phoneNumbLabel.setBounds(270, 150, 70, 30);
        staffInfoPanel.add(phoneNumbLabel);
        
        phoneNumbTxt = new JTextField();
        phoneNumbTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        phoneNumbTxt.setColumns(10);
        phoneNumbTxt.setBounds(340, 150, 170, 30);
        staffInfoPanel.add(phoneNumbTxt);
        
        addStaffBtn = new JButton("Thêm");      
        addStaffBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(IdStaffTxt.getText().equals("") || nameStaffTxt.getText().equals("") || addressStaffTxt.getText().equals("") || phoneNumbTxt.getText().equals("")) {
        			JOptionPane.showMessageDialog(null, "Thông tin chưa đầy đủ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "Đã thêm nhân viên!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
        });
        addStaffBtn.setFont(new Font("Arial", Font.PLAIN, 13)); 
        addStaffBtn.setBounds(270, 280, 90, 35);
        staffInfoPanel.add(addStaffBtn);
        
        fixStaffBtn = new JButton("Cập nhật");       
        fixStaffBtn.setFont(new Font("Arial", Font.PLAIN, 13));       
        fixStaffBtn.setBounds(358, 280, 90, 35);
        staffInfoPanel.add(fixStaffBtn);
        
        delStaffBtn = new JButton("Xóa");     
        delStaffBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int decide = JOptionPane.showConfirmDialog(null, "Xác nhận muốn xóa?", "Thông báo", JOptionPane.YES_NO_OPTION);
        		//xoa o day
        		if(decide == 0) {
        			JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
        });
        delStaffBtn.setFont(new Font("Arial", Font.PLAIN, 13));       
        delStaffBtn.setBounds(445, 280, 90, 35);
        staffInfoPanel.add(delStaffBtn);
        
        JButton browsePhoto = new JButton("Chọn");
        browsePhoto.setBounds(70, 200, 80, 30);
        staffInfoPanel.add(browsePhoto);
        
        JLabel lblGiiTnh = new JLabel("Giới tính");
        lblGiiTnh.setFont(new Font("Arial", Font.BOLD, 13));
        lblGiiTnh.setBounds(270, 100, 70, 30);
        staffInfoPanel.add(lblGiiTnh);
        
        maleRadioBtn = new JRadioButton("Nam");
        buttonGroup.add(maleRadioBtn);
        maleRadioBtn.setBounds(340, 100, 60, 30);
        staffInfoPanel.add(maleRadioBtn);
        
        femaleRadioBtn = new JRadioButton("Nữ");
        buttonGroup.add(femaleRadioBtn);
        femaleRadioBtn.setBounds(400, 100, 60, 30);
        staffInfoPanel.add(femaleRadioBtn);
        
        JLabel staffDateLabel = new JLabel("Ngày sinh");
        staffDateLabel.setFont(new Font("Arial", Font.BOLD, 13));
        staffDateLabel.setBounds(530, 100, 70, 30);
        staffInfoPanel.add(staffDateLabel);
        
        JComboBox<String> positioncbB = new JComboBox<>();
        positioncbB.setModel(new DefaultComboBoxModel<String>(new String[] {"Admin", "Quản lí", "Nhân viên"}));
        positioncbB.setBounds(340, 200, 90, 30);
        staffInfoPanel.add(positioncbB);
        
        JLabel lblChcV = new JLabel("Chức vụ");
        lblChcV.setFont(new Font("Arial", Font.BOLD, 13));
        lblChcV.setBounds(270, 200, 70, 30);
        staffInfoPanel.add(lblChcV);
        
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(600, 100, 170, 30);
        staffInfoPanel.add(dateChooser);
        
        JPanel bigNamePanel = new JPanel();
        bigNamePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        bigNamePanel.setBounds(0, 0, 1080, 50);
        contentField.add(bigNamePanel);
        bigNamePanel.setLayout(null);
        
        JLabel staffLabel = new JLabel("NHÂN VIÊN");
        staffLabel.setBounds(240, 0, 600, 50);
        bigNamePanel.add(staffLabel);
        staffLabel.setHorizontalAlignment(SwingConstants.CENTER);
        staffLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        searchPanel = new JPanel();
        searchPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        searchPanel.setBounds(800, 50, 280, 330);
        contentField.add(searchPanel);
        searchPanel.setLayout(null);
        
        JLabel lblTmKim = new JLabel("Tìm kiếm");
        lblTmKim.setHorizontalAlignment(SwingConstants.CENTER);
        lblTmKim.setFont(new Font("Arial", Font.BOLD, 15));
        lblTmKim.setBounds(80, 80, 120, 40);
        searchPanel.add(lblTmKim);
        
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 13));
        textField.setColumns(10);
        textField.setBounds(55, 131, 170, 30);
        searchPanel.add(textField);
        
        searchButton = new JButton("OK");
        searchButton.setFont(new Font("Arial", Font.PLAIN, 13));
        searchButton.setBounds(90, 180, 100, 30);
        searchPanel.add(searchButton);
		//End
		
		
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}