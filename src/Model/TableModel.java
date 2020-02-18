package Model;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;




public class TableModel extends AbstractTableModel{
    private final String[] titlesT = {"S_EMP", "S_ORD", "S_CUSTOMER"};
    
    
    private String queryUpdatePt1 = "UPDATE ";
    private String queryUpdatePt2 = " SET ";
    private String queryUpdatePt3 = " = ";
    private String queryUpdatePt4 = " WHERE ";

    private String queryInsertNewPt1 = "INSERT INTO ";
    private String queryInsertNewPt2 = " (ID) VALUES (";
    private String queryRowCountStr = "SELECT ID FROM ";
    private String queryColCountStr = "SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = ";
    private String queryColNameStr = "SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME = ";
    private String queryValue = "SELECT * FROM ";


    private String selectedTable = titlesT[0];
    private ResultSet rsRowCount;
    private ResultSet rsColCount;
    private ResultSet rsColName;
    private ResultSet rsValue;

    private int rowCount;
    private int columnCount;
    
    private Connection conn;
    private PreparedStatement preparedStatementRowCount;
    private PreparedStatement preparedStatementColCount;
    private PreparedStatement preparedStatementColName;
    private PreparedStatement preparedStatementValue;
    private PreparedStatement preparedStatementUpdate;
    private PreparedStatement preparedStatementInsertNew;

    private ArrayList<String> al;
    private ArrayList<String> an;
    private int prev_r = 1;
    
    public TableModel() throws SQLException{             
        this.connectToDB();
        this.execStateRowCount();        
        this.execStateColCount();
        this.execStateColName();
        this.execStateValue();
        

    }
    
    public void execStateValue() throws SQLException{
        preparedStatementValue = conn.prepareStatement(queryValue + selectedTable);
        rsValue = preparedStatementValue.executeQuery();
        
        al = new ArrayList();
        for(int k = 0; k < rowCount; k++){
            rsValue.next();
            for(int i = 0; i < columnCount; i++)
                al.add(rsValue.getString(i+1));
        }       
    }
    
    public void execStateColName() throws SQLException{
        preparedStatementColName = conn.prepareStatement(queryColNameStr + "'" + selectedTable + "'");
        rsColName = preparedStatementColName.executeQuery();
        
        an = new ArrayList();
        while(rsColName.next())
            an.add(rsColName.getString("COLUMN_NAME"));
    }
    
    public void execStateRowCount() throws SQLException{
        rowCount = 0;
        preparedStatementRowCount = conn.prepareStatement(queryRowCountStr + selectedTable);
        
        rsRowCount = preparedStatementRowCount.executeQuery();
        while(rsRowCount.next())
            rowCount++;
    }
    
    public void execStateColCount() throws SQLException{
        columnCount = 0;
        preparedStatementColCount = conn.prepareStatement(queryColCountStr + "'" + selectedTable + "'");
        
        rsColCount = preparedStatementColCount.executeQuery();
        while(rsColCount.next())
            columnCount++;  
    }
    private Object getDataCell;

