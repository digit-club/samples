package main.java.data.dao;

import main.java.data.model.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellDao extends JpaRepository<Sell, Integer> {
}
