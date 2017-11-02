import model.Client;
import org.junit.Assert;
import org.junit.Test;
import model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientTest {


    @Test
    public void checkRecords() {

        List<Client> client = new ArrayList<>();
        client.add(new Client("adam", "shafai86@gmail.com", "0720373135", 86));
        client.add(new Client("haseeb", "haseeb@gmail.com", "0700000", 87));
        client.add(new Client("adam", "shafai86@gmail.com", "0720373135", 86));


        for (Client clients : client) {

            if (clients.getId() == 86) {
                System.out.println("Client exits" +":"+ clients.toString());
            } else {
                //System.out.println("Client is not in the list");
            }
        }
    }

}