    @Override
    public void setValueAt( Object inValue, int inRow, int inCol ) {                       
        String tmp = "";
        
        this.fireTableDataChanged();
        try {
        this.execStateColName();
        if(al.get(inRow*columnCount + inCol) == null)
            tmp = queryUpdatePt1 + selectedTable + queryUpdatePt2 + an.get(inCol) + queryUpdatePt3 + "'" + inValue + "' " + queryUpdatePt4 + an.get(inCol) + " IS " + al.get(inRow*columnCount + inCol);
        else
            tmp = queryUpdatePt1 + selectedTable + queryUpdatePt2 + an.get(inCol) + queryUpdatePt3 + "'" + inValue + "' " + queryUpdatePt4 + an.get(inCol) + this.queryUpdatePt3 + "'" +al.get(inRow*columnCount + inCol) + "'";
            //preparedStatementUpdate = conn.prepareStatement(queryUpdatePt1 + selectedTable + queryUpdatePt2 + an.get(inCol) + queryUpdatePt3 + inValue + "' " + queryUpdatePt4 + an.get(inCol) + this.queryUpdatePt3 + "'" + al.get(inRow*columnCount + inCol) + "'");
        } catch (SQLException ex) {
            Logger.getLogger(TableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            preparedStatementUpdate = conn.prepareStatement(tmp);
            preparedStatementUpdate.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(tmp);
        al.set(inRow*columnCount + inCol, (String) inValue); 
    }
    
    
    @Override
    public boolean isCellEditable(int r, int c) {
	getDataCell = getValueAt(r,c);
	return true;
    }
    
    @Override
    public int getRowCount() {
        return rowCount;
    }
    
    @Override
    public int getColumnCount() {
        return columnCount;
    }
    
    @Override
    public Object getValueAt(int r, int c) {
        //System.out.print("getValueAt");
        Object[] temp = al.toArray();
        this.fireTableCellUpdated(r, c);
        return temp[r*columnCount + c];
    }
    
    @Override
    public String getColumnName(int c) {
        /*try {
            switch (c) {
                default:
                    rsColName.next();
                    an.add(rsColName.getString("COLUMN_NAME"));
                    break;
            }
        System.out.print(an.get(c) + " ");
        } catch (SQLException ex) {
            Logger.getLogger(TableModel.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return an.get(c);
    }
   
    public void connectToDB() throws SQLException{        
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@82.179.14.185:1521:nmics", "stud11", "stud11");
        //statement = conn.createStatement();
        //CallableStatement cstmt = conn.prepareCall("{? = call FUNC_3(?, ?)}");
        //cstmt.registerOutParameter(1, Types.VARCHAR);
        //cstmt.setInt(2, 1);
        //cstmt.setString(3, "Ngao");
        //cstmt.executeUpdate();
        //String acctBal = cstmt.getString(1);
        //System.out.print(acctBal);
        

    }

    public String[] getTitles() {
        return titlesT;
    }
    
    public void setSelectedTable(String sTable) throws SQLException{  
        this.selectedTable = sTable;
        this.execStateRowCount();
        this.execStateColCount(); 
        this.execStateColName();
        this.execStateValue();
    }

    public void insertNewStr() throws SQLException {       
        preparedStatementInsertNew = conn.prepareCall(queryInsertNewPt1 + this.selectedTable + this.queryInsertNewPt2 + (this.rowCount+1) + ")");

        preparedStatementInsertNew.executeUpdate();
        preparedStatementInsertNew.executeUpdate("COMMIT");
    }
    public String selectSalary(JTextField jt) throws SQLException{
        Statement statement = conn.createStatement();
        CallableStatement cstmt = conn.prepareCall("{? = call SALARY(?)}");
        cstmt.registerOutParameter(1, Types.VARCHAR);
        cstmt.setString(2, jt.getText());
        cstmt.executeUpdate();
        String res = cstmt.getString(1);
        System.out.print(jt.getText());
        
        return res;
    }
    
    public String selectDeptName(JTextField jt) throws SQLException{
        Statement statement = conn.createStatement();
        CallableStatement cstmt = conn.prepareCall("{? = call REGION_NAME(?)}");
        cstmt.registerOutParameter(1, Types.VARCHAR);
        cstmt.setString(2, jt.getText());
        cstmt.executeUpdate();
        String res = cstmt.getString(1);
        System.out.print(jt.getText());
        
        return res;
    }
    
    public String selectSumOrd(JTextField jt) throws SQLException{
        Statement statement = conn.createStatement();
        CallableStatement cstmt = conn.prepareCall("{? = call SUM_ORD(?)}");
        cstmt.registerOutParameter(1, Types.NUMERIC);
        cstmt.setString(2, jt.getText());
        cstmt.executeUpdate();
        String res = cstmt.getString(1);
        System.out.print(jt.getText());
        
        return res;
    }

    public String selectCreditRating(JTextField jt) throws SQLException {
        Statement statement = conn.createStatement();
        CallableStatement cstmt = conn.prepareCall("{? = call CREDIT_RAT(?)}");
        cstmt.registerOutParameter(1, Types.VARCHAR);
        cstmt.setString(2, jt.getText());
        cstmt.executeUpdate();
        String res = cstmt.getString(1);
        System.out.print(jt.getText());
        
        return res;
    }
    
}
