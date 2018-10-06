package student;

import admin.PerformanceData;
import db.util.dbConnection;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentController {
    @FXML
    private TableColumn<PerformanceData,Integer> stid;
    @FXML
    private TableColumn<PerformanceData,String>stmath;
    @FXML
    private TableColumn<PerformanceData,String>steng;
    @FXML
    private TableColumn<PerformanceData,String>stkisw;
    @FXML
    private TableColumn<PerformanceData,String>stbio;
    @FXML
    private TableColumn<PerformanceData,String>stchem;
    @FXML
    private TableColumn<PerformanceData,String>stphyc;
    @FXML
    private TableColumn<PerformanceData,String>stother;
    @FXML
    public void loadGrade(javafx.event.ActionEvent event) {

        try
        {
            Connection conn= dbConnection.getConnection();
            String stload="SELECT  * FROM Grade ";
            assert(conn !=null);
            PreparedStatement stmt=conn.prepareStatement(stload);
            ResultSet rs=stmt.executeQuery();
            while(rs.next())
            {
                this.stid.setText(Integer.toString(rs.getInt(1)));
                this.stmath.setText(rs.getString(2));
                this.steng.setText(rs.getString(3));
                this.stkisw.setText(rs.getString(4));
                this.stbio.setText(rs.getString(5));
                this.stchem.setText(rs.getString(6));
                this.stphyc.setText(rs.getString(7));
                this.stother.setText(rs.getString(8));
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
