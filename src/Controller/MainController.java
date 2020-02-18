package Controller;

import Model.TableModel;
import View.MainFrame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainController {
    
    TableModel mdl;
    MainFrame mf;
    
    public MainController(TableModel model, MainFrame mainFrame){
        mdl = model;
        mf = mainFrame;
        initView();
    }
    
    public void initView(){
        mf.setJComboBox(mdl.getTitles());
        mf.setJTable(mdl);
    }
    
    public void initController(){
        mf.getComboBox().addActionListener(e -> {try {
            saveSelectedTable();
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
                refreshTable();});
        mf.getJMenuItemInsert().addActionListener(e -> {
            try {
                insertPopup();
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        mf.getJButtonSalary().addActionListener(e -> {
            try {
                findSalary();
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        mf.getJButtonDeptName().addActionListener(e -> {
            try {
                findDeptName();
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        mf.getJButtonSumOrd().addActionListener(e -> {
            try {
                findSumOrd();
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        mf.getJButtonCreditRating().addActionListener(e -> {
            try {
                findCreditRating();
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        mf.getJMenuItemStandTheme().addActionListener(e -> changeThemeToStand());
        mf.getJMenuItemAnothTheme().addActionListener(e -> changeThemeToAnoth());
       
    }

    private void saveSelectedTable() throws SQLException {
        mdl.setSelectedTable(String.valueOf(mf.getComboBox().getSelectedItem()));
    }
    
    public void refreshTable(){
        mf.setJTable(mdl);
    }



    private void insertPopup() throws SQLException {
        mdl.insertNewStr();
    }

    private void findSalary() throws SQLException {
        mf.setJLabelResult(mdl.selectSalary(mf.getJTextFieldSalary()));
    }

    private void findDeptName() throws SQLException {
        mf.setJLabelDeptNameResult(mdl.selectDeptName(mf.getJTextFieldDeptName()));
    }

    private void findSumOrd() throws SQLException {
        mf.setJLabelSumOrdResult(mdl.selectSumOrd(mf.getJTextFieldSumOrd()));
    }

    private void findCreditRating() throws SQLException {
        mf.setJLabelCredtiRatingResult(mdl.selectCreditRating(mf.getJTextFieldCreditRating()));
    }

    private void changeThemeToStand() {
        mf.setThemeToStand();
    }

    private void changeThemeToAnoth() {
        mf.setThemeToAnoth();
    }
}
