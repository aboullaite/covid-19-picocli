package me.aboullaite.rest;

import me.aboullaite.model.Country;
import me.aboullaite.model.History;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class CovidAPI {
    private static final String BASE_URL = "https://corona.lmao.ninja/v2/";
    private Client client = ClientBuilder.newClient();
    private WebTarget covidTarget = client.target(BASE_URL);

    public Country globalStats(){
       return covidTarget.path("all").request(MediaType.APPLICATION_JSON)
               .get(Country.class);
    }

    public Country countryStats(String country){
        return apiCall("all", Country.class);
    }

    public List<Country> allCountryStats(){
        return apiCall("countries", new GenericType<List<Country>>() {});
    }

    public History history( String country){
        return this.apiCall("historical/"+country, History.class);
    }

    private <T> T apiCall(String path, Class<T> tClass){
        try {
            return covidTarget.path(path).request(MediaType.APPLICATION_JSON)
                    .get(tClass);
        }catch (ClientErrorException cex){
            System.out.printf("Something happened in our side: %s", cex.getMessage());
        }catch (ServerErrorException sex){
            System.out.printf("Something happened in server side: %s", sex.getMessage());
        }
        return null;
    }

    private <T> T apiCall(String path, GenericType<T> tClass){
        try {
            return covidTarget.path(path).request(MediaType.APPLICATION_JSON)
                    .get(tClass);
        }catch (ClientErrorException cex){
            System.out.printf("Something happened in our side: %s", cex.getMessage());
        }catch (ServerErrorException sex){
            System.out.printf("Something happened in server side: %s", sex.getMessage());
        }
        return null;
    }


}
