package admin;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PerformanceData {
    private final IntegerProperty id;
    private final IntegerProperty Mathematics;
    private final IntegerProperty English;
    private final IntegerProperty Kiswahili;
    private final IntegerProperty Biology;
    private final IntegerProperty Chemistry;
    private final IntegerProperty Physics;
    private final IntegerProperty Other;
    public PerformanceData(int id,int Math,int Eng,int Kisw,int Bio,int Chem,int Phy,int Other)
    {
        this.id=new SimpleIntegerProperty(id);
        this.Mathematics=new SimpleIntegerProperty(Math);
        this.English=new SimpleIntegerProperty(Eng);
        this.Kiswahili=new SimpleIntegerProperty(Kisw);
        this.Biology=new SimpleIntegerProperty(Bio);
        this.Chemistry=new SimpleIntegerProperty(Chem);
        this.Physics=new SimpleIntegerProperty(Phy);
        this.Other=new SimpleIntegerProperty(Other);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getMathematics() {
        return Mathematics.get();
    }

    public IntegerProperty mathematicsProperty() {
        return Mathematics;
    }

    public void setMathematics(int mathematics) {
        this.Mathematics.set(mathematics);
    }

    public int getEnglish() {
        return English.get();
    }

    public IntegerProperty englishProperty() {
        return English;
    }

    public void setEnglish(int english) {
        this.English.set(english);
    }

    public int getKiswahili() {
        return Kiswahili.get();
    }

    public IntegerProperty kiswahiliProperty() {
        return Kiswahili;
    }

    public void setKiswahili(int kiswahili) {
        this.Kiswahili.set(kiswahili);
    }

    public int getBiology() {
        return Biology.get();
    }

    public IntegerProperty biologyProperty() {
        return Biology;
    }

    public void setBiology(int biology) {
        this.Biology.set(biology);
    }

    public int getChemistry() {
        return Chemistry.get();
    }

    public IntegerProperty chemistryProperty() {
        return Chemistry;
    }

    public void setChemistry(int chemistry) {
        this.Chemistry.set(chemistry);
    }

    public int getPhysics() {
        return Physics.get();
    }

    public IntegerProperty physicsProperty() {
        return Physics;
    }

    public void setPhysics(int physics) {
        this.Physics.set(physics);
    }

    public int getOther() {
        return Other.get();
    }

    public IntegerProperty otherProperty() {
        return Other;
    }

    public void setOther(int other) {
        this.Other.set(other);
    }
}
