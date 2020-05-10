package me.aboullaite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class History {
    private String country;
    private Integer[] cases, deaths, recovered;

    @SuppressWarnings("unchecked")
    @JsonProperty("timeline")
    public void unpackNested(Map<String,Object> timeline) {
        Map<String, Integer> casesMap = (Map<String, Integer>)timeline.get("cases");
        this.cases = casesMap.values().toArray(new Integer[casesMap.values().size()]);
        Map<String, Integer> deathsMap = (Map<String, Integer>)timeline.get("deaths");
        this.deaths = deathsMap.values().toArray(new Integer[deathsMap.values().size()]);
        Map<String, Integer> recoveredMap = (Map<String, Integer>)timeline.get("recovered");
        this.recovered = recoveredMap.values().toArray(new Integer[recoveredMap.values().size()]);
    }
    @JsonProperty("cases")
    public void unpackNestedCases(Map<String,Object> globalCases) {
        this.cases = globalCases.values().toArray(new Integer[globalCases.values().size()]);
    }
    @JsonProperty("deaths")
    public void unpackNestedDeaths(Map<String,Object> globalDeaths) {
        this.deaths = globalDeaths.values().toArray(new Integer[globalDeaths.values().size()]);
    }
    @JsonProperty("recovered")
    public void unpackNestedRecovered(Map<String,Object> globalRecovered) {
        this.recovered = globalRecovered.values().toArray(new Integer[globalRecovered.values().size()]);
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer[] getCases() {
        return cases;
    }

    public void setCases(Integer[] cases) {
        this.cases = cases;
    }

    public Integer[] getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer[] deaths) {
        this.deaths = deaths;
    }

    public Integer[] getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer[] recovered) {
        this.recovered = recovered;
    }
}
