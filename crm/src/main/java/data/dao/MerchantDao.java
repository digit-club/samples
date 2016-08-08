package main.java.data.dao;

import main.java.data.model.Merchant;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface MerchantDao extends Repository<Merchant, Integer> {

    List<Merchant> findAll();

    Merchant save(Merchant merchant);

    void delete(int id);

    Merchant get(int id);
}
