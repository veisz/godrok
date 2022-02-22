package hu.godrok.model.controller;

import java.util.List;

public class PitService {

    private final List<Integer> depth;

    public PitService(List<Integer> depth) {
        this.depth = depth;
    }

    public int size() {
        return depth.size();
    }
}
