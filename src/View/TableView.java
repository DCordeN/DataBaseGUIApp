package View;

import Model.TableModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class TableView {
    private JTable jtbl; 
    private JInternalFrame jf;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    public TableView() throws PropertyVetoException, SQLException{
        jtbl = new JTable(new TableModel());
        
        
        jtbl.setPreferredScrollableViewportSize(new Dimension(950, 100));
        JScrollPane jscrlp = new JScrollPane(jtbl);
        jtbl.setFillsViewportHeight(true);
        

        jf = new JInternalFrame("DataBaseGUI - Table");
        jf.setBounds(200, 300, 290, 300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(true);
        

        //jf.setPreferredSize(new Dimension(screenSize.width, screenSize.height));
        jf.setLocation(500, 500);    
      
       
        jf.getContentPane().add(jscrlp);
  
        jf.pack();        
        jf.setVisible(true);

              
        System.out.print(new TableModel());
    }
    
    public JTable getTable(){
        return jtbl;
    }
}
