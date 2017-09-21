package org.sample;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@State(Scope.Thread)
public class ArrayState {
    public ArrayList<String> testList;
    public ArrayList<String> smallList;
    public ArrayList<Integer> intList;

    public ArrayState() {
        testList = new ArrayList<>();
        for (int i = 0;i < 100_000;i++) {
            testList.add(String.valueOf(i));
        }
        Collections.shuffle(testList);

        smallList = testList.stream().limit(100).collect(Collectors.toCollection(ArrayList::new));

        intList = IntStream.range(0, 1_000_000).boxed().collect(Collectors.toCollection(ArrayList::new));
    }
}
