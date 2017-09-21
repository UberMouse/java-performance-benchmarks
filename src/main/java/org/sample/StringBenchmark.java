package org.sample;

import org.openjdk.jmh.annotations.Benchmark;

public class StringBenchmark {

    @Benchmark
    public String stringFormat() {
        String foo = "foo";
        String formattedString = String.format("%s = %d", foo, 2);

        return formattedString;
    }

    @Benchmark
    public String stringConcat() {
        String foo = "foo";
        String concattedString = foo + " = " + 2;

        return concattedString;
    }

    @Benchmark
    public String stringAppendLoop() {
        String s = "";

        for (int i = 0;i < 10_000;i++) {
            if (s.length() > 0) s += ", ";
            s += "bar";
        }

        return s;
    }

    @Benchmark
    public String stringAppendLoopPlus() {
        String s = "";

        for (int i = 0;i < 10_000;i++) {
            if (s.length() > 0) s = s + ", ";
            s = s + "bar";
        }

        return s;
    }

    @Benchmark
    public String stringAppendLoopPlusDouble() {
        String s = "";
        String bar = "bar";

        for (int i = 0;i < 10_000;i++) {
            if (s.length() > 0) s = s + ",";
            s = s + " " + bar;
        }

        return s;
    }

    @Benchmark
    public String stringCreateLoop() {
        String s = "";

        for (int i = 0;i < 10_000;i++) {
            s = "Hello world " + i;
        }

        return s;
    }

    @Benchmark
    public String stringAppendBuilderLoop() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0;i < 10_000;i++) {
            if (sb.length() > 0) sb.append(", ");
            sb.append("bar");
        }

        return sb.toString();
    }

    @Benchmark
    public String stringAppendBuilderLoopSized() {
        StringBuilder sb = new StringBuilder(10_000 * 5);

        for (int i = 0;i < 10_000;i++) {
            if (sb.length() > 0) sb.append(", ");
            sb.append("bar");
        }

        return sb.toString();
    }

    @Benchmark
    public String stringAppend() {
        String s = "foo";
        s += ", bar";
        s += ", baz";
        s += ", qux";
        s += ", bar";
        s += ", bar";
        s += ", bar";
        s += ", bar";
        s += ", bar";
        s += ", bar";
        s += ", baz";
        s += ", qux";
        s += ", baz";
        s += ", qux";
        s += ", baz";
        s += ", qux";
        s += ", baz";
        s += ", qux";
        s += ", baz";
        s += ", qux";
        s += ", baz";
        s += ", qux";

        return s;
    }

    @Benchmark
    public String stringAppendBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("foo");
        sb.append(", bar");
        sb.append(", bar");
        sb.append(", baz");
        sb.append(", qux");
        sb.append(", baz");
        sb.append(", qux");
        sb.append(", baz");
        sb.append(", qux");
        sb.append(", baz");
        sb.append(", qux");
        sb.append(", baz");
        sb.append(", qux");
        sb.append(", baz");
        sb.append(", qux");
        sb.append(", baz");
        sb.append(", qux");
        sb.append(", baz");
        sb.append(", qux");
        sb.append(", baz");
        sb.append(", qux");
        sb.append(", baz");
        sb.append(", qux");

        return sb.toString();
    }
}
