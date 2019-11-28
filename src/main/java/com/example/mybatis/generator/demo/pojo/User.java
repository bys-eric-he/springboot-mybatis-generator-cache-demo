package com.example.mybatis.generator.demo.pojo;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    /**
     * 真实姓名
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "真实姓名")
    private String realname;

    private static final long serialVersionUID = 1L;

    public User(Integer id, String username, String password, String realname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", realname=").append(realname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}