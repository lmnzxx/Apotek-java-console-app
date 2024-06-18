package apotek.controller;

public class Apoteker extends User{
    private String username, password;
    private boolean isLogin;
    
    public Apoteker(String nama, String alamat, String email, String hp, String username, String password) {
        super(nama, alamat, email, hp);
        this.username = username;
        this.password = password;
        this.isLogin = false;
    }

    public boolean login(String uName, String pass) {
        if(this.username.equals(uName) && this.password.equals(pass)){
            this.isLogin = true;
            return true;
        } else {
            this.isLogin = false;
            return false;
        }
    }

    public void logout() {
        isLogin = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogin() {
        return isLogin;
    }
}
