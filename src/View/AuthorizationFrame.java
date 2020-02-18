package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class AuthorizationFrame {      
    private JFrame jfrm;
    private JPanel jpnl;
    private JLabel jlblAttempts;
    private String message = "Осталось попыток входа - %d.";
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JLabel jlblLogin;
    private JLabel jlblPassword;
    private Font fontLabels, fontTextArea;
    private JTextField loginField; 
    private JPasswordField passField;
    private JButton btnEnter;
    
    public AuthorizationFrame(){
        jfrm = new JFrame("DataBaseGUI - Authorization");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jfrm.setPreferredSize(new Dimension(screenSize.width-200, screenSize.height-200));
        jfrm.setLocation(100, 100);      
         
        fontLabels = new Font("TimesRoman", Font.BOLD, 24);
        fontTextArea = new Font("TimesRoman", Font.ROMAN_BASELINE, 24);
        
        jlblLogin = new JLabel("ЛОГИН:");
        jlblLogin.setBounds(screenSize.width/2 - 200, screenSize.height/2 - 325, 100, 50);
        jlblLogin.setFont(fontLabels);
        jlblLogin.setForeground(Color.white);
        
        jlblAttempts = new JLabel();
        jlblAttempts.setBounds(screenSize.width/2 - 325, screenSize.height/2 + 150, 350, 50);
        jlblAttempts.setFont(fontLabels);
        jlblAttempts.setForeground(Color.white);

        loginField = new JTextField(10);
        loginField.setBounds(screenSize.width/2 - 300, screenSize.height/2 - 250, 300, 50);
        loginField.setFont(fontTextArea);
        loginField.setForeground(Color.BLACK);
        
        jlblPassword = new JLabel("ПАРОЛЬ:");
        jlblPassword.setBounds(screenSize.width/2 - 210, screenSize.height/2 - 175, 150, 50);
        jlblPassword.setFont(fontLabels);
        jlblPassword.setForeground(Color.white);
        
        passField = new JPasswordField(10);
        passField.setBounds(screenSize.width/2 - 300, screenSize.height/2 - 100, 300, 50);
        passField.setFont(fontTextArea);
        passField.setForeground(Color.BLACK);
                
        btnEnter = new JButton("Войти");
        btnEnter.setBounds(screenSize.width/2 - 300, screenSize.height/2, 300, 50);
        btnEnter.setFont(fontTextArea);
        btnEnter.setForeground(Color.BLACK);
        
        jpnl = new JPanel();
        jpnl.setLayout(null);
        jpnl.add(jlblLogin);
        jpnl.add(jlblPassword);
        jpnl.add(jlblAttempts);  
        jpnl.add(loginField);
        jpnl.add(passField);
        jpnl.add(btnEnter);
        
        jpnl.setBackground(new Color(0, 0, 75));
        jfrm.getContentPane().add(jpnl);
        jfrm.pack();
        jfrm.setVisible(true);
        
    }
    
    public void setJLabelAttempts(int count){
        this.jlblAttempts.setText(String.format(message, count));
    }
    
    public JButton getEnterButton(){
        return btnEnter;
    }
    
    public JTextField getLoginField(){
        return loginField;
    }
    
    public JTextField getPassField(){
        return passField;
    }
    
    public JLabel getJLabelAttempts(){
        return jlblAttempts;
    }
    
    public String getMessage(){
        return message;
    }
    
    
    public void disp(){
        jfrm.dispose();
    }
}
