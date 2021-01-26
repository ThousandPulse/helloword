package studentSystem;

public class LoginUser {
    private String loginName;
    private String loginPwd;
    private String loginType;

    public LoginUser(String loginName, String loginPwd, String loginType) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.loginType = loginType;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public String getLoginType() {
        return loginType;
    }
}
