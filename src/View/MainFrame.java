package View;

import Model.TableModel;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class MainFrame {
    public int cnt = 0;
    
    private JFrame jfrm2;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JMenu jmnF, jmnV;
    private JMenuItem jmiExit, jmiStandTheme, jmiAnothTheme;
    private JMenuBar jmb;
    private JComboBox cbFirst;
    private JPanel jpnl2, jpnl3;
    private JLabel jlblChTable;
    private Font fntLbl, fntMenu;
    private JTable jtbl;
    private JScrollPane jsp;
    private JPopupMenu jpm; 
    private JMenuItem jmiInsert;
    private JLabel jlblMan;
    private JButton jbtSalary;
    private JLabel jlblSalary;
    private JTextField jtfSalary;
    private JLabel jlblSalaryRes;
    private JButton jbtDeptName;
    private JLabel jlblDeptName;
    private JTextField jtfDeptName;
    private JLabel jlblDeptNameRes;
    private JButton jbtSumOrd;
    private JLabel jlblSumOrd;
    private JTextField jtfSumOrd;
    private JLabel jlblSumOrdRes;
    private JButton jbtCreditRating;
    private JLabel jlblCreditRating;
    private JTextField jtfCreditRating;
    private JLabel jlblCreditRatingRes;
    
    
    private JLabel artLbl;
    
    public MainFrame() throws SQLException{
        jfrm2 = new JFrame("DataBaseGUI");
        jfrm2.setLayout(null);                                                  //отключение менеджера раскладки
        jfrm2.setPreferredSize(new Dimension(screenSize.width, screenSize.height));
        jfrm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jpnl2 = new JPanel();
        jpnl2.setLayout(null);
        jpnl2.setBounds(0, 0, screenSize.width / 2 - 200, screenSize.height);
        jpnl2.setBackground(new Color(0, 0, 75));
        
        jpnl3 = new JPanel();
        jpnl3.setLayout(null);
        jpnl3.setBounds(screenSize.width / 2 - 200, 0, screenSize.width / 2 + 200, screenSize.height);
        jpnl3.setBackground(new Color(0, 0, 50));
        
        fntLbl = new Font("TimesRoman", Font.BOLD, 16);
        
        jlblChTable = new JLabel("Выберите таблицу:");
        jlblChTable.setBounds(100, 75, 200, 20);
        jlblChTable.setFont(fntLbl);
        jlblChTable.setForeground(Color.white);
        
        fntMenu = new Font("Verdana", Font.PLAIN, 11);
        jmb = new JMenuBar();
        jmnF = new JMenu("Файл");
        jmnV = new JMenu("Вид");

        
        jmiExit = new JMenuItem("Выйти");
        jmiExit.setFont(fntMenu);
        
        jmiStandTheme = new JMenuItem("Стандартная тема");
        jmiStandTheme.setFont(fntMenu);
        jmiStandTheme.setForeground(new Color(0, 0, 50));
        
        jmiAnothTheme = new JMenuItem("Светлая тема");
        jmiAnothTheme.setFont(fntMenu);
 
        
        jmnF.add(jmiExit);
        jmnV.add(jmiStandTheme);
        jmnV.add(jmiAnothTheme);
        jmb.add(jmnF);
        jmb.add(jmnV);
        
        jmiExit.addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent e) {
                jfrm2.dispose();
                Model.AuthorizationModel model = new Model.AuthorizationModel();
                View.AuthorizationFrame frame = new View.AuthorizationFrame();
                Controller.AuthorizationController cont = new Controller.AuthorizationController(model, frame);
                cont.initController();
            }           
        });
        
        ImageIcon artIcon = new ImageIcon("art.jpg");

        artLbl = new JLabel();
        
        artLbl.setIcon(artIcon);
        artLbl.setBounds(screenSize.width/2 + 50, screenSize.height - 200, 100, 100);
        
        jpm = new JPopupMenu();
        jmiInsert = new JMenuItem("Вставить");
        jpm.add(jmiInsert);
        
        jlblMan = new JLabel("<html>Чтобы добавить заказ, сотрудника или заказчика, выберите таблицу и нажмите \"вставить\", нажав ПКМ. <br>Отредактировать созданный заказ можно, изменив ячейку таблицы.</html>");
        jlblMan.setFont(fntLbl);
        jlblMan.setForeground(Color.white);
        
        jlblSalary = new JLabel("Зарплата:");
        jlblSalary.setBounds(160, 300, 200, 20);
        jlblSalary.setFont(fntLbl);
        jlblSalary.setForeground(Color.white);
        jpnl2.add(jlblSalary);
        
        jtfSalary = new JTextField(20);
        jtfSalary.setBounds(100, 340, 200, 30);
        jtfSalary.setFont(this.fntLbl);
        jtfSalary.setForeground(Color.BLACK);
        jpnl2.add(jtfSalary);
        
        jbtSalary = new JButton("Узнать");
        jbtSalary.setBounds(100, 390, 200, 30);
        jbtSalary.setFont(this.fntLbl);
        jbtSalary.setForeground(Color.BLACK);
        jpnl2.add(jbtSalary);
        
        jlblSalaryRes = new JLabel();
        jlblSalaryRes.setBounds(100, 440, 300, 30);
        jlblSalaryRes.setFont(this.fntLbl);
        jlblSalaryRes.setForeground(Color.WHITE);
        jpnl2.add(jlblSalaryRes);
        
        jlblDeptName = new JLabel("Название региона:");
        jlblDeptName.setBounds(125, 500, 200, 20);
        jlblDeptName.setFont(fntLbl);
        jlblDeptName.setForeground(Color.white);
        jpnl2.add(jlblDeptName);
        
        jtfDeptName = new JTextField(20);
        jtfDeptName.setBounds(100, 540, 200, 30);
        jtfDeptName.setFont(this.fntLbl);
        jtfDeptName.setForeground(Color.BLACK);
        jpnl2.add(jtfDeptName);
        
        jbtDeptName = new JButton("Узнать");
        jbtDeptName.setBounds(100, 590, 200, 30);
        jbtDeptName.setFont(this.fntLbl);
        jbtDeptName.setForeground(Color.BLACK);
        jpnl2.add(jbtDeptName);
        
        jlblDeptNameRes = new JLabel();
        jlblDeptNameRes.setBounds(100, 640, 300, 30);
        jlblDeptNameRes.setFont(this.fntLbl);
        jlblDeptNameRes.setForeground(Color.WHITE);
        jpnl2.add(jlblDeptNameRes);
        
        jlblSumOrd = new JLabel("Сумма заказа:");
        jlblSumOrd.setBounds(145, 300, 200, 20);
        jlblSumOrd.setFont(fntLbl);
        jlblSumOrd.setForeground(Color.white);
        jpnl2.add(jlblSumOrd);
        
        jtfSumOrd = new JTextField(20);
        jtfSumOrd.setBounds(100, 340, 200, 30);
        jtfSumOrd.setFont(this.fntLbl);
        jtfSumOrd.setForeground(Color.BLACK);
        jpnl2.add(jtfSumOrd);
        
        jbtSumOrd = new JButton("Узнать");
        jbtSumOrd.setBounds(100, 390, 200, 30);
        jbtSumOrd.setFont(this.fntLbl);
        jbtSumOrd.setForeground(Color.BLACK);
        jpnl2.add(jbtSumOrd);
        
        jlblSumOrdRes = new JLabel();
        jlblSumOrdRes.setBounds(100, 440, 300, 30);
        jlblSumOrdRes.setFont(this.fntLbl);
        jlblSumOrdRes.setForeground(Color.WHITE);
        jpnl2.add(jlblSumOrdRes);
        
        jlblCreditRating = new JLabel("Кредитный рейтинг:");
        jlblCreditRating.setBounds(120, 300, 200, 20);
        jlblCreditRating.setFont(fntLbl);
        jlblCreditRating.setForeground(Color.white);
        jpnl2.add(jlblCreditRating);
        
        jtfCreditRating = new JTextField(20);
        jtfCreditRating.setBounds(100, 340, 200, 30);
        jtfCreditRating.setFont(this.fntLbl);
        jtfCreditRating.setForeground(Color.BLACK);
        jpnl2.add(jtfCreditRating);
        
        jbtCreditRating = new JButton("Узнать");
        jbtCreditRating.setBounds(100, 390, 200, 30);
        jbtCreditRating.setFont(this.fntLbl);
        jbtCreditRating.setForeground(Color.BLACK);
        jpnl2.add(jbtCreditRating);
        
        jlblCreditRatingRes = new JLabel();
        jlblCreditRatingRes.setBounds(100, 440, 300, 30);
        jlblCreditRatingRes.setFont(this.fntLbl);
        jlblCreditRatingRes.setForeground(Color.WHITE);
        jpnl2.add(jlblCreditRatingRes);
        
        
        jlblMan.setBounds(50, 200, screenSize.width, 500);
        jpnl3.add(jlblMan);
        jtbl = new JTable();
        jsp = new JScrollPane(jtbl);
        jsp.setBounds(50, 75, screenSize.width/2 + 100, 225);
        
        jpnl3.add(jsp);
        jtbl.setComponentPopupMenu(jpm);
        jpnl3.add(artLbl);
        jpnl2.add(jlblChTable);
        
        jfrm2.add(jpnl2);
        jfrm2.add(jpnl3);

        jfrm2.setJMenuBar(jmb);
        jfrm2.pack();        
        jfrm2.setVisible(true);
    }
    
    public JMenuItem getJMenuItemStandTheme(){
        return jmiStandTheme;
    }
    
    public JMenuItem getJMenuItemAnothTheme(){
        return jmiAnothTheme;
    }
    
    public JMenuItem getJMenuItemInsert(){
        return jmiInsert;
    }
    
    
    public void setJComboBox(String[] titles){
        this.cbFirst = new JComboBox(titles);
        cbFirst.setBounds(100, 115, 150, 25);
        jpnl2.add(cbFirst);
    }
    
    public String getSelectedTable(){
        return String.valueOf(cbFirst.getSelectedItem());
    }
    
    public JComboBox getComboBox(){
        return cbFirst;
    }
    

    public void setJTable(TableModel mdl) {
        if(getSelectedTable() == "S_EMP"){
            this.jbtDeptName.setVisible(true);
            this.jlblDeptName.setVisible(true);
            this.jlblDeptNameRes.setVisible(true);
            this.jtfDeptName.setVisible(true);
            this.jbtSalary.setVisible(true);
            this.jlblSalary.setVisible(true);
            this.jlblSalaryRes.setVisible(true);
            this.jtfSalary.setVisible(true);
            
            this.jbtCreditRating.setVisible(false);
            this.jlblCreditRating.setVisible(false);
            this.jlblCreditRatingRes.setVisible(false);
            this.jtfCreditRating.setVisible(false);            
            this.jbtSumOrd.setVisible(false);
            this.jlblSumOrd.setVisible(false);
            this.jlblSumOrdRes.setVisible(false);
            this.jtfSumOrd.setVisible(false);
        }
        else if (getSelectedTable() == "S_ORD"){
            this.jbtSumOrd.setVisible(true);
            this.jlblSumOrd.setVisible(true);
            this.jlblSumOrdRes.setVisible(true);
            this.jtfSumOrd.setVisible(true);
            
            this.jbtDeptName.setVisible(false);
            this.jlblDeptName.setVisible(false);
            this.jlblDeptNameRes.setVisible(false);
            this.jtfDeptName.setVisible(false);
            this.jbtSalary.setVisible(false);
            this.jlblSalary.setVisible(false);
            this.jlblSalaryRes.setVisible(false);
            this.jtfSalary.setVisible(false);            
            this.jbtCreditRating.setVisible(false);
            this.jlblCreditRating.setVisible(false);
            this.jlblCreditRatingRes.setVisible(false);
            this.jtfCreditRating.setVisible(false);
        }
        else{
            this.jbtCreditRating.setVisible(true);
            this.jlblCreditRating.setVisible(true);
            this.jlblCreditRatingRes.setVisible(true);
            this.jtfCreditRating.setVisible(true);
            
            this.jbtSumOrd.setVisible(false);
            this.jlblSumOrd.setVisible(false);
            this.jlblSumOrdRes.setVisible(false);
            this.jtfSumOrd.setVisible(false);
            
            this.jbtDeptName.setVisible(false);
            this.jlblDeptName.setVisible(false);
            this.jlblDeptNameRes.setVisible(false);
            this.jtfDeptName.setVisible(false);
            this.jbtSalary.setVisible(false);
            this.jlblSalary.setVisible(false);
            this.jlblSalaryRes.setVisible(false);
            this.jtfSalary.setVisible(false);  
        }
        
        if(cnt != 0){
            this.jtbl.setModel(mdl);
            jtbl.createDefaultColumnsFromModel();  

            artLbl.setVisible(false);
            jtbl.revalidate();
            jtbl.setEditingColumn(1);
        }else {
            cnt++;        
            
            this.jtbl.setModel(mdl);
            mdl.fireTableCellUpdated(1, 1);
            jtbl.revalidate();
        }

    }
    
    public JButton getJButtonSalary() {
        return jbtSalary;
    } 
    
    public JButton getJButtonDeptName(){
        return jbtDeptName;
    }
    
    public JButton getJButtonSumOrd(){
        return jbtSumOrd;
    }
    
    public JButton getJButtonCreditRating(){
        return jbtCreditRating;
    }

    public JTextField getJTextFieldSalary() {
        return jtfSalary;
    }
    
    public JTextField getJTextFieldDeptName() {
        return jtfDeptName;
    }
    
    public JTextField getJTextFieldSumOrd() {
        return jtfSumOrd;
    }
    
    public JTextField getJTextFieldCreditRating(){
        return jtfCreditRating;
    }
    
    public void setJLabelResult(String str){
        if(str.equals("0"))
            str = "THE LAST NAME DOES NOT EXIST!";
        jlblSalaryRes.setText(str);
        jlblSalaryRes.revalidate();
    }
    
    public void setJLabelDeptNameResult(String str){
        if(str.equals("0"))
            str = "THE LAST NAME DOES NOT EXIST!";
        jlblDeptNameRes.setText(str);
        jlblDeptNameRes.revalidate();             
    }
    
    public void setJLabelSumOrdResult(String str){
        if(str.equals("0"))
            str = "THE LAST NAME DOES NOT EXIST!";
        jlblSumOrdRes.setText(str);
        jlblSumOrdRes.revalidate();             
    }
    
    public void setJLabelCredtiRatingResult(String str){
        if(str.equals("0"))
            str = "THE LAST NAME DOES NOT EXIST!";
        jlblCreditRatingRes.setText(str);
        jlblCreditRatingRes.revalidate();             
    }

    public void setThemeToStand() {
        jpnl2.setBackground(new Color(0, 0, 75));
        jpnl3.setBackground(new Color(0, 0, 50));
        jlblChTable.setForeground(Color.white);
        jlblMan.setForeground(Color.white);
        jlblSalaryRes.setForeground(Color.BLACK);
        jlblSalary.setForeground(Color.WHITE);        
        jtfSalary.setForeground(Color.BLACK);
        jbtSalary.setForeground(Color.BLACK);
        jlblDeptNameRes.setForeground(Color.BLACK);
        jlblDeptName.setForeground(Color.WHITE);        
        jtfDeptName.setForeground(Color.BLACK);
        jbtDeptName.setForeground(Color.BLACK);
        jlblSumOrdRes.setForeground(Color.BLACK);
        jlblSumOrd.setForeground(Color.WHITE);        
        jtfSumOrd.setForeground(Color.BLACK);
        jbtSumOrd.setForeground(Color.BLACK);
        jlblCreditRatingRes.setForeground(Color.BLACK);
        jlblCreditRating.setForeground(Color.WHITE);        
        jtfCreditRating.setForeground(Color.BLACK);
        jbtCreditRating.setForeground(Color.BLACK);
    }

    public void setThemeToAnoth() {
        jpnl2.setBackground(new Color(255, 255, 255));
        jpnl3.setBackground(new Color(245, 245, 245));
        jlblChTable.setForeground(new Color(0, 0, 75));
        jlblMan.setForeground(new Color(0, 0, 75));
        jlblSalaryRes.setForeground(new Color(0, 0, 75));
        jlblSalary.setForeground(new Color(0, 0, 75));        
        jtfSalary.setForeground(new Color(0, 0, 75));
        jbtSalary.setForeground(new Color(0, 0, 75));
        jlblDeptNameRes.setForeground(new Color(0, 0, 75));
        jlblDeptName.setForeground(new Color(0, 0, 75));        
        jtfDeptName.setForeground(new Color(0, 0, 75));
        jbtDeptName.setForeground(new Color(0, 0, 75));
        jlblSumOrdRes.setForeground(new Color(0, 0, 75));
        jlblSumOrd.setForeground(new Color(0, 0, 75));        
        jtfSumOrd.setForeground(new Color(0, 0, 75));
        jbtSumOrd.setForeground(new Color(0, 0, 75));
        jlblCreditRatingRes.setForeground(new Color(0, 0, 75));
        jlblCreditRating.setForeground(new Color(0, 0, 75));        
        jtfCreditRating.setForeground(new Color(0, 0, 75));
        jbtCreditRating.setForeground(new Color(0, 0, 75));
    }

}
