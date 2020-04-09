package co.commit.wheat.wheat.model;

public class User {
    private int id;
    private String accountId;
    private String name;
    private String token;
    private Long gmtCreate;
    private Long gmtModifieo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccount_id(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModifieo() {
        return gmtModifieo;
    }

    public void setGmtModifieo(Long gmtModifieo) {
        this.gmtModifieo = gmtModifieo;
    }
}
