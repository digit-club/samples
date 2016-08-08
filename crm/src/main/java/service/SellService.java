package main.java.service;

import main.java.data.dao.SellDao;
import main.java.data.model.Sell;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SellService {

    @Autowired
    private SellDao sellDao;

    public List<Sell> getSells() {
        return sellDao.findAll();
    }

}
