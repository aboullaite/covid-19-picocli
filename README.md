# covid-19-picocli
Track the COVID-19 disease in the command line:
+ 📚 Worldwide Coronavirus disease (COVID-19) reporting
+ 🔢 Daily COVID-19 statistics for many countries 
+ 🗃️ Data: Country, Cases, Deaths, Recovered, Active, Critical, Per Million
+ 📈 Line Charts
```bash
Usage: cov19 [-aghV] [-c=<country>]
Track covid-19 from your command line
  -a, --all                 show data for all affected countries
  -c, --country=<country>   Country to display data for
  -g, --graph               show data as graph history of last 30 days
  -h, --help                Show this help message and exit.
  -V, --version             Print version information and exit.
```
It is built using java, [picocli](https://picocli.info/), with support to generate a native binary using [graal VM](https://www.graalvm.org/)
Inspired from [ahmadawais/corona-cli](https://github.com/ahmadawais/corona-cli)
### Build the app
The app uses maven as build tool. To build the app, simply run the command below:
```bash
$ mvn clean package
```
This will generate a uber-jar that contains all its dependencies:
```bash
$ java -jar ./target/covid-java-cli-1.0-SNAPSHOT.jar --help                                                                                                                  ✔ │ 02:01:16 PM 
Usage: cov19 [-aghV] [-c=<country>]
Track covid-19 from your command line
  -a, --all                 show data for all affected countries
  -c, --country=<country>   Country to display data for
  -g, --graph               show data as graph history of last 30 days
  -h, --help                Show this help message and exit.
  -V, --version             Print version information and exit.
```

### Generate native binary
We use [Graal VM](https://www.graalvm.org/) [native-image tool](https://www.graalvm.org/docs/reference-manual/aot-compilation/) to compile our application into compiled into a native image.
Make sure that you are using GraalVM as your `JAVA_HOME`, and the `native image` tool is installed on your machine. Then run:
```bash
$ mvn clean verify
```
It will take a couple of second to generate the native executable. Once it finished, you can run the exectable without having a JVM:
```bash
$ ./cov19-cli --help                                                                                                                                                                                       ✔ │ 10:00:47 pm
  Usage: cov19 [-aghV] [-c=<country>]
  Track covid-19 from your command line
    -a, --all                 show data for all affected countries
    -c, --country=<country>   Country to display data for
    -g, --graph               show data as graph history of last 30 days
    -h, --help                Show this help message and exit.
    -V, --version             Print version information and exit.
```
