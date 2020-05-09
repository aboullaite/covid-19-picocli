package me.aboullaite.utils;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import com.github.freva.asciitable.HorizontalAlign;
import com.mitchtalmadge.asciidata.graph.ASCIIGraph;
import me.aboullaite.model.Coutry;
import me.aboullaite.model.History;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PrintUtils {

    private static final int MAX_WIDTH = 60;
    private static final int ROWS_NUM = 30;
    private static final DecimalFormat DF = new DecimalFormat("0");

    public static void printGlobalTable(List<Coutry> coutry){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(AsciiTable.getTable(coutry, Arrays.asList(
                new Column().header("Total cases").with(c -> String.valueOf(c.getCases())),
                new Column().header("Today cases").with(c -> String.valueOf(c.getTodayCases())),
                new Column().header("Total deaths").with(c -> String.valueOf(c.getDeaths())),
                new Column().header("Today deaths").with(c -> String.valueOf(c.getTodayDeaths())),
                new Column().header("Total recovered").with(c -> String.valueOf(c.getRecovered())),
                new Column().header("Total active").with(c -> String.valueOf(c.getActive())),
                new Column().header("Total critical").with(c -> String.valueOf(c.getCritical())),
                new Column().header("Total tests").with(c -> String.valueOf(c.getTests())),
                new Column().header("Cases ppm").with(c -> String.valueOf(c.getCasesPerOneMillion())),
                new Column().header("Deaths ppm").with(c -> String.valueOf(c.getDeathsPerOneMillion())),
                new Column().header("Tests ppm").with(c -> String.valueOf(c.getTestsPerOneMillion())),
                new Column().header("Affected Countries").with(c -> String.valueOf(c.getAffectedCountries())),
                new Column().header("Last updated").with(c -> String.valueOf(sdf.format(c.getUpdated())))
        )));

    }

    public static void printCountryStatTable(List<Coutry> coutry){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(AsciiTable.getTable(coutry, Arrays.asList(
                new Column().header("Country").with(c -> String.valueOf(c.getCountry())),
                new Column().header("Total cases").with(c -> String.valueOf(c.getCases())),
                new Column().header("Today cases").with(c -> String.valueOf(c.getTodayCases())),
                new Column().header("Total deaths").with(c -> String.valueOf(c.getDeaths())),
                new Column().header("Today deaths").with(c -> String.valueOf(c.getTodayDeaths())),
                new Column().header("Total recovered").with(c -> String.valueOf(c.getRecovered())),
                new Column().header("Total active").with(c -> String.valueOf(c.getActive())),
                new Column().header("Total critical").with(c -> String.valueOf(c.getCritical())),
                new Column().header("Total tests").with(c -> String.valueOf(c.getTests())),
                new Column().header("Cases ppm").with(c -> String.valueOf(c.getCasesPerOneMillion())),
                new Column().header("Deaths ppm").with(c -> String.valueOf(c.getDeathsPerOneMillion())),
                new Column().header("Tests ppm").with(c -> String.valueOf(c.getTestsPerOneMillion())),
                new Column().header("Last updated").with(c -> String.valueOf(sdf.format(c.getUpdated())))
        )));

    }

    public static void printGrapgh(History history){
        double[] cases = Stream.of(history.getCases()).mapToDouble(Integer::doubleValue).toArray();
        double[] deaths = Stream.of(history.getDeaths()).mapToDouble(Integer::doubleValue).toArray();
        double[] recovered = Stream.of(history.getRecovered()).mapToDouble(Integer::doubleValue).toArray();

        Graph g = new Graph();
        g.setCases(ASCIIGraph.fromSeries(cases).withTickFormat(DF).withNumRows(ROWS_NUM).plot());
        g.setDeaths(ASCIIGraph.fromSeries(deaths).withTickFormat(DF).withNumRows(ROWS_NUM).plot());
        g.setRecovered(ASCIIGraph.fromSeries(recovered).withTickFormat(DF).withNumRows(ROWS_NUM).plot());


        System.out.println(AsciiTable.getTable(Arrays.asList(g), Arrays.asList(
                new Column().header("History of Cases in the last 30 days").maxColumnWidth(MAX_WIDTH).headerAlign(HorizontalAlign.CENTER).dataAlign(HorizontalAlign.LEFT).with(graph -> graph.getCases()),
                new Column().header("History of deaths in the last 30 days").maxColumnWidth(MAX_WIDTH).headerAlign(HorizontalAlign.CENTER).dataAlign(HorizontalAlign.LEFT).with(graph -> graph.getDeaths()),
                new Column().header("History of Recovered in the last 30 days").maxColumnWidth(MAX_WIDTH).headerAlign(HorizontalAlign.CENTER).dataAlign(HorizontalAlign.LEFT).with(graph -> graph.getRecovered())

                )));
    }


    static class Graph{
        String cases, deaths, recovered;

        public String getCases() {
            return cases;
        }

        public void setCases(String cases) {
            this.cases = cases;
        }

        public String getDeaths() {
            return deaths;
        }

        public void setDeaths(String deaths) {
            this.deaths = deaths;
        }

        public String getRecovered() {
            return recovered;
        }

        public void setRecovered(String recovered) {
            this.recovered = recovered;
        }
    }

    }
