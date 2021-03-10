package com.dijon.emailduplicated;

import java.io.Serializable;

public class Person implements Serializable {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person() {
    }

}
