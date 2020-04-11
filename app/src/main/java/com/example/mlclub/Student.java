package com.example.mlclub;

public class Student {
    String name;
    String scholarid;
    String phoneno;
    String email;
    String branch;

    public Student(String name, String scholarid, String phoneno, String email, String branch) {
        this.name = name;
        this.scholarid = scholarid;
        this.phoneno = phoneno;
        this.email = email;
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScholarid() {
        return scholarid;
    }

    public void setScholarid(String scholarid) {
        this.scholarid = scholarid;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
