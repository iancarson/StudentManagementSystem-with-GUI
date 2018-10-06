package LogInApp;

public enum Option {
    Admin,Student;
    private Option()
    {}
    public String value(){
        return name();
    }
    public static Option fromvalue(String v)
    {
        return valueOf(v);
    }
}
