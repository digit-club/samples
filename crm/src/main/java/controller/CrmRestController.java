package main.java.controller;

import main.java.data.model.Merchant;
import main.java.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/merchants")
public class CrmRestController {

    @Autowired
    private MerchantService merchantService;

    @RequestMapping(method = POST)
    public Merchant saveMerchant(@RequestBody Merchant merchant) {
        Merchant created = merchantService.save(merchant);
        return created;
    }

    @RequestMapping(method = GET)
    public List<Merchant> getMerchants() {
        return merchantService.findAll();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Merchant getMerchant(@PathVariable Integer id) {
        return merchantService.get(id);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public void deleteMerchant(@PathVariable Integer id) {
        merchantService.delete(id);
    }

}
