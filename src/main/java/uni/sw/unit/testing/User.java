package uni.sw.unit.testing;

public class User {
    private int _id;
    private String _userName;
    private String _password;


    public String getUserName() { return _userName; }
    public String getPassword() { return _password; }
    public int getId() { return _id; }
    public double getAcademicAverage(int semester) { return 0; }

    public boolean update(String newPassword, boolean isLoggedInValue) { return false; }

    boolean isLoggedIn() { throw new UnsupportedOperationException("not implemented"); }

}
