package uni.sw.unit.testing;

public class User {
    private int _id;
    private String _userName;
    private String _password;
    private double _academicAverage;

    public String getUserName() { return _userName; }
    public String getPassword() { return _password; }
    public int getId() { return _id; }

    boolean isLoggedIn() { throw new UnsupportedOperationException("not implemented"); }

}
