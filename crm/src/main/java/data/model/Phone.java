package main.java.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE")
public class Phone {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "phone")
    private String phone;

    public Phone() {
    }

    public Phone(String phone) {
        this.phone = phone;
    }

    public Phone(int personId, String phone) {
        this.id = personId;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
