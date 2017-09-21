package org.sample;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBenchmark {

    @Benchmark
    public void testStream(ArrayState state) {
        List<String> collect = state.testList
                .stream()
                .filter(s -> s.length() > 5)
                .map(s -> "Value: " + s)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    @Benchmark
    public void testStreamParrallel(ArrayState state) {
        List<String> collect = state.testList
                .stream()
                .parallel()
                .filter(s -> s.length() > 5)
                .map(s -> "Value: " + s)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    @Benchmark
    public void testLargeStreamParallel(ArrayState state) {
        ArrayList<Double> collect = state.intList
                .stream()
                .parallel()
                .map(i -> Math.sqrt(i * 2 / ((i >> 3) + 1)))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Benchmark
    public void testLargeStream(ArrayState state) {
        ArrayList<Double> collect = new ArrayList<>();
        for (Integer i : state.intList) {
            collect.add(Math.sqrt(i * 2 / ((i >> 3) + 1)));
        }
    }

    @Benchmark
    public void testFor(ArrayState state) {
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0;i < state.testList.size();i++) {
            String s = state.testList.get(i);

            if (s.length() > 5) {
                results.add("Value: " + s);
            }
        }

        results.sort(String::compareTo);
    }

    @Benchmark
    public void testStreamInLoop(ArrayState state) {
        ArrayList<String> output = new ArrayList<>();

        for (int i = 0;i < 1000; i++) {
            state.smallList
                    .stream()
                    .filter(s -> s.length() > 2)
                    .map(s -> "Value: " + s)
                    .forEach(output::add);
        }
    }

    @Benchmark
    public void testForInLoop(ArrayState state) {
        ArrayList<String> output = new ArrayList<>();

        for (int i = 0;i < 1000; i++) {
            for (String s : state.smallList) {
                if (s.length() > 2) {
                    output.add("Value: " + s);
                }
            }
        }
    }
}

