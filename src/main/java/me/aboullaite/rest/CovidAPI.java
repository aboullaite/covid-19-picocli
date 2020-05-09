package me.aboullaite.rest;

import me.aboullaite.model.Coutry;
import me.aboullaite.model.History;

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

    public Coutry globalStats(){
       return covidTarget.path("all").request(MediaType.APPLICATION_JSON)
               .get(Coutry.class);
    }

    public Coutry countryStats(String country){
        return covidTarget.path("countries").path(country).request(MediaType.APPLICATION_JSON)
                .get(Coutry.class);
    }

    public List<Coutry> allCountryStats(){
        return covidTarget.path("countries").request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Coutry>>() {});
    }

    public History history( String country){
        return covidTarget.path("historical").path(country).request(MediaType.APPLICATION_JSON)
                .get(History.class);
    }
}
