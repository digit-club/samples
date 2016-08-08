package main.java.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "SELL")
public class Sell {

    @Id @GeneratedValue @Column(name = "id")
    private int id;
    @Column(name = "merchant_id")
    private int merchantId;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @OneToMany(targetEntity = Item.class)
    private List<Item> items;

    public Sell() {
    }

    public Sell(int id, int merchantId, LocalDateTime dateTime, List<Item> items) {
        this.id = id;
        this.merchantId = merchantId;
        this.dateTime = dateTime;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
