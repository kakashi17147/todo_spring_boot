package come.try3.demo.service;

import come.try3.demo.domain.UserLogin;

public class RequestObj {
    private UserLogin userLogin;



    public RequestObj(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "RequestObj{" +
                "userLogin=" + userLogin +
                '}';
    }
}