package me.aboullaite.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    private String country;
    private CountryInfo info;
    private int cases;
    private int todayCases;
    private int deaths;
    private int todayDeaths;
    private int recovered;
    private int active;
    private int critical;
    private int tests;
    private int casesPerOneMillion;
    private int deathsPerOneMillion;
    private int testsPerOneMillion;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp updated;
    private int affectedCountries;

    public Country() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CountryInfo getInfo() {
        return info;
    }

    public void setInfo(CountryInfo info) {
        this.info = info;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public int getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(int casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public int getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(int deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public int getTests() {
        return tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }

    public int getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(int testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public int getAffectedCountries() {
        return affectedCountries;
    }

    public void setAffectedCountries(int affectedCountries) {
        this.affectedCountries = affectedCountries;
    }

    @Override
    public String toString() {
        return "Coutry{" + "country='" + country + '\'' + ", info=" + info + ", cases=" + cases + ", todayCases=" + todayCases + ", deaths=" + deaths + ", todayDeaths=" + todayDeaths + ", recovered=" + recovered + ", active=" + active + ", critical=" + critical + ", tests=" + tests + ", casesPerOneMillion=" + casesPerOneMillion + ", deathsPerOneMillion=" + deathsPerOneMillion + ", updated=" + updated + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        if (getCases() != country.getCases()) return false;
        if (getTodayCases() != country.getTodayCases()) return false;
        if (getDeaths() != country.getDeaths()) return false;
        if (getTodayDeaths() != country.getTodayDeaths()) return false;
        if (getRecovered() != country.getRecovered()) return false;
        if (getActive() != country.getActive()) return false;
        if (getCritical() != country.getCritical()) return false;
        if (getTests() != country.getTests()) return false;
        if (getCasesPerOneMillion() != country.getCasesPerOneMillion()) return false;
        if (getDeathsPerOneMillion() != country.getDeathsPerOneMillion()) return false;
        if (!getCountry().equals(country.getCountry())) return false;
        if (!getInfo().equals(country.getInfo())) return false;
        return getUpdated().equals(country.getUpdated());
    }

    @Override
    public int hashCode() {
        int result = getCountry().hashCode();
        result = 31 * result + getInfo().hashCode();
        result = 31 * result + getCases();
        result = 31 * result + getTodayCases();
        result = 31 * result + getDeaths();
        result = 31 * result + getTodayDeaths();
        result = 31 * result + getRecovered();
        result = 31 * result + getActive();
        result = 31 * result + getCritical();
        result = 31 * result + getTests();
        result = 31 * result + getCasesPerOneMillion();
        result = 31 * result + getDeathsPerOneMillion();
        result = 31 * result + getUpdated().hashCode();
        return result;
    }
}
