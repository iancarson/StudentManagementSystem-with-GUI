package admin;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentData {
    private final StringProperty Id;
    private final StringProperty FirstName;
    private final StringProperty LastName;
    private final StringProperty Email;
    private final StringProperty DOB;
    private final DoubleProperty Balance;
    public StudentData(String id,String firstName,String lastName,String email,String dob,Double bal)
    {
        this.Id=new SimpleStringProperty(id);
        this.FirstName=new SimpleStringProperty(firstName);
        this.LastName=new SimpleStringProperty(lastName);
        this.Email=new SimpleStringProperty(email);
        this.DOB=new SimpleStringProperty(dob);
        this.Balance=new SimpleDoubleProperty(bal);
    }

    public double getBalance() {
        return Balance.get();
    }

    public DoubleProperty balanceProperty() {
        return Balance;
    }

    public void setBalance(double balance) {
        this.Balance.set(balance);
    }

    public String getId() {
        return Id.get();
    }

    public StringProperty idProperty() {
        return Id;
    }

    public void setId(String id) {
        this.Id.set(id);
    }

    public String getFirstName() {
        return FirstName.get();
    }

    public StringProperty firstNameProperty() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName.set(firstName);
    }

    public String getLastName() {
        return LastName.get();
    }

    public StringProperty lastNameProperty() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName.set(lastName);
    }

    public String getEmail() {
        return Email.get();
    }

    public StringProperty emailProperty() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email.set(email);
    }

    public String getDOB() {
        return DOB.get();
    }

    public StringProperty DOBProperty() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB.set(DOB);
    }

}
