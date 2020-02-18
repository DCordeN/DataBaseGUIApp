package Controller;

import Model.AuthorizationModel;
import Model.TableModel;
import View.AuthorizationFrame;
import View.MainFrame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AuthorizationController {   
    AuthorizationFrame frm;
    AuthorizationModel mdl;
    
    public AuthorizationController(AuthorizationModel m, AuthorizationFrame f){
        mdl = m;
        frm = f;
        initView();
    }
    
    public void initView(){
        frm.setJLabelAttempts(mdl.getCount());
    }
    
    public void initController(){
        frm.getEnterButton().addActionListener(e -> {
            try {
                saveEnterData();
            } catch (SQLException ex) {
                Logger.getLogger(AuthorizationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });  
    }
    
    public void saveEnterData() throws SQLException{
        mdl.setEnterData(frm.getLoginField().getText(), frm.getPassField().getText());
        mdl.setCount();
        frm.setJLabelAttempts(mdl.getCount());
        if(mdl.isOver())
            frm.disp();  
        if(mdl.isCorrect()){
            frm.disp();
            TableModel tbl = new TableModel();
            MainFrame mnf = new MainFrame();
            MainController mnc = new MainController(tbl, mnf);
            mnc.initController();
        }
    }

}
