package restAPI;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.concurrent.SynchronousQueue;

public class EcxhangeServices {
    @Test
    public Double euroToDol(Double euro) {
        /*
        get an exchange rate data
         */
        Client client = Client.create();
        WebResource wr = client.resource("http://api.fixer.io/latest");
        ClientResponse cr = wr.accept("application/json").get(ClientResponse.class);
        /*
        client response should be converted in string format, because
         */
        String output = cr.getEntity(String.class);
        /*
        client response is being formatted into String
        we need Json format to get the data
         */
        JSONObject ob = new JSONObject(output);
        JSONObject rates = ob.getJSONObject("rates");

        Double usdRate = rates.getDouble("USD");
        /*
        do the calculation and return the result (value)
         */
        System.out.print(usdRate);

        Double euroResult = usdRate * euro;
        return euroResult;
    }

    public Double  dolToEuro(Double dollar){
        Client client = Client.create();
        WebResource wr = client.resource("http://api.fixer.io/latest?base=USD");
        ClientResponse cr = wr.accept("application/json").get(ClientResponse.class);
        String output = cr.getEntity(String.class);
        JSONObject ob = new JSONObject(output);
        JSONObject rates = ob.getJSONObject("rates");
        Double eurRate = rates.getDouble("EUR");
        Double dolResult = eurRate * dollar;
        return dolResult;
    }
}

