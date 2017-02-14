package entity;

import java.io.Serializable;

public class User implements Serializable {
    String uname;
    String pwd;

    public User(String uname, String pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }

    public User() {

    }

    public String getUname() {
        return uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

