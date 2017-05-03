package com.nadezda.diplom.tables;

/**
 * Created by Nadezda on 26.02.2017.
 */
public class User {
    private int id;
    private String sluzhba;
    private String name;
    private String doljnost;
    private String tel;
    private String login;
    private String pass;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", sluzhba='" + sluzhba + '\'' +
                ", name='" + name + '\'' +
                ", doljnost='" + doljnost + '\'' +
                ", tel='" + tel + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", role_id='" + role_id + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSluzhba() {
        return sluzhba;
    }

    public void setSluzhba(String sluzhba) {
        this.sluzhba = sluzhba;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoljnost() {
        return doljnost;
    }

    public void setDoljnost(String doljnost) {
        this.doljnost = doljnost;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public User(int id, String sluzhba, String name, String doljnost, String tel, String login, String pass, String role_id) {

        this.id = id;
        this.sluzhba = sluzhba;
        this.name = name;
        this.doljnost = doljnost;
        this.tel = tel;
        this.login = login;
        this.pass = pass;
        this.role_id = role_id;
    }

    private String role_id;

}
