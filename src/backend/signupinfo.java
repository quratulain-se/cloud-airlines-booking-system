package backend;

public class signupinfo {

    private static String username;
    private static String password;

    public void setUsername(String username) {
        signupinfo.username = username;
    }

    public void setPassword(String password) {
        signupinfo.password = password;
    }

    public String getUsername() {
        return signupinfo.username;
    }

    public String getPassword() {
        return signupinfo.password;
    }
}