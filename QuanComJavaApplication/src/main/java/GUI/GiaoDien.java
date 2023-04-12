package main.java.GUI;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoNatureGreenIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatMonokaiProIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GiaoDien extends JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TitlePanel title;
    private JPanel leftMenu;
    private JPanel mainContent;
    static CardLayout cardLayout;
    static JPanel switchPanel;
	static JPanel functionPanel1;
    static JPanel functionPanel2;
    static JPanel functionPanel3;
    static JPanel functionPanel4;
    static JPanel functionPanel5;
    static JPanel functionPanel6;
    static JPanel functionPanel7;
    static JPanel functionPanel8;
    static DetailOrdersGUI taoDon;
    static ReceivingGUI phieuNhap;
    static DetailReceivingGUI taoPhieu;
    static SupplierGUI supplier;
    static StaffsGUI staffs;
    public GiaoDien() {
        init();
        this.setVisible(true);
    }
    
    public void init() {
        this.setSize(1280, 732);
        this.setLocationRelativeTo(null);
		this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Giao diện bán hàng");

        //Tieu de
		title = new TitlePanel(this);
        title.setBackground(Color.darkGray);
        title.setPreferredSize(new Dimension(1280,32));
        title.setOpaque(true);
        //---------------------------------------------------------------


        //Menu ben trai + logo
        
    
        //Menu ben trai
        leftMenu = new LeftMenu();
        leftMenu.setPreferredSize(new Dimension(200, 700));
        
		//---------------------------------------------------------------
        mainContent = new JPanel(new BorderLayout());
        mainContent.setPreferredSize(new Dimension(1080, 700));
        
        
        cardLayout = new CardLayout();
        switchPanel = new JPanel(cardLayout);
        switchPanel.setPreferredSize(new Dimension(1080, 700));
        mainContent.add(switchPanel);
        //Tạo đơn
        functionPanel1 = new JPanel(null);
        functionPanel1.setPreferredSize(new Dimension(1080, 700));
        switchPanel.add(functionPanel1, "func1");
        taoDon = new DetailOrdersGUI();
        taoDon.setBounds(0, 0, 1080, 700);
        functionPanel1.add(taoDon);
        
        //Tạo phiếu nhập
        functionPanel2 = new JPanel(null);
        functionPanel2.setPreferredSize(new Dimension(1080, 700));
        phieuNhap = new ReceivingGUI();      
        phieuNhap.setBounds(0, 0, 1080, 700);
        functionPanel2.add(phieuNhap);     
        taoPhieu = new DetailReceivingGUI();
        taoPhieu.setBounds(0, 0, 1080, 700);
        functionPanel2.add(GiaoDien.taoPhieu);
        taoPhieu.setVisible(false);
        
        switchPanel.add(functionPanel2, "func2");   
        
        //chức năng 3
        functionPanel3 = new JPanel(null);
        functionPanel3.setPreferredSize(new Dimension(1080, 700));
        
        switchPanel.add(functionPanel3, "func3");
        
        //chức năng 4
        functionPanel4 = new JPanel(null);
        switchPanel.add(functionPanel4, "fun4");
        
        //chức năng 5
        functionPanel5 = new JPanel(null);
        switchPanel.add(functionPanel5, "func5");
        
        //chức năng 6
        functionPanel6 = new JPanel(null);
        switchPanel.add(functionPanel6, "func6");
        
        //Nhân viên
        functionPanel7 = new JPanel(null);
        functionPanel7.setPreferredSize(new Dimension(1080, 700));
        staffs = new StaffsGUI();
        staffs.setBounds(0, 0, 1080, 700);
        functionPanel7.add(staffs);
        switchPanel.add(functionPanel7, "func7");
        
        //Nhà cung cấp
        functionPanel8 = new JPanel(null);
        functionPanel8.setPreferredSize(new Dimension(1080, 700));
        supplier = new SupplierGUI();
        supplier.setBounds(0, 0, 1080, 700);
        functionPanel8.add(supplier);
        switchPanel.add(functionPanel8, "func8");
        
        
        //---------------------------------------------------------------








        this.setLayout(new BorderLayout());
        this.add(title,BorderLayout.NORTH);
        this.add(leftMenu, BorderLayout.WEST);
        this.add(mainContent, BorderLayout.CENTER);
        
        
    }

    
    public static void main(String[] args) {
    	try {
    		FlatSolarizedLightIJTheme.setup();
    	} catch( Exception ex ) {
    	    System.err.println( "Failed to initialize LaF" );
    	}
		JFrame a = new GiaoDien();		
	}
}