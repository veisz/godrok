package hu.godrok.model.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PitService {

    private final List<Integer> depth;


    public PitService(List<Integer> depth) {
        this.depth = depth;
    }

    public int size() {
        return depth.size();
    }

    public int getDepthAtCertainDistance(int distance) {
        return depth.get(distance);
    }

    private long getUntouchedSurfaceCount() {
        return depth.stream()
                .filter(i -> i == 0)
                .count();
    }

    public String getUntouchedArea() {
        double percent = 100.0 * getUntouchedSurfaceCount() / depth.size();
        return String.format("%5.2f%%", percent);
    }

    public List<String> getPits() {
        String[] pits = getDepthAsString().split("_");
        return Arrays.stream(pits)
                .filter(i -> i.length() > 1)
                .map(i -> i.substring(1))
                .collect(Collectors.toList());
    }

    private String getDepthAsString() {
        return depth.stream()
                .map(this::transform)
                .collect(Collectors.joining(" "));
    }

    private String transform(int value) {
        return value == 0 ? "_" : String.valueOf(value);
    }

    public String getPitDetails(int distance) {
        return getDepthAtCertainDistance(distance) == 0 ? "Az adott helyen nincs gödör" : printAnswers(distance);
    }

    private String  printAnswers(int distance) {
        return  "valami";
    }
}
