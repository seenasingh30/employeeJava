package com.example.employee.users;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "user")
public class model {
    @Id
    private long id;
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
}
