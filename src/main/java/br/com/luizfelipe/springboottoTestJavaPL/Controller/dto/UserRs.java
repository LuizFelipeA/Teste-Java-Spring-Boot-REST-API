package br.com.luizfelipe.springboottoTestJavaPL.Controller.dto;

import br.com.luizfelipe.springboottoTestJavaPL.Model.User;

import java.sql.Date;

public class UserRs {

    private Long id;
    private String name;
    private String email;
    private Date birthdate;

    public static UserRs converter(User u) {
        var user = new UserRs();
        user.setId(u.getId());
        user.setName(u.getName());
        user.setEmail(u.getEmail());
        user.setBirthdate(u.getBirthdate());

        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
