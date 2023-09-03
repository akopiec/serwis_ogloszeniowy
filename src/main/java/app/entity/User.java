package app.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="serwis_users")
public class User {

    @Id
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Boolean enabled;
    @Column
    private String telephone;
    @Column
    private String e_mail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Authority> authorities;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Motorization> motorizations;

    public User() {

        enabled = true;

        authorities = new ArrayList<>();

        motorizations=new ArrayList<>();
    }

    public User(String username) {

        this();

        this.username = username;

    }

    public User(String username,String password,String telephone,String e_mail) {

        this.username = username;

        this.password = password;

        this.telephone=telephone;

        this.e_mail=e_mail;
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

    public String getTelephone() {

        return telephone;
    }

    public String getE_mail() {

        return e_mail;
    }

    public void setTelephone(String telephone) {

        this.telephone = telephone;
    }

    public void setE_mail(String e_mail) {

        this.e_mail = e_mail;
    }

    public Boolean getEnabled() {

        return enabled;
    }

    public void setEnabled(Boolean enabled) {

        this.enabled = enabled;
    }

    public List<Authority> getAuthorities() {

        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {

        this.authorities = authorities;
    }

    public List<Motorization> getMotorizations(){

        return motorizations;
    }
    public void setMotorizations(List<Motorization> motorizations){

        this.motorizations=motorizations;
    }
}