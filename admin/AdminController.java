package admin;
import com.sun.org.apache.xpath.internal.operations.String;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import db.util.dbConnection;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import javax.naming.Context;
import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminController implements Initializable {
    private double FeeTotal = 30000;
    private double Balance = 0;
    @FXML
    private TextField FirstName;
    @FXML
    private TextField FirstName1;
    @FXML
    private TextField LastName;
    @FXML
    private TextField LastName1;
    @FXML
    private BarChart<java.lang.String, Integer> BarChart;
    @FXML
    private CategoryAxis X;
    @FXML
    private NumberAxis y;
    @FXML
    private TextField Email;
    @FXML
    private TextField Email1;
    @FXML
    private TextField Id;
    @FXML
    private TextField LoadId;
    @FXML
    private TextField ID;
    @FXML
    private DatePicker DOB;
    @FXML
    private DatePicker DOB1;
    @FXML
    private TextField Username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField division;
    @FXML
    private TableView<AdminData> AdminTable;
    @FXML
    private TableColumn<AdminData, String> Usernamecolumn;
    @FXML
    private TableColumn<AdminData, String> passwordcolumn;
    @FXML
    private TableColumn<AdminData, String> divisioncolumn;
    @FXML
    private ObservableList<AdminData> AdminData;
    private java.lang.String AdminSql = "SELECT * FROM LogIn ORDER BY password ASC ";
    @FXML
    private TableView<StudentData> StudentTable;
    @FXML
    private TableColumn<StudentData, java.lang.String> Idcolumn1;
    @FXML
    private TableColumn<StudentData, java.lang.String> FirstNamecolumn1;
    @FXML
    private TableColumn<StudentData, java.lang.String> LastNamecolumn1;
    @FXML
    private TableColumn<StudentData, java.lang.String> Emailcolumn1;
    @FXML
    private TableColumn<StudentData, Double> Balancecolumnsearch;
    @FXML
    private TableColumn<StudentData, String> DOBcolumn1;
    @FXML
    private TableColumn<StudentData, String> Idcolumn;
    @FXML
    private TableColumn<StudentData, String> FirstNamecolumn;
    @FXML
    private TableColumn<StudentData, String> LastNamecolumn;
    @FXML
    private TableColumn<StudentData, String> Emailcolumn;
    @FXML
    private TableColumn<StudentData, String> DOBcolumn;
    @FXML
    private TableColumn<StudentData, Double> Balancecolumn;
    @FXML
    private TextField Feepaid;
    @FXML
    private TableView<PerformanceData> performanceTable;
    @FXML
    private TableColumn<PerformanceData, Integer> idcolumn;
    @FXML
    private TableColumn<PerformanceData, java.lang.String> Gradecolumn;
    @FXML
    private TableColumn<PerformanceData, java.lang.String> Gradecolumn1;
    @FXML
    private TableColumn<PerformanceData, java.lang.String> Gradecolumn2;
    @FXML
    private TableColumn<PerformanceData, java.lang.String> Gradecolumn3;
    @FXML
    private TableColumn<PerformanceData, java.lang.String> Gradecolumn4;
    @FXML
    private TableColumn<PerformanceData, java.lang.String> Gradecolumn5;
    @FXML
    private TableColumn<PerformanceData, java.lang.String> Gradecolumn6;
    @FXML
    private TableColumn<PerformanceData, Integer> Mathematicscolumn;
    @FXML
    private TableColumn<PerformanceData, Integer> Englishcolumn;
    @FXML
    private TableColumn<PerformanceData, Integer> Kiswahilicolumn;
    @FXML
    private TableColumn<PerformanceData, Integer> Biologycolumn;
    @FXML
    private TableColumn<PerformanceData, Integer> Chemistrycolumn;
    @FXML
    private TableColumn<PerformanceData, Integer> Physicscolumn;
    @FXML
    private TableColumn<PerformanceData, Integer> Othercolumn;
    @FXML
    private TextField id;
    @FXML
    private TextField Mathematics;
    @FXML
    private TextField English;
    @FXML
    private TextField Kiswahili;
    @FXML
    private TextField Biology;
    @FXML
    private TextField Chemistry;
    @FXML
    private TextField Physics;
    @FXML
    private TextField Other;

    private dbConnection dc;
    private ObservableList<PerformanceData> performance;
    private ObservableList<StudentData> data;
    private java.lang.String sql = "SELECT * FROM  Student ORDER BY ID ASC";

    public void initialize(URL url, ResourceBundle rb) {
        this.dc = new dbConnection();

    }

    @FXML
    private void loadStudentData(ActionEvent e) {
        try {
            Connection conn = dbConnection.getConnection();
            this.data = FXCollections.observableArrayList();
            assert (conn != null);
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                this.data.add(new StudentData(rs.getString(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6)));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        this.Idcolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("Id"));
        this.FirstNamecolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("FirstName"));
        this.LastNamecolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("LastName"));
        this.Emailcolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("Email"));
        this.DOBcolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("DOB"));
        this.Balancecolumn.setCellValueFactory(new PropertyValueFactory<StudentData, Double>("Balance"));
        this.StudentTable.setItems(null);
        this.StudentTable.setItems(this.data);
        StudentTable.setRowFactory(
                new Callback<TableView<StudentData>, TableRow<StudentData>>() {
                    @Override
                    public TableRow<StudentData> call(TableView<StudentData> param) {
                        final TableRow<StudentData> row= new TableRow<>();
                        final ContextMenu rowMenu=new ContextMenu();
                        MenuItem editItem= new MenuItem("Edit");
                        editItem.setOnAction(
                                new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        StudentTable.getItems().remove(row.getItem());
                                    }
                                }
                        );
                        MenuItem deleteItem=new MenuItem("Delete");
                        deleteItem.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                StudentTable.getItems().remove(row.getItem());
                            }
                        });
                        rowMenu.getItems().addAll(editItem,deleteItem);
                        //To only display context Menu of a non-null items.
                        row.contextMenuProperty().bind(
                                Bindings.when(Bindings.isNotNull(row.itemProperty())).then(rowMenu)
                                .otherwise((ContextMenu)null));
                        return  row;

                    }
                }
        );
    }

    @FXML
    private void searchStudent(ActionEvent event) throws Exception {
        java.lang.String sqlsearch = "SELECT * FROM Student WHERE ID=?";
        try {
            Connection conn = dbConnection.getConnection();
            assert (conn != null);
            PreparedStatement stmt = conn.prepareStatement(sqlsearch);
            stmt.setString(1, this.ID.getText());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                java.lang.String search1 = rs.getString("ID");
                Idcolumn1.setText(search1);
                java.lang.String search2 = rs.getString("Fname");
                FirstNamecolumn1.setText(search2);
                java.lang.String search3 = rs.getString("Lname");
                LastNamecolumn1.setText(search3);
                java.lang.String search4 = rs.getString("Email");
                Emailcolumn1.setText(search4);
                java.lang.String search5 = rs.getString("DOB");
                DOBcolumn1.setText(search5);
                java.lang.String search6 = java.lang.String.valueOf(rs.getDouble("Balance"));
                Balancecolumnsearch.setText(search6);

            } else {
                JOptionPane.showMessageDialog(null, "Student not found!!!",
                        null, JOptionPane.ERROR_MESSAGE);
            }
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(AdminController.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);
        }

    }

    @FXML
    private void deleteEntry(ActionEvent event) throws Exception {
        java.lang.String delsql = "DELETE FROM Student WHERE ID=?";
        try {
            Connection conn = dbConnection.getConnection();
            assert (conn != null);
            PreparedStatement stmt = conn.prepareStatement(delsql);
           // stmt.setString(1,);
           stmt.setString(1, this.Id.getText());
            JOptionPane.showConfirmDialog(null, "You are about to delete an entry ?",
                    null, JOptionPane.WARNING_MESSAGE);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.getMessage();
        }

    }

    @FXML
    private void DeleteEntry(ActionEvent event) throws Exception {
        java.lang.String Admdel = "DELETE FROM LogIn WHERE Username=?";
        try {
            Connection conn = dbConnection.getConnection();
            assert (conn != null);
            PreparedStatement stmt = conn.prepareStatement(Admdel);
            stmt.setString(1, this.Username.getText());
            JOptionPane.showConfirmDialog(null, "Are you sure?", null, JOptionPane.WARNING_MESSAGE);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void loadAdminData(ActionEvent e) {
        try {
            Connection conn = dbConnection.getConnection();
            assert (conn != null);
            this.AdminData = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery(AdminSql);
            while (rs.next()) {
                this.AdminData.add(new AdminData(rs.getString(1),
                        rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            System.err.println("ERROR" + ex);
        }
        this.Usernamecolumn.setCellValueFactory(new PropertyValueFactory<admin.AdminData, String>("Username"));
        this.passwordcolumn.setCellValueFactory(new PropertyValueFactory<admin.AdminData, String>("password"));
        this.divisioncolumn.setCellValueFactory(new PropertyValueFactory<admin.AdminData, String>("division"));
        this.AdminTable.setItems(null);
        this.AdminTable.setItems(AdminData);
        AdminTable.setRowFactory(
                new Callback<TableView<admin.AdminData>, TableRow<admin.AdminData>>() {
                    @Override
                    public TableRow<AdminData> call(TableView<AdminData> param) {
                        final TableRow<admin.AdminData> row=new TableRow<>();
                        final ContextMenu rowmenu=new ContextMenu();
                        MenuItem editItem=new MenuItem("Edit");
                        editItem.setOnAction(
                                new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        AdminTable.getItems().remove(row.getItem());
                                    }
                                }
                        );
                        MenuItem deleteItem=new MenuItem("Delete");
                        deleteItem.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                AdminTable.getItems().remove(row.getItem());
                            }
                        });
                        rowmenu.getItems().addAll(editItem,deleteItem);
                        //only display context for non-null items
                        row.contextMenuProperty().bind(
                                Bindings.when(Bindings.isNotNull(row.itemProperty())).then(rowmenu)
                                .otherwise((ContextMenu)null));
                        return  row;
                    }
                }
        );

    }

    @FXML
    private void addAdmin(ActionEvent event) {
        java.lang.String AdminSqlInsert = "INSERT INTO LogIn(Username,password,division) VALUES(?,?,?)";
        try {
            Connection conn = dbConnection.getConnection();
            assert (conn != null);
            PreparedStatement stmt = conn.prepareStatement(AdminSqlInsert);
            if(this.Username.getText()==null) {
                stmt.setString(1, this.Username.getText());
                stmt.setString(2, this.password.getText());
                stmt.setString(3, this.division.getText());
                stmt.executeUpdate();
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"You cannot update null values!!.",null,JOptionPane.WARNING_MESSAGE);
        }
    }

    @FXML
    private void addStudent(ActionEvent event) {
        java.lang.String sqlInsert = "INSERT  INTO   Student(ID,Fname,Lname,Email,DOB,Balance) VALUES(?,?,?,?,?,?)";
        try {
            Connection conn = dbConnection.getConnection();
            assert (conn != null);
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);
            stmt.setString(1, this.Id.getText());
            stmt.setString(2, this.FirstName.getText());
            stmt.setString(3, this.LastName.getText());
            stmt.setString(4, this.Email.getText());
            stmt.setString(5, this.DOB.getEditor().getText());
            Balance = FeeTotal - (Double.parseDouble(this.Feepaid.getText()));
            stmt.setDouble(6, Balance);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            java.lang.String bogus="<html><span style='Color:Red'>YOU CANNOT INSERT NULL VALUES!!</span><html>";
            JOptionPane.showMessageDialog(null,bogus,null,JOptionPane.WARNING_MESSAGE);
        }
    }

    @FXML
    private void clearFields(ActionEvent event) {
        this.Id.setText("");
        this.FirstName.setText("");
        this.LastName.setText("");
        this.Email.setText("");
        this.DOB.setValue(null);
    }

    @FXML
    private void clearFields1(ActionEvent event) {
        this.ID.setText("");
        this.FirstName1.setText("");
        this.LastName1.setText("");
        this.Email1.setText("");
        this.DOB1.setValue(null);
    }

    @FXML
    private void clearfields(ActionEvent event) {
        this.Username.setText("");
        this.password.setText("");
        this.division.setText("");
    }

    @FXML
    public void barChart(ActionEvent event) {
        java.lang.String loadSql = "SELECT Mathematics,English,Kiswahili,Biology,Chemistry,Physics,Other FROM Performance  WHERE Id=? ORDER BY Id ASC ";
        java.lang.String grade = "SELECT MathGrade,EngGrade,KiswGrade,BioGrade,ChemGrade,PhycGrade,OtherGrade FROM Grade WHERE Ident=?";
        XYChart.Series<java.lang.String, Integer> series = new XYChart.Series<>();
        try {
            Connection conn = dbConnection.getConnection();
            assert (conn != null);
            PreparedStatement stmt = conn.prepareStatement(loadSql);
            stmt.setInt(1, Integer.parseInt(this.LoadId.getText()));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                series.getData().add(new XYChart.Data<java.lang.String, Integer>("Mathematics", rs.getInt(1)));
                series.getData().add(new XYChart.Data<java.lang.String, Integer>("English", rs.getInt(2)));
                series.getData().add(new XYChart.Data<java.lang.String, Integer>("Kiswahili", rs.getInt(3)));
                series.getData().add(new XYChart.Data<java.lang.String, Integer>("Biology", rs.getInt(4)));
                series.getData().add(new XYChart.Data<java.lang.String, Integer>("Chemistry", rs.getInt(5)));
                series.getData().add(new XYChart.Data<java.lang.String, Integer>("Physics", rs.getInt(6)));
                series.getData().add(new XYChart.Data<java.lang.String, Integer>("Other", rs.getInt(7)));
                BarChart.getData().add(series);
            }
            rs.close();
            stmt.close();
            PreparedStatement stmt1 = conn.prepareStatement(grade);
            stmt1.setInt(1, Integer.parseInt(this.LoadId.getText()));
            ResultSet rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                Gradecolumn.setText(rs1.getString(1));
                Gradecolumn1.setText(rs1.getString(2));
                Gradecolumn2.setText( rs1.getString(3));
                Gradecolumn3.setText(rs1.getString(4));
                Gradecolumn4.setText(rs1.getString(5));
                Gradecolumn5.setText( rs1.getString(6));
                Gradecolumn6.setText(rs1.getString(7));
            }
            rs1.close();
            stmt1.close();
        } catch (Exception e1) {
            java.lang.String bogus="<html><span style ='color:Red'>Enter Id</span></html>";
            JOptionPane.showMessageDialog(null,bogus,"WARNING!!",JOptionPane.WARNING_MESSAGE);
        }
    }
    @FXML
    public void performance(ActionEvent event) throws SQLException {
        Connection conn=dbConnection.getConnection();
        java.lang.String updatesql="INSERT INTO Performance VALUES(?,?,?,?,?,?,?,?)";
        try {
            assert (conn != null);
            PreparedStatement stmt = conn.prepareStatement(updatesql);
            stmt.setInt(1, Integer.parseInt(this.id.getText()));
            stmt.setInt(2, Integer.parseInt(java.lang.String.valueOf(this.Mathematics.getText())));
            stmt.setInt(3, Integer.parseInt(this.English.getText()));
            stmt.setInt(4, Integer.parseInt(this.Kiswahili.getText()));
            stmt.setInt(5, Integer.parseInt(this.Biology.getText()));
            stmt.setInt(6, Integer.parseInt(this.Chemistry.getText()));
            stmt.setInt(7, Integer.parseInt(this.Physics.getText()));
            stmt.setInt(8, Integer.parseInt(this.Other.getText()));
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            java.lang.String bogus="<html><span style='Color:Red'>YOU CAN'T UPDATE NULL VALUES!!</span></html>";
            JOptionPane.showMessageDialog(null,bogus,"WARNING",JOptionPane.WARNING_MESSAGE);
        }

    }
    public java.lang.String grading(int n)
    {
        java.lang.String Grade=null;
        if(n>=80)
            Grade="A";
        else if (n>=70)
            Grade="B";
        else if (n>=60)
            Grade="C";
        else if(n>=50)
            Grade="D";
        else if(n<=40)
            Grade="E";
        else
            Grade="N/A";
        return Grade;
    }
    @FXML
    public void grade(ActionEvent event) throws SQLException {
        Connection conn=dbConnection.getConnection();
        java.lang.String grade="SELECT * FROM Performance ";
        java.lang.String grade1="INSERT INTO Grade VALUES (?,?,?,?,?,?,?,?)";
        assert(conn !=null);
        PreparedStatement stmt1=conn.prepareStatement(grade1);
        PreparedStatement stmt=conn.prepareStatement(grade);
        ResultSet rs=stmt.executeQuery();
        while(rs.next()) {
            stmt1.setInt(1,rs.getInt(1));
            stmt1.setString(2,grading(rs.getInt(2)));
            stmt1.setString(3,grading(rs.getInt(3)));
            stmt1.setString(4,grading(rs.getInt(4)));
            stmt1.setString(5,grading(rs.getInt(5)));
            stmt1.setString(6,grading(rs.getInt(6)));
            stmt1.setString(7,grading(rs.getInt(7)));
            stmt1.setString(8,grading(rs.getInt(8)));
            }
            stmt1.executeUpdate();
        stmt.close();
        rs.close();
        stmt1.close();
    }

    @FXML
    public void reload(ActionEvent event)
    {

       try {

           Connection conn = dbConnection.getConnection();

           java.lang.String reloadsql = "SELECT * FROM Performance ORDER BY Id ASC";
           this.performance = FXCollections.observableArrayList();
           assert (conn != null);
           ResultSet rs = conn.createStatement().executeQuery(reloadsql);
           while (rs.next()) {
               this.performance.add(new PerformanceData(rs.getInt(1), rs.getInt(2),
                       rs.getInt(3), rs.getInt(4), rs.getInt(5),
                       rs.getInt(6), rs.getInt(7), rs.getInt(8)));
           }
       }
       catch (SQLException e)
       {
           e.printStackTrace();
       }
       this.idcolumn.setCellValueFactory(new PropertyValueFactory<PerformanceData, Integer>("Id"));
       this.Mathematicscolumn.setCellValueFactory(new PropertyValueFactory<PerformanceData, Integer>("Mathematics"));
       this.Englishcolumn.setCellValueFactory(new PropertyValueFactory<PerformanceData, Integer>("English"));
       this.Kiswahilicolumn.setCellValueFactory(new PropertyValueFactory<PerformanceData, Integer>("Kiswahili"));
       this.Biologycolumn.setCellValueFactory(new PropertyValueFactory<PerformanceData, Integer>("Biology"));
       this.Chemistrycolumn.setCellValueFactory(new PropertyValueFactory<PerformanceData, Integer>("Chemistry"));
       this.Physicscolumn.setCellValueFactory(new PropertyValueFactory<PerformanceData, Integer>("Physics"));
       this.Othercolumn.setCellValueFactory(new PropertyValueFactory<PerformanceData, Integer>("Other"));
       this.performanceTable.setItems(null);
       this.performanceTable.setItems(performance);
       performanceTable.setRowFactory(
               new Callback<TableView<PerformanceData>, TableRow<PerformanceData>>() {
                   @Override
                   public TableRow<PerformanceData> call(TableView<PerformanceData> param) {
                       final TableRow<PerformanceData> row=new TableRow<>();
                       final ContextMenu rowmenu= new ContextMenu();
                       final MenuItem EditItem=new MenuItem("Edit");
                       EditItem.setOnAction(
                               new EventHandler<ActionEvent>() {
                                   @Override
                                   public void handle(ActionEvent event) {
                                       performanceTable.getItems().remove(row.getItem());
                                   }
                               }
                       );
                       MenuItem deleteItem=new MenuItem("Delete");
                       deleteItem.setOnAction(
                               new EventHandler<ActionEvent>() {
                                   @Override
                                   public void handle(ActionEvent event) {
                                       performanceTable.getItems().remove(row.getItem());
                                   }
                               }
                       );
                       rowmenu.getItems().addAll(EditItem,deleteItem);
                       //only display context on null rows
                       row.contextMenuProperty().bind(Bindings.when(Bindings.isNotNull(row.itemProperty())).then (rowmenu)
                       .otherwise((ContextMenu)null));
                       return row;
                   }
               }
       );
    }

}
