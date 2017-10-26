import model.Client;
import org.junit.Assert;
import org.junit.Test;
import model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientTest {


    @Test
    public void checkRecords() {

        List<Client> clients = new ArrayList<>();
        clients.add(new Client("adam", "shafai86@gmail.com", "0720373135", 86));
        clients.add(new Client("haseeb", "haseeb@gmail.com", "0700000", 87));
        clients.add(new Client("adam", "shafai86@gmail.com", "0720373135", 86));


//        for (Client clients : client) {
//
//            if (clients.getId() == 86) {
//                System.out.println("Client exits" +":"+ clients.toString());
//            } else {
//                //System.out.println("Client is not in the list");
//            }
//        }
        Assert.assertEquals(86, clients.get(0).getId());
        Assert.assertEquals(87, clients.get(1).getId());
        Assert.assertEquals(86, clients.get(2).getId());
    }

}
