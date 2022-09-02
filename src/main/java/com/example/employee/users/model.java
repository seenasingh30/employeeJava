package com.example.employee.users;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class model {
    @Id
    private int id;
    private String name,email,phone,password,desgination;

    public model() {
        super();
    }

    public model( String name, String email, String phone, String password, String desgination) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.desgination = desgination;
    }

    public int getId() {s
        return id;
    }

    public void setId(int id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesgination() {
        return desgination;
    }

    public void setDesgination(String desgination) {
        this.desgination = desgination;
    }
}
