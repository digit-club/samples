package main.java.service;

import main.java.data.dao.MerchantDao;
import main.java.data.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantService {

    @Autowired
    private MerchantDao merchantDao;

    public Merchant save(Merchant merchant) {
        return merchantDao.save(merchant);
    }

    public List<Merchant> findAll() {
        return merchantDao.findAll();
    }

    public void delete(int id) {
        merchantDao.delete(id);
    }

    public Merchant get(int id) {
        return merchantDao.get(id);
    }

}
