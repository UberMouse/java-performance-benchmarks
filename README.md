# Java performance benchmarks

Some basic Java performance benchmarks for Streams, some Date operations and Strings

Benchmarks are run using JMH and can be built using `mvn clean install`

Prebuilt jar is included as `benchmarks.jar` which can be run directly

My test command was `java -jar benchmarks.jar -f 1 -i 10 -wi 10 -r 5` which resulted in the output of

```
Benchmark                                      Mode  Cnt          Score        Error  Units
DateBenchmark.dateLong                        thrpt   10  398180671.307 ± 861095.156  ops/s
DateBenchmark.dateLongWithFormat              thrpt   10    3205290.937 ±  17495.643  ops/s
DateBenchmark.dateParsingWithFormat           thrpt   10     829339.030 ±   5872.319  ops/s
StreamBenchmark.testFor                       thrpt   10       1676.135 ±     33.174  ops/s
StreamBenchmark.testForInLoop                 thrpt   10        543.856 ±      2.759  ops/s
StreamBenchmark.testLargeStream               thrpt   10         95.626 ±      0.480  ops/s
StreamBenchmark.testLargeStreamParallel       thrpt   10        128.419 ±      1.185  ops/s
StreamBenchmark.testStream                    thrpt   10       1637.747 ±     11.793  ops/s
StreamBenchmark.testStreamInLoop              thrpt   10        432.207 ±      1.098  ops/s
StreamBenchmark.testStreamParrallel           thrpt   10       8068.937 ±    260.249  ops/s
StringBenchmark.stringAppend                  thrpt   10   22572323.301 ± 181309.750  ops/s
StringBenchmark.stringAppendBuilder           thrpt   10    6983217.796 ±  54212.734  ops/s
StringBenchmark.stringAppendBuilderLoop       thrpt   10       7202.648 ±    117.500  ops/s
StringBenchmark.stringAppendBuilderLoopSized  thrpt   10       8106.539 ±    135.040  ops/s
StringBenchmark.stringAppendLoop              thrpt   10         11.111 ±      0.373  ops/s
StringBenchmark.stringAppendLoopPlus          thrpt   10         11.624 ±      0.056  ops/s
StringBenchmark.stringAppendLoopPlusDouble    thrpt   10         11.593 ±      0.084  ops/s
StringBenchmark.stringConcat                  thrpt   10  116474840.767 ± 766799.557  ops/s
StringBenchmark.stringCreateLoop              thrpt   10       6404.057 ±     97.817  ops/s
StringBenchmark.stringFormat                  thrpt   10    1384875.999 ±   7025.733  ops/s
```