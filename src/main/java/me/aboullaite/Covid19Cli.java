package me.aboullaite;

import me.aboullaite.rest.CovidAPI;
import me.aboullaite.utils.PrintUtils;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Help.Ansi;
import java.util.Arrays;
import java.util.concurrent.Callable;

@Command(description = "Track covid-19 from your command line",
        name = "cov19", mixinStandardHelpOptions = true, version = "cov19 1.0")
public class Covid19Cli implements Callable<Integer> {
    @Option(names = {"-c", "--country"}, description = "Country to display data for", defaultValue = "all")
    String country;
    @Option(names = {"-g", "--graph"}, description = "show data as graph history of last 30 days")
    boolean graph;
    @Option(names = {"-a", "--all"}, description = "show data for all affected countries")
    boolean all;

    CovidAPI covidAPI = new CovidAPI();

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Covid19Cli()).execute(args);
        System.exit(exitCode);
    }

    public Integer call() throws Exception {
        if(graph){
            if ("all".equals(this.country)) {
                this.colorise("Global");
            } else {
                this.colorise(this.country);
            }
            PrintUtils.printGrapgh(covidAPI.history(this.country));
        }else{
            if (all){
                this.colorise("Global");
                PrintUtils.printCountryStatTable(covidAPI.allCountryStats());
            }else if(this.country.equals("all")) {
                PrintUtils.printGlobalTable(Arrays.asList(covidAPI.globalStats()));
            }else{
                this.colorise(this.country);
                PrintUtils.printCountryStatTable(Arrays.asList(covidAPI.countryStats(this.country)));
            }

        }

        return 0;
    }

    private void colorise(String text){
        String str = Ansi.AUTO.string("@|bold,green, ****** Printing %s's data****** |@\n");
        System.out.printf(str, text);

    }
}
