package admin;
import db.util.dbConnection;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class AdminData {
    private final StringProperty Username;
    private final StringProperty password;
    private final StringProperty  division;
    public  AdminData(String User,String pass,String div)
    {
        this.Username=new SimpleStringProperty(User);
        this.password=new SimpleStringProperty(pass);
        this.division=new SimpleStringProperty(div);
    }

    public String getUsername() {
        return Username.get();
    }

    public StringProperty usernameProperty() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getDivision() {
        return division.get();
    }

    public StringProperty divisionProperty() {
        return division;
    }

    public void setDivision(String division) {
        this.division.set(division);
    }
}
