package test;

import main.java.config.Application;
import main.java.config.Constants;
import main.java.data.dao.MerchantDao;
import main.java.data.model.Merchant;
import main.java.data.model.Phone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDate;
import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles(Constants.PROFILE_TEST)
public class TestPersistance {

    @Autowired
    private MerchantDao merchantDao;

    @Test
    public void testMerchantCRUD() {
        Merchant saved = merchantDao.save(new Merchant(0, "name", "surname", LocalDate.of(1990, 2, 1),
            Arrays.asList(new Phone("00000001"), new Phone("00000002"))));
        System.out.println(saved);
    }

}
