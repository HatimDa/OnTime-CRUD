package com.ontime.dbmapping;


import javax.persistence.*;

@Entity
@Table(name = "app_admin")
public class Admin {

    /**
     * Mapping each column from "app_admin table" into it's proper variable in Admin class
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT(11)")
    private int id;

    @Column(name = "admin_email", columnDefinition = "VARCHAR(45)")
    private String adminEmail;

    @Column(name = "admin_name", columnDefinition = "VARCHAR(45)")
    private String adminName;

    @Column(name = "admin_password", columnDefinition = "VARCHAR(45)")
    private String adminPassword;

    public Admin() {

    }

    public Admin(int id, String adminEmail, String adminName, String adminPassword) {
        this.id = id;
        this.adminEmail = adminEmail;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminEmail='" + adminEmail + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
}
