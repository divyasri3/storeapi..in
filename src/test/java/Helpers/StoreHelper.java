package Helpers;

import com.github.javafaker.Faker;
import test.store.pojo.store.Store;

public class StoreHelper {



    public  static Store storeData(){


        Store s = new Store();
        s.setId(1);
        s.setPetId(10);
        s.setQuantity(4);
        s.setShipDate("2023-08-13T11:28:11.472Z");
        s.setStatus("placed");
        s.setComplete(true);
        return s;
    }
}
