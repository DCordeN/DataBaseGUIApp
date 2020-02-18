package databaseguiapp;


import java.sql.SQLException;



public class DataBaseGUIApp {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Model.AuthorizationModel model = new Model.AuthorizationModel();
        View.AuthorizationFrame frame = new View.AuthorizationFrame();
        Controller.AuthorizationController cont = new Controller.AuthorizationController(model, frame);
        cont.initController();
    }

}
